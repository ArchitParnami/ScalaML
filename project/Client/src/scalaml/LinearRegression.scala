package scalaml

class LinearRegression {

  class Parameters{
    var coef : Array[Double] =null
    var inter : Double = 0
  }

  class Predictions {
    var pred : Array[Double] = null
  }

  var params = new Parameters
  var predictions = new Predictions


   def fit(X: Array[Array[Double]], y:Array[Double]): Unit = {
    val route = "LinearRegression/Fit"
    params = Model.fit(X, y, route, params.getClass())
  }

  def predict(X: Array[Array[Double]]): Array[Double] = {

    val route = "LinearRegression/Predict"
    predictions = Model.predict(X, route, params, predictions.getClass())
    predictions.pred
  }

}

