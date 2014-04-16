package vlach

// Eclipse Worksheet

object presentation {
  println("Introduction to Scala")                //> Introduction to Scala

  val ages = List(1, 2, 3, 4, 5)                  //> ages  : List[Int] = List(1, 2, 3, 4, 5)

  // Imperative style
  def total(l: List[Int]): Int = {
    var sum = 0
    for (i <- l) {
      sum += i
    }
    sum
  }                                               //> total: (l: List[Int])Int

  // Functional style
  def totalFunctional(l: List[Int]): Int = {
    l.foldLeft(0) { (carryOver, el) => carryOver + el }
  }                                               //> totalFunctional: (l: List[Int])Int
  
  def totalAll(l : List[Int]) : Int = {
  	var sum = 0
    l.foreach { e => sum += e }
    sum
  }                                               //> totalAll: (l: List[Int])Int
  
  def totalEven(l : List[Int]) : Int = {
  	var sum = 0
    l.foreach { e => if(e % 2 == 0) sum += e }
    sum
  }                                               //> totalEven: (l: List[Int])Int

  // Higher Order Function for abstraction over commonly repeating patterns
  def totalWithSelector(l: List[Int], selector: Int => Boolean): Int = {
    var sum = 0
    l.foreach { e => if (selector(e)) sum += e }
    sum
  }                                               //> totalWithSelector: (l: List[Int], selector: Int => Boolean)Int
  
  total(ages)                                     //> res0: Int = 15
  totalFunctional(ages)                           //> res1: Int = 15
  
  totalAll(ages)                                  //> res2: Int = 15
  totalEven(ages)                                 //> res3: Int = 6
  
  totalWithSelector(ages, i => true)              //> res4: Int = 15
  totalWithSelector(ages, i => i % 2 == 0)        //> res5: Int = 6
  totalWithSelector(ages, i => i > 4)             //> res6: Int = 5

}