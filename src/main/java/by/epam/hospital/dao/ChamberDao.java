package by.epam.hospital.dao;

import by.epam.hospital.entity.Chamber;

import java.util.List;


public interface ChamberDao {

    List<Chamber> findAll();

    List<Chamber> findAllByType(String type);

    Chamber findChamberById(Long id);

    boolean updateChamber(Chamber chamber);

    boolean deleteChamber(Chamber chamber);

    boolean insertChamber(Chamber chamber);

}
