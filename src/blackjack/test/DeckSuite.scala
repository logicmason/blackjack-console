package blackjack

import org.scalatest.FunSuite

class DeckSuite extends FunSuite {
  trait TestSets {
    val deck = new Deck
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

  test("size of new deck") {
    new TestSets {
      assert(deck.cards.size === 0)
    }
  }
}