package tn.fst.spring.entity.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Piste")
public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numPiste")
    private Long numPiste;

    @Column(name = "namePiste")
    private String namePiste;

    @Column(name = "color")
    private String color;

    @Column(name = "length")
    private int length;

    @Column(name = "slope")
    private int slope;

    public Piste() { }

    public Piste(String namePiste, String color, int length, int slope) {
        this.namePiste = namePiste;
        this.color = color;
        this.length = length;
        this.slope = slope;
    }

    // Getters et Setters
    public Long getNumPiste() { return numPiste; }
    public void setNumPiste(Long numPiste) { this.numPiste = numPiste; }

    public String getNamePiste() { return namePiste; }
    public void setNamePiste(String namePiste) { this.namePiste = namePiste; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public int getSlope() { return slope; }
    public void setSlope(int slope) { this.slope = slope; }
@ManyToMany( )
Set<Skier> skiers;

}
