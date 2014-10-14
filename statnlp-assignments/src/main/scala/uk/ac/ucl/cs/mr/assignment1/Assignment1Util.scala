package uk.ac.ucl.cs.mr.assignment1

import java.io.{PrintWriter, File}

import ml.wolfe.nlp.{Document, Sentence, Token, _}
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import uk.ac.ucl.cs.mr.assignment1.Assignment1.LanguageModel
import scala.io.{Source, Codec}

/**
 * @author Sebastian Riedel
 */
object Assignment1Util {
  /* Type aliases */
  type Counts = Map[NGram,Double]
  type NGram = Seq[String]

  /**
   * Converts a file into a tokenized and sentence segmented document
   * @param file text file to convert
   * @return Document of sentences and tokens.
   */
  def toDocument(file: File): Document = {
    val content = Source.fromFile(file)(Codec("ISO8859-1")).getLines().toArray
    val text = content.foldLeft("")(_ + " " + _)
    val pipeline = SentenceSplitter andThen TokenSplitter
    pipeline(text)
  }

  /**
   * Generic method to get n-grams from a sentence
   * @param sentence sentence to n-grams from
   * @param n n-gram order
   * @return n-grams in sentence
   */
  def ngramsInSentence(sentence: Sentence, n: Int): Seq[NGram] = ???

  /**
   * Get all descendant files in the directory specified by f.
   * @param f the parent directory.
   * @return all files in the directory, recursive.
   */
  def recursiveListFiles(f: File): Array[File] = {
    val these = f.listFiles
    these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
  }

  /**
   * Add counts to an immutable map
   * @param counts map with counts
   * @param ngram ngram to increase count
   * @param count count to add
   * @return new map with count of ngram increased by count.
   */
  def addNgramCount(counts: Counts, ngram: NGram, count: Double = 1.0): Counts = ???

  /**
   * Take two count maps, and add their counts
   * @param countsMany first count map
   * @param countsFew second count map
   * @return a map that maps each key in the union of keys of counts1 and counts2 to the sum of their counts.
   */
  def addNgramCounts(countsMany: Counts, countsFew: Counts): Counts = ???

  /**
   * Collect n-gram counts of a given order in the document
   * @param document the document to get n-gram counts from
   * @param n the n-gram order.
   * @return a n-gram to count in document map
   */
  def getNGramCounts(document: Document, n: Int): Counts = ???

  /**
   * For a given n-gram count map get the counts for n-1 grams.
   * @param counts the n-gram counts
   * @return the n-1 gram counts.
   */
  def getNMinus1Counts(counts: Counts): Counts = ???



  // loads both the vocabulary and the history file, creates their
  // cartesian product, gets the probability for the language model
  // (account for possibly unknown words!) and saves it in a tab-separated
  // file in the format: historyngram1 historyngram2 word probability
  def serialize(lm: LanguageModel, history: Seq[NGram], vocabulary: Seq[String], filename: String) = {
    val output = new PrintWriter(new File(filename))
    try {
      for {
        ngram <- history
        word <- vocabulary
      } {
        val probability = lm.prob(word, ngram) //what if the word you're searching for is not in your LM?
        output.print("%s\t%s\t%s\t".format(ngram(0), ngram(1), word))
        output.println(probability)
      }
    }
    finally {
      output.close()
    }
  }

  // reads a vocabulary from a file
  // the file is structured as a single vocabulary word per line
  def loadVocabulary(filename: String): Seq[String] = {
    val source = Source.fromFile(filename).getLines()
    source.toSeq
  }

  // reads history (ngrams) from a file
  // the file is structured as a tab-separated pair of words (2-gram) per line
  def loadHistory(filename: String): Seq[NGram] = {
    val source = Source.fromFile(filename).getLines()
    source.map(_.split("\\t").toSeq).toSeq
  }

}








