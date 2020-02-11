package org.apache.spark.examples

import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("wordcount")
      .master("local[2]")
      .getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("DEBUG")
    val lines = sc.textFile("D:\\Data\\Code\\spark-2.3.2\\examples\\src\\main\\resources\\word.txt")
    val rdd = lines.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .collect()
    val rdd1 = rdd
      .map(x => (x._1, x._2 + 1))
      .take(5)
    rdd.toList.foreach(x => println(s"value is $x"))
    rdd.toList.map(x => println(s"value map is $x")).take(10)
    rdd1.toList.foreach(x => println(s"value is $x"))

  }

}
