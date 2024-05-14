package com.example.jpaapvd4a2.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="DESCRIPTION")
    private String desc ;
    @Column(length = 20 ,unique=true)
    private String roleName;
    @ManyToMany (fetch = FetchType.EAGER)
    //  Quand on va utiliser eager on doit initialiser la list
    // et le raison pour evite l'exeption Null Pointer
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<User> users = new ArrayList<>();
}
