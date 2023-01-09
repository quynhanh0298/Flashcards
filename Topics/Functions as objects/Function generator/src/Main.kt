// TODO: provide three functions here
fun identity(a: Int): Int = a
fun half(a: Int): Int = a/2
fun zero(a: Int): Int = 0

fun generate(functionName: String): (Int) -> Int {
    // TODO: provide implementation here
    return when(functionName){
        "identity" -> ::identity
        "half" -> ::half
        else -> ::zero
    }

}