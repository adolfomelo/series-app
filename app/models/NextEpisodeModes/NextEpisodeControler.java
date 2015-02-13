package models.NextEpisodeModes;

import models.Episode;
import models.Season;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by JULIE on 10/02/2015.
 */
@Entity
public abstract class NextEpisodeControler {
    @Id
    @GeneratedValue
    private Long id;

    public abstract Episode nextEpisode(Season season);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
