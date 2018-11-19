/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.swing.JTable;

/**
 *
 * @author drmas
 */
public interface mainData {
    
    public void add();
    public void update();
    public void delete();
    public String getAutoNumber();
    public void getAllRows(JTable table);
    public void getOneRow(JTable table);
    public void getCustomRows(String statment, JTable table);
    public String getValueByName(String name);
    public String getNameByValue(String value);
}
