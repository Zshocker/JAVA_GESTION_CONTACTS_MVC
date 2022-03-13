package ma.fstm.ilisi.Gest_Contact_HibAno.View;

import ma.fstm.ilisi.Gest_Contact_HibAno.Controller.ContactController;
import ma.fstm.ilisi.Gest_Contact_HibAno.Model.bo.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MainApp
{
    private JTabbedPane tabbedPane1;
    private JPanel MainPannel;
    private JTable MainTable;
    private JTextField Prenom;
    private JButton Add_Contact_butt;
    private JTextField Nom;
    private JTextField Tel;
    private JTextField Email;
    private JComboBox<Contact> ComboUpdate;
    private JTextField Nom_up;
    private JTextField Tel_up;
    private JTextField Email_up;
    private JButton Update_Contact_butt;
    private JButton Delete;
    private JComboBox<Contact> ComboDelete;
    private JTextField Prenom_up;
    private ContactController controller;
    public MainApp()
    {
        Add_Contact_butt.addActionListener(e -> {
            boolean b= controller.insertContact(Nom.getText(),Prenom.getText(), Tel.getText(), Email.getText());
            if(b){
            Nom.setText("");
            Prenom.setText("");
            Tel.setText("");
            Email.setText("");
            Refresh_Tables();
            JOptionPane.showMessageDialog(MainPannel.getParent(), "Done!");
            }else{
                JOptionPane.showMessageDialog(MainPannel.getParent(), "Nop!");
            }
        });
        Update_Contact_butt.addActionListener(e -> {
            Contact c=null;
            if((c=(Contact) ComboUpdate.getSelectedItem())!=null){
            controller.updateContact(c, Nom_up.getText(),Prenom_up.getText(), Tel_up.getText(), Email_up.getText());
            Refresh_Tables();
                JOptionPane.showMessageDialog(MainPannel.getParent(), "Done!");

            }
        });

        ComboUpdate.addItemListener(e -> {
            Contact c=null;
            if((c=(Contact) ComboUpdate.getSelectedItem())!=null){
                Prenom_up.setText(c.getPrenom());
                Nom_up.setText(c.getNom());
                Tel_up.setText(c.getTel());
                Email_up.setText(c.getEmail());
            }
        });
        Delete.addActionListener(e -> {
            Contact c=null;
            if((c=(Contact) ComboDelete.getSelectedItem())!=null){
                controller.deleteContact(c);
                Refresh_Tables();
                JOptionPane.showMessageDialog(MainPannel.getParent(), "Done!");

            }
        });
    }

    private void createUIComponents() {
        controller=new ContactController();
        MainTable =new JTable();
        ComboDelete =new JComboBox<Contact>();
        ComboUpdate =new JComboBox<Contact>();
        Refresh_Tables();
    }
    private void Refresh_Tables() {
        ComboUpdate.removeAllItems();
        ComboDelete.removeAllItems();
        List<Contact> contacts =controller.AllContacts();
        String[][] sq = new String[contacts.size()][4];
        int i = 0;
        for (Contact entry : contacts)
        {
            sq[i][0] = entry.getNom();
            sq[i][1] = entry.getPrenom();
            sq[i][2] = entry.getTel();
            sq[i][3] = entry.getEmail();
            i++;
            ComboUpdate.addItem(entry);
            ComboDelete.addItem(entry);
        }
        MainTable.setModel(new DefaultTableModel(sq, new String[] { "Nom", "Prenom","Tel","Email" }));
        MainTable.disable();
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("APP CONTACTS");
        frame.setContentPane( new MainApp().MainPannel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
