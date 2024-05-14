package ma.enset.jpaapvd3a2.service;

import ma.enset.jpaapvd3a2.Repositories.ConsultationRepository;
import ma.enset.jpaapvd3a2.Repositories.MedecinRepository;
import ma.enset.jpaapvd3a2.Repositories.PatientRepository;
import ma.enset.jpaapvd3a2.Repositories.RendezVousRepository;
import ma.enset.jpaapvd3a2.entities.Consultation;
import ma.enset.jpaapvd3a2.entities.Medecin;
import ma.enset.jpaapvd3a2.entities.Patient;
import ma.enset.jpaapvd3a2.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    //l'injection des dependances
    //1ere methode :Autowired c'est inject pour chaque repository
    //2eme methode :c'est le constructeur


    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    //Declarer les interface
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        //UUID c'est un chaine de caractere qui unique
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
