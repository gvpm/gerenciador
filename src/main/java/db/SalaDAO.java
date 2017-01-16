package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import model.Equipamento;

import model.Sala;

public class SalaDAO {

    private static SalaDAO instance;

    private EntityManagerFactory factory = Persistence
.createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();
    
    
    private SalaDAO() {

    }

    public static SalaDAO getInstance() {

        if (instance == null) {
            instance = new SalaDAO();
        }
        return instance;

    }




    public boolean inserirSala(Sala sala) {
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

    public boolean deletarSala(Sala sala) {
        try {
            em.remove(sala);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sala> salasReservadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Sala> todasSalas() {
        List<Sala> result = em.createQuery("FROM Sala").getResultList();
        return result;    }

}
