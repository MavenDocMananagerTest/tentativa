package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.webapp.dao.DocumentoDAO;
import br.edu.utfpr.md.webapp.model.Documento;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.bson.types.ObjectId;

@Controller
@Path("/doc")
public class DocumentoController {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    @Inject
    private DocumentoDAO documentoDAO;

    public void teste() {
        System.out.println("Oi cara!");
    }
    
    @Path(value = "/edit/{id}", priority = Path.LOW)
    @Get
    public Documento edit(String _id) {
        ObjectId objectId = new ObjectId(_id);
        System.out.println(_id);
        if (_id != null) {
            //Buscar o doc no banco  de dados
            System.out.println(_id);
            
            //incluir no result

            System.out.println("ID:" + _id);
            return documentoDAO.getById(objectId);
        }
        return documentoDAO.getById(objectId);
    }
    
    
    @Path(value = "/new", priority = Path.HIGHEST)
    public void form() {
        
    }

    @Path(value = {"", "/"})
    @Get
    public List<Documento> list() {
        result.include("mensagem", "Esta é uma mensagem qualquer");
        result.include("data", new Date());
        return documentoDAO.find().asList();
    }

    @Post
    public void save(@Valid Documento documento) {
        validator.onErrorForwardTo(this).form();
        System.out.println("Descricao: " + documento.getDescricao());
        System.out.println("Data: " + documento.getData());
        System.out.println("Ultima atualizacao: " + documento.getUltatualizacao());
        System.out.println("Nome: " + documento.getNome());
        try {
            this.documentoDAO.save(documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar Documento"));
        }
        result.redirectTo(this).list();
    }

}
