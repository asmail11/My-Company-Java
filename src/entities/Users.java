/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.swing.JTable;
import mycompany.Tools;

/**
 *
 * @author drmas
 */
public class Users implements mainData {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String birthDay;
    private String address;

    public Users(String firstName, String lastName, String username, String email, String password, String birthDay, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDay = birthDay;
        this.address = address;
    }
    
    public Users(){
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void add() {
        String strInsert = "insert into users values("
                + "'" + firstName + "',"
                + "'" + lastName + "',"
                + "'" + username + "',"
                + "'" + email + "',"
                + "'" + password + "',"
                + "'" + birthDay + "',"
                + "'" + address + "')";
        boolean isAdded = db.Go.runNonQuery(strInsert);
        if(isAdded){
         Tools.msgBox("User is added");
        }
        
        
    }

    @Override
    public void update() {
        String strUpdate = "update users set "
                + "'" + firstName + "',"
                + "'" + lastName + "',"
                + "'" + email + "',"
                + "'" + password + "',"
                + "'" + birthDay + "',"
                + "'" + address + "'"
                + " where username='" + username + "'";
        boolean isUpdated = db.Go.runNonQuery(strUpdate);
        if(isUpdated){
            Tools.msgBox("Username Is Updated");
        }
        
        
    }

    @Override
    public void delete() {
        String strDelete = "delete from users where username='" + username + "'";
        boolean isDeleted = db.Go.runNonQuery(strDelete);
        if(isDeleted){
            Tools.msgBox("User an account is deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllRows(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOneRow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValueByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByValue(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
