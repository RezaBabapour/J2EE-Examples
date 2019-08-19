package hibernateonetoone.demo.dao;

import hibernateonetoone.demo.entry.Instructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DAO {
    public List<Instructor> finaAll();
    public void add(Instructor instructor);
}
