/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author user
 */
public class Database {
    
     private static Database instance;
        public static Connection conex=null;
        
        
      private Database() throws SQLException {
        
        try {
            
         conex=DriverManager.getConnection("jdbc:mysql://localhost:3306", "dba", "sql");  
         
         Statement stat = conex.createStatement();
         stat.executeUpdate("create database if not exists MusicAlbums2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conex;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null)
            instance = new Database();
        else if (instance.getConnection().isClosed())
            instance = new Database();
        return instance;
    }
    
    public void createTables() {
        try{
            Statement stat = conex.createStatement();
            String sql = "CREATE USER IF NOT EXISTS dba IDENTIFIED BY 'sql'";
            stat.executeUpdate(sql);
            sql = "select user from mysql.user";
            ResultSet r = stat.executeQuery(sql);
            System.out.println("");
            sql = "USE MusicAlbums2";
            stat.executeUpdate(sql);
            sql =   "create table if not exists artists("+
                    "id integer not null auto_increment," +
                    "name varchar(100) not null," +
                    "country varchar(100)," +
                    "primary key (id));";
            stat.executeUpdate(sql);
            System.out.println("Table artists created!");

            sql =   "create table if not exists albums("+
                    "id integer not null auto_increment," +
                    "name varchar(100) not null," +
                    "id_artist integer not null references artists on delete restrict," +
                    "release_year integer," +
                    "primary key (id));";
            stat.executeUpdate(sql);
            System.out.println("Table albums created!");
            
            sql="create table if not exists charts (" +
                    "id integer not null auto_increment," +
                    "album_id integer not null references albums on delete restrict," +
                    "top_chart integer," +
                    "primary key (id)" +
                    ");";
            stat.executeUpdate(sql);
            System.out.println("Table charts created!");
        } catch(SQLException e) {
            System.out.println(e);
        } catch(NullPointerException e) {
            System.out.println(e);
        }
    }

    public static void closeConnection() {
        try{
            Statement stat = conex.createStatement();
            if(stat != null)
                stat.close();
            System.out.println("Connection closed!");
        } catch(SQLException err) {
            System.out.println("ERROR!");
        }
    }
    
    
       
}
