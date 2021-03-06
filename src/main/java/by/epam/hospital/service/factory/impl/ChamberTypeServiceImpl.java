package by.epam.hospital.service.factory.impl;


import by.epam.hospital.dao.ChamberTypeDao;
import by.epam.hospital.dao.MySqlDaoFactory;
import by.epam.hospital.entity.ChamberType;
import by.epam.hospital.service.ChamberTypeService;

import java.util.List;

public class ChamberTypeServiceImpl implements ChamberTypeService{

    private static volatile ChamberTypeServiceImpl chamberTypeService;

    private final ChamberTypeDao chamberTypeDao = MySqlDaoFactory.getChamberTypeDao();

    private ChamberTypeServiceImpl(){

    }

    public static ChamberTypeServiceImpl getInstance(){
        ChamberTypeServiceImpl localInstance = chamberTypeService;
        if(localInstance == null){
            synchronized (ChamberTypeServiceImpl.class){
                localInstance = chamberTypeService;
                if(localInstance == null){
                    chamberTypeService = localInstance = new ChamberTypeServiceImpl();
                }
            }
        }
        return localInstance;
    }


    @Override
    public List<ChamberType> findAll() {
        return chamberTypeDao.findAll();
    }

    @Override
    public ChamberType findChamberTypeById(Long id) {
        return chamberTypeDao.findChamberTypeById(id);
    }

    @Override
    public ChamberType findChamberTypeByName(String name) {
        return chamberTypeDao.findChamberTypeByName(name);
    }

    @Override
    public boolean deleteChamberType(ChamberType chamberType) {
        return chamberTypeDao.deleteChamberType(chamberType);
    }

    @Override
    public boolean insertChamberType(ChamberType chamberType) {
        return chamberTypeDao.insertChamberType(chamberType);
    }
}
