package by.epam.hospital.service.factory.impl;

import by.epam.hospital.dao.PrescriptionDao;
import by.epam.hospital.dao.MySqlDaoFactory;
import by.epam.hospital.entity.Prescription;
import by.epam.hospital.service.PrescriptionService;

import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {

    private static volatile PrescriptionServiceImpl prescriptionService;

    private static final PrescriptionDao prescriptionDao = MySqlDaoFactory.getPrescriptionDao();

    private PrescriptionServiceImpl() {

    }

    public static PrescriptionServiceImpl getInstance() {
        PrescriptionServiceImpl localInstance = prescriptionService;
        if (localInstance == null) {
            synchronized (PersonDiagnosisServiceImpl.class) {
                localInstance = prescriptionService;
                if (localInstance == null) {
                    prescriptionService = localInstance = new PrescriptionServiceImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionDao.findAll();
    }

    @Override
    public Prescription findPrescriptionById(Long idPrescription) {
        return prescriptionDao.findPrescriptionById(idPrescription);
    }

    @Override
    public boolean insertPrescription(Prescription prescription) {
        return prescriptionDao.insertPrescription(prescription);
    }

    @Override
    public boolean updatePrescription(Prescription prescription) {
        return prescriptionDao.updatePrescription(prescription);
    }

    @Override
    public boolean deletePrescription(Prescription prescription) {
        return prescriptionDao.deletePrescription(prescription);
    }

}
