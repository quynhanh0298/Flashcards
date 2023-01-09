import kotlin.math.pow

fun main() {
    // write your code here
    val name = readLine()
    val value = readLine()!!.toInt()
    fun finalAmount(amount: Int = 1000, percent: Int = 5, year: Int = 10): Int = (amount * (1 + percent.toDouble()/100).pow(year)).toInt()
    when(name){
        "amount" -> println(finalAmount(amount = value))
        "percent" -> println(finalAmount(percent = value))
        "years" -> println(finalAmount(year = value))
        else -> println("error!")
    }
}