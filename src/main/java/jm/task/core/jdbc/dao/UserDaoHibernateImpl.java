package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {
    private Transaction transaction = null;

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("Creating table in selected database...");
            String SQL =
                    "CREATE TABLE IF NOT EXISTS " + Util.nameDB +
                            "(Id INTEGER NOT NULL AUTO_INCREMENT, " +
                            "Name VARCHAR(50), " +
                            "LastName VARCHAR(50), " +
                            "Age INTEGER NOT NULL ," +
                            "primary key (Id))";
            session.createSQLQuery(SQL).addEntity(User.class).executeUpdate();
            System.out.println("Table successfully created... \n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("drop table if exists " + Util.nameDB).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("Saving a user...");
            User user = new User(name, lastName, age);
            session.save(user);
            System.out.println("User с именем \"" + name + "\" добавлен в базу данных \n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("Deleted user...");
            session.delete(session.get(User.class, id));
            System.out.println("User ID " + id + " deleted \n");
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = new LinkedList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            usersList = session.createQuery("from " + User.class.getSimpleName()).list();
            for (User user : usersList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("truncate table " + Util.nameDB).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
