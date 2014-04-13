package blackjack

class Player(name: String, var chips: Int) {
	var hand: List[Card] = null
	var wager = 0

	def bet(amount:Int): Boolean = {
	  if (chips < 0) return false
	  else {
	    chips -= amount
	    wager += amount
	    return true
	  }
	}

	def wins {
	  chips += wager * 2
	  wager = 0
	}

	def loses {
	  wager = 0
	}

	override def toString: String = s"""
    Name: $name
    Chips: $chips
    Hand: $hand
	""".stripMargin
}