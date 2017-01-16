package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

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

}
