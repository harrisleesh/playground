package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("harris");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.getReference(Member.class, member.getId());
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("findAgain : " + findMember.getName());
            em.flush();
            em.clear();
            System.out.println("findAgain : " + findMember.getName());
//            System.out.println("refMember : " + refMember.getName());
//            em.flush();
//            em.clear();
//            System.out.println("refAgain : " + refMember.getName());
//            System.out.println("refMember = " + refMember.getClass());
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("findMember == refMember : " + (refMember == findMember));
            tx.commit();
        }
        catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
