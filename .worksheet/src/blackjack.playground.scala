package blackjack
import Suit._

object playground {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala worksheet");$skip(29); 
	Suit.values foreach println;$skip(52); 
  val myCard = new Card(new Rank("Four", 4), Clubs);System.out.println("""myCard  : blackjack.Card = """ + $show(myCard ));$skip(38); 
  
  val myRank = new Rank("ace", 11);System.out.println("""myRank  : blackjack.Rank = """ + $show(myRank ));$skip(51); 
  
  val points = List(1,2,3,4,5,6,7,8,9,10,10,10);System.out.println("""points  : List[Int] = """ + $show(points ));$skip(122); 
  val names = List("Ace","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King");System.out.println("""names  : List[String] = """ + $show(names ));$skip(68); 
	val r = (names, points).zipped.map { (n, p) =>
		new Rank(n, p)
	};System.out.println("""r  : List[blackjack.Rank] = """ + $show(r ));$skip(71); 
  var deck = for (rank <- r; s <- Suit.values) yield new Card(rank, s);System.out.println("""deck  : List[blackjack.Card] = """ + $show(deck ));$skip(35); 
  deck.foreach { c => println(c) }}
}
