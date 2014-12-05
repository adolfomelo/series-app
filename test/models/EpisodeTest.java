package models;

import models.dao.GenericDAO;
import org.junit.Test;
import test.AbstractTest;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class EpisodeTest extends AbstractTest {
    GenericDAO dao = new GenericDAO();
    List<Episode> episodes;

    @Test
    public void mustStartWithNoEpisode() throws Exception {
        episodes = dao.findAllByClass(Episode.class);
        assertThat(episodes).isEmpty();
    }
}