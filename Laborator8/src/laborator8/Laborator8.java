/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author user
 */
public class Laborator8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        try{
           
           Database db = Database.getInstance();
        db.createTables();
        Connection con = db.getConnection();
         AlbumController albumController = new AlbumController(Database.getInstance().getConnection());
            ArtistController artistController = new ArtistController(Database.getInstance().getConnection());
          
          artistController.create("Rush", "Canada");
          artistController.create("Iron Maiden", "Britain");
          albumController.create("Moving Pictures", 1, 1981);
          albumController.create("The Number of the Beast", 2, 1982);
          albumController.create("2112", 1, 1976);
          albumController.create("Powerslave", 2, 1984);
          albumController.create("Permanent Waves", 1, 1980);
           
          
            
            db.closeConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
        }
    }
    

