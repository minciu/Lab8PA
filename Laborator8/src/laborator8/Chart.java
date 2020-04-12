/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;

/**
 *
 * @author user
 */
public class Chart {
    private int id;
    private int albumId;
    private int top_chart;
    
    public Chart(int id, int albumId, int top_chart) {
        this.id = id;
        this.albumId = albumId;
        this.top_chart = top_chart;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the albumId
     */
    public int getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId the albumId to set
     */
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    /**
     * @return the top_chart
     */
    public int getTop_chart() {
        return top_chart;
    }

    /**
     * @param top_chart the top_chart to set
     */
    public void setTop_chart(int top_chart) {
        this.top_chart = top_chart;
    }
    
    
}
