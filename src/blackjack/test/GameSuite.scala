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

}