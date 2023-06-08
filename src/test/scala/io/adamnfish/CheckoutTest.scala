package io.adamnfish

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers


class CheckoutTest extends AnyFreeSpec with Matchers {
  "checkout" - {
    "returns £0.00 for an empty list" in {
      Checkout.checkout(List.empty) shouldEqual "£0.00"
    }
    "returns £0.60 for a list with one apple" in {
      Checkout.checkout(List("apple")) shouldEqual "£0.60"
    }
    "returns £0.25 for a list with one orange" in {
      Checkout.checkout(List("orange")) shouldEqual "£0.25"
    }
    "returns £0.85 for a list with an apple and an orange" in {
      Checkout.checkout(List("apple", "orange")) shouldEqual "£0.85"
    }
    "returns £0.85 for a list with two apples and an orange" in {
      Checkout.checkout(List("apple", "apple", "orange")) shouldEqual "£0.85"
    }
    "returns £1.10 for a list with two apples and two oranges" in {
      Checkout.checkout(List("apple", "apple", "orange", "orange")) shouldEqual "£1.10"
    }
    "returns £1.10 for a list with two apples and three oranges" in {
      Checkout.checkout(List("apple", "apple", "orange", "orange", "orange")) shouldEqual "£1.10"
    }
    "returns £1.70 for a list with three apples and two oranges" in {
      Checkout.checkout(List("apple", "apple", "apple", "orange", "orange")) shouldEqual "£1.70"
    }
    "returns £1.70 for a list with four apples and three oranges" in {
      Checkout.checkout(List("apple", "apple", "apple", "apple", "orange", "orange", "orange")) shouldEqual "£1.70"
    }

    "throws an error on invalid input" in {
      an[IllegalArgumentException] should be thrownBy Checkout.checkout(List("banana"))
    }
  }

  "formatMoney" - {
    "returns £0.00 for 0" in {
      Checkout.formatMoney(0) shouldEqual "£0.00"
    }
    "returns £0.01 for 1" in {
      Checkout.formatMoney(1) shouldEqual "£0.01"
    }
    "returns £0.10 for 10" in {
      Checkout.formatMoney(10) shouldEqual "£0.10"
    }
    "returns £1.00 for 100" in {
      Checkout.formatMoney(100) shouldEqual "£1.00"
    }
    "returns £1.23 for 123" in {
      Checkout.formatMoney(123) shouldEqual "£1.23"
    }
    "returns £1.23 for 123.4" in {
      Checkout.formatMoney(123) shouldEqual "£1.23"
    }
    "returns £1.23 for 123.45" in {
      Checkout.formatMoney(123) shouldEqual "£1.23"
    }
    "returns £1.23 for 123.456" in {
      Checkout.formatMoney(123) shouldEqual "£1.23"
    }
    "returns £1.23 for 123.4567" in {
      Checkout.formatMoney(123) shouldEqual "£1.23"
    }
  }

  "orderPrice" - {
    // more detailed checks on the offer logic

    "returns 0 for an empty list" in {
      Checkout.orderPrice(List.empty) shouldEqual 0
    }

    "returns 60 for a list with one apple" in {
      Checkout.orderPrice(List(Apple)) shouldEqual 60
    }
    "returns 60 for a list with two apples" in {
      Checkout.orderPrice(List(Apple, Apple)) shouldEqual 60
    }
    "returns 120 for a list with three apples" in {
      Checkout.orderPrice(List(Apple, Apple, Apple)) shouldEqual 120
    }
    "returns 120 for a list with four apples" in {
      Checkout.orderPrice(List(Apple, Apple, Apple, Apple)) shouldEqual 120
    }

    "returns 25 for a list with one orange" in {
      Checkout.orderPrice(List(Orange)) shouldEqual 25
    }
    "returns 50 for a list with two orange" in {
      Checkout.orderPrice(List(Orange, Orange)) shouldEqual 50
    }
    "returns 50 for a list with three orange" in {
      Checkout.orderPrice(List(Orange, Orange, Orange)) shouldEqual 50
    }
    "returns 75 for a list with four oranges" in {
      Checkout.orderPrice(List(Orange, Orange, Orange, Orange)) shouldEqual 75
    }
    "returns 100 for a list with five orange" in {
      Checkout.orderPrice(List(Orange, Orange, Orange, Orange, Orange)) shouldEqual 100
    }
    "returns 100 for a list with six orange" in {
      Checkout.orderPrice(List(Orange, Orange, Orange, Orange, Orange, Orange)) shouldEqual 100
    }

    "returns 85 for a list with an apple and an orange" in {
      Checkout.orderPrice(List(Apple, Orange)) shouldEqual 85
    }
    "returns 85 for a list with two apples and an orange" in {
      Checkout.orderPrice(List(Apple, Apple, Orange)) shouldEqual 85
    }
    "returns 110 for a list with two apples and two oranges" in {
      Checkout.orderPrice(List(Apple, Apple, Orange, Orange)) shouldEqual 110
    }
    "returns 110 for a list with two apples and three oranges" in {
      Checkout.orderPrice(List(Apple, Apple, Orange, Orange, Orange)) shouldEqual 110
    }
    "returns 170 for a list with three apples and two oranges" in {
      Checkout.orderPrice(List(Apple, Apple, Apple, Orange, Orange)) shouldEqual 170
    }
    "returns 170 for a list with four apples and three oranges" in {
      Checkout.orderPrice(List(Apple, Apple, Apple, Apple, Orange, Orange, Orange)) shouldEqual 170
    }
  }
}
