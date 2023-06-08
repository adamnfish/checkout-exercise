package io.adamnfish

import scala.math.Integral.Implicits.infixIntegralOps


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
    val total = orderPrice(items)
    formatMoney(total)
  }

  private val APPLE_PRICE = 60
  private val ORANGE_PRICE = 25

  def orderPrice(items: List[Item]): Int = {
    val applesCount = items.count(_ == Apple)
    val (appleOffersCount, extraApple) = applesCount /% 2
    val applesPrice = (appleOffersCount * APPLE_PRICE) + (extraApple * APPLE_PRICE)

    val orangesCount = items.count(_ == Orange)
    val (orangeOffersCount, extraOranges) = orangesCount /% 3
    val orangesPrice = (orangeOffersCount * ORANGE_PRICE * 2) + (extraOranges * ORANGE_PRICE)

    applesPrice + orangesPrice
  }

  def formatMoney(pence: Int): String = {
    val pounds = pence / 100.0
    f"£$pounds%.2f"
  }
}
