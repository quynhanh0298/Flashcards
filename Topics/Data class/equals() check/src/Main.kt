data class Client(val name: String, val age: Int){
    val balance: Int = 0
}

fun main() {
    //implement your code here
    val name1 = readln()
    val age1 = readln().toInt()
    val balance1 = readln().toInt()
    val name2 = readln()
    val age2 = readln().toInt()
    val balance2 = readln().toInt()

    val client1 = Client(name1, age1)
    val client2 = Client(name2, age2)

    println(client1 == client2)
}