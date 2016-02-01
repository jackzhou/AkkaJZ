package com.zoaks.learnakka

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

/**
 * @author  jyzhou on 1/31/16.
 */
class SimpleActorTest extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()
  
  describe("akkajz") {
    describe("given message") {
      it("should place the message on the lstString field") {
        val msg = "Hello, Actor."
        val actorRef = TestActorRef(new SimpleActor)
        actorRef ! msg
        actorRef.underlyingActor.lstString should equal(msg)
      }
    }
    
    describe("given two messages") {
      it("should place the last message on the lstString field") {
        val msg1 = "hello, Actor"
        val msg2 = "hello, Actor again"
        val actorRef = TestActorRef(new SimpleActor)
        actorRef ! msg1
        actorRef ! msg2
        actorRef.underlyingActor.lstString should equal(msg2)
        actorRef ! 1

      }
    }
  }

}
