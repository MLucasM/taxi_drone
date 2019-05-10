import scala.io.Source
import scalaj.http._
import java.io.File

object Main {

	def getListOfFiles(dir: String):List[File] = {
		val d = new File(dir)
		if (d.exists && d.isDirectory) {
			d.listFiles.filter(_.isFile).toList
		} else {
			List[File]()
		}
	}

	def sendJsonString(s: String): Any = {
		val req = Http("http://localhost:9000/saveDrone").postData(s).header("Content-type", "application/json").asString.code
	}

	def main(args: Array[String]): Unit = {
		val paths = args.flatMap(getListOfFiles)
		val files = paths.flatMap(Source.fromFile(_).getLines())
		files.map(sendJsonString).toList

	}
}