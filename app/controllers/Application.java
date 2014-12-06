package controllers;

import models.Series;
import models.dao.GenericDAO;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {
    static final GenericDAO dao = new GenericDAO();

    public static Result index() {
        return redirect(routes.Application.series());
    }

    @Transactional
    public static Result series() {
        List<Series> seriesList = dao.findAllByClass(Series.class);
        return ok(views.html.index.render(seriesList));
    }
}
