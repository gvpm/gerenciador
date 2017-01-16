package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import db.EquipamentoDAO;
import db.SolicitacaoEquipamentoDAO;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import model.Equipamento;
import model.SolicitacaoEquipamento;

@ManagedBean(name = "SolicitacaoEquipamentoMB")
@ViewScoped
public class SolicitacaoEquipamentoManagedBean {

    private SolicitacaoEquipamentoDAO solicitacaoEquipamentoDAO = SolicitacaoEquipamentoDAO.getInstance();
    
    
    
     public List<SolicitacaoEquipamento> getListReservados(){
         return solicitacaoEquipamentoDAO.equipamentosReservados();
     }
    public List<SolicitacaoEquipamento> getList(){
        return solicitacaoEquipamentoDAO.todosSolicitacaoEquipamento();
    }
    
    
}