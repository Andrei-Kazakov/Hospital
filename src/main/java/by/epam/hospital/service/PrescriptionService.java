package by.epam.hospital.service;

import by.epam.hospital.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> findAll();

    Prescription findPrescriptionById(Long id);

    boolean updatePrescription(Prescription prescription);

    boolean deletePrescription(Prescription prescription);

    boolean insertPrescription(Prescription prescription);


}
