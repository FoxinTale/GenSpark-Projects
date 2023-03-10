package org.example;

import org.example.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        // Practically, the password would be encrypted. In the production database,
        // I used PHP's password encrypt function which uses blowfish by default.
        User newUser = new User(13, "A Fox", "aaaaaaaaaaaaa", "No email", false);
        session.save(newUser);

        Query q = session.createQuery("from User"); // "Read". We're reading all the users. Functionally, I'd say the logged in user
        List<User> users = q.list();
        User u;

        for(int i = 0; i < users.size(); i++){
            u = users.get(i);
            System.out.println(u.getUser_Name());
        }

        q = session.createQuery("update User set User_Email=:mail where User_ID=:id"); // "Update". It does work.
        q.setParameter("mail", "N/A");
        q.setParameter("id", 10);
        q.executeUpdate();



        // Delete
        q = session.createQuery("delete User where User_Name=:name");
        q.setParameter("name", "A fox");
        q.executeUpdate();

        t.commit();

        session.close();
        sf.close();


    }
}
