/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;

import java.sql.*;
import java.util.*;


public class ChartsController  {
    
    public void create(int albumId, int numberOfAlbums) throws SQLException {
        
        Connection conex = Database.getInstance().getConnection();
        String sql = "INSERT INTO chart (album_id, top_chart) VALUES(?,?);";
        PreparedStatement stat = conex.prepareStatement(sql);
        stat.setInt(1, albumId);
        stat.setInt(2, numberOfAlbums);
        stat.execute();
    }

    public void insertGeneratedChart(int rows) throws SQLException {
        Connection conex = Database.getInstance().getConnection();
        Statement stat = conex.createStatement();
        
        Random random = new Random();

        int i = 0;
        while (i < rows) {
            int randomChartId = -1;
            String sql = "SELECT id FROM albums ORDER BY random() limit 1;";
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                randomChartId = res.getInt("id");
            }
            int randomNumberOfAlbums = random.nextInt(20);
            create(randomChartId, randomNumberOfAlbums);
            i++;
        }
    }

    public void generateTop() throws SQLException {
        List<Map<String, Object>> top = new ArrayList<>();
        Connection conex = Database.getInstance().getConnection();
        Statement stat = conex.createStatement();
        String query = "SELECT artists.name, AVG(top_chart) AS top " +
                "FROM artists JOIN albums ON artists.id = albums.artist_id " +
                "JOIN chart ON albums.id = chart.album_id " +
                "GROUP BY artists.name " +
                "ORDER BY top ;";
        ResultSet res = stat.executeQuery(query);
        int i = 0;
        while (res.next()) {
            top.add(new HashMap<>());
            top.get(i).put("position", i + 1);
            String artistName = res.getString("name");
            top.get(i).put("name", artistName);
            int TOP = res.getInt("top");
            top.get(i).put("TOP", TOP);
            i++;
        }
        for (Map<String, Object> stringObjectMap : top) {
            System.out.println((int) stringObjectMap.get("position") + ". " + 
                    (String) stringObjectMap.get("name") +
                    " top_chart " +
                     (int) stringObjectMap.get("TOP"));
        }
    }
}
