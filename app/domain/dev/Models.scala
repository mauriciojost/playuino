package domain.dev

import play.api.libs.json.Writes

object Models {

  type InfosRaw = List[String]
  type StatusRaw = Map[String, String]
  type TargetRaw = Map[String, String]

  case class ActorId(
    deviceId: String,
    actorId: String
  )

  case class ActorTarget(
    t: TargetRaw
  )

  case class ActorStatus(
    s: StatusRaw
  )

  case class ActorInfo(
    i: InfosRaw
  )

  object Implicits {

    implicit def infosWrites(implicit w1: Writes[InfosRaw]) = new Writes[ActorInfo] {
      def writes(i: ActorInfo) = w1.writes(i.i)
    }

    implicit def statusWrites(implicit w1: Writes[StatusRaw]) = new Writes[ActorStatus] {
      def writes(a: ActorStatus) = w1.writes(a.s)
    }

    implicit def targetWrites(implicit w1: Writes[TargetRaw]) = new Writes[ActorTarget] {
      def writes(t: ActorTarget) = w1.writes(t.t)
    }

  }

}

