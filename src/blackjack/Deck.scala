package blackjack

import scala.collection.mutable.ListBuffer

class Deck {
	val names = List("Ace","Two", "Three", "Four", "Five", "Six", "Seven",
						 "Eight", "Nine", "Ten", "Jack", "Queen", "King")
	val points = List(11,2,3,4,5,6,7,8,9,10,10,10, 10)

	val ranks = (names, points).zipped.map { new Rank(_, _) }
	val cards = for (a <- ranks; b <- Suit.values) yield new Card(a, b)

	var pile: ListBuffer[Card] = ListBuffer()
	shuffle.foreach { a => pile += a }

	def size:Int = pile.size
	def length:Int = pile.length

	def shuffle = util.Random.shuffle(cards)

	def draw():Card = {
	  if (pile.length > 15) pile.remove(0)
	  else {
	    // shuffle a new deck
	    pile.clear
	    shuffle.foreach { a => pile += a }
	    pile.remove(0)
	  }
	}
}