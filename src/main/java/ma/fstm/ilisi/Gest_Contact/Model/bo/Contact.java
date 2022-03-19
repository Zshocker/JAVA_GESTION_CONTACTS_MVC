package ma.fstm.ilisi.Gest_Contact.Model.bo;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
    private int id;
    private String tel;
    private String nom;    
    private String prenom;
    private String email;
    private Type types;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(int id, String tel, String nom, String prenom, String email) {
        this.id = id;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Contact() {
    }

    public Type getTypes() {
        return types;
    }

    public void setTypes(Type types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", tel='" + tel + '\'' +
                        ", nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", email='" + email + '\'' +
                        ", type=" + types ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id;
    }
}
