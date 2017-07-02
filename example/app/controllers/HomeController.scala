package controllers

import play.api.Logger
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import javax.inject.{Inject, Singleton}

@Singleton
class HomeController @Inject() (cc: ControllerComponents) extends AbstractController(cc) {

  private val logger = Logger(classOf[HomeController])

  def index() = Action { request: Request[AnyContent] =>
    request.queryString.foreach { case (k, v) =>
        logger.info(s"$k=$v")
    }
    Ok(views.html.index())
  }

}