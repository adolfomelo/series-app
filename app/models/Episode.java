package models;

import javax.persistence.*;

/**
 * Created by gustavo on 05/12/14.
 */
@Entity(name="Episode")
public class Episode {
    @Id
    @GeneratedValue
    @Column
    private long id;
    @ManyToOne(cascade=CascadeType.ALL)
    private Season season;
    @Column
    private int number;
    @Column
    private String name;
    @Column
    private boolean watched;

    public Episode() {
        this.watched = false;
    }

    public Episode(int number, String name, Season season) {
        this();
        this.number = number;
        this.name = name;
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
