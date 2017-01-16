/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.SalaDAO;
import db.SolicitacaoSalaDAO;
import db.UsuarioDAO;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Sala;
import model.SolicitacaoSala;

/**
 *
 * @author gvpm
 */
@ManagedBean(name = "CadastroSolicitacaoSalaMB")

@ViewScoped
public class CadastroSolicitacaoSalaManagedBean {

    /**
     * Creates a new instance of CadastroManagedBean
     */
    private SolicitacaoSalaDAO solicitacaoSalaDAO = SolicitacaoSalaDAO.getInstance();
    private SolicitacaoSala sala = new SolicitacaoSala();
    private SolicitacaoSala salaAtual = new SolicitacaoSala();


    public String cadastra() {

        
        boolean inseriu = solicitacaoSalaDAO.inserirSolicitacaoSala(sala);

        if (!inseriu) {
            sala = new SolicitacaoSala();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro",
                            "Erro no Cadastro"));
            return null;
        } else {
            return "gerentesolicitacao.xhtml";
        }

    }

    public SolicitacaoSala getSolicitacaoSala() {
        return sala;
    }

    public void setSolicitacaoSala(SolicitacaoSala sala) {
        this.sala = sala;
    }


}
