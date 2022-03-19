package ma.fstm.ilisi.Gest_Contact.Model.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Type implements Serializable {

    private String type;
    private Set<Contact> contacts = new HashSet<Contact>();

    public Type() {
    }


    public Type(String type) {
        this.type = type;
    }
    public Type(String type, Set contactses) {
        this.type = type;
        this.contacts = contactses;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Set<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return type;
    }





}
