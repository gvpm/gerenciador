package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import model.Equipamento;

import model.Sala;
import model.SolicitacaoSala;

public class SolicitacaoSalaDAO {

    private static SolicitacaoSalaDAO instance;

    private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();

    private SolicitacaoSalaDAO() {

    }

    public static SolicitacaoSalaDAO getInstance() {

        if (instance == null) {
            instance = new SolicitacaoSalaDAO();
        }
        return instance;

    }

    public boolean inserirSolicitacaoSala(SolicitacaoSala sala) {
        try {
            em.getTransaction().begin();
            em.persist(sala);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarSolicitacaoSala(SolicitacaoSala sala) {
        try {
            em.remove(sala);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sala> salasReservadas() {
        return null;
    }

    public List<SolicitacaoSala> todasSolicitacaoSala() {
        List<SolicitacaoSala> result = em.createQuery("Select re FROM SolicitacaoSala as re WHERE re.estado= :estado ").setParameter("estado", "Solicitado").getResultList();

        return result;
    }

    public List<SolicitacaoSala> todasSolicitacaoSalaPorId() {
        List<SolicitacaoSala> result = em.createQuery("FROM SolicitacaoSala").getResultList();
        return result;
    
    }
 


}
