package blackjack

class Game(val player: Player) {
	val deck = new Deck
	var dealerHand: List[Card] = null
	val limit = 21
	val minimumBet = 1

	def isGameOver() = {
	  isBust(dealerHand) || isBust(player.hand) || player.hand == null
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

	def display(hand: List[Card]) {
	  print("Cards: ")
	  println(hand.mkString(", "))
	}

	def hit(p: Player) {
	  dealTo(p)
	  println(s"\nYou are dealt the ${player.hand.head}")
	  display(p.hand)
	  if (isBust(p.hand)) lose(p)
	}

	def lose(p: Player) {
	  println("BUST!!!  You lose.")
	  p.loses
	  gameOver
	}

	def gameOver {
	  player.hand = null
	}

	// game sequence
	dealerDraw()
	println(s"Dealer draws a card.  It's the ${dealerHand.head}")
	dealerDraw()  // hole card
	println(s"Dealer draws a second card and places it face-down")

	dealTo(player)
	println(s"You are dealt the ${player.hand.head}")

	//TODO loop of hitting until player stops
	var action: Char = ' '
	var doneHitting = false
	while (!doneHitting && !isGameOver) {
	  println("\nWould you like to (h)it or (s)tand?")
		try {
		  action = readChar()
		} catch {
			  case x: IndexOutOfBoundsException =>
			    println("Invalid input.\n")
			    action = ' '
			  case x: RuntimeException => println(x.getMessage())
        System.exit(1)
		}
		action match {
			case 'h' => {
				hit(player)
			}
			case 's' => {
			  println("Stand.\n")
			  doneHitting = true
			}
			case ' ' => {}
			case _ => try{
				println("Press \"h\" to hit or press \"s\" to stand.\n")
			} catch {
        case x: RuntimeException => println(x.getMessage())
        System.exit(1)
      }
		}
	}
	gameOver
}

