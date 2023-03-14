package practice

object Ass2 {
  case class PlayerStats(PlayYear: Int, playerName: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)
  def main(args: Array[String]): Unit = {


    val players = List(
      PlayerStats(2021, "Sam", "India", 23, 2300, 3),
      PlayerStats(2021, "Ram", "India", 23, 300, 30),
      PlayerStats(2021, "Mano", "India", 23, 300, 13),
      PlayerStats(2021, "Rohit", "India", 23,264, 13),
      PlayerStats(2021, "Kohli", "India", 23, 2390, 13)
    )
    println("--------------------------------------------------------------------------------------------------------")
    println()
    //Finding the maximum score and the playerS
    val maximumScoringPlayer = players.maxBy(_.Runs)
    println(s"1) Player with the  maximum run is ${maximumScoringPlayer.playerName} with runs ${maximumScoringPlayer.Runs}")
    println("--------------------------------------------------------------------------------------------------------")

    //Finding the top five players
    //Using the while loop only
    val listofTopPlayers = players.sortBy(-_.Runs)
    var i = 0
    println("2) Top Five players with the following top score are this ->")
    while( i < 5){
      print(s"${listofTopPlayers(i).playerName} with score ${listofTopPlayers(i).Runs}, ")
      i += 1
    }
    println()
    println("----------------------------------------------------------------------------------------------------------")

    //Finding the top five players in terms of the wickets
    //Using the while loop only
    val listofTopPlayersWithWickets = players.sortBy(-_.Wickets)
    var x = 0
    println("3) Top Five players with the following top Wickets are this ->")
    while (x < 5) {
      print(s"${listofTopPlayersWithWickets(x).playerName} with number of wickets are ${listofTopPlayersWithWickets(x).Wickets}, ")
      x += 1
    }
    println()
    println("----------------------------------------------------------------------------------------------------------")

    println(s"4) The Following players are sorted on the basis of the score")
    println()
    //Sort by the following criteria as given
    val collectionNew = players.map(x => (x.playerName,(x.Wickets)*5 + x.Runs*(0.05) ))
    val sortedByPlayers = collectionNew.sortBy(_._2).reverse
    for(i <- 0 until sortedByPlayers.length){
      print(s"${sortedByPlayers(i)._1} with score ${sortedByPlayers(i)._2}")
      println()
    }

  }

}
