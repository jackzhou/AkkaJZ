package com.zoaks.learnakka

import akka.actor.{ActorLogging, Actor}

/**
 * @author  jyzhou on 1/31/16.
 */
class SimpleActor  extends Actor with ActorLogging{
  var lstString: String = _
  override def receive: Receive = {
    case str: String => lstString = str
    case o => log.info("received an non string message {}.", o)
  }

}
