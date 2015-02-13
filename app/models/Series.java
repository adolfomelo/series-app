package models;

import models.NextEpisodeModes.NextEpisodeControler;
import models.NextEpisodeModes.OldWatched;
import models.NextEpisodeModes.OldWatchedAfterLast;
import models.NextEpisodeModes.Watched3Episodes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavo on 05/12/14.
 */
@Entity(name = "Series")
public class Series {
    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column
    private String name;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn
    private List<Season> seasons;
    @Column
    private boolean watched;

    public static final int PRIME = 31;

    public Series() {
        seasons = new ArrayList<>();
        watched = false;
    }

    public Series(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public void setNextEpisodeControler(String nextEpisodeControler){
        NextEpisodeControler episodeControler;

        switch (nextEpisodeControler){
            case "olderthan3":
                episodeControler = new Watched3Episodes();
                break;
            case "olderthanlast":
                episodeControler = new OldWatchedAfterLast();
                break;
            default:
                episodeControler = new OldWatched();
        }

        for (int i = 0; i <seasons.size() ; i++) {
            seasons.get(i).setNextEpisodeControler(episodeControler);
        }
    }

    public long getId() {
        return id;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched() {
        watched = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Series series = (Series) o;

        if (watched != series.watched) {
            return false;
        }
        if (!name.equals(series.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = PRIME * result + seasons.hashCode();
        result = PRIME * result + (watched ? 1 : 0);
        return result;
    }
}
