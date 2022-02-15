package jonus.cassius.wordcounter

import scala.io.{Source, BufferedSource, Codec}

/** 
* This object contains the logic for the application.
*/

object WordCounter:

  def getWordsFrom(path: String): Either[String, List[String]] = {
    try {
      val fileSource: BufferedSource = Source.fromFile(path, Codec.UTF8)
      Right(fileSource.getLines().flatMap(_.split("\\W+")))
    }
    catch {
      case e: FileNotFoundException => Left(s"$path does not exist.")
      case e: IOException => Left("An error occurred while trying to access the path specified. Perhaps the path is invalid.")
    }
    finally fileSource.close

    
  }

end WordCounter