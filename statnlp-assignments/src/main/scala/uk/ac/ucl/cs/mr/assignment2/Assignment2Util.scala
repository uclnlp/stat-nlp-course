package uk.ac.ucl.cs.mr.assignment2

import java.io.{FilenameFilter, File}
import ml.wolfe.nlp.io._


object LoadData {
  def main(args: Array[String]) {
    val pathToBioNLP = args.lift(0).getOrElse("path-to/bionlp-train")
    val jsonFiles = new File(pathToBioNLP).listFiles(new FilenameFilter {
      override def accept(dir: File, name: String): Boolean = name.endsWith(".json")
    }).toList

    println("Showing just the head file: " + jsonFiles.head)
    val doc = LoadBioNLP.jsonFileToWolfeDoc(jsonFiles.head)
    println("Parsed data" + doc)
  }
}
