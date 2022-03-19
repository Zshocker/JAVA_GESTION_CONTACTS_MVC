package ma.fstm.ilisi.Gest_Contact.Controller;

import ma.fstm.ilisi.Gest_Contact.Model.bo.Type;
import ma.fstm.ilisi.Gest_Contact.Model.dao.DAOType;

import java.util.List;

public class TypeController
{
    public List<Type> getAllTypes(){
        return DAOType.getDAOType().Retreve();
    }
}
