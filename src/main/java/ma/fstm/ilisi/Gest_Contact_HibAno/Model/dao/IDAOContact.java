package ma.fstm.ilisi.Gest_Contact_HibAno.Model.dao;



import ma.fstm.ilisi.Gest_Contact_HibAno.Model.bo.Contact;

import java.util.Collection;

public interface IDAOContact {
    boolean Create(Contact user);
    Collection<Contact> Retrieve();
    void update(Contact user);
    boolean delete(Contact user);
}
