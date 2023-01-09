import kotlin.random.Random

fun generateTemperature(seed: Int): String{
    // write your code here
    var randomNumberList = mutableListOf<Int>()
    val randomGenerator = Random(seed)
    repeat(7){
        randomNumberList.add(randomGenerator.nextInt(20,31))
    }
    return randomNumberList.joinToString(" ")
}