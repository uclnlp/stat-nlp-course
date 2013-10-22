package assignment2

import org.riedelcastro.frontlets.Frontlet
import scala.io.Source

/**
 * @author Sebastian Riedel
 */
class Document extends Frontlet {
  val txt = StringSlot("txt")
  val sentences = FrontletListSlot("sentences", () => new Sentence)
}

class Sentence extends Frontlet {
  val eventCandidates = FrontletListSlot("eventCandidates", () => new Event)
  val tokens = FrontletListSlot("tokens", () => new Token)
  val mentions = FrontletListSlot("mentions", () => new Mention)
  val deps = FrontletListSlot("deps", () => new Dep)
}

class Token extends Frontlet {
  val word = StringSlot("word")
  val stem = StringSlot("lemma")
  val tag = StringSlot("tag")
  val begin = IntSlot("begin")
  val end = IntSlot("end")
}

class Dep extends Frontlet {
  val mod = IntSlot("mod")
  val head = IntSlot("head")
  val label = StringSlot("label")
}

class Mention extends Span {
  val label = StringSlot("label")
}

class Argument extends Span {
  val gold = StringSlot("gold")
}

class Event extends Span {
  val gold = StringSlot("gold")
  val arguments = FrontletListSlot("arguments", () => new Argument)
}

trait Span extends Frontlet {
  val begin = IntSlot("begin")
  val end = IntSlot("end")
}

object Test {
  def main(args: Array[String]) {
    val json = Source.fromFile("/tmp/bionlp-json/PMC-1134658-00-TIAB.json").getLines().mkString("\n")
    val doc = new Document().setJSON(json)
    println(doc.sentences().head.eventCandidates().find(_.gold() != "None"))
    println(doc.sentences().head.eventCandidates().find(_.gold() != "None"))
    val doc2 = new Document().setJSON(json)
    println(doc2.sentences().head.eventCandidates().find(_.gold() != "None"))
    //println(doc)
  }
}

