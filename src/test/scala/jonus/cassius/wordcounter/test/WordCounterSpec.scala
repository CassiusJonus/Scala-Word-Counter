package jonus.cassius.wordcounter
package test

import scala.io.{BufferedSource, Codec, Source}
import scala.util.Either

import org.scalatest.flatspec.AnyFlatSpec

import jonus.cassius.wordcounter.WordCounter

class WordCounterSpec extends AnyFlatSpec {

  "An empty file" should "have no lines" in {
    val emptyFile = Source.fromResource("empty.txt")(Codec.UTF8)
    assert(emptyFile.getLines.isEmpty)
    emptyFile.close()
  }
}
