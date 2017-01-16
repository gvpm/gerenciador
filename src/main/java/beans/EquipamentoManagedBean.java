package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import db.EquipamentoDAO;
import java.util.Map;
import javax.faces.context.ExternalContext;
import model.Equipamento;

@ManagedBean(name = "EquipamentoMB")
@ViewScoped
public class EquipamentoManagedBean {

    private EquipamentoDAO equipamentoDAO = EquipamentoDAO.getInstance();
    
    
    
    
}