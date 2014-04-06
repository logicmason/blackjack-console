package blackjack

class Deck {
	val names = List("Ace","Two", "Three", "Four", "Five", "Six", "Seven",
						 "Eight", "Nine", "Ten", "Jack", "Queen", "King")
	val points = List(11,2,3,4,5,6,7,8,9,10,10,10, 10)

	val ranks = (names, points).zipped.map { new Rank(_, _) }
	val cards = for (a <- ranks; b <- Suit.values) yield new Card(a, b)
}