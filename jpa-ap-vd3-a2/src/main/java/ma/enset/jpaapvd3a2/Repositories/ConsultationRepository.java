package ma.enset.jpaapvd3a2.Repositories;

import ma.enset.jpaapvd3a2.entities.Consultation;
import ma.enset.jpaapvd3a2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
