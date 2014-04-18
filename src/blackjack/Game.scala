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

	def score(hand: List[Card]): Int = {
	  val hi = tallyHigh(hand)
	  if (isBust(hand)) 0
	  else if (hi <= limit) hi
	  else deductTenUntilValid(hi)
	}

	def deductTenUntilValid(n: Int): Int = {
	  if (n <= limit) n
	  else deductTenUntilValid(n-10)
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
	  if (isBust(p.hand)) {
	    println("BUST!!!")
	    gameOver
	  }
	}

	def dealerHit() {
	  dealerDraw()
	  println(s"Dealer draws a card.  It's the ${dealerHand.head}")
	}

	def lose(p: Player) {
	  println("You lose.")
	  p.loses
	}

	def win(p: Player) {
	  println("You win!")
	  p.wins
	}

	def tie(p: Player) {
	  println("It's a draw.")
	  p.ties
	}

	def gameOver {
	  println
	  determineWinner
	  player.hand = null
	  dealerHand = null
	  println("GAME OVER")
	}

	def determineWinner {
	  val playerScore = score(player.hand)
	  val dealerScore = score(dealerHand)
	  println(s"\nDealer - Score: ${dealerScore}  (${dealerHand.mkString(", ")})")
	  println(s"${player.name} - Score: ${playerScore}  (${player.hand.mkString(", ")})")
	  if (playerScore > dealerScore) win(player)
	  else if (playerScore < dealerScore) lose(player)
	  else tie(player)
	}

	def getBet(player: Player) {
	  println("How much would you like to bet?")
	  val i = try {
       Console.readInt
     } catch {
       case e: NumberFormatException =>
         0
     }
     if (i < minimumBet) {
       println(s"Sorry, the minimum bet at this table is ${minimumBet}")
       if (minimumBet > player.chips) {
         println("... and that's more than you have.  K thx bye!")
         System.exit(1)
         return
       }
       else return getBet(player)
     }

     if (player.bet(i)) {
       println(player)
       return
     } else {
       println("You can't afford that much")
     }
     return getBet(player)
	}

	def gameLoop() {
	  // game sequence
		getBet(player)

		dealerDraw()
		println(s"Dealer draws a card.  It's the ${dealerHand.head}")
		dealerDraw()
		println(s"Dealer draws a second card and places it face-down\n")

		dealTo(player)
		println(s"You are dealt the ${player.hand.head}")

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
		if (!isGameOver) {
		  while (tallyLow(dealerHand) < 17) dealerHit

		  display(dealerHand)
			if (isBust(dealerHand)) println("Dealer Bust!\n")
			else println("Dealer Stands.")

			gameOver
		}
	}
}

