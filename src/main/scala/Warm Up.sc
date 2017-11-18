//Question #1
//function to determine if the integer is a prime number
def primeNumbers(n: Int): Boolean = {
  n >1 && (2 until n). forall (n % _ != 0)
}

primeNumbers(5)
primeNumbers(0)

//Question #2
//function to check for twin primes
def twinPrimes (x: Int , y: Int): Boolean = {
  primeNumbers(x) && primeNumbers(y)
  Math.abs(x-y)
  match {
    case 2 => true
    case _ => false
  }
}

twinPrimes(41,43)
twinPrimes(43,47)
twinPrimes(39,37)
twinPrimes(34,45)

//Question #3
// function to return an integer list of all the twin primes
def TwinPrimesList(n:Int): List[Int] = {
  primeslisthelper(n).sortBy(3 until n)

}
// recursive approach for the list
def primeslisthelper(n:Int) :List[Int] = n match {
  // base case since 2 is first prime number and doesn't have a twin prime
  case 2 => Nil
  //recursion case
  case _ => if (primeNumbers(n) && primeNumbers(n - 2)) {
    n :: (n - 2) :: primeslisthelper(n - 2).distinct
  } else
    primeslisthelper(n - 1).distinct
}

TwinPrimesList(50)

//Question #4
// function that takes even integer greater than 2 and returns this number as a sum of two prime numbers
def goldbachConjecture(n:Int):  Unit ={

    n match {
        //make sure number greater than 2
    case n if n <= 2   => println (" Input must be greater than 2 for goldbachConjecture")
      //make sure the number it's not an integer
    case n if n %2 ==1 => println(" Input can't be a prime number for goldbachConjecture ")
    case _  => ( 3 until n).foreach(x=> if (primeNumbers(x) && primeNumbers(n-x))
      println(x + " + " + (n-x) + " = " +n))
    }
  }
  goldbachConjecture(28)



