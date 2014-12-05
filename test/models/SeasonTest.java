package models;

import models.dao.GenericDAO;
import org.junit.Test;
import test.AbstractTest;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class SeasonTest extends AbstractTest {
    GenericDAO dao = new GenericDAO();
    List<Season> seasons;

    @Test
    public void mustStartWithNoSeason() throws Exception {
        seasons = dao.findAllByClass(Season.class);
        assertThat(seasons).isEmpty();
    }
}