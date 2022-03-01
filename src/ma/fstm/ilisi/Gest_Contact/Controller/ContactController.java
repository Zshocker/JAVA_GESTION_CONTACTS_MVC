package ma.fstm.ilisi.Gest_Contact.Controller;

import ma.fstm.ilisi.Gest_Contact.Model.bo.Contact;
import ma.fstm.ilisi.Gest_Contact.Model.dao.DAOContact;

import java.util.List;

/**
 *
 * @author hicham
 */
public class ContactController {
    public void insertContact(String Nom, String Prenom, String tel, String email ){
        Contact con=new Contact();
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        DAOContact.getDAOContact().Create(con);
    }
    public void updateContact(Contact con, String Nom, String Prenom, String tel, String email ){
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        DAOContact.getDAOContact().update(con);
    }
    public List<Contact> AllContacts()
    {
        return (List<Contact>) DAOContact.getDAOContact().Retrieve();
    }
    public void  deleteContact(Contact c){
        DAOContact.getDAOContact().delete(c);
    }
}
