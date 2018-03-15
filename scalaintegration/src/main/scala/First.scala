import breeze.linalg.{DenseVector => BreezeVector}
import org.apache.hadoop.security.UserGroupInformation
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.SparkSession

// $example on:init_session$
// $example off:init_session$
// $example on:programmatic_schema$
// $example on:data_types$


object SparkSQLExample {

  case class Person(name: String, age: Long)

  def main(args: Array[String]): Unit = {

    UserGroupInformation.loginUserFromKeytab("dfuser1", "/tmp/dfuser1.keytab")

    val spark = SparkSession
      .builder()
      .master("yarn")
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    val describedf = spark.read.format("com.databricks.spark.csv").option("inferSchema", "true").option("header", "true").load("hdfs://host:8020/*")

    val sparseVec1 = Vectors.sparse(20, Array(0,2,18,19), Array(5, 3, 8,9))

    println(sparseVec1.size)
    println(sparseVec1.numActives)
    println(sparseVec1.numNonzeros)
    println("sparseVec1 presentation = ",sparseVec1)

    describedf.printSchema()

  }

  }
