import scala.io.Source
import scalaj.http._

object Main {

	def sendJsonString(s: String): Any = {
			val req = Http("http://localhost:9000/saveDrone").postData(s).header("Content-type", "application/json").asString.code
	}

	def main(args: Array[String]): Unit = {
		val lines = Source.fromFile("jsons/test.txt").getLines()
		lines.map(sendJsonString).toList
	}
}