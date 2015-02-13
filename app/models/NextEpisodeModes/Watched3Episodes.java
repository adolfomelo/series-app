package models.NextEpisodeModes;

import models.Episode;
import models.Season;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by JULIE on 10/02/2015.
 */
@Entity
public class Watched3Episodes extends NextEpisodeControler {

    public static final int LIMIT = 3;

    @Override
    public Episode nextEpisode(Season season) {

        List<Episode> episodes = season.getEpisodes();

        for (int i = 0; i < episodes.size(); i++) {
            if(!episodes.get(i).isWatched() && !verifyNext3Episodes(episodes, i) ){
                return episodes.get(i);
            }
        }
        return null;
    }


    private boolean verifyNext3Episodes(List<Episode> episodes, int i){
        int count = 0;
        for (int j = i+1; j < episodes.size(); j++) {
            if(episodes.get(j).isWatched()){
                count++;
            }
            if(count == LIMIT){
                return true;
            }
        }
        return false;
    }
}



