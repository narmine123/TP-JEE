package tn.fst.spring.entity.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Registration")
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numRegistration;
    @Column(name="numWeek")
    private int numWeek;

    @ManyToOne()
    Skier skier;

    @ManyToOne()
    Course course;


}
