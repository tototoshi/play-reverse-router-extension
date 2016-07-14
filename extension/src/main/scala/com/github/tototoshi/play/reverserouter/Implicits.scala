package com.github.tototoshi.play.reverserouter

import java.net.URLEncoder

import play.api.mvc.Call

object Implicits {

  implicit class RichCall(call: Call) {

    private val charset = "UTF-8"

    def withQueryString(parameters: (String, Any)*): Call = {
      val q = parameters.map { case (k, v) => encode(k) + "=" + encode(v.toString) }
      val url = call.url + (if (call.url.contains("?")) "&" else "?") + q.mkString("&")
      call.copy(url = url)
    }

    private def encode(s: String): String = URLEncoder.encode(s, charset)
  }

}