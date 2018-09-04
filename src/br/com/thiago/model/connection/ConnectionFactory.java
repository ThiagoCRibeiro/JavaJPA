
package br.com.thiago.model.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    
    public EntityManager getConnection(){
        return emf.createEntityManager();
    }
    
}
