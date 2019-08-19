package hibernateonetoone.demo.dao;

import hibernateonetoone.demo.entry.Instructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Data
public class DAO_hibernate implements DAO {
    private EntityManager entityManager;

    public DAO_hibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void add(Instructor instructor) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(instructor);

    }

    @Transactional
    @Override
    public List<Instructor> finaAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Instructor> theQuery = currentSession.createQuery("from Instructor", Instructor.class);
        List<Instructor> instructors = theQuery.getResultList();
        return instructors;

    }
}
