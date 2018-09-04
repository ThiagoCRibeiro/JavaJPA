package br.com.thiago.model.dao;

import br.com.thiago.model.bean.NivelUsuario;
import br.com.thiago.model.connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

public class NivelUsuarioDAO {

    public NivelUsuario save(NivelUsuario nivelUsuario) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (nivelUsuario.getId()== null) {
                em.persist(nivelUsuario);
            } else {
                em.merge(nivelUsuario);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return nivelUsuario;
    }

    public NivelUsuario findByID/*busca por id*/(Integer Id) {

        EntityManager em = new ConnectionFactory().getConnection();
        NivelUsuario nivelUsuario = null;

        try {
            nivelUsuario = em.find(NivelUsuario.class, Id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return nivelUsuario;
    }

    public List<NivelUsuario> findAll/*buscar todos*/() {
        
        EntityManager em = new ConnectionFactory().getConnection();
        List<NivelUsuario> nivelUsuarios = null;
        
        try {
            nivelUsuarios = em.createQuery("from nivelusuario n").getResultList();
            
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return nivelUsuarios;
    }

 public NivelUsuario remove(Integer Id)  {
     
      EntityManager em = new ConnectionFactory().getConnection();
     NivelUsuario nivelUsuario = null;
     try {
         nivelUsuario =em.find(NivelUsuario.class, Id);
         
         em.getTransaction().begin();
         em.remove(nivelUsuario);
         em.getTransaction().commit();
         
     } catch (Exception e) {
         System.err.println(e);
         em.getTransaction().rollback();
     }finally{
         em.close();
     }
     return nivelUsuario;
 } 
    
}
