package uk.ac.ucl.cs.mr.assignment1

import ml.wolfe.nlp.{CharOffsets, Token, Document}

/**
 * @author Sebastian Riedel
 */
object Assignment1 {

  import uk.ac.ucl.cs.mr.assignment1.Assignment1Util._

  trait LanguageModel {
    def order:Int
    def prob(word: String, history: NGram): Double
  }

  def perplexity(lm: LanguageModel, documents:Iterator[Document]): Double = ???

  class ConstantLM(vocabSize: Int) extends LanguageModel {
    val order = 1
    def prob(word: String, history: NGram) = ???
  }

  class NgramLM(val countsN: Counts,
                val countsNMinus1: Counts,
                val order: Int) extends LanguageModel {
    def prob(word: String, history: NGram) = ???
  }

  class AddOneLM(ngramLM: NgramLM, vocabSize: Int, eps: Double = 1.0) extends LanguageModel {
    def order = ngramLM.order
    def prob(word: String, history: NGram) = ???
  }

  class GoodTuringLM(ngramLM: NgramLM) extends LanguageModel {
    def order = ngramLM.order
    def prob(word: String, history: NGram) = ???
  }

  def trainNgramLM(train:Seq[Document], order:Int): LanguageModel = ???

  def main(args: Array[String]) {
    println("Hello, world!")
    //val vocabulary = loadVocabulary("vocabulary.txt")
    //val history = loadHistory("history.txt")
    //serialize(lm, history, vocabulary, "output.txt")

    //todo
  }
}