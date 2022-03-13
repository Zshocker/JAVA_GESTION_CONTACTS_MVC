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
    public boolean insertContact(String Nom, String Prenom, String tel, String email ){
        Contact con=new Contact();
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        boolean b= DAOContact.getDAOContact().Create(con);
        if(b && contacts!=null)
            contacts.add(con);
        return b;
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
    public boolean  deleteContact(Contact c){
        boolean b= DAOContact.getDAOContact().delete(c);
        if(b&& contacts!=null)
                contacts.remove(c);
        return b;
    }
}
