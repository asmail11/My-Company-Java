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
public class WorkOn implements mainData {
    private int empNo;
    private int projectNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public void add() {
       String strInsert = "insert into workon values("
               + empNo + ","
               + projectNo + ")";
       boolean isAdded = db.Go.runNonQuery(strInsert);
       if(isAdded){
           Tools.msgBox("WorkOn Is Added");
       }
    }

    @Override
    public void update() {
      Tools.msgBox("Update Method Not Working In Workon Class");
    }

    @Override
    public void delete() {
       String strDelete = "delete from workon where "
               + "empNo=" + empNo 
               + " and "
               + "projectNo=" + projectNo;
       boolean isDelete = db.Go.runNonQuery(strDelete);
       if(isDelete){
           Tools.msgBox("WorkOn Is Deleted");
       }
    }

    @Override
    public String getAutoNumber() {
         Tools.msgBox("getAutoNumber Method Not Working In Workon Class");
         return "";
    }

    @Override
    public void getAllRows(JTable table) {
         db.Go.fillToJTable("workon_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from workon where "
                + "employee_no=" + empNo
                + " and "
                + "project_no=" + projectNo;
        db.Go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
        db.Go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
         Tools.msgBox("getValueByName Method Not Working In Workon Class");
         return "";    
    }

    @Override
    public String getNameByValue(String value) {
         Tools.msgBox("getNameByValue Method Not Working In Workon Class");
         return "";    
    }
    
}
