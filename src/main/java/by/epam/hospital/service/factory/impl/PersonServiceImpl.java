package by.epam.hospital.service.factory.impl;

import by.epam.hospital.dao.PersonDao;
import by.epam.hospital.dao.MySqlDaoFactory;
import by.epam.hospital.entity.Person;
import by.epam.hospital.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private static volatile PersonServiceImpl personService;

    private static final PersonDao personDao = MySqlDaoFactory.getPersonDao();

    private PersonServiceImpl() {

    }

    public static PersonServiceImpl getInstance() {
        PersonServiceImpl localInstance = personService;
        if (localInstance == null) {
            synchronized (PersonServiceImpl.class) {
                localInstance = personService;
                if (localInstance == null) {
                    personService = localInstance = new PersonServiceImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Person findPersonById(Long id) {
        return personDao.findPersonById(id);
    }

    @Override
    public boolean checkEmail(String email) {
        return personDao.checkEmail(email);
    }

    @Override
    public Person login(String login, String password) {
        return personDao.login(login, password);
    }

    @Override
    public boolean changePersonPassword(Person person) {
        return personDao.changePersonPassword(person);
    }

    @Override
    public boolean updateChamber(Person patient) {
        return personDao.updateChamber(patient);
    }

    @Override
    public boolean updatePerson(Person person) {
        return personDao.updatePerson(person);
    }

    @Override
    public boolean deletePerson(Person person) {
        return personDao.deletePerson(person);
    }

    @Override
    public boolean insertPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public List<Person> findAllByRole(String role) {
        return personDao.findAllByRole(role);
    }

    @Override
    public List<Person> findAllHealthyPatients() {
        return personDao.findAllHealthyPatients();
    }

    @Override
    public List<Person> findAllInSpecificChamber(Long idChamber) {
        return personDao.findAllInSpecificChamber(idChamber);
    }
}
