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

/**
 *
 * @author user
 */
public class Laborator8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Connection conex=null;
        Statement stat=null;
        ResultSet res=null;
        String query="SELECT * FROM DBA.ALBUMS";
        try{
          conex=DriverManager.getConnection("jdbc:derby://localhost:1527/MusicAlbums", "dba", "sql");
          stat=conex.createStatement();
          res=stat.executeQuery(query);
          
           
           stat.executeUpdate("create table artists(" +
                    "id integer primary key," +
                    "name varchar(100) not null," +
                   "country varchar(100)" +
                   ")");


           stat.executeUpdate("create sequence INC");


           stat.executeUpdate("create or replace trigger FOO_trg " +
                   "before insert on artists " +
                   "for each row " +
                   "begin " +
                    "select INC.nextval into :new.id from dual; " +
                    "end; ");


            stat.executeUpdate("create table albums(" +
                   "id integer primary key," +
                    "name varchar(100) not null," +
                   "artist_id integer not null, " +
                   "release_year integer, " +
                  "foreign key (artist_id) references artists (id)" +
                  ")");


                stat.executeUpdate("create or replace trigger INC " +
                  "before insert on albums " +
                  "for each row " +
                   "begin " +
                   "select FOO_seq2.nextval into :new.id from dual; " +
                  "end; ");
          
         AlbumController albumController = new AlbumController(conex);
            ArtistController artistController = new ArtistController(conex);
          
          artistController.create("Rush", "Canada");
          artistController.create("Iron Maiden", "Britain");
          albumController.create("Moving Pictures", 1, 1981);
          albumController.create("The Number of the Beast", 2, 1982);
          albumController.create("2112", 1, 1976);
          albumController.create("Powerslave", 2, 1984);
           
           
          while(res.next()){
            int id =res.getInt("id");
            String name=res.getString("name");
            int artist_id =res.getInt("artist_id");
            int release_year =res.getInt("release_year");
            System.out.println(id +name+artist_id+release_year);
          }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        }
    }
    

