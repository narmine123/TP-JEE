package tn.fst.spring.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;
@Entity
@Table( name ="Etudiant")
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @ManyToOne
    private Department dept;;

// Constructeur et accesseurs (getters) et mutateurs (setters)


    public Etudiant() {
    }

}

