package controllers.dev

import domain.dev.Models.Implicits._
import domain.dev.Models._
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller => PlayController}
import services.dev.ServiceComponent

/**
  * Controller (action generator / provider).
  *
  * An Action is an f: Request => Result.
  *
  * The `routes` file will map urls to these actions.
  */
trait Controller extends PlayController {
  self: ServiceComponent =>
  0

  def updateInfo(devId: String, actorId: String) = Action(parse.json) { request =>
    val i = ActorId(devId, actorId)
    val f = ActorInfo(request.body.as[InfosRaw])
    service.updateInfo(i, f)
    Logger.info(s"Update info $i: $f")
    Ok
  }

  def getInfo(devId: String, actorId: String) = Action(parse.empty) { request =>
    val i = ActorId(devId, actorId)
    val f = service.getInfo(i)
    Logger.info(s"Get info $i: $f")
    Ok(Json.toJson(f))
  }

  def updateStatus(devId: String, actorId: String) = Action(parse.json) { request =>
    val i = ActorId(devId, actorId)
    val s = ActorStatus(request.body.as[StatusRaw])
    service.updateStatus(i, s)
    Logger.info(s"Update status $i: $s")
    Ok
  }

  def getStatus(devId: String, actorId: String) = Action(parse.empty) { request =>
    val i = ActorId(devId, actorId)
    val s = service.getStatus(i)
    Logger.info(s"Get status $i: $s")
    Ok(Json.toJson(s))
  }

  def updateTarget(devId: String, actorId: String) = Action(parse.json) { request =>
    val i = ActorId(devId, actorId)
    val t = ActorTarget(request.body.as[TargetRaw])
    service.updateTarget(i, t)
    Logger.info(s"Update target $i: $t")
    Ok
  }

  def getTarget(devId: String, actorId: String) = Action(parse.empty) { request =>
    val i = ActorId(devId, actorId)
    val t = service.getTarget(i)
    Logger.info(s"Get target $i: $t")
    Ok(Json.toJson(t))
  }
}

