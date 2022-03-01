package ma.fstm.ilisi.Gest_Contact.Model.dao;
import ma.fstm.ilisi.Gest_Contact.Model.bo.Contact;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DAOContact implements IDAOContact{
    private static DAOContact daoContact=null;
    public static DAOContact getDAOContact(){
       if(daoContact==null)daoContact=new DAOContact();
       return  daoContact;
    }
    private DAOContact(){

    }
    @Override
    public void Create(Contact user) {
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("insert into Contacts(prenom,Nom,tel,email) values(?,?,?,?) ");
            pr.setString(1,user.getPrenom());
            pr.setString(2,user.getNom());
            pr.setString(3,user.getTel());
            pr.setString(4,user.getEmail());
            pr.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public Collection<Contact> Retrieve() {
        List<Contact> Contacts=new LinkedList<Contact>();
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("select * from Contacts");
            ResultSet resultSet=pr.executeQuery();
            while (resultSet.next())
            {
                Contact user=ExtractContact(resultSet);
                Contacts.add(user);
            }
            return Contacts;
        } catch (SQLException e) {
            System.err.println(e);
          return null;
        }
    }

    @Override
    public void update(Contact user) {
        try {
            PreparedStatement pr = Connexion.getCon().prepareStatement("Update Contacts SET prenom=?,Nom=?,tel=?,email=? where id=? ");
            pr.setString(1,user.getPrenom());
            pr.setString(2,user.getNom());
            pr.setString(3,user.getTel());
            pr.setString(4,user.getEmail());
            pr.setInt(5, user.getId());
            pr.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public boolean delete(Contact user) {
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("Delete FROM Contacts where id=?");
            pr.setInt(1,user.getId());
            pr.executeUpdate();
            return true;
        }catch (SQLException e){
            System.err.println(e);
            return false;
        }
    }
   
    private Contact ExtractContact( ResultSet resultSet) throws SQLException {
        Contact user=new Contact();
        user.setId(resultSet.getInt("Id"));
        user.setPrenom(resultSet.getString("prenom"));
        user.setNom(resultSet.getString("nom"));
        user.setEmail(resultSet.getString("email"));
        user.setTel(resultSet.getString("tel"));
       
        return user;
    }
}
