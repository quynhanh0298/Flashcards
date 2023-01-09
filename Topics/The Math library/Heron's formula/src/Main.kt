import kotlin.math.*

fun main() {
    // put your code here
    val a = readln().toDouble()
    val b = readln().toDouble()
    val c = readln().toDouble()
    val s = (a + b + c) / 2
    println(sqrt(s * (s - a) * (s - b) * (s - c)))
}