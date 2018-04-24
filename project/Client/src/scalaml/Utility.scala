package scalaml

import org.apache.http._
import org.apache.http.util.EntityUtils
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClientBuilder
import java.util.ArrayList
import org.apache.http.client.entity.UrlEncodedFormEntity


object Utility {

  val server = "http://localhost:5000/"

  def makePostRequest(nameValuePairs : ArrayList[NameValuePair],  route : String) : String = {

    val url = server + route
    val post = new HttpPost(url)
    post.setEntity(new UrlEncodedFormEntity(nameValuePairs))

    val client = HttpClientBuilder.create().build()
    val response = client.execute(post)
    val jsonString = EntityUtils.toString(response.getEntity())

    return  jsonString

  }

}


