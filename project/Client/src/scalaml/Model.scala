package scalaml

import java.util.ArrayList
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import com.google.gson.Gson


object Model {

  val gson = new Gson()

  def fit[T](X: Array[Array[Double]], y:Array[Double], route:String, parameterClass : Class[T]): T  = {

    val XasJson = gson.toJson(X)
    val yasJson = gson.toJson(y)

    val nameValuePairs = new ArrayList[NameValuePair]()
    nameValuePairs.add(new BasicNameValuePair("X", XasJson))
    nameValuePairs.add(new BasicNameValuePair("y", yasJson))
    val jsonResponse = Utility.makePostRequest(nameValuePairs, route)
    val params =  gson.fromJson(jsonResponse, parameterClass)
    params
  }

  def predict[T, P](X: Array[Array[Double]], route : String, params : T, predictionClass : Class[P]): P = {

    val xAsJson = gson.toJson(X)
    val paramsAsJson = gson.toJson(params, params.getClass())
    val nameValuePairs = new ArrayList[NameValuePair]()
    nameValuePairs.add(new BasicNameValuePair("X", xAsJson))
    nameValuePairs.add(new BasicNameValuePair("params", paramsAsJson))
    val jsonResponse = Utility.makePostRequest(nameValuePairs, route)
    val predictions = gson.fromJson(jsonResponse, predictionClass)
    predictions
  }

}

