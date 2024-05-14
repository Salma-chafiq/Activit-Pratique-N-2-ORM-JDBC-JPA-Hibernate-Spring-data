package ma.enset.jpaapvd3a2.service;

import ma.enset.jpaapvd3a2.entities.Consultation;
import ma.enset.jpaapvd3a2.entities.Medecin;
import ma.enset.jpaapvd3a2.entities.Patient;
import ma.enset.jpaapvd3a2.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV (RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
