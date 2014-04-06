package blackjack
import Suit._

object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala worksheet");$skip(29); 
	Suit.values foreach println;$skip(34); 
  val myCard = new Card(4, Clubs);System.out.println("""myCard  : blackjack.Card = """ + $show(myCard ))}
}
