package org.scalax.ugeneric.circe.encoder.common.model

import zsg.{Context3, Plus3, ZsgTuple0}
import io.circe.Json

object JsonObjectContext extends Context3[JsonObjectContent] {

  /*override def append[X1, X2, X3, Y1, Y2, Y3, Z1, Z2, Z3](x: JsonObjectContent[X1, X2, X3], y: JsonObjectContent[Y1, Y2, Y3])(
    p: Plus3[X1, X2, X3, Y1, Y2, Y3, Z1, Z2, Z3]
  ): JsonObjectContent[Z1, Z2, Z3] = new JsonObjectContent[Z1, Z2, Z3] {
    override def appendField(name: Z3): JsonObjectAppender[Z2] = {
      val appender1 = x.appendField(p.takeHead3(name))
      val appender2 = y.appendField(p.takeTail3(name))
      new JsonObjectAppender[Z2] {
        override def getAppender(data: Z2, l: List[(String, Json)]): List[(String, Json)] = {
          val data1 = p.takeHead2(data)
          val data2 = p.takeTail2(data)
          appender2.getAppender(data2, appender1.getAppender(data1, l))
        }
      }
    }
  }

  override val start: JsonObjectContent[ZsgTuple0, ZsgTuple0, ZsgTuple0] = new JsonObjectContent[ZsgTuple0, ZsgTuple0, ZsgTuple0] {
    val jsonObjectAppenderAsunaTuple0: JsonObjectAppender[ZsgTuple0] = new JsonObjectAppender[ZsgTuple0] {
      override def getAppender(data: ZsgTuple0, l: List[(String, Json)]): List[(String, Json)] = l
    }
    override def appendField(name: ZsgTuple0): JsonObjectAppender[ZsgTuple0] = {
      jsonObjectAppenderAsunaTuple0
    }
  }*/

  override def append[X1, X2, X3, Y1, Y2, Y3, Z1, Z2, Z3](x: JsonObjectContent[X1, X2, X3], y: JsonObjectContent[Y1, Y2, Y3])(
    p: Plus3[X1, X2, X3, Y1, Y2, Y3, Z1, Z2, Z3]
  ): JsonObjectContent[Z1, Z2, Z3] = new JsonObjectContent[Z1, Z2, Z3] {
    override def getAppender(data: Z3, l: List[(String, Json)]): List[(String, Json)] = {
      val data1 = p.takeHead3(data)
      val data2 = p.takeTail3(data)
      y.getAppender(data2, x.getAppender(data1, l))
    }
  }

  override val start: JsonObjectContent[ZsgTuple0, ZsgTuple0, ZsgTuple0] = new JsonObjectContent[ZsgTuple0, ZsgTuple0, ZsgTuple0] {
    override def getAppender(data: ZsgTuple0, l: List[(String, Json)]): List[(String, Json)] = l
  }

}
