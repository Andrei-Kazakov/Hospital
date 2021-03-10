package by.epam.hospital.dao;


import by.epam.hospital.entity.Prescription;

import java.util.List;

public interface PrescriptionDao {

    List<Prescription> findAll();

    Prescription findPrescriptionById(Long id);

    boolean updatePrescription(Prescription prescription);

    boolean deletePrescription(Prescription prescription);

    boolean insertPrescription(Prescription prescription);

}
