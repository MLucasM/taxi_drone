import play.api.libs.json.Json
import scala.io.Source
import scalaj.http._

object Main {
	def main(args: Array[String]): Unit = {
		println(args)
		val lines = Source.fromFile("jsons/test.txt").getLines()
		print(lines)
		val json = Json.parse(Source.fromFile("jsons/test.txt").getLines().mkString)
		val lat = (json \ "latitude").get
		//val seq = json.as[Seq[String]]
		println(Json.prettyPrint(json))
		//println(seq)
		val seq = Seq(
			"id" -> (json \ "id").get.toString(),
			"latitude" -> (json \ "latitude").get.toString(),
			"longitude" -> (json \ "longitude").get.toString(),
			"temperature" -> (json \ "temperature").get.toString(),
			"battery" -> (json \ "battery").get.toString(),
			"weight" -> (json \ "weight").get.toString())
	}
}