package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl extends UserDaoHibernateImpl implements UserService {

    //    private UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser("Ivan", "Ivanov", (byte) 5);
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return new LinkedList<>(userDaoHibernate.getAllUsers());
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
