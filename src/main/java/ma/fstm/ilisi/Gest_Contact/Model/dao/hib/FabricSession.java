package ma.fstm.ilisi.Gest_Contact.Model.dao.hib;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FabricSession
{
    private static SessionFactory sessionFactory;
    private FabricSession(){
    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try {
                Configuration configuration=new Configuration();
                configuration.configure("hibernate.cfg.xml");
                sessionFactory=configuration.buildSessionFactory();
            }catch (HibernateException exception){
                System.err.println(exception);
            }
        }
        return sessionFactory;
    }
}
