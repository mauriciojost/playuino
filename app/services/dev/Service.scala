package services.dev

import domain.dev.Models._
import repositories.dev.RepositoryComponent

trait ServiceComponent {
  val service: Service

  trait Service {

    def getInfo(i: ActorId): ActorInfo

    def updateInfo(i: ActorId, s: ActorInfo)

    def getStatus(i: ActorId): ActorStatus

    def updateStatus(i: ActorId, s: ActorStatus)

    def getTarget(i: ActorId): ActorTarget

    def updateTarget(i: ActorId, s: ActorTarget)

  }

}

trait ServiceComponentImpl extends ServiceComponent {
  self: RepositoryComponent =>

  override val service = new ServiceImpl

  class ServiceImpl extends Service {

    override def getInfo(i: ActorId): ActorInfo = repository.getInfo(i)

    override def updateInfo(i: ActorId, f: ActorInfo): Unit = repository.updateInfo(i, f)

    override def getStatus(i: ActorId): ActorStatus = repository.getStatus(i)

    override def updateStatus(i: ActorId, s: ActorStatus): Unit = repository.updateStatus(i, s)

    override def getTarget(i: ActorId): ActorTarget = repository.getTarget(i)

    override def updateTarget(i: ActorId, t: ActorTarget): Unit = repository.updateTarget(i, t)

  }

}
