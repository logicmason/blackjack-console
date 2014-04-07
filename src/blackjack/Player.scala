package blackjack

class Player(name: String, var chips: Int) {
	var hand: List[Card] = null
	override def toString: String = s"""
    Name: $name
    Chips: $chips
    Hand: $hand
	""".stripMargin
}