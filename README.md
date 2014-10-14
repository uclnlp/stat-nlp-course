[![Build Status](https://travis-ci.org/uclmr/stat-nlp-course.svg?branch=master)](https://travis-ci.org/uclmr/stat-nlp-course) [![Stories in Ready](https://badge.waffle.io/uclmr/stat-nlp-course.png?label=ready&title=Ready)](https://waffle.io/uclmr/stat-nlp-course)
stat-nlp-course
===============

Code for the UCL Statistical NLP course

# Terminal Setup
This assumes that you have [Git](http://git-scm.com/) and [SBT](http://www.scala-sbt.org/) installed on your machine. Then run the following commands in your working directory.
```
  git clone https://github.com/uclmr/stat-nlp-course.git
  cd stat-nlp-course
  sbt clean; sbt compile; sbt test
```

# IntelliJ Setup

If you are using [IntelliJ](http://www.jetbrains.com/idea/) you can run the following command to automatically setup an IntelliJ project (after you did the setup via the terminal).
```
sbt gen-idea
```


# Scala Learning Resources
* [Twitter Scala School](http://twitter.github.io/scala_school/)
* [Scala Tutorial for Java Programmers](http://docs.scala-lang.org/tutorials/scala-for-java-programmers.html)
* [Twitter Effective Scala](http://twitter.github.io/effectivescala/)
* [Coursera: Functional Programming Principles in Scala](https://www.coursera.org/course/progfun)
* [Odersky et al. (2008). Programming in Scala](http://www.cs.ucsb.edu/~benh/162/Programming-in-Scala.pdf)
* [Odersky. (2014). Scala by Example](http://www.scala-lang.org/docu/files/ScalaByExample.pdf)
