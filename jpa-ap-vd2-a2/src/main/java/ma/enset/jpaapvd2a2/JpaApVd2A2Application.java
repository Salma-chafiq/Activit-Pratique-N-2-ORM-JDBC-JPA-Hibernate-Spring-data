package ma.enset.jpaapvd2a2;

import jdk.swing.interop.SwingInterOpUtils;
import ma.enset.jpaapvd2a2.entities.Patient;
import ma.enset.jpaapvd2a2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApVd2A2Application implements CommandLineRunner {
    @Autowired
    //Cherche moi l'interface et injecter
    //Cree l'interface sans cree l'implementation
    private PatientRepository patientRepository ;
    public static void main(String[] args) {
        //demarer le conteneur sprinh
        SpringApplication.run(JpaApVd2A2Application.class, args);
    }
// Automatiquement appel la methode run
    @Override
    public void run(String... args) throws Exception {
        //PARCOURIR PLUSIEUR ligne
        for (int i =0 ; i<100 ;i ++){
            patientRepository.save(
                    new Patient(null,"hassan",new Date(), Math.random() > 0.5?true :false,(int) (Math.random()*1000)));
        }

        //Affiche moi les 5 premier patient
        //Faire la pagination

//        patientRepository.save(
//                new Patient(null,"hassan",new Date(),false,56));
//        patientRepository.save(
//                new Patient(null,"Mohamed",new Date(),true,100));
//        patientRepository.save(
//                new Patient(null,"Mariam",new Date(),false,159));
        //List<Patient> patients =patientRepository.findAll();
        Page<Patient> patients =patientRepository.findAll(PageRequest.of(0,10));
        System.out.println("Total pages :"+patients.getTotalPages());
        System.out.println("Total Element"+patients.getTotalElements());
        System.out.println("Num Page"+patients.getNumber());
        List<Patient> content =patients.getContent();
        Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,4) );
        //Quelle que soit avant et quelque soit apres
        byMalade.forEach(p->{
            System.out.println("======================================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());

        });
        List<Patient> patientList= patientRepository.chercherPatients("%h%",40);
       //Page c'est un pobjet iterable
        patients.forEach(p->{
            System.out.println("======================================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());

        });
        System.out.println("******************************************");
        Patient patient=patientRepository.findById(1l).orElse(null);
        //get() si l'existe afficher sinon generer une exeption de preference utilise or else ....
        if (patient!= null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        //dans cette ligne on fait update car on a deja mensionnee que id =1
        //Par contre si l'id est est null on fait l'ajout
        patient.setScore(870);
        patientRepository.save(patient);
        //Supprimer un patient
        patientRepository.deleteById(1L);
    }

}
