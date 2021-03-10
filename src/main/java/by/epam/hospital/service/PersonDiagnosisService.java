package by.epam.hospital.service;


import by.epam.hospital.entity.PersonDiagnosis;

import java.util.List;

public interface PersonDiagnosisService {

    List<PersonDiagnosis> findAllByPatientId(Long idPatient);

    List<PersonDiagnosis> findAllByStaffId(Long idStaff);

    List<PersonDiagnosis> findAllOpenByStaffId(Long idStaff);

    List<PersonDiagnosis> findAllByPatientAndDoctorId(Long idPatient, Long idDoctor);

    List<PersonDiagnosis> findAllForNurse();

    PersonDiagnosis findPersonDiagnosis(Long idPatient, Long idStaff, Long idPrescription, Long idDiagnosis);

    boolean updatePatientDiagnosis(PersonDiagnosis personDiagnosis);

    boolean deletePatientDiagnosis(PersonDiagnosis personDiagnosis);

    boolean insertPatientDiagnosis(PersonDiagnosis personDiagnosis);
}
