package blackjack

class Game(val player: Player) {
	val deck = new Deck
	var dealerHand: List[Card] = null
	val limit = 21
	val minimumBet = 1

	def gameOver() = {
	  isBust(dealerHand) || isBust(player.hand)
	}

	def tallyLow(hand: List[Card]): Int = {
	  if (hand == null) return 0
	  hand.foldLeft(0)((a,b) => a + (b.rank.minPoints) )
	}

	def tallyHigh(hand: List[Card]): Int = {
	  if (hand == null) return 0
	  hand.foldLeft(0)((a,b) => a + (b.rank.points))
	}

	def isBust(hand: List[Card]):Boolean = tallyLow(hand) > limit

	def dealTo(player: Player) = {  // player, not hand because List[Card] is immutable
	  if (player.hand == null) player.hand = List(deck.draw)
	  else player.hand = deck.draw :: player.hand
	}

	def dealerDraw() = {
	  if (dealerHand == null) dealerHand = List(deck.draw)
		else dealerHand = deck.draw :: dealerHand
	}
}

