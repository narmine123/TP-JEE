package tn.fst.spring.entity.entities;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Skier")
public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numSkier")
    private Long numSkier;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    //TemporalType.TIMESTAMP signifie que la colonne sera
    // stockée sous forme de TIMESTAMP en base de données.
    private Date dateOfBirth;
    @Column(name = "city")
    private String city;

@OneToMany(mappedBy = "skier")
Set<Registration>registers;

@ManyToMany(mappedBy = "skiers")
Set<Piste> pistes;

 @OneToOne
 Skier skier;


    public Skier() { }




}



