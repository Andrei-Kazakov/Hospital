package by.epam.hospital.dao;

import by.epam.hospital.entity.ChamberType;

import java.util.List;

public interface ChamberTypeDao {

    List<ChamberType> findAll();

    ChamberType findChamberTypeById(Long id);

    ChamberType findChamberTypeByName(String name);

    boolean deleteChamberType(ChamberType chamberType);

    boolean insertChamberType(ChamberType chamberType);

}
