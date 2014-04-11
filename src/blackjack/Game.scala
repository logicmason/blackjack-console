package blackjack

class Game(val player: Player) {
	val deck = new Deck
	var dealerHand: List[Card] = null

	def gameOver() = {
	  isBust(dealerHand) || isBust(player.hand)
	}

	def isBust(hand: List[Card]):Boolean = {
	  if (hand == null) false
	  else hand.length > 3  //TODO real check
	}
}

