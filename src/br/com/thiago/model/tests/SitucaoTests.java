
package br.com.thiago.model.tests;

import br.com.thiago.model.bean.SituacaoUsuario;
import br.com.thiago.model.connection.ConnectionFactory;
import br.com.thiago.model.dao.SituacaoUsuarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SitucaoTests {
    
    public static void main(String[] args) {
        
       //Criar tabela no banco e inserir dados
        SituacaoUsuarioDAO dao = new SituacaoUsuarioDAO();
        SituacaoUsuario s = new SituacaoUsuario();
        s.setSituacao("Inativo");
        
        
        dao.save(s);
        
    }
}