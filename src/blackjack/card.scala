package blackjack

class Card(val rank: Int, val suit: String) {
  override def toString: String = {
    rank.toString + " of " + suit.toString
  }
}