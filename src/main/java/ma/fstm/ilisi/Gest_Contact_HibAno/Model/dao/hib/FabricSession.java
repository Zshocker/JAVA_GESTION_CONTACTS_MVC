package ma.fstm.ilisi.Gest_Contact_HibAno.Model.dao.hib;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class FabricSession
{
    private static SessionFactory sessionFactory;
    private FabricSession(){
    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try
            {
                sessionFactory = new Configuration().configure("V2_Ano/hibernate.cfg.xml").buildSessionFactory();
            }catch (Throwable exception){
                System.err.println(exception);
            }
        }
        return sessionFactory;
    }
}
