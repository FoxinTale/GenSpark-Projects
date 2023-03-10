package org.example;

import org.example.Entity.Character;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println( "Hello World!" );
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        int user_ID = 1;
        /*
        I can already see hopw I'll end up using this in my website...
        Barring front end. Once the user logs in, all their information will be pulled from the databaser itself (via the user ID).
         */


        // In production, the char_user_ID would be gotten from the active user via getUserID(), and fed into this.
        // this is the "Create" aspect.
        Character azaria = new Character(10, user_ID, "Azaria", "Azzie, Az",
                "A fluffy, female dragon.", "80 something in dragon years, 30 in human.", "Female", "Nardoragon");

        session.save(azaria); //There's got to be an "if object exists, don't create it"

        Query q = session.createQuery("from Character where Char_User_ID=:u"); // "Read".
        q.setParameter("u", user_ID);
        List<Character> characters = q.list();
        Character c;


        for(int i = 0; i < characters.size(); i++){
            c = characters.get(i);
            System.out.println(c.getChar_Name());
        }

        q = session.createQuery("update Character set Char_ShortName=:n where Char_ID=:i"); // "Update". It does work.
        q.setParameter("n", "Unknown");
        q.setParameter("i", 10);
        q.executeUpdate();

        // Delete
        q = session.createQuery("delete Character where Char_Name=:name");
        q.setParameter("name", "Azaria");
        q.executeUpdate();


        t.commit();

        session.close();
        sf.close();
    }
}