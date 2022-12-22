/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed osama
 */
public class connectionManger {

    private  final String user = "admin";
    private  final String password = "V32Kzbs7";
    private  final String add = "jdbc:mysql://68.64.164.104:10149/GameStation";
    private Connection c=null;
    private static  connectionManger inc=null;
    private connectionManger(){
        
    }
    public static  connectionManger getInc(){
        if(inc==null)
        {
            inc=new connectionManger();
            
        }
        return inc;
    }
    private boolean openConnection()
    {
        try {
            c=DriverManager.getConnection(add, user, password);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public Connection getConnection(){
        if(c==null){
            if(openConnection())
            {
                System.out.println("connected");
                return c;
                
            }else{
                return null;
            }
        }return c;
    }
}
