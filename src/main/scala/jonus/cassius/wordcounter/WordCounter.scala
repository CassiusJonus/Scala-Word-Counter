package jonus.cassius.wordcounter

import scala.io.{BufferedSource, Codec, Source}
import java.io.{FileNotFoundException, IOException}
import java.io.File

/** This object contains the logic for the application.
  */

object WordCounter:

  def getLinesFrom(path: String): Either[String, Iterator[String]] = {
    import scala.util.Either
    try {
      val fileSource = Source.fromFile(path)(Codec.UTF8)
      try
        Right(fileSource.getLines())
      catch {

        case e: IOException =>
          Left("An error occurred while trying to access the path specified. Perhaps the path is invalid.")
      }
      finally fileSource.close()
    }
    catch {
      case e: FileNotFoundException => Left(s"$path does not exist.")
    }
  }

  def count(words: Iterator[String]): Int = words.flatMap(_.split("\\W+").iterator).size

end WordCounter
