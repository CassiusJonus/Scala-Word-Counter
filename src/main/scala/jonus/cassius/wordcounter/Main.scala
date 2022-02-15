package jonus.cassius.wordcounter

import scala.io.StdIn

import scala.util.Either

/** The entry point for the application.
  *
  * @author: Cassius jonus
  * @version: 0.1.0
  */
object Main {

  def main(args: Array[String]): Unit = {

    println("""
    |Welcome to the word counter application! Enter a path to a text file, 
    |to find out how many words it contains. Enter
    |
    """)

    val wordsOrError: Either[String, Iterator[String]] = WordCounter.getLinesFrom(getFilePath())
    wordsOrError match {
      case Right(words) => println(s"The number of words in the file is ${WordCounter.count(words)}")
      case Left(error)  => println(error)
    }
  }

  def getFilePath(): String =
    StdIn.readLine("Enter the path to a text file: ")
}
