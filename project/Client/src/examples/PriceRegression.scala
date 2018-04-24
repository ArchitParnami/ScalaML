package examples

import java.util.ArrayList
import java.io._
import scalaml.LinearRegression

object PriceRegression {

  def main(args: Array[String]): Unit = {

    val src = io.Source.fromFile("./data/LPvsBP/train.csv")
    val X : ArrayList[Array[Double]] = new ArrayList[Array[Double]]()
    val Y : ArrayList[Double] = new ArrayList[Double]()

    for(line <- src.getLines().drop(1)) {

      val Array(x, y) = line.split(",").map(_.trim)
      X.add(Array(x.toDouble))
      Y.add(y.toDouble)
    }

    val XA : Array[Array[Double]] = new Array[Array[Double]](X.size())
    val YA : Array[Double] = new Array[Double](X.size())
    for (i <- 0 until X.size) {
      XA(i) = X.get(i)
      YA(i) = Y.get(i)
    }

    val XTest:Array[Array[Double]] = (10 to 25).toArray.map(x=> Array(x.toDouble))

    val reg = new LinearRegression()
    reg.fit(XA, YA)
    val predictions = reg.predict(XTest)

    val pw = new PrintWriter(new File("./data/LPvsBP/results.csv" ))
    for(i <- 0 until XTest.size) {
      var s = XTest(i)(0).toString
      s = s + "," + predictions(i).toString
      pw.println(s)
    }
    pw.close

  }
}
