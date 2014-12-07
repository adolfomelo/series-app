package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavo on 05/12/14.
 */
@Entity(name="Season")
public class Season {
    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column
    private int number;
    @ManyToOne(cascade=CascadeType.ALL)
    private Series series;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn
    private List<Episode> episodes;

    public Season() {
        episodes = new ArrayList<>();
    }

    public Season(int number, Series series) {
        this();
        this.number = number;
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public long getId() {
        return id;
    }
}
