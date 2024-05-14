package ma.enset.jpaapvd2a2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//Lombok ajoute les getters et les setters
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    //Informer que id est le cle primaire
    //Generer les valeur par defaut autoincrement
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(length = 50)
    private String nom ;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;
    private boolean malade ;
    private int score ;
}
