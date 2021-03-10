package by.epam.hospital.service;

import by.epam.hospital.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    List<Person> findAllByRole(String role);

    List<Person> findAllHealthyPatients();

    List<Person> findAllInSpecificChamber(Long idChamber);

    Person findPersonById(Long id);

    boolean updatePerson(Person person);

    boolean deletePerson(Person person);

    boolean insertPerson(Person person);

    Person login(String email, String password);

    boolean checkEmail(String email);

    boolean changePersonPassword(Person person);

    boolean updateChamber(Person patient);
}
