package laborator8;

import java.sql.*;

//import com.github.javafaker.Faker;

import java.util.*;
public class AlbumController {
    private static Connection conex;


    public AlbumController(Connection conex) {
        this.conex = conex;
    }

    public void create(String name, int artistId, int releaseYear) {
        try{
            Statement st = conex.createStatement();
            String sql = "INSERT INTO albums (name, artist_id, release_year) VALUES ('" + name + "', '" + artistId + "', '" +
                    releaseYear + "')";
            st.executeUpdate(sql);
            System.out.println(name + " * " + artistId + " * " + releaseYear + " * was inserted to the table albums!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void findByArtist(int artistId) {
        try{
            Statement st = conex.createStatement();
            String sql = "SELECT * FROM albums WHERE artist_id = " + artistId;
            ResultSet r = st.executeQuery(sql);
            int id = 0;
            while(r.next()) {
                id = r.getInt("id");
                String result_name = r.getString("name");
                int art_id = r.getInt("artist_id");
                int rel_year = r.getInt("release_year");
                System.out.println(id + " * " + result_name + " * " + art_id + " * " + rel_year);
            }
            if (id == 0) {
                System.out.println("Artist id '" + artistId + "' was not found!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
   /* public void insertGeneratedAlbum(int rows) throws SQLException {
        conex = Database.getInstance().getConnection();
        Statement stat = conex.createStatement();
        
        Faker faker = new Faker();
        Random random=new Random();
        int i = 0;
        while (i < rows) {
            String fakeName = faker.music().genre();
            int randomArtistId = -1;
            String sql = "SELECT id FROM artists ORDER BY random() limit 1;";
            ResultSet resultSet = stat.executeQuery(sql);
            
            while (resultSet.next()) {
                randomArtistId = resultSet.getInt("id");
            }
            int randomYear = random.nextInt(26) + 1980;
            create(fakeName, randomArtistId, randomYear);
            i++;
        }
    }           */
    
    
}