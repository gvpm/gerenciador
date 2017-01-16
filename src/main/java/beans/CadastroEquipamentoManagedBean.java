/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.SalaDAO;
import db.UsuarioDAO;
import db.EquipamentoDAO;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Equipamento;

/**
 *
 * @author gvpm
 */
@ManagedBean(name = "CadastroEquipamentoMB")

@ViewScoped
public class CadastroEquipamentoManagedBean {

    /**
     * Creates a new instance of CadastroManagedBean
     */
    private EquipamentoDAO equipamentoDAO = EquipamentoDAO.getInstance();
    private Equipamento equipamento = new Equipamento();


    public String cadastra() {

        
        boolean inseriu = equipamentoDAO.inserirEquipamento(equipamento);

        if (!inseriu) {
            equipamento = new Equipamento();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro",
                            "Erro no Cadastro"));
            return null;
        } else {
            return "gerente.xhtml";
        }

    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setSala(Equipamento equipamento) {
        this.equipamento = equipamento;
    }


}
