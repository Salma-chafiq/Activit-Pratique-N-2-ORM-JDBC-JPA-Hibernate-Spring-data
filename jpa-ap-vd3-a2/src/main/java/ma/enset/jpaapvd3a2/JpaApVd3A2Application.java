package ma.enset.jpaapvd3a2;

import ma.enset.jpaapvd3a2.Repositories.ConsultationRepository;
import ma.enset.jpaapvd3a2.Repositories.MedecinRepository;
import ma.enset.jpaapvd3a2.Repositories.PatientRepository;
import ma.enset.jpaapvd3a2.Repositories.RendezVousRepository;
import ma.enset.jpaapvd3a2.entities.*;
import ma.enset.jpaapvd3a2.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class JpaApVd3A2Application {

	public static void main(String[] args) {

		SpringApplication.run(JpaApVd3A2Application.class, args);
	}
	// @Bean Une methode qui va s'execute au moment du demarage
	//Pour injecter quelque chose just de le mettre dans les paramettre de la methode start
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,RendezVousRepository rendezVousRepository,MedecinRepository medecinRepository){
		//autowierd pour l'injection
		//ce blog executer au moment du demarage
		return args -> {
			//Dans cette methode on doit specifier le rendez vous
			//cest pour cela de preference on utilise le constructeur sans parametre
			//patientRepository.save(new Patient(null,"Hassan" ,new Date(),false,null));
			//Creation de 4 patient
			Stream.of("Mohamed","Hassan","Najat")
			.forEach (name->{
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				patientRepository.save(patient);
			});
			Stream.of("Ayman","Hanan","Yassmine")
					.forEach (name->{
						Medecin medecin =new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medecinRepository.save(medecin);
					});
			Patient patient=patientRepository.findById(1L).orElse(null);
			Patient patient1 =patientRepository.findByNom("Mohamed");
			Medecin medecin=medecinRepository.findByNom("Yassmine");

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
			System.out.println(saveDRDV.getId());

			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
			Consultation consultation =new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport consultation ..............");
			hospitalService.saveConsultation(consultation);
		};
	}


}
