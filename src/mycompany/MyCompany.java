/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

import forms.LoginForm;
import forms.ProfileForm;
import javax.swing.JFrame;


/**
 *
 * @author drmas
 */
public class MyCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      // Tools.OpenForm(new frmTest());
     // Tools.OpenForm(new frmDepartment());
    // Tools.OpenForm(new frmEmployee());
     // Tools.OpenForm(new frmProject());
    // Tools.OpenForm(new frmWorkon());
   // Tools.OpenForm(new LoginForm());
        LoginForm lgf = new LoginForm();
     //  ProfileForm lgf = new ProfileForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}
