/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author AARTHI
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        Registerbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("LOGIN FORM");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 50, 300, 52);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("User Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 210, 150, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 330, 160, 29);
        jPanel1.add(name);
        name.setBounds(400, 220, 230, 40);
        jPanel1.add(pass);
        pass.setBounds(400, 320, 230, 40);

        login.setBackground(new java.awt.Color(230, 174, 225));
        login.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        login.setForeground(new java.awt.Color(0, 204, 0));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(300, 410, 130, 37);

        Registerbtn.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        Registerbtn.setForeground(new java.awt.Color(153, 0, 153));
        Registerbtn.setText(" If Dont have an account ? Register Now");
        Registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Registerbtn);
        Registerbtn.setBounds(100, 500, 560, 37);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\AARTHI\\Downloads\\movie3.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 0, 740, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
               
            String s1=name.getText();
            String s2=pass.getText();
            try
             {
                 ResultSet rs;
            	 Class.forName("com.mysql.jdbc.Driver");
            	 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","PassWord@123");
            	 String s="select * from register where name = '" +s1+"'and pass ='"+s2+"'";
            	 Statement stmt=connect.createStatement();
            	 rs=stmt.executeQuery(s);
                 if(name.getText().length() <=0||pass.getText().length()<=0)
            {
                 JOptionPane.showMessageDialog(null,"TextBox is empty");
            }
            else
            {
     
        
            	 int count=0;
            	 while(rs.next())
            	{
                    count++;
            	}
            	if(count==1)
		{
                       dispose();
                       new bookingLoc().setVisible(true);
		}
            	else
	        {
                    JOptionPane.showMessageDialog(null,"Username && Password Mismatch");
		}
        		}}
        	catch (Exception e)
        	{
                    JOptionPane.showMessageDialog(null, e.getMessage());
        	}
         
    }//GEN-LAST:event_loginActionPerformed

    private void RegisterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterbtnActionPerformed
        // TODO add your handling code here:
        dispose();
           Register reg = new Register();
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RegisterbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Registerbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
