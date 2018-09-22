package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.webapp.model.Documento;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;


public class MorphiaDocumentoDAO extends BasicDAO<Documento, ObjectId>{
    
    @Inject
    public MorphiaDocumentoDAO(MongoClient mongoClient) {
        super(Documento.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    
}
