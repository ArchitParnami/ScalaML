package scalaml

class NaiveBayes{

  class Parameters {
    // probability of each class.
    var class_prior: Array[Double] = null
    // number of training samples observed in each class.
    var class_count: Array[Double] = null
    // mean of each feature per class
    var theta: Array[Array[Double]] = null
    // variance of each feature per class
    var sigma: Array[Array[Double]] = null
    var classes: Array[Int] = null
  }

  class Predictions {
    var pred: Array[Int] = null
  }

  var params = new Parameters
  var predictions = new Predictions


  def fit(X: Array[Array[Double]], y: Array[Int]): Unit = {
    val route = "NaiveBayes/Fit"
    val yd = y.map(x=> x.toDouble)
    params = Model.fit(X, yd, route, params.getClass())
  }

  def predict[K](X: Array[Array[Double]]): Array[Int] = {
    val route = "/NaiveBayes/Predict"
    predictions = Model.predict(X, route, params, predictions.getClass())
    predictions.pred
  }
}



