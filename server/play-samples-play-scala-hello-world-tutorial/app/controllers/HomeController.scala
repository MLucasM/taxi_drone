package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */

class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  
  def explore() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.explore())
  }
  
  def tutorial() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.tutorial())
  }

  import play.api.libs.json.Json

  val drones = scala.collection.mutable.MutableList[Drone]()

  def saveDrone = Action { request =>
    val json = request.body.asJson.get
    val drone = json.as[Drone]
    drones.++=(List(drone))
    println(drones)
    Ok(views.html.home(drones))
  }

  def hello() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.home(drones))
  }
}
