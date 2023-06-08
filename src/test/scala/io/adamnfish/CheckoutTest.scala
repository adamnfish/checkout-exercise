package io.adamnfish

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers


class CheckoutTest extends AnyFreeSpec with Matchers {
  "price" - {
    "returns 60 for an apple" in {
      Checkout.price(Apple) shouldEqual 60
    }
    "returns 25 for an orange" in {
      Checkout.price(Orange) shouldEqual 25
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
    "returns £1.45 for a list with two apples and an orange" in {
      Checkout.checkout(List("apple", "apple", "orange")) shouldEqual "£1.45"
    }
    "returns £1.70 for a list with two apples and two oranges" in {
      Checkout.checkout(List("apple", "apple", "orange", "orange")) shouldEqual "£1.70"
    }
    "returns £1.95 for a list with two apples and three oranges" in {
      Checkout.checkout(List("apple", "apple", "orange", "orange", "orange")) shouldEqual "£1.95"
    }
    "returns £2.30 for a list with three apples and two oranges" in {
      Checkout.checkout(List("apple", "apple", "apple", "orange", "orange")) shouldEqual "£2.30"
    }
    "returns £3.15 for a list with four apples and three oranges" in {
      Checkout.checkout(List("apple", "apple", "apple", "apple", "orange", "orange", "orange")) shouldEqual "£3.15"
    }

    "throws an error on invalid input" in {
      an[IllegalArgumentException] should be thrownBy Checkout.checkout(List("banana"))
    }
  }
}
