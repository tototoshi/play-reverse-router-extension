package com.github.tototoshi.play.reverserouter

import org.scalatest.funsuite.AnyFunSuite
import play.api.mvc.Call

class ImplicitsTest extends AnyFunSuite {

  import Implicits._

  test("Add #withQueryString") {
    val call = Call("GET", "/", "fragment")
    assert(call.withQueryString("a" -> "あ").toString === "/?a=%E3%81%82#fragment")
  }

}
