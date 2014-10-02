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

Afterwards you have to make some manual adjustments to IntelliJ's project setup.

- Change the compile output path of wolfe-build from stat-nlp-course to wolfe
![IntelliJ Setup 1](/statnlp-tutorial/src/main/resources/setup/setup1.png)
- Remove wolfe-build as content root
![IntelliJ Setup 2](/statnlp-tutorial/src/main/resources/setup/setup2.png)
