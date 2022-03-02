package ma.fstm.ilisi.Gest_Contact.Model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connexion {
    private  static  Connection conn=null;
    public static Connection getCon(){
        if(conn==null)conn=createConn();
        return conn;
    }
    private static Connection createConn(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Contact_DB","Hicham","hich");
        }catch (ClassNotFoundException e){
            System.err.println(e);
            return  null;
        }catch (SQLException e){
            System.err.println(e);
            return  null;
        }
    }
}
