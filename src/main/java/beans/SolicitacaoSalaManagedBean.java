package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import db.EquipamentoDAO;
import db.SalaDAO;
import db.SolicitacaoSalaDAO;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import model.Equipamento;
import model.Sala;
import model.SolicitacaoSala;

@ManagedBean(name = "SolicitacaoSalaMB")
@ViewScoped
public class SolicitacaoSalaManagedBean {

    private SolicitacaoSalaDAO solicitacaoSalaDAO = SolicitacaoSalaDAO.getInstance();
    
    
    

    public List<SolicitacaoSala> getList(){
        return solicitacaoSalaDAO.todasSolicitacaoSala();
    }
    
    
}