package models;

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

    public Series() {
        seasons = new ArrayList<>();
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
}
