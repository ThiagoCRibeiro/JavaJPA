
package br.com.thiago.model.tests;

import br.com.thiago.model.bean.NivelUsuario;
import br.com.thiago.model.bean.SituacaoUsuario;
import br.com.thiago.model.bean.Usuario;
import br.com.thiago.model.dao.UsuarioDAO;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UsuarioTests {
    
    //SALVAR E ATUALIZAR 
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        NivelUsuario n = new NivelUsuario();
        n.setId(2);
        SituacaoUsuario s = new SituacaoUsuario();
        s.setId(2);
        
        Usuario usuario = new Usuario();
        //usuario.setId_Usuario(1); PARA ATUALIZAR TIRA O COMENTARIOS DESSE ID
        usuario.setNome("teste");
        usuario.setLogin("teste");
        usuario.setSenha("123");
        Calendar data = new GregorianCalendar();
        data.set(Calendar.YEAR, 2018);
        data.set(Calendar.MONTH, 9);
        data.set(Calendar.DAY_OF_MONTH, 2);
        usuario.setDataCad(data.getTime());
        usuario.setNivelUsuario(n);
        usuario.setSituacaoUsuario(s);
        
        dao.save(usuario);
    }
    
}
    /*BUSCAR POR ID
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.finById(1);
        System.out.println("Nome: "+u.getNome_Usuario());
        System.out.println("Login: "+u.getLogin_Usuario());
        System.out.println("Senha: "+u.getSenha_Usuario());
        System.out.println("Data de Cadastro: "+u.getDataCad_Usuario());
        System.out.println("Nível: "+u.getNivelUsuario().getNivel_NivelUsuario());
        System.out.println("Situação: "+u.getSituacaoUsuario().getSit_SituacaoUsuario());
    }*/
    
    /*BUSCAR TODOS
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        for(Usuario u : dao.findAll()){
            System.out.println("Nome: "+u.getNome_Usuario());
            System.out.println("Login: "+u.getLogin_Usuario());
            System.out.println("Senha: "+u.getSenha_Usuario());
            System.out.println("Data de Cadastro: "+u.getDataCad_Usuario());
            System.out.println("Nível: "+u.getNivelUsuario().getNivel_NivelUsuario());
            System.out.println("Situação: "+u.getSituacaoUsuario().getSit_SituacaoUsuario());  
        }
        
    }*/
    /*REMOVER
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        dao.remove(3);
    
    }
    
}*/
