import  scalaml.LogisticRegression

object LogExample {

  def main(args: Array[String]): Unit = {

    val X: Array[Array[Double]] = Array(Array(-1, -1), Array(-2, -1), Array(-3, -2), Array(1, 1), Array(2, 1), Array(3, 2))
    var y: Array[Int] = Array(1, 1, 1, 2, 2, 2);

    val X_Test : Array[Array[Double]] = Array(Array(-0.8, -1), Array(8.1, 12.1))
    var clf = new LogisticRegression()
    clf.fit(X, y)

    val results = clf.predict(X_Test)
    println(results.mkString(" "))
  }

}
