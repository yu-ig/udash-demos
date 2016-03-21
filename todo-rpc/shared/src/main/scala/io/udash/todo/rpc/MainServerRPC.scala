package io.udash.todo.rpc

import io.udash.rpc._
import io.udash.todo.rpc.model.Todo
import scala.concurrent.Future

trait MainServerRPC extends RPC {
  def store(todos: Seq[Todo]): Future[Boolean]
  def load(): Future[Seq[Todo]]
}

       