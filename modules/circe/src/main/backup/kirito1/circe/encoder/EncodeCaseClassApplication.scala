package org.scalax.kirito1.circe.encoder

import java.util

import asuna.{Application2, Context2, PropertyTag0}
import io.circe.Json

class EncodeCaseClassApplication[T](final val toProperty: (String, T) => (String, Json)) extends Application2[JsonObjectAppender, PropertyTag0[T], T, String] {

  private final val appender = new JsonObjectAppender[T, String] {
    override final def appendField(data: T, name: String, m: util.LinkedHashMap[String, Json]): Unit = {
      val pro = toProperty(name, data)
      m.put(pro._1, pro._2)
    }
  }

  override final def application(context: Context2[JsonObjectAppender]): JsonObjectAppender[T, String] = appender

}
