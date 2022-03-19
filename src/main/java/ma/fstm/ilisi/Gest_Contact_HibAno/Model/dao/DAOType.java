package ma.fstm.ilisi.Gest_Contact_HibAno.Model.dao;

import ma.fstm.ilisi.Gest_Contact_HibAno.Model.bo.Type;
import ma.fstm.ilisi.Gest_Contact_HibAno.Model.dao.hib.FabricSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class DAOType
{
    private static DAOType daoType=null;
    public static DAOType getDAOType(){
        if(daoType==null)daoType=new DAOType();
        return daoType;
    }
    private DAOType(){}
    public List<Type> Retreve()
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try
        {
            List<Type> types=(List<Type>) session.createQuery("from Type ").list();
            session.close();
            return types;
        }catch (HibernateException e){
            System.out.println(e);
            return null;
        }
    }
}
