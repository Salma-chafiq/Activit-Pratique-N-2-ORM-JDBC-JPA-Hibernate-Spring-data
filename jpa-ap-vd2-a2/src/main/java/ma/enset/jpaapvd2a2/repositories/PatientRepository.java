package ma.enset.jpaapvd2a2.repositories;

import ma.enset.jpaapvd2a2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//Mapping Objet relationnel EST TERMINER
public interface PatientRepository extends JpaRepository<Patient,Long> {
    //le magic de spring et la genericite

    public List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade(boolean m , Pageable pageable);
    List<Patient> findByMaladeAndScoreLessThan(boolean m ,int score);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1 , Date d2,String mc);
    @Query ("select p from Patient p where p.nom like :x and p.score < :y")
    List<Patient> chercherPatients(@Param("x") String nom ,@Param("y") int scoreMin );


}
