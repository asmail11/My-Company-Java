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
public class Employee_phones implements mainData {
    
    private int empNo;
    private String phone;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void add() {
          String strAdd = "insert into employee_phones values("
                  + empNo + ","
                  + "'" + phone + "')";
          boolean isAdded = db.Go.runNonQuery(strAdd);
          if(isAdded){
             // Tools.msgBox("Phone Is Added");
          }
          
    }

    @Override
    public void update() {
        Tools.msgBox("Update Method In Employee Phone Is Not Working!");
    }

    @Override
    public void delete() {
        String strDelete = "delete from employee_phones where empNo=" 
                + empNo + " and phone='" + phone + "'" ;
        boolean isDeleted = db.Go.runNonQuery(strDelete);
        if(isDeleted){
           // Tools.msgBox("Phone Number Is Deleted");
        }
    }
    
    public void deleteByEmp(){
        String strDelete = "delete from employee_phones where empNo=" + empNo;
        boolean isDeleted = db.Go.runNonQuery(strDelete);
        if(isDeleted){
           // Tools.msgBox("Phone Number Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        Tools.msgBox("getAutoNumber Method in employee_phones Class");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
         String strSelect = "select phone from employee_phones where empNo=" + empNo;
         db.Go.fillToJTable(strSelect, table);
    }

    @Override
    public void getOneRow(JTable table) {
    Tools.msgBox("getOneRow Method in employee_phones Class");
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
       Tools.msgBox("getCustomRows Method in employee_phones Class");
    }

    @Override
    public String getValueByName(String name) {
        Tools.msgBox("getValueByName Method in employee_phones Class");
         return "";
    }

    @Override
    public String getNameByValue(String value) {
         Tools.msgBox("getNameByValue Method in employee_phones Class");
         return "";       
    }
    
    public String getEmpNoByPhone(String requestPhone){
        String strSelect = "select empNo from employee_phones where phone='" + requestPhone + "'";
        Object row[][] = db.Go.getTableData(strSelect).Items;
        String strEmpNo = "";
        if(row.length > 0){
            strEmpNo = (String) row[0][0];
        } else{
            strEmpNo = "0";
        }
        return strEmpNo;
    }
    
}
