import play.api.libs.json.Json
import scala.io.Source
import scalaj.http._

object Main {

	def sendJsonString(s: String): Any = {
		/*val json = Json.parse(s)
		val seq = Seq(
			"id" -> (json \ "id").get.toString(),
			"latitude" -> (json \ "latitude").get.toString(),
			"longitude" -> (json \ "longitude").get.toString(),
			"temperature" -> (json \ "temperature").get.toString(),
			"battery" -> (json \ "battery").get.toString(),
			"weight" -> (json \ "weight").get.toString())*/
			val req = Http("http://localhost:9000/saveDrone").postData(s).header("Content-type", "application/json").asString.code
	}

	def main(args: Array[String]): Unit = {
		val lines = Source.fromFile("jsons/test.txt").getLines()
		lines.map(sendJsonString).toList
	}
}