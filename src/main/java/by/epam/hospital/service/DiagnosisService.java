package by.epam.hospital.service;

import by.epam.hospital.entity.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    List<Diagnosis> findAll();

    Diagnosis findDiagnosisById(Long id);

    boolean updateDiagnosis(Diagnosis diagnosis);

    boolean deleteDiagnosis(Diagnosis diagnosis);

    boolean insertDiagnosis(Diagnosis diagnosis);

}
