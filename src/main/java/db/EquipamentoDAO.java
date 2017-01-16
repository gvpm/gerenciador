package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Equipamento;

public class EquipamentoDAO {

    private static EquipamentoDAO instance;

    private EntityManagerFactory factory = Persistence
.createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();
    
    
    private EquipamentoDAO() {

    }

    public static EquipamentoDAO getInstance() {

        if (instance == null) {
            instance = new EquipamentoDAO();
        }
        return instance;

    }

    public List<Equipamento> todosEquipamentos(){
        List<Equipamento> result = em.createQuery("FROM Equipamento").getResultList();
        return result;
    }
    
    
    public List<Equipamento> equipamentosReservados(){
//        select equipamento.*,solicitacao_equipamento.dia_semana,solicitacao_equipamento.hora_inicio,solicitacao_equipamento.hora_fim from reserva_equipamento
//        return em.createQuery("FROM  ReservaEquipamento as re, re.idSolicitacaoEquipamento as se, se.idEquipamento as eq"
//                + " WHERE re.ativo = 1 ").getResultList();
           System.out.println(em.createQuery("select eq,se.diaSemana,se.horaInicio,se.horaFim from ReservaEquipamento as re inner join re.idSolicitacaoEquipamento as se inner join se.idEquipamento as eq where re.ativo =1").getResultList().get(0));

           return em.createQuery("select eq from ReservaEquipamento as re inner join re.idSolicitacaoEquipamento as se inner join se.idEquipamento as eq where re.ativo =1").getResultList();
    }

    public boolean inserirEquipamento(Equipamento equipamento) {
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

    public boolean deletarEquipamento(Equipamento equipamento) {
        try {
            em.remove(equipamento);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
