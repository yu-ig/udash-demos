package io.udash.demos.files

import io.udash._

sealed abstract class RoutingState(val parentState: Option[ContainerRoutingState]) extends State {
  type HierarchyRoot = RoutingState

  def url(implicit application: Application[RoutingState]): String =
    s"#${application.matchState(this).value}"
}

sealed abstract class ContainerRoutingState(parentState: Option[ContainerRoutingState]) extends RoutingState(parentState) with ContainerState
sealed abstract class FinalRoutingState(parentState: Option[ContainerRoutingState]) extends RoutingState(parentState) with FinalState

case object RootState extends ContainerRoutingState(None)
case object ErrorState extends FinalRoutingState(Some(RootState))
case object IndexState extends FinalRoutingState(Some(RootState))