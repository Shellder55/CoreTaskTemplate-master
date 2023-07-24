package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        ///////////////   JDBC
//
//        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        userDaoJDBC.createUsersTable();
//
//        userDaoJDBC.saveUser("Vitaliy", "Usoltsev", (byte) 20);
//        userDaoJDBC.saveUser("Evgeniy", "Usoltsev", (byte) 31);
//        userDaoJDBC.saveUser("Irina", "Pamorzina", (byte) 21);
//        userDaoJDBC.saveUser("Alexandr", "Feredyk", (byte) 42);
//
//        userDaoJDBC.getAllUsers();
//
//        userDaoJDBC.removeUserById(3);
//
//        userDaoJDBC.cleanUsersTable();
//
//        userDaoJDBC.dropUsersTable();

        ///////////////   Hibernate

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Vitaliy", "Usoltsev", (byte) 20);
        userDaoHibernate.saveUser("Evgeniy", "Usoltsev", (byte) 31);
        userDaoHibernate.saveUser("Irina", "Pamorzina", (byte) 21);
        userDaoHibernate.saveUser("Alexandr", "Feredyk", (byte) 42);

        userDaoHibernate.removeUserById(4);

        userDaoHibernate.getAllUsers();

        userDaoHibernate.cleanUsersTable();

        userDaoHibernate.dropUsersTable();
    }
}