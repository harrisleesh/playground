package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
            Team teamB = new Team();
            teamB.setName("TeamB");
            em.persist(teamB);

            Member member = new Member();
            member.setName("harris");
            member.setTeam(team);
            em.persist(member);
            Member member3 = new Member();
            member3.setName("harris3");
            member3.setTeam(team);
            em.persist(member3);
            Member member2 = new Member();
            member2.setName("harris2");
            member2.setTeam(teamB);
            em.persist(member2);
            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("findAgain : " + findMember.getName());
//            em.flush();
//            em.clear();
//            System.out.println("findAgain : " + findMember.getName());
//            System.out.println("findMember = " + findMember.getTeam().getClass());
//            System.out.println("findMember = " + findMember.getTeam().getName());

            List<Member> members = em.createQuery("select m from Member m", Member.class)
                    .getResultList();
            for (Member m : members) {
                System.out.println("m.getTeam().getName() = " + m.getTeam().getName());
            }
//            List<Team> teams = em.createQuery("select t from Team t", Team.class)
//                    .getResultList();
//            for (Team t: teams) {
//                System.out.println("t.getMembers() = " + t.getMembers().get(0).getName());
//            }
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();
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
