import scalaml.LinearRegression

object LRExample{

  def main(args: Array[String]): Unit = {

    var X = Array.ofDim[Double](6,1)
    var data = Array(0,1,2,3,4,5);
    for (i <- 0 to data.length - 1) {
      X(i)(0) = data(i);
    }

    var y :Array[Double]= Array(1,3,5,7,9,11);

    var X_Test = Array.ofDim[Double](n1 = 2, n2 = 1)
    var test = Array(6,7)
    for (i <- 0 to test.length - 1) {
      X_Test(i)(0) = test(i)
    }

    var reg = new LinearRegression()
    reg.fit(X, y)

    val results = reg.predict(X_Test)


    println(results.mkString(" "))

  }
}