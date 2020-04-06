/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class ArtistController {
    private Connection conex;

    
    public ArtistController(Connection conex) {
        this.conex = conex;
    }

    
    
    public void create(String name, String country) throws SQLException{
        String sql = "insert into artists (name, country) values (1, 2)";
        PreparedStatement stat = conex.prepareStatement(sql);
        stat.setString(1, name);
        stat.setString(2, country);
        stat.executeUpdate();
    }

    
    
    public List<Artist> findByName(String name) throws SQLException {
    
        PreparedStatement stat = conex.prepareStatement("select * from artists ");
        stat.setString(1, name);
        ResultSet rs = stat.executeQuery();
        List<Artist> artists = new ArrayList<>();
        while (rs.next()) {
            artists.add(new Artist(rs.getInt("id"), rs.getString("name"),rs.getString("country")));
        }
        return artists;
    }
    
    
}
