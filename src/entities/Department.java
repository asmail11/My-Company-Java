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
public class Department implements mainData {
    private int deptNo;
    private String deptName;
    private String location;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void add() {
      String insert = "insert into department values("
              + deptNo + ","
              + "'" + deptName + "',"
              + "'" + location + "')";
      boolean isAdd = db.Go.runNonQuery(insert);
      if(isAdd){
          Tools.msgBox("Department Is Added");
      }
    }

    @Override
    public void update() {
        String update = "update department set "
                + "DeptName='" + deptName + "',"
                + "Location='" + location + "' "
                + " where deptNo=" + deptNo;
        boolean isUpdate = db.Go.runNonQuery(update);
        if(isUpdate){
            Tools.msgBox("Department Is Updated");
        }
    }

    @Override
    public void delete() {
        String delete = "delete from department where deptNo=" + deptNo;
        boolean isDelete = db.Go.runNonQuery(delete);
        if(isDelete){
            Tools.msgBox("Department Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
      return db.Go.getAutoNumber("department", "deptNo"); 
    }

    @Override
    public void getAllRows(JTable table) {
        db.Go.fillToJTable("department_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
          String select = "select * from department_data "
                  + " where department_no=" + deptNo;
          db.Go.fillToJTable(select, table); 
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
            db.Go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
          String select = "select deptNo from department"
                  + " where deptName='" + name + "'";
          String value = (String) db.Go.getTableData(select).Items[0][0];
          return value;
    }

    @Override
    public String getNameByValue(String value) {
        String select = "select deptName from department"
                + " where deptNo=" + value;
        String name = (String) db.Go.getTableData(select).Items[0][0];
        return name;
    }
    
    
}
