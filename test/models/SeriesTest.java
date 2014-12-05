package models;

import models.dao.GenericDAO;
import org.junit.Test;
import test.AbstractTest;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class SeriesTest extends AbstractTest {
    GenericDAO dao = new GenericDAO();
    List<Series> seriesList;

    @Test
    public void mustStartWithNoSeries() throws Exception {
        seriesList = dao.findAllByClass(Series.class);
        assertThat(seriesList).isEmpty();
    }
}