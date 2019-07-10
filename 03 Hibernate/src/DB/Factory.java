package DB;

import org.hibernate.*;

import org.hibernate.cfg.*;


public class Factory {
    private static final SessionFactory session_factory;

    static {
        session_factory = new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession() {
        ThreadLocal thread_session = new ThreadLocal();
        Session session = (Session) thread_session.get();

        if (session == null || session.equals(null)) {
            session = session_factory.openSession();
            thread_session.set(session);
        }

        return session;
    }
}
