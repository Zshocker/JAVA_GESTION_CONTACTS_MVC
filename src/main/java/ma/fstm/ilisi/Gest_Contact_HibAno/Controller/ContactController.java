package ma.fstm.ilisi.Gest_Contact_HibAno.Controller;

import ma.fstm.ilisi.Gest_Contact_HibAno.Model.bo.Contact;
import ma.fstm.ilisi.Gest_Contact_HibAno.Model.bo.Type;
import ma.fstm.ilisi.Gest_Contact_HibAno.Model.dao.DAOContact;
import ma.fstm.ilisi.Gest_Contact_HibAno.Model.servise.ContactServise;

import java.util.List;
/**
 *
 * @author hicham
 */
public class ContactController {
    ContactServise servise=new ContactServise();
    public boolean insertContact(String Nom, String Prenom, String tel, String email ,Type type){
        return servise.insertContact(Nom,Prenom,tel,email,type);
    }
    public void updateContact(Contact con, String Nom, String Prenom, String tel, String email, Type type ){
        servise.Update_Contact(con, Nom, Prenom, tel, email,type);
    }
    public List<Contact> AllContacts()
    {
        return (List<Contact>) DAOContact.getDAOContact().Retrieve();
    }
    public boolean deleteContact(Contact c){
        return servise.deleteContact(c);

    }
}
