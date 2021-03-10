package by.epam.hospital.dao;

import by.epam.hospital.dao.impl.*;

public class MySqlDaoFactory {

    private MySqlDaoFactory() {

    }

    public static PersonDao getPersonDao() {
        return MySqlPersonDao.getInstance();
    }

    public static PersonDiagnosisDao getPersonDiagnosisDao() {
        return MySqlPersonDiagnosisDao.getInstance();
    }

    public static DiagnosisDao getDiagnosisDao() {
        return MySqlDiagnosisDao.getInstance();
    }

    public static PrescriptionDao getPrescriptionDao() {
        return MySqlPrescriptionDao.getInstance();
    }

    public static RoleDao getRoleDao() {
        return MySqlRoleDao.getInstance();
    }

    public static ChamberDao getChamberDao() {
        return MySqlChamberDao.getInstance();
    }

    public static ChamberTypeDao getChamberTypeDao() {
        return MySqlChamberTypeDao.getInstance();
    }

}
