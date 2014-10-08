package uk.ac.ucl.cs.mr.assignment1

import ml.wolfe.nlp.{CharOffsets, Token}
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization._
import org.scalatest.{WordSpec, Matchers}

/**
 * Created by rockt on 08/10/2014.
 */
class SerializationSpec extends WordSpec with Matchers {
  "Serialization" should {
    "serialize and deserialze tokens" in {
      implicit val formats = Serialization.formats(NoTypeHints)
      val token = Token("Test", CharOffsets(0, 4))
      info(token.toString)

      val serializedToken = write(token)
      info(serializedToken.toString)

      val deserializedToken = read[Token](serializedToken)
      info(deserializedToken.toString)

      token shouldEqual deserializedToken
    }
  }

}
