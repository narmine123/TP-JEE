package tn.fst.spring.entity.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCourse;

    @Column(name="level")
    private int level;
    @Column(name = "TypeCourse")
    private String typeCourse;
    @Column(name="Support")
    private String support;
    @Column(name="price")
    private float price;
    @Column(name="timeSlot")
    private int timeSlot;

    @OneToMany(mappedBy = "course")
    Set<Registration> registers;

}
