package blackjack.test
import blackjack._

import org.scalatest.FunSuite

class DeckSuite extends FunSuite {
  trait TestSets {
    val deck = new Deck
  }

  test("size of new deck") {
    new TestSets {
      assert(deck.cards.size === 52)
    }
  }

  test("first card is an ace") {
    new TestSets {
      assert(deck.cards.head.rank.name === "Ace")
    }
  }

  test("size of draw pile after drawing a card") {
    new TestSets {
      deck.draw
      assert(deck.pile.size == 51)
    }
  }

  test("cards in pile plus those drawn are the same set as the original deck") {
    new TestSets {
    	val card1 = deck.draw
    	val card2 = deck.draw
    	val pile = deck.pile.toList
    	assert( (card1 :: card2 :: pile).toSet == deck.cards.toSet )
    }
  }
}