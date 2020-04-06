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
public class Album {
    private int id;
    private String name;
    private int artist_id;
    private int release_year;
    public Album(int id, String name, int artist_id, int release_year) {
        this.id = id;
        this.name = name;
        this.artist_id = artist_id;
        this.release_year = release_year;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the artist_id
     */
    public int getArtist_id() {
        return artist_id;
    }

    /**
     * @param artist_id the artist_id to set
     */
    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    /**
     * @return the release_year
     */
    public int getRelease_year() {
        return release_year;
    }

    /**
     * @param release_year the release_year to set
     */
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
