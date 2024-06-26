package ma.enset.jpaapvd3a2.Repositories;

import ma.enset.jpaapvd3a2.entities.Medecin;
import ma.enset.jpaapvd3a2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom (String nom);
}
