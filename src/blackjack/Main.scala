package blackjack

object Main extends App {
	println("Let's play Blackjack!\n")
	println("What's your name?\n")
	val player = new Player(readLine(), 100)
	println(player)
	var isPlaying = true
	var willContinue: Char = ' '
	//play a game
	while (isPlaying){
		println("\nWould you like to play a new game? (y or n)")
		try {
		  willContinue = readChar()
		} catch {
			  case x: IndexOutOfBoundsException =>
			    println("Be bold!  Make a decision.\n")
			    willContinue = ' '
			  case x: RuntimeException => println(x.getMessage())
        System.exit(1)
		}
		willContinue match {
			case 'y' => {
				new Game(player)
			}
			case 'n' => {
			  println("See you next time!")
			  isPlaying = false
			}
			case ' ' => {}
			case _ => try{
				println("Press \"y\" to play again or press \"n\" to quit.\n")
			} catch {
        case x: RuntimeException => println(x.getMessage())
        System.exit(1)
      }
		}
	}
}