package db;

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
