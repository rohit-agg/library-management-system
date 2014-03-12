/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangePassword.java
 *
 * Created on Mar 14, 2010, 11:44:08 AM
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Rohit Aggarwal
 */
public class ChangePassword extends javax.swing.JFrame {

    ChangePasswordQuery query_class;
    static String user_name, old_password, new_password;

    /** Creates new form ChangePassword */
    public ChangePassword() {
        initComponents();
        jLabel1.setText(ServerDetails.library_name);
        jLabel1.setSize(jLabel1.getPreferredSize());
        jLabel2.setSize(jLabel2.getPreferredSize());
        jLabel3.setSize(jLabel3.getPreferredSize());
        jLabel4.setSize(jLabel4.getPreferredSize());
        jLabel5.setSize(jLabel5.getPreferredSize());
        jLabel6.setSize(jLabel6.getPreferredSize());
        jButton1.setSize(jButton1.getPreferredSize());
        jButton2.setSize(jButton2.getPreferredSize());
        if(ServerDetails.database == Database.MSACCESS)
        {
           //query_class = new ChangePasswordMSSQL();
        }
        else if(ServerDetails.database == Database.SQLSERVER)
        {
           query_class = new ChangePasswordMSSQL();
        }
        else if(ServerDetails.database == Database.MYSQL)
        {
            query_class = new ChangePasswordMYSQL();
        }
        else if(ServerDetails.database == Database.POSTGRESQL)
        {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change Password");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 24));
        jLabel1.setText("Library Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 161, 29);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel2.setText("User Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 75, 83, 20);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel3.setText("User Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 75, 83, 20);

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel4.setText("Old Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 110, 99, 20);

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel5.setText("New Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 145, 105, 20);

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jLabel6.setText("<html>Confirm New<br>Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 180, 97, 40);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton1.setText("Change");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 240, 91, 29);

        jButton2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 240, 83, 29);

        jPasswordField1.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(150, 105, 175, 26);

        jPasswordField2.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(150, 145, 175, 26);

        jPasswordField3.setFont(new java.awt.Font("Century Schoolbook", 0, 16));
        getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(150, 185, 175, 26);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-360)/2, (screenSize.height-325)/2, 360, 325);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        jLabel3.setText(ServerDetails.login_user);
        jLabel3.setSize(jLabel3.getPreferredSize());
        user_name = ServerDetails.login_user;
    }//GEN-LAST:event_formWindowOpened

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(check_data() == true)
        {
            old_password = jPasswordField1.getText();
            new_password = jPasswordField2.getText();
            if(query_class.check_password() == true)
            {
                query_class.update_password();
                this.dispose();
                if(ServerDetails.invoker == Invoker.ADMINISTRATOR)
                {
                    AdministratorPage admin_page = new AdministratorPage();
                    admin_page.show();
                }
                else if(ServerDetails.invoker == Invoker.LIBRARIAN)
                {
                    LibrarianPage librarian_page = new LibrarianPage();
                    librarian_page.show();
                }
                else if(ServerDetails.invoker == Invoker.EMPLOYEE)
                {
                    EmployeePage employee_page = new EmployeePage();
                    employee_page.show();
                }
                else if(ServerDetails.invoker == Invoker.MEMBER)
                {
                    MemberPage member_page = new MemberPage();
                    member_page.show();
                }
                else
                    System.exit(0);
            }
            else
                JOptionPane.showMessageDialog(this, "Given Old Password is incorrect", "Incorrect Password", JOptionPane.WARNING_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this, "Correct the highlighted items before proceeding", "Incorrect Data", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        if(ServerDetails.invoker == Invoker.ADMINISTRATOR)
        {
            AdministratorPage admin_page = new AdministratorPage();
            admin_page.show();
        }
        else if(ServerDetails.invoker == Invoker.LIBRARIAN)
        {
            LibrarianPage librarian_page = new LibrarianPage();
            librarian_page.show();
        }
        else if(ServerDetails.invoker == Invoker.EMPLOYEE)
        {
            EmployeePage employee_page = new EmployeePage();
            employee_page.show();
        }
        else if(ServerDetails.invoker == Invoker.MEMBER)
        {
            MemberPage member_page = new MemberPage();
            member_page.show();
        }
        else
            System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    private boolean check_data()
    {
        boolean return_value= true;

        if(jPasswordField1.getText() == null || jPasswordField1.getText().compareTo("") == 0)
        {
            jLabel4.setText("<html><font color='red'>Old Password");
            return_value = false;
        }
        else
            jLabel4.setText("Old Password");

        if(jPasswordField2.getText() == null || jPasswordField2.getText().compareTo("") == 0)
        {
            jLabel5.setText("<html><font color='red'>New Password");
            return_value = false;
        }
        else
            jLabel5.setText("New Password");

        if(jPasswordField3.getText() == null || jPasswordField3.getText().compareTo("") == 0)
        {
            jLabel6.setText("<html><font color='red'>Confirm New<br>Password");
            return_value = false;
        }
        else
            jLabel6.setText("<html>Confirm New<br>Password");

        if(jPasswordField2.getText().compareTo(jPasswordField3.getText()) != 0)
        {
            jLabel5.setText("<html><font color='red'>New Password");
            jLabel6.setText("<html><font color='red'>Confirm New<br>Password");
            return_value = false;
        }
        else if(jPasswordField2.getText().compareTo(jPasswordField3.getText()) == 0 && (jPasswordField3.getText() == null || jPasswordField3.getText().compareTo("") != 0 && jPasswordField2.getText() == null || jPasswordField2.getText().compareTo("") != 0))
        {
            jLabel5.setText("New Password");
            jLabel6.setText("<html>Confirm New<br>Password");
        }

        return(return_value);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables

}