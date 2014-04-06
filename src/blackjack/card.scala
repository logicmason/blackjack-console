package blackjack

object Suit extends Enumeration {
  type Suit = Value
  val Hearts, Spades, Diamonds, Clubs = Value
}
import Suit._

class Card(val rank: Int, val suit: Suit.Value) {
  override def toString: String = {
    rank.toString + " of " + suit.toString
  }
}

