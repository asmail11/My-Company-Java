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
public class Employee implements mainData {
    private int empNo;
    private String empName;
    private String address;
    private double salary;
    private String hiringDate;
    private String birthDate;
    private int deptNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

        public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

        public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
    

    @Override
    public void add() {
      String insert = "insert into employee values("
              + empNo + ","
              + "'" + empName + "',"
              + "'" + address + "',"
              + salary + ","
              + "'" + hiringDate + "',"
              + "'" + birthDate + "',"
              + deptNo + ")";
      boolean isAdd = db.Go.runNonQuery(insert);
      if(isAdd){
          Tools.msgBox("Employee Is Added");
      }
    }

    @Override
    public void update() {
           String update = "update employee set "
                   + "empName='" + empName + "',"
                   + "address='" + address + "',"
                   + "salary=" + salary + ","
                   + "hiringDate='" + hiringDate + "',"
                   + "birthDate='" + birthDate + "',"
                   + "deptNo=" + deptNo 
                   + " where empNo=" + empNo;
           boolean isUpdated = db.Go.runNonQuery(update);
           if(isUpdated){
               Tools.msgBox("Employee Is Updated");
           }
    }

    @Override
    public void delete() {
         String delete = "delete from employee where empNo=" + empNo;
         boolean isDeleted = db.Go.runNonQuery(delete);
         if(isDeleted){
             Tools.msgBox("Employee Is Deleted");
         }
    }

    @Override
    public String getAutoNumber() {
       return db.Go.getAutoNumber("employee", "empNo");
    }

    @Override
    public void getAllRows(JTable table) {
          db.Go.fillToJTable("employee_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
         String strSelect = "select * from employee_data "
                 + " where number=" + empNo;
         db.Go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statment, JTable table) {
         db.Go.fillToJTable(statment, table);
    }

    @Override
    public String getValueByName(String name) {
        String strSelect = "select empNo from employee where empName='" + name + "'";
        String strValue = db.Go.getTableData(strSelect).Items[0][0].toString();
        return strValue;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect = "select empName from employee where empNo=" + value;
        String strName = db.Go.getTableData(strSelect).Items[0][0].toString();
        return strName;
    }




    
    
}
