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
import org.mongodb.morphia.query.Query;

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
    
    @Path(value = "/{_id}", priority = Path.LOW)
    @Get
   public Documento edit(String _id) {
        result.include("mensagem", "Esta é uma mensagem qualquer");
        result.include("data", new Date());
        
        System.out.println(_id);
        System.out.println("ID:" + _id);
        //System.out.println("oID:" + objectId.toString());
        if (_id != null) {
            int ww;
            //Buscar o doc no banco  de dados
            //ObjectId objectId = new ObjectId(_id);
                //Query<Documento> query = documentoDAO.createQuery();
                //query.disableValidation();
                //query.criteria(_id).equal(_id);
                //query.criteria("_id").contains(_id);
            System.out.println(documentoDAO.count());
            for(ww =0 ;ww< documentoDAO.count();ww++){
                System.out.println(_id.equals(documentoDAO.find().asList().get(ww).getId().toString()));
                
                if(_id.equals(documentoDAO.find().asList().get(ww).getId().toString())){
                    System.out.println("Descricao: " + documentoDAO.find().asList().get(ww).getDescricao());
                    System.out.println("Data: " + documentoDAO.find().asList().get(ww).getData());
                    System.out.println("Ultima atualizacao: " + documentoDAO.find().asList().get(ww).getUltatualizacao());
                    System.out.println("Nome: " + documentoDAO.find().asList().get(ww).getNome());
                    return documentoDAO.find().asList().get(ww);
                }
            }
            //incluir no result
            
            return documentoDAO.find().asList().get(0);
            //return documentoDAO.getById(objectId);
        }
        return documentoDAO.find().asList().get(0);
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
    @Path(value = "/id={_id}")
    @Post
    public void saveFromEdit(Documento documento,String _id) {
        validator.onErrorForwardTo(this).form();

        System.out.println("Descricao: " + documento.getDescricao());
        System.out.println("Data: " + documento.getData());
        System.out.println("Ultima atualizacao: " + documento.getUltatualizacao());
        System.out.println("Nome: " + documento.getNome());
        
        try {
            System.out.println("ID: " + _id);
            ObjectId objectId = new ObjectId(_id);
            this.documentoDAO.deleteById(objectId);
            this.documentoDAO.save(documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar Documento"));
        }
        result.redirectTo(this).list();
    }

}
