package by.epam.hospital.service;

import by.epam.hospital.entity.Chamber;

import java.util.List;

public interface ChamberService {

    List<Chamber> findAllFree();

    List<Chamber> findAllFreeByType(String s);

    Chamber findChamberById(Long idChamber);

    List<Chamber> findAll();

    boolean insertChamber(Chamber chamber);

    boolean deleteChamber(Chamber chamber);

}
