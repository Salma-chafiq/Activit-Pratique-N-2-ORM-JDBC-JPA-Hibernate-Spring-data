package ma.enset.jpaapvd3a2.Repositories;

import ma.enset.jpaapvd3a2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name );
}
