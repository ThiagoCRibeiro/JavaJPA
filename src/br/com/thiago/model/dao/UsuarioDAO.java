
package br.com.thiago.model.dao;

import br.com.thiago.model.bean.Usuario;
import br.com.thiago.model.connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class UsuarioDAO {
    
    public Usuario save(Usuario usuario){
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            
            em.getTransaction().begin();
            if(usuario.getId()==null){
                em.persist(usuario);
            }else{
                em.merge(usuario);
            }
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return usuario;
    }
    
    public Usuario finById(Integer Id){
       
        EntityManager em = new ConnectionFactory().getConnection();
        Usuario usuario = null;
        
        try {
           usuario = em.find(Usuario.class, Id);
           
        } catch (Exception e) {
            System.err.println(e); 
        }finally{
            em.close();
        }
        
        return usuario;
    }
    
    public List<Usuario> findAll/*buscar todos*/(){
        
        EntityManager em = new ConnectionFactory().getConnection();
        List<Usuario>usuarios = null;
        
        try {
          usuarios = em.createQuery("from usuario u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return usuarios;
    }
    
    public Usuario remove(Integer Id){
        
         EntityManager em = new ConnectionFactory().getConnection();
         Usuario usuario = null;
         
         try {
             
             usuario = em.find(Usuario.class, Id);
             em.getTransaction().begin();
             em.remove(usuario);
             em.getTransaction().commit();
             
        } catch (Exception e) {
             System.err.println(e);
             em.getTransaction().rollback();
        }finally{
             em.close();
         }
        return usuario;
    }
       	
	public Usuario consultarUsuario(String login, String senha) {
		
		Usuario usuario = null;
		
                EntityManager em = new ConnectionFactory().getConnection();
                EntityTransaction et = em.getTransaction();
		et.begin();
		em.getTransaction().begin();
		
		usuario = (Usuario) em.createQuery("select u from Usuario u where p.login"
                        + " = '" + login + "' and p.senha = '" + senha + "'").getSingleResult();
		
		et.commit();
		em.close();
		
		return usuario;
	}
       
}
