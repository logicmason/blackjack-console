package blackjack

class Card(val rank: Rank, val suit: Suit.Value) {
  override def toString: String = {
    rank.toString + " of " + suit.toString
  }
}

object Suit extends Enumeration {
  type Suit = Value
  val Hearts, Spades, Diamonds, Clubs = Value
}
import Suit._

class Rank(cardName: String, cardPoints: Int) {
  val name: String = cardName
  val points: Int = cardPoints
  val minPoints = {
    if (name == "Ace") 1
    else points
  }
  override def toString: String = name
}
