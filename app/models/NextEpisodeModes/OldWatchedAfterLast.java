package models.NextEpisodeModes;

import models.Episode;
import models.Season;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by JULIE on 10/02/2015.
 */
@Entity
public class OldWatchedAfterLast extends NextEpisodeControler {

    @Override
    public Episode nextEpisode(Season season) {
        List<Episode> episodes = season.getEpisodes();
        for (int i = 0; i < episodes.size(); i++) {
            if (episodes.get(i).equals(season.getLastEpisode())){
                return episodes.get(i+1);
            }
        }
        return null;
    }
}
