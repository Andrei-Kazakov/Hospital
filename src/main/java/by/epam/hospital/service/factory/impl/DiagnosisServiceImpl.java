package by.epam.hospital.service.factory.impl;

import by.epam.hospital.dao.DiagnosisDao;
import by.epam.hospital.dao.MySqlDaoFactory;
import by.epam.hospital.entity.Diagnosis;
import by.epam.hospital.service.DiagnosisService;

import java.util.List;

public class DiagnosisServiceImpl implements DiagnosisService {

    private static volatile DiagnosisServiceImpl diagnosisService;

    private static final DiagnosisDao diagnosisDao = MySqlDaoFactory.getDiagnosisDao();

    private DiagnosisServiceImpl() {

    }

    public static DiagnosisServiceImpl getInstance() {
        DiagnosisServiceImpl localInstance = diagnosisService;
        if (localInstance == null) {
            synchronized (DiagnosisServiceImpl.class) {
                localInstance = diagnosisService;
                if (localInstance == null) {
                    diagnosisService = localInstance = new DiagnosisServiceImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public List<Diagnosis> findAll() {
        return diagnosisDao.findAll();
    }

    @Override
    public Diagnosis findDiagnosisById(Long id) {
        return diagnosisDao.findDiagnosisById(id);
    }

    @Override
    public boolean updateDiagnosis(Diagnosis diagnosis) {
        return diagnosisDao.updateDiagnosis(diagnosis);
    }

    @Override
    public boolean deleteDiagnosis(Diagnosis diagnosis) {
        return diagnosisDao.deleteDiagnosis(diagnosis);
    }

    @Override
    public boolean insertDiagnosis(Diagnosis diagnosis) {
        return diagnosisDao.insertDiagnosis(diagnosis);
    }
}
