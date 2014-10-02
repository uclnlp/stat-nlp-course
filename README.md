[![Stories in Ready](https://badge.waffle.io/uclmr/stat-nlp-course.png?label=ready&title=Ready)](https://waffle.io/uclmr/stat-nlp-course)
stat-nlp-course
===============

Code for the UCL Statistical NLP course

# Terminal Setup
This assumes that you have [Git](http://git-scm.com/) and [SBT](http://www.scala-sbt.org/) installed on your machine. Then run the following commands in your working directory.
```
  git clone https://github.com/wolfe-pack/wolfe.git
  git clone https://github.com/uclmr/stat-nlp-course.git
  cd stat-nlp-course
  sbt compile
```

# IntelliJ Setup

If you are using [IntelliJ](http://www.jetbrains.com/idea/) you can run the following command to automatically setup an IntelliJ project (after you did the setup via the terminal).
```
sbt gen-idea
```

Afterwards you have to remove `wolfe-build` from IntelliJ's modules in the `Project Structure`.

![IntelliJ Setup](/statnlp-tutorial/src/main/resources/setup.jpg)

