package blackjack.test
import blackjack._

import org.scalatest.FunSuite

class DeckSuite extends FunSuite {
  trait TestSets {
    val deck = new Deck
  }

  test("size of new deck") {
    new TestSets {
      assert(deck.cards.size === 0)
    }
  }

  test("first card is an ace") {
    new TestSets {
      assert(deck.cards.head.rank.name === "Ace")
    }
  }
}