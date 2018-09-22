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
    
    @Path(value = "{id}", priority = Path.LOW)
    @Get
    public void edit(String id) {
        if (id != null) {
            //Buscar o doc no banco  de dados
            
            //incluir no result

            System.out.println("ID>>" + id);
        }
        result.forwardTo(this).form();
    }
    
    @Path(value = "/new", priority = Path.HIGHEST)
    public void form() {
        
    }

    @Path(value = {"", "/"})
    @Get
    public List<Documento> list() {
        result.include("mensagem", "Esta é uma mensagem qualquer");
        result.include("data", new Date());

        // Buscando os carros do banco de dados
        //return carroDAO.getAll();
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
            //this.carroDAO.insert(carro);
            this.documentoDAO.save(documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar Carro"));
        }

        /*        
        if(carro.getMarca() == null || carro.getMarca().isEmpty()) {
            validator.add(new SimpleMessage("carro.marca", "Marca está vazia!"));
        }
        if(carro.getModelo() == null || carro.getModelo().isEmpty()) {
            validator.add(new SimpleMessage("carro.modelo", "Modelo está vazio!"));
        }
         */
        //Cadastrar no banco de dados....
        //Redirecionamento
        result.redirectTo(this).list();
    }

}
