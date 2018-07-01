package repositories.dev

import java.util.concurrent.ConcurrentHashMap

import domain.dev.Models._

trait RepositoryComponent {
  val repository: Repository

  trait Repository {

    def getInfo(i: ActorId): ActorInfo
    def updateInfo(a: ActorId, i: ActorInfo)

    def getStatus(i: ActorId): ActorStatus
    def updateStatus(i: ActorId, s: ActorStatus)

    def getTarget(i: ActorId): ActorTarget
    def updateTarget(i: ActorId, t: ActorTarget)

  }

}

trait RepositoryComponentImpl extends RepositoryComponent {
  override val repository = new RepositoryImpl

  class RepositoryImpl extends Repository {

    val infos = new ConcurrentHashMap[ActorId, ActorInfo]
    val status = new ConcurrentHashMap[ActorId, ActorStatus]
    val targets = new ConcurrentHashMap[ActorId, ActorTarget]

    override def getInfo(a: ActorId): ActorInfo = infos.get(a)
    override def updateInfo(a: ActorId, i: ActorInfo): Unit = infos.put(a, i)
    override def getStatus(a: ActorId): ActorStatus = status.get(a)
    override def updateStatus(i: ActorId, s: ActorStatus): Unit = status.put(i, s)
    override def getTarget(a: ActorId): ActorTarget = targets.get(a)
    override def updateTarget(a: ActorId, t: ActorTarget): Unit = targets.put(a, t)

  }

}