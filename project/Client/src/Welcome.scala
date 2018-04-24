
object Welcome extends App{

  def get(url: String) = scala.io.Source.fromURL(url).mkString
  var url = "http://127.0.0.1:5000"
  var result = get(url)

  println(result)

}
