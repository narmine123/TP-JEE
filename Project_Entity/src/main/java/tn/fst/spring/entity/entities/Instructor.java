package tn.fst.spring.entity.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Instructor")
public class Instructor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInstructor;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfHire;
 @OneToMany
 Set<Course> courses;
}
