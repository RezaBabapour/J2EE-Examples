import DB.Factory;
import DB.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;

public class select {
    public static void main(String[] args) {
        Session session = Factory.getSession();
        Transaction tx = session.beginTransaction();
        User obj = new User();
        Iterator i = session.createQuery("from User").iterate();
        while (i.hasNext()){
            obj = (User) i.next();
            obj.setName(obj.getName()+"edited");
            session.saveOrUpdate(obj);
            System.out.println(obj.getId());
            System.out.println(obj.getName());
        }
        tx.commit();
        session.close();
    }
}
