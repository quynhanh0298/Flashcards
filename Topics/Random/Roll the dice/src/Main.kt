import kotlin.random.Random

fun throwD6(): Int {
    // write your code here
	var numberOnTheDice = Random.nextInt(1,7)
	return numberOnTheDice
}