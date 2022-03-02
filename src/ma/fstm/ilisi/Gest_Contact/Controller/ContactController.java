package ma.fstm.ilisi.Gest_Contact.Controller;

import ma.fstm.ilisi.Gest_Contact.Model.bo.Contact;
import ma.fstm.ilisi.Gest_Contact.Model.dao.DAOContact;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hicham
 */
public class ContactController {
    List<Contact> contacts =null;
    public void insertContact(String Nom, String Prenom, String tel, String email ){
        Contact con=new Contact();
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        if(DAOContact.getDAOContact().Create(con))
        if(contacts!=null)
            contacts.add(con);
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
        if(contacts==null)contacts =(List<Contact>) DAOContact.getDAOContact().Retrieve();
        return contacts;
    }
    public void  deleteContact(Contact c){
        if(DAOContact.getDAOContact().delete(c))
            if(contacts!=null)
                contacts.remove(c);
    }
}
