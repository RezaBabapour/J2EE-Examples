package hibernateonetoone.demo.rest;

import hibernateonetoone.demo.dao.DAO;
import hibernateonetoone.demo.entry.Instructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InsRest {

    private DAO dao;

    public InsRest(DAO dao) {
        this.dao = dao;
    }

    @GetMapping("/ins")
    public List<Instructor> findAll() {
        return dao.finaAll();
    }

    @PostMapping("/ins")
    public void add(@RequestBody Instructor instructor) {
        dao.add(instructor);
    }
}
