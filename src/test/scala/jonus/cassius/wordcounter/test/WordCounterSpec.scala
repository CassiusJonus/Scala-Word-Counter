package jonus.cassius.wordcounter
package test

import scala.io.{BufferedSource, Codec, Source}
import scala.util.Either

import java.io.{FileNotFoundException, IOException}

import org.scalatest.flatspec.AnyFlatSpec

import jonus.cassius.wordcounter.WordCounter

class WordCounterSpec extends AnyFlatSpec {

  "An empty file" should "have no lines" in {
    val emptyFile = Source.fromResource("empty.txt")(Codec.UTF8)
    assert(emptyFile.getLines.isEmpty)
    emptyFile.close()
  }

  "A path to a non-existent file" should "throw a FileNotFoundException" in {
    assertThrows[FileNotFoundException](Source.fromFile("notFound.txt")(Codec.UTF8))
  }

  "A non-empty file" should "have a word count greater than zero" in {
    val nonEmptyFile = Source.fromResource("words.txt")(Codec.UTF8)
    assert(WordCounter.count(nonEmptyFile.getLines) > 0)
  }
}
