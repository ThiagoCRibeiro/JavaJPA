
package br.com.thiago.model.dao;


import br.com.thiago.model.bean.SituacaoUsuario;
import br.com.thiago.model.connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

public class SituacaoUsuarioDAO {
    
    public SituacaoUsuario save(SituacaoUsuario situacaoUsuario) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (situacaoUsuario.getId()== null) {
                em.persist(situacaoUsuario);
            } else {
                em.merge(situacaoUsuario);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return situacaoUsuario;
    }

    public SituacaoUsuario findByID/*busca por id*/(Integer Id) {

        EntityManager em = new ConnectionFactory().getConnection();
        SituacaoUsuario situacaoUsuario = null;

        try {
            situacaoUsuario = em.find(SituacaoUsuario.class, Id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return situacaoUsuario;
    }

    public List<SituacaoUsuario> findAll/*buscar todos*/() {
        
        EntityManager em = new ConnectionFactory().getConnection();
        List<SituacaoUsuario> situacaoUsuario = null;
        
        try {
            situacaoUsuario = em.createQuery("from situacaousuario s").getResultList();
            
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return situacaoUsuario;
    }

 public SituacaoUsuario remove(Integer Id)  {
     
      EntityManager em = new ConnectionFactory().getConnection();
     SituacaoUsuario situacaoUsuario = null;
     try {
         situacaoUsuario =em.find(SituacaoUsuario.class, Id);
         
         em.getTransaction().begin();
         em.remove(situacaoUsuario);
         em.getTransaction().commit();
         
     } catch (Exception e) {
         System.err.println(e);
         em.getTransaction().rollback();
     }finally{
         em.close();
     }
     return situacaoUsuario;
 } 
    
}
