/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class AlbumController {
    private Connection connection;

    
    public AlbumController(Connection connection) {
        this.connection = connection;
    }

    
    
    public void create(String name, int artistId, int releaseYear) throws SQLException {
        PreparedStatement stat = connection.prepareStatement
                ("insert into albums (name, artist_id, release_year) values (1,2 , 3)");
        stat.setString(1, name);
        stat.setInt(2, artistId);
        stat.setInt(3, releaseYear);
        stat.executeUpdate();
    }

    
    
    public List<Album> findByArtist(int artistId) throws SQLException {
        PreparedStatement stat = connection.prepareStatement("select * from albums ");
        stat.setInt(1, artistId);
        ResultSet rs = stat.executeQuery();
        List<Album> albums = new ArrayList<>();
        while (rs.next()) {
            albums.add(new Album(rs.getInt("id"), rs.getString("name"),
                    rs.getInt("artist_id"), rs.getInt("release_year")));
        }
        return albums;
    }
}
