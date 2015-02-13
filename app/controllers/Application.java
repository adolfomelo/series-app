package controllers;

import models.Episode;
import models.Series;
import models.dao.GenericDAO;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {
    static final GenericDAO DAO = new GenericDAO();
    private static Form<Series> serieForm = Form.form(Series.class);

    @Transactional
    public static Result index() {
        return redirect(routes.Application.series());
    }

    @Transactional
    public static Result series() {
        List<Series> seriesList = DAO.findByAttributeName("Series", "watched", "false");
        List<Series> watchedSeriesList = DAO.findByAttributeName("Series", "watched", "true");
        return ok(index.render(seriesList, watchedSeriesList));
    }

    @Transactional
    public static Result watchSeries(long id) {
        Series series = DAO.findByEntityId(Series.class, id);
        series.setWatched();
        DAO.merge(series);
        return redirect(routes.Application.series());
    }

    @Transactional
    public static Result watchEpisode(long id) {
        Episode episode = DAO.findByEntityId(Episode.class, id);
        episode.setWatched();
        DAO.merge(episode);
        return redirect(routes.Application.series());
    }

    @Transactional
    public static Result nextEpisodeView(){
        Form<Series> filledForm = serieForm.bindFromRequest();
        if (filledForm.hasErrors()) {
            return badRequest();
        } else {
            long id = Long.parseLong(filledForm.data().get("id"));
            Series serie = DAO.findByEntityId(Series.class, id);
            serie.setNextEpisodeControler(filledForm.data().get("nextEpisodeSetter"));

            Logger.debug("EpisodeControler: " + filledForm.data().get("nextEpisodeSetter") + " na serie " + serie.getName());

            DAO.merge(serie);
            DAO.flush();

            return redirect(routes.Application.index());
        }
    }
}
