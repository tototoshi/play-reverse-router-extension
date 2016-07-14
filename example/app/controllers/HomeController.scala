package controllers

import play.api.Logger
import play.api.mvc.{ Action, Controller }

class HomeController extends Controller {

  private val logger = Logger(classOf[HomeController])

  def index() = Action { request =>
    request.queryString.foreach { case (k, v) =>
        logger.info(s"$k=$v")
    }
    Ok(views.html.index())
  }

}