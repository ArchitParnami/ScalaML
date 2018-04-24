package scalaml

class LogisticRegression {

  class Parameters{
    var coef : Array[Array[Double]] =null
    var inter : Array[Double] = null
    var niter : Array[Int] = null
    var classes : Array[Int] = null
  }

  class Predictions {
    var pred : Array[Int] = null
  }

  var params = new Parameters
  var predictions = new Predictions

  def fit(X: Array[Array[Double]], y:Array[Int]): Unit = {
    val route = "LogisticRegression/Fit"
    val yd = y.map(x => x.toDouble)
    params = Model.fit(X, yd, route, params.getClass())
  }

  def predict(X: Array[Array[Double]]): Array[Int] = {
    val route = "LogisticRegression/Predict"
    predictions = Model.predict(X, route, params, predictions.getClass())
    predictions.pred
  }

}
