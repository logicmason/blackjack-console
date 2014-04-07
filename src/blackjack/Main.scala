package blackjack

object Main extends App {
	println("Let's play Blackjack!\n")
	println("What's your name?\n")
	val player = new Player(readLine(), 100)
	println(player)
	var isPlaying = true
	//play a game
	while (isPlaying){
		println("Would you like to play a new game? (y or n)")
		var willContinue = readChar()
		willContinue match {
			case 'y' => try{
				println("...pretend game")
			} catch {
        case x: RuntimeException => println(x.getMessage())
        System.exit(1)
      }
			case 'n' => {
			  println("See you next time!")
			  isPlaying = false
			}
			case _ => println("Press \"y\" to play again or press \"n\" to quit.")
		}
	}
}