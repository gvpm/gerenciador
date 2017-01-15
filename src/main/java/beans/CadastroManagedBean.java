/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.UsuarioDAO;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author gvpm
 */
@ManagedBean(name = "CadastroMB")
@ViewScoped
public class CadastroManagedBean {

    /**
     * Creates a new instance of CadastroManagedBean
     */
    private UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    private Usuario usuario = new Usuario();
     //Parachecar se usuario esta logado
    private String nome;
    int idUsuario;

    public String cadastra() {

        
        boolean inseriu = usuarioDAO.inserirUsuario(usuario);

        if (!inseriu) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro",
                            "Erro no Cadastro"));
            return null;
        } else {
            return "cadastro.xhtml";
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
      public String getLoga() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        
        if (sessionMap.get("idUsuario") != null) {
            idUsuario = (int) sessionMap.get("idUsuario");
        } else {
            idUsuario = -1;
        }

        usuario = usuarioDAO.getUsuarioFromId(idUsuario);
        if (usuario == null) {
            nome = null;
            return "Você não está logado, volte ao Login";
        } else {
            //Preenche com o id do usuario encontrado a sessao
//            FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_ERROR, usuario.getNome(),
//                            usuario.getNome()));
            nome = usuario.getNome();
            System.out.println("Logado" + nome);

            return "Bem vindo " + nome + "!";
        }

    }

}
