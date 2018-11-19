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
public class Project implements mainData {
    private int projectNo;
    private String projectName;
    private String location;
    private int deptNo;

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public void add() {
      String strInsert = "insert into project values("
              + projectNo + ","
              + "'" + projectName + "',"
              + "'" + location + "',"
              + deptNo + ")";
      boolean isAdded = db.Go.runNonQuery(strInsert);
      if(isAdded){
          Tools.msgBox("Project Is Added");
      }
    }

    @Override
    public void update() {
        String strUpdate = "update project set "
                + "projectName='" + projectName + "',"
                + "location='" + location + "',"
                + "deptNo=" + deptNo 
                + " where projectNo=" + projectNo;
        boolean isUpdated = db.Go.runNonQuery(strUpdate);
        if(isUpdated){
            Tools.msgBox("Project Is Updated");
        }
    }

    @Override
    public void delete() {
         String strDelete = "delete from project "
                 + " where projectNo=" + projectNo;
         boolean isDeleted = db.Go.runNonQuery(strDelete);
         if(isDeleted){
             Tools.msgBox("Project Is Deleted");
         }
    }

    @Override
    public String getAutoNumber() {
        return db.Go.getAutoNumber("project", "projectNo");
    }

    @Override
    public void getAllRows(JTable table) {
          db.Go.fillToJTable("project_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from project_data"
                + " where projectNo=" + projectNo;
        db.Go.fillToJTable("project_data", table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
          db.Go.fillToJTable("project_data", table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "select projectNo from project"
                + " where projectName='" + name + "'";
        String strVal = (String) db.Go.getTableData(strSelect).Items[0][0];
        return strVal;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "select projectName from project"
                + " where projectNo=" + value;
        String strVal = (String) db.Go.getTableData(strSelect).Items[0][0];
        return strVal;
    }
    
    
}
