package com.example.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    
    public static Connection connect() { 
        Connection con = null;

        try{
            Class.forName("org.sqLite.JDBC");
            con = DriverManager.getConnection("JDBC:SQlite:C:/Users/forev/Desktop/Everthing/VSCode/WebNotes3/project/src/main/java/com/example/project/database/webNotesDataBase.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + " ");
        }
        return con;

    }
}
