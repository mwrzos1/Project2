//Question #1
//function to determine if the integer is a prime number
def primeNumbers(n: Int): Boolean = {
  n >1 &&
    (2 until n). forall (n % _ != 0)
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
// function to sort the list from 3 to n
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

def goldbachConjecture(n:Int): Unit ={


}