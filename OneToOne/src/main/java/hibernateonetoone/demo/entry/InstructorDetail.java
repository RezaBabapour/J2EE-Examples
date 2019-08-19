package hibernateonetoone.demo.entry;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String channal;

    @Column
    private String email;

}
