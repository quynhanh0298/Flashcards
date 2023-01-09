import kotlin.math.*

fun main() {
    // write your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()
    println(max(max(a,b), max(c,d)))
}