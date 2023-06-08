package io.adamnfish


/**
 * This is a simple checkout system that takes a list of items and
 * calculates the total cost.
 *
 * We work in pence throughout to avoid floating point rounding errors,
 * and format the output as pounds and pence.
 */
object Checkout {
  def main(args: Array[String]): Unit = {
    val result = checkout(args.toList)
    println(result)
  }

  def checkout(input: List[String]): String = {
    val items = input.map {
      case "apple" => Apple
      case "orange" => Orange
      case item =>
        // We could consider using Either to model errors in the type system,
        // but the exercise asks for the simplest possible solution.
        throw new IllegalArgumentException(s"Unknown item: $item")
    }
    val total = items.map(price).sum
    formatMoney(total)
  }

  def price(item: Item): Int = {
    item match {
      case Apple => 60
      case Orange => 25
    }
  }

  def formatMoney(pence: Int): String = {
    val pounds = pence / 100.0
    f"£$pounds%.2f"
  }
}
