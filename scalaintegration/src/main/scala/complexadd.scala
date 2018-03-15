
//operator overloadin in scala. here the value operator + definition is to add two complex numbers.

class Complex(val real:Int, val imaginary:Int){
  def +(complex:Complex):Complex={
    new Complex(real+complex.real, imaginary+complex.imaginary)
  }
  override def toString():String={
    real+(if (imaginary<0) "" else "+") + imaginary + "i"
  }
}
object complexadd{
  def main(args:Array[String]){
    val c1 = new Complex(1, 4)
    val c2 = new Complex(2, 5)
    println(c1+c2)
  }
}
