package blackjack.test
import blackjack._
import Suit._

import org.scalatest.FunSuite

class GameSuite extends FunSuite {
  trait TestSets {
    val Johnny = new Player("Johnny", 100)
    val game = new Game(Johnny)
    val hand1 = List(
    		new Card(new Rank("Four", 4), Clubs),
    		new Card(new Rank("Seven", 7), Hearts),
    		new Card(new Rank("Queen", 10), Hearts)
    )
    val hand2 = List(
    		new Card(new Rank("Ace", 11), Clubs),
    		new Card(new Rank("Ace", 11), Spades),
    		new Card(new Rank("Ace", 11), Diamonds),
    		new Card(new Rank("Seven", 7), Clubs)
    )
    val hand3 = List(
    		new Card(new Rank("King", 10), Spades),
    		new Card(new Rank("Three", 3), Spades),
    		new Card(new Rank("Nine", 9), Hearts)
    )
  }

  test("Correctly counts max values of hands") {
    new TestSets {
      assert(game.tallyHigh(hand1) == 21)
      assert(game.tallyHigh(hand2) == 40)
      assert(game.tallyHigh(hand3) == 22)
    }
  }

  test("Correctly counts min values of hands") {
    new TestSets {
      assert(game.tallyLow(hand1) == 21)
      assert(game.tallyLow(hand2) == 10)
      assert(game.tallyLow(hand3) == 22)
    }
  }

  test("Correctly checks for busts") {
    new TestSets {
      assert(game.isBust(hand1) == false)
      assert(game.isBust(hand2) == false)
      assert(game.isBust(hand3) == true)
    }
  }

  test("Deck pile gets smaller when dealing") {
    new TestSets {
      game.dealerDraw()
      game.dealTo(Johnny)
      game.dealTo(Johnny)
      assert(game.deck.size == 49)
    }
  }

  test("deductTenUntilValid works") {
    new TestSets {
      assert(game.deductTenUntilValid(17) == 17)
      assert(game.deductTenUntilValid(37) == 17)
      assert(game.deductTenUntilValid(21) == 21)
      assert(game.deductTenUntilValid(40) == 20)
      assert(game.deductTenUntilValid(51) == 21)
    }
  }

  test("Correctly scores hands") {
    new TestSets {
      assert(game.score(hand1) == 21)
      assert(game.score(hand2) == 20)
      assert(game.score(hand3) == 0) // since it's bust
    }
  }
}