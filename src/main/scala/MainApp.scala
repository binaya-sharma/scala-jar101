import org.apache.spark.sql.{SparkSession, Row}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object MainApp {

  def main(args: Array[String]): Unit = {


    // REPL-safe: reuse existing SparkSession
    // val spark = SparkSession.active


    val spark = SparkSession.builder()
      .appName("StructType-Transformation")
      .getOrCreate()

    try {

      // 1️⃣ Define schema
      val schema = StructType(Seq(
        StructField("id", IntegerType, nullable = false),
        StructField("name", StringType, nullable = true),
        StructField("is_active", BooleanType, nullable = true)
      ))

      // 2️⃣ Create data (rows)
      val data = Seq(
        Row(1, "Alice", true),
        Row(2, "Bob", false),
        Row(3, "Charlie", true)
      )

      // 3️⃣ Create DataFrame using schema
      val df = spark.createDataFrame(
        spark.sparkContext.parallelize(data),
        schema
      )

      // 4️⃣ Simple transformation
      val resultDf = df.filter(col("is_active") === true)

      // 5️⃣ Show result
      resultDf.show()

    } finally {
      spark.stop()
    }
  }
}