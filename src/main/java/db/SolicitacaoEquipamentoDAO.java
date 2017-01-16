package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Equipamento;
import model.SolicitacaoEquipamento;

public class SolicitacaoEquipamentoDAO {

    private static SolicitacaoEquipamentoDAO instance;

    private EntityManagerFactory factory = Persistence
.createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();
    
    
    private SolicitacaoEquipamentoDAO() {

    }

    public static SolicitacaoEquipamentoDAO getInstance() {

        if (instance == null) {
            instance = new SolicitacaoEquipamentoDAO();
        }
        return instance;

    }

    public List<SolicitacaoEquipamento> todosSolicitacaoEquipamento(){
        List<SolicitacaoEquipamento> result = em.createQuery("Select re FROM SolicitacaoEquipamento as re WHERE re.estado= :estado ").setParameter("estado", "Solicitado").getResultList();
        return result;
    }
    
    
    public List<SolicitacaoEquipamento> equipamentosReservados(){
//        select equipamento.*,solicitacao_equipamento.dia_semana,solicitacao_equipamento.hora_inicio,solicitacao_equipamento.hora_fim from reserva_equipamento
//        return em.createQuery("FROM  ReservaEquipamento as re, re.idSolicitacaoEquipamento as se, se.idEquipamento as eq"
//                + " WHERE re.ativo = 1 ").getResultList();
           System.out.println(em.createQuery("select eq,se.diaSemana,se.horaInicio,se.horaFim from ReservaEquipamento as re inner join re.idSolicitacaoEquipamento as se inner join se.idEquipamento as eq where re.ativo =1").getResultList().get(0));

           return em.createQuery("select eq from ReservaEquipamento as re inner join re.idSolicitacaoEquipamento as se inner join se.idEquipamento as eq where re.ativo =1").getResultList();
    }

    public boolean inserirSolicitacaoEquipamento(SolicitacaoEquipamento equipamento) {
        try {
            em.getTransaction().begin();
            em.persist(equipamento);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarSolicitacaoEquipamento(SolicitacaoEquipamento equipamento) {
        try {
            em.remove(equipamento);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SolicitacaoEquipamento> todosSolicitacaoEquipamentoPorId() {
        //List<SolicitacaoEquipamento> result = em.createQuery("Select re FROM SolicitacaoEquipamento as re WHERE re.estado= :estado ").setParameter("estado", "Solicitado").getResultList();
        List<SolicitacaoEquipamento> result = em.createQuery("FROM SolicitacaoEquipamento").getResultList();

        return result;    
    }

}
