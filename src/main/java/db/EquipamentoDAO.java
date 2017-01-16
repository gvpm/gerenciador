package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import model.Equipamento;;

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

//    public Equipamento getEquipamento(String login, String senha) {
//
//        try {
//            Equipamento Equipamento = (Equipamento) em
//                    .createQuery(
//                            "SELECT u from Equipamento u where u.Equipamento = :Equipamento and u.senha = :senha")
//                    .setParameter("Equipamento", login)
//                    .setParameter("senha", senha).getSingleResult();
//
//            return Equipamento;
//        } catch (NoResultException e) {
//            return null;
//        }
//    }

    public Equipamento getEquipamentoFromId(int id) {

        try {
            Equipamento Equipamento = (Equipamento) em
                    .createQuery(
                            "SELECT u from Equipamento u where u.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            return Equipamento;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirEquipamento(Equipamento Equipamento) {
        try {
            em.getTransaction().begin();
            em.persist(Equipamento);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarEquipamento(Equipamento Equipamento) {
        try {
            em.remove(Equipamento);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
