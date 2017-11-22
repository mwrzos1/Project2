// COSC 455 - Programming Languages: Implementation and Design
// Project 2

// NAME: <Marcin Wrzoszczyk>


// lists of numbers in Chinese and English
val chinese: List[String] = List("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi")
val english: List[String] = List("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

//test cases for this assignment
go(List("yi", "nine" , "six" , "ba" ))
go(List("yi", "Josh" , "three" , "si"))

def go(aList: List[String]) : Unit = {

  val myList: List[Int] = convert(aList)
  val endList: List [Int] = myList.filter(_ > -1) // filter the numbers anything not between <0 and 10> gets discarded

  println("Translation:" + numbers(endList))
  println()
  print("Addition:" +  displaySum(endList))
  print(" = "+ sumOfNumbers(endList))
  println()
  println("Multiplication:" + displayMult(endList))
  print(" = "+ multiplicationOfNumbers(endList))

}

def convert(aList: List[String]): List[Int] = {

  aList.map(n => LanguagetoNumbers(n))
}

def LanguagetoNumbers(words: String): Int = {

  words match {

    case "ling" => 0
    case "yi" => 1
    case "er" => 2
    case "san" => 3
    case "si" => 4
    case "wu" => 5
    case "liu" => 6
    case "qi" => 7
    case "ba" => 8
    case "jiu" => 9
    case "shi" => 10
    case "one" => 1
    case "two" => 2
    case "three" => 3
    case "four" => 4
    case "five" => 5
    case "six" => 6
    case "seven" => 7
    case "eight" => 8
    case "nine" => 9
    case "ten" => 10
    case _ => -1
  }

}

// recursive function to print numbers after conversion
def numbers (endList: List[Int]): Unit = {

  endList.nonEmpty match {
    case true =>
      print(endList.head + " ")
      numbers(endList.tail)
    case false => Nil
  }
}

//this method only adds the numbers together
def sumOfNumbers (endList: List[Int] ): Int = endList match {

    case Nil => 0
    case head :: tail =>
      head + sumOfNumbers(tail)
}

//this method displays for example "1+9+6+8"
def displaySum (endList: List [Int] ): Unit = {

  (endList.nonEmpty , endList.length != 1) match {
    case (false, _) => Nil
    case (true, true) => print(endList.head + " + ")
      displaySum(endList.tail)
    case (true, false) => {
      print(endList.head)
      displayMult(endList.tail)
    }
  }
}
// this method multiplies the numbers
def multiplicationOfNumbers(endList: List [Int]): Int = endList match{

  case Nil => 1
  case head :: tail =>
    head * multiplicationOfNumbers(tail)
}


// this method displays 1*9*6**8
def displayMult (endList: List [Int] ): Unit = {

  (endList.nonEmpty , endList.length != 1) match {
    case (false, _) => Nil
    case (true, true) => {
      print(endList.head + " * ")
      displayMult(endList.tail)
    }
    case (true, false) => {
      print(endList.head)
      displayMult(endList.tail)
    }
  }
}