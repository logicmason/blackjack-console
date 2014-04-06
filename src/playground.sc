package blackjack
import Suit._

object playground {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	Suit.values foreach println               //> Hearts
                                                  //| Spades
                                                  //| Diamonds
                                                  //| Clubs
  val myCard = new Card(new Rank("Four", 4), Clubs)
                                                  //> myCard  : blackjack.Card = Four of Clubs
  
  val myRank = new Rank("ace", 11)                //> myRank  : blackjack.Rank = ace
  
  val points = List(1,2,3,4,5,6,7,8,9,10,10,10)   //> points  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10)
  val names = List("Ace","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King")
                                                  //> names  : List[String] = List(Ace, Two, Three, Four, Five, Six, Seven, Eight,
                                                  //|  Nine, Ten, Jack, Queen, King)
	val r = (names, points).zipped.map { (n, p) =>
		new Rank(n, p)
	}                                         //> r  : List[blackjack.Rank] = List(Ace, Two, Three, Four, Five, Six, Seven, Ei
                                                  //| ght, Nine, Ten, Jack, Queen)
  var deck = for (rank <- r; s <- Suit.values) yield new Card(rank, s)
                                                  //> deck  : List[blackjack.Card] = List(Ace of Hearts, Ace of Spades, Ace of Dia
                                                  //| monds, Ace of Clubs, Two of Hearts, Two of Spades, Two of Diamonds, Two of C
                                                  //| lubs, Three of Hearts, Three of Spades, Three of Diamonds, Three of Clubs, F
                                                  //| our of Hearts, Four of Spades, Four of Diamonds, Four of Clubs, Five of Hear
                                                  //| ts, Five of Spades, Five of Diamonds, Five of Clubs, Six of Hearts, Six of S
                                                  //| pades, Six of Diamonds, Six of Clubs, Seven of Hearts, Seven of Spades, Seve
                                                  //| n of Diamonds, Seven of Clubs, Eight of Hearts, Eight of Spades, Eight of Di
                                                  //| amonds, Eight of Clubs, Nine of Hearts, Nine of Spades, Nine of Diamonds, Ni
                                                  //| ne of Clubs, Ten of Hearts, Ten of Spades, Ten of Diamonds, Ten of Clubs, Ja
                                                  //| ck of Hearts, Jack of Spades, Jack of Diamonds, Jack of Clubs, Queen of Hear
                                                  //| ts, Queen of Spades, Queen of Diamonds, Queen of Clubs)
  deck.foreach { c => println(c) }                //> Ace of Hearts
                                                  //| Ace of Spades
                                                  //| Ace of Diamonds
                                                  //| Ace of Clubs
                                                  //| Two of Hearts
                                                  //| Two of Spades
                                                  //| Two of Diamonds
                                                  //| Two of Clubs
                                                  //| Three of Hearts
                                                  //| Three of Spades
                                                  //| Three of Diamonds
                                                  //| Three of Clubs
                                                  //| Four of Hearts
                                                  //| Four of Spades
                                                  //| Four of Diamonds
                                                  //| Four of Clubs
                                                  //| Five of Hearts
                                                  //| Five of Spades
                                                  //| Five of Diamonds
                                                  //| Five of Clubs
                                                  //| Six of Hearts
                                                  //| Six of Spades
                                                  //| Six of Diamonds
                                                  //| Six of Clubs
                                                  //| Seven of Hearts
                                                  //| Seven of Spades
                                                  //| Seven of Diamonds
                                                  //| Seven of Clubs
                                                  //| Eight of Hearts
                                                  //| Eight of Spades
                                                  //| Eight of Diamonds
                                                  //| Eight of Clubs
                                                  //| Nine of Hearts
                                                  //| Nine of Spades
                                                  //| Nine of Diamonds
                                                  //| Nine of Clubs
                                                  //| Ten of Hearts
                                                  //| Ten of Spades
                                                  //| Ten of Diamonds
                                                  //| Ten of Clubs
                                                  //| Jack of Hearts
                                                  //| Jack of Spades
                                                  //| Jack of Diamonds
                                                  //| Jack of Clubs
                                                  //| Queen of Hearts
                                                  //| Queen of Spades
                                                  //| Queen of Diamonds
                                                  //| Queen of Clubs
}