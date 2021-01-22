/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brieftreeskills.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public  class connection {
  public  Connection conx;
    public  Connection getConnection(){
    String dbName="treeSkills";
    String user="root";
    String password="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conx=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,user,password);
        } catch (Exception ex) {
           System.out.print(ex); ;
        }
        return conx;
    }

   
}
