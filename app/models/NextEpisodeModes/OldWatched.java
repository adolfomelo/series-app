package models.NextEpisodeModes;

import models.Episode;
import models.Season;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by JULIE on 10/02/2015.
 */
@Entity
public class OldWatched extends NextEpisodeControler {

    @Override
    public Episode nextEpisode(Season season) {
        List<Episode> episodes = season.getEpisodes();
        for (int i = 0; i < episodes.size(); i++) {
            if (!episodes.get(i).isWatched()) {
                return episodes.get(i);
            }
        }
        return null;
    }
}
