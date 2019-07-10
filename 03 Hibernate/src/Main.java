import DB.Factory;
import DB.User;
import org.hibernate.*;


public class Main {

    public static void main(final String[] args) throws Exception {
        Session session = Factory.getSession();
        Transaction tx = session.beginTransaction();
        User obj = new User();
        //obj.setName("reza");
        //session.saveOrUpdate(obj);
        obj.setId(7);
        session.delete(obj);
        tx.commit();
        session.close();
    }
}