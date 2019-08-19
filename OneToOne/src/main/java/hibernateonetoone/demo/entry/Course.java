package hibernateonetoone.demo.entry;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private int instructorId;
}
