import kotlin.math.pow
import kotlin.math.sqrt

fun perimeter(
    x1: Double,
    y1: Double,
    x2: Double,
    y2: Double,
    x3: Double,
    y3: Double,
    x4: Double = x3,
    y4: Double = y3
): Double {
    val s1 = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    val s2 = sqrt((x3 - x2).pow(2) + (y3 - y2).pow(2))
    val s3 = sqrt((x4 - x3).pow(2) + (y4 - y3).pow(2))
    val s4 = sqrt((x1 - x4).pow(2) + (y1 - y4).pow(2))
    return s1 + s2 + s3 + s4

}