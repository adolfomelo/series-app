package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by gustavo on 05/12/14.
 */
@Entity(name="Episode")
public class Episode {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Season season;
    private String name;
    private boolean watched;

    public Episode() {
        this.watched = false;
    }

    public Episode(String name) {
        this();
        this.name = name;
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
}
