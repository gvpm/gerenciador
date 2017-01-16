package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import db.EquipamentoDAO;
import db.SalaDAO;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import model.Equipamento;
import model.Sala;

@ManagedBean(name = "SalaMB")
@ViewScoped
public class SalaManagedBean {

    private SalaDAO salaDAO = SalaDAO.getInstance();
    
    
    
     public List<Sala> getListReservados(){
         return salaDAO.salasReservadas();
     }
    public List<Sala> getList(){
        return salaDAO.todasSalas();
    }
    
    
}