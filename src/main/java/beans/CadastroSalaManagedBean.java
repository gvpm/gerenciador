/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.SalaDAO;
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

/**
 *
 * @author gvpm
 */
@ManagedBean(name = "CadastroSalaMB")

@ViewScoped
public class CadastroSalaManagedBean {

    /**
     * Creates a new instance of CadastroManagedBean
     */
    private SalaDAO salaDAO = SalaDAO.getInstance();
    private Sala sala = new Sala();
    private Sala salaAtual = new Sala();


    public String cadastra() {

        
        boolean inseriu = salaDAO.inserirSala(sala);

        if (!inseriu) {
            sala = new Sala();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro",
                            "Erro no Cadastro"));
            return null;
        } else {
            return "gerente.xhtml";
        }

    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


}
