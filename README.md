# Scala Assignment



## Question 1
Bucketise the given array[Double] into buckets having range interval (x, x+0.049).

0.000 - 0.049 \
0.050 - 0.099.  
0.100 - 0.149. 
...........

Sample -
12.050, 12.030, 10.33, 11.45, 13.50 

### Output-
[12.050-12.099, 12.050-12.099, 10.300-10.349, 11.450-11.499, 13.500-13.549]







```scala
  def bucketize(numbers : List[Double]):ArrayBuffer[String]  = {
    val rangeofvals = Range.BigDecimal(0, 1, 0.050).toList
    val outputBucket = ArrayBuffer[String]()

    for(p <- numbers){
      //Extracting the number that is x than decimal value as dec 0.yyy then finding the
      //bucket number which is 0.yyy/(0.049) -> This will give a integer value between 1-19
      //Which is in the range of values of rangeovals list which is itself divided into 20 buckets
      val header = (p/1).toInt
      val dec = p%1
      val bucketnumber = math.ceil(dec/(0.049)).toInt

      //We are comparing it with the bucket it belongs to the
      val start : BigDecimal = if (bucketnumber != 0) header + rangeofvals(bucketnumber-1)  else header
      val startWithPrecision = start.setScale(3, BigDecimal.RoundingMode.HALF_UP)
      val end = start + 0.049
      val bucket = startWithPrecision.toString + " - " +  end.toString();

      //Append the bucket x.yyy - x.yyy + 0.049
      outputBucket.append(bucket)

    }
    return outputBucket
  }

//Example of the code is as follows

Input = 10.33 
header = 10
dec = 0.33
bucketnumber = ceil(6.73) = 7

start = bucketnumber != 0 so  -> start  =  10 + rangeofvals(6) = 10.300
end = start + 10.349
createbucket = [10.300 - 10.349]


output = [10.300 - 10.349]
```

## 2
For given players statistics..
    Found the below -
1. Player with the best highest run scored.
2. Top 5 players by run scored.
3. Top 5 players by wicket taken.
4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.

#### Sample - 
Year, PlayerName, Country, Matches, Runs, Wickets \
2021, Sam, India, 23, 2300, 3. \
2021, Ram, India, 23, 300, 30.  \
2021, Mano, India, 23, 300, 13


```scala
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




```



