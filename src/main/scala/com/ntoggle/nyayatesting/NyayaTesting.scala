package com.ntoggle.nyayatesting

import nyaya.gen.Gen

object NyayaTesting extends App {

  case class Bar(value: Int)
  case class Foo(b: Option[Bar], c: String)

  val genBar: Gen[Bar] = Gen.int.map(Bar.apply)
  val genFoo: Gen[Foo] =
    Gen.apply2(Foo.apply)(genBar.option, Gen.string)

  val input = genFoo.samples().take(100).toList
  input.foreach(println)
}
