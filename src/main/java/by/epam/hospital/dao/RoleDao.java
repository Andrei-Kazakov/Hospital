package by.epam.hospital.dao;

import by.epam.hospital.entity.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    Role findRoleById(Long id);

    Role findRoleByName(String name);

    boolean deleteRole(Role role);

    boolean insertRole(Role role);

}
