import play.api.libs.json.Json
import scala.io.Source

object Main {
	def main(args: Array[String]): Unit = {

		val json = Json.parse(Source.fromFile("test.json").getLines().mkString)
		val lat = (json \ "latitude").get
		println(lat)
	}
}