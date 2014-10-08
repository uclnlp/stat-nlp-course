package uk.ac.ucl.cs.mr.assignment1

import ml.wolfe.nlp.{Token, TokenSplitter, SentenceSplitter}
import org.scalatest.{Matchers, WordSpec}

/**
 * Created by rockt on 08/10/2014.
 */
class Assignment1Spec extends WordSpec with Matchers {
  def tokenize(text: String): Seq[Token] = (SentenceSplitter andThen TokenSplitter)(text).sentences.flatMap(_.tokens)

  "A tokenizer" should {
    "should split a text into words" in {
      tokenize("This is a test.").map(_.word) shouldBe List("This", "is", "a", "test", ".")
    }
  }

  //todo: additional unit tests go here
}
