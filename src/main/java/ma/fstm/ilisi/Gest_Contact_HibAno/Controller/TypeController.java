package ma.fstm.ilisi.Gest_Contact_HibAno.Controller;

import ma.fstm.ilisi.Gest_Contact_HibAno.Model.bo.Type;
import ma.fstm.ilisi.Gest_Contact_HibAno.Model.dao.DAOType;

import java.util.List;

public class TypeController
{
    public List<Type> getAllTypes(){
        return DAOType.getDAOType().Retreve();
    }
}
