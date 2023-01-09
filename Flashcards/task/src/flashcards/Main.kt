package flashcards

import java.io.File
import kotlin.random.Random

//cards: collection of flashcards declare as map of pair with key is term (String)
// and value is definition (String)
val cards = mutableMapOf<String, String>()

val mistakes = mutableMapOf<String, Int>()

var logs = ""

fun main(args : Array<String>) {

    if (args.contains("-import")){
        val index = args.indexOf("-import")
        val fileName = args[index + 1]
        import(fileName)
    }
    chooseAction()
    if (args.contains("-export")){
        val index = args.indexOf("-export")
        val fileName = args[index + 1]
        export(fileName)
    }
}


//Choose actions:
fun chooseAction() {
    println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
    val action = readLine()
    if (action !in listOf("add", "remove", "import", "export", "ask", "exit", "log", "hardest card", "reset stats")) {
        println("Wrong input!")
        chooseAction()
    }
    when (action) {
        "add" -> {
            add()
            chooseAction()
        }

        "remove" -> {
            remove()
            chooseAction()
        }

        "import" -> {
            println("File name:")
            val fileName = readLine()
            import(fileName)
            chooseAction()
        }

        "export" -> {
            println("File name:")
            val fileName = readLine()
            export(fileName)
            chooseAction()
        }

        "ask" -> {
            ask()
            chooseAction()
        }

        "exit" -> {
            println("Bye bye!")
            return
        }

        "log" -> {
            log()
            chooseAction()
        }

        "hardest card" -> {
            hardestCard()
            chooseAction()
        }

        "reset stats" -> {
            resetStats()
            chooseAction()
        }

    }
}

//Add new flashcard:
fun add() {
    println("The card:")
    val term = readLine()
    if (cards.containsKey(term)) {
        println("The card \"$term\" already exists.")
        return
    }
    println("The definition of the card:")
    val definition = readLine()
    if (cards.containsValue(definition)) {
        println("The definition \"$definition\" already exists.")
        return
    }
    println("The pair (\"$term\":\"$definition\") has been added.")
    cards[term] = definition
}

//Remove card:
fun remove() {
    println("Which card?")
    val term = readLine()
    if (mistakes.containsKey(term)) mistakes.remove(term)
    if (cards.containsKey(term)) {
        cards.remove(term)
        println("The card has been removed.")
    } else {
        println("Can't remove \"$term\": there is no such card.")
    }
}

//Import:
fun import(fileName: String) {
    val file = File(fileName)
    if (!file.exists()) println("File not found")
    else {
        val lines = file.readLines()

        for (i in 1..lines[0].toInt()) {
            val line = lines[i].split(" ")
            cards[line[0]] = line[1]
        }

        for (i in lines[0].toInt() + 2 until lines.size) {
            val line = lines[i].split(" ")
            mistakes[line[0]] = line[1].toInt()
        }

        println("${lines[0]} cards have been loaded.")
    }
}

//Export:
fun export(fileName: String) {
    val file = File(fileName)
    file.writeText(cards.size.toString())
    for (card in cards) file.appendText("\n${card.key} ${card.value}")
    file.appendText("\n${mistakes.size}")
    for (mistake in mistakes) file.appendText("\n${mistake.key} ${mistake.value}")
    println("${cards.size} cards have been saved.")
}

//Ask:
fun ask() {
    println("How many times to ask?")
    val times = readLine().toInt()
    val listOfQuestions = mutableListOf<Int>()
    while (listOfQuestions.size < times) {
        val num = Random.nextInt(cards.size)
        if (num !in listOfQuestions) listOfQuestions.add(num)
    }

    //Convert cards from map to list to take the element of map with a random index
    val cardsList = cards.toList()

    for (i in listOfQuestions) //Take random pair of term-definition
    {
        val pair = cardsList[i]

        // pair: pair<String, String> of <term, definition>
        // pair.first -> term; pair.second -> definition

        println("Print the definition of \"${pair.first}\"")
        val answer = readLine()
        if (answer == pair.second) println("Correct!")
        else {
            if (mistakes.containsKey(pair.first)) mistakes[pair.first] = mistakes[pair.first]!! + 1
            else mistakes[pair.first] = 1
            if (!cards.containsValue(answer)) println("Wrong. The right answer is \"${pair.second}\".")
            else {
                for (item in cards) {
                    if (item.value == answer)
                        println("Wrong. The right answer is \"${pair.second}\", but your definition is correct for \"${item.key}\"")
                }
            }
        }
    }
}

//Log:
fun log() {
    println("File name:")
    val fileName = readLine()
    val file = File(fileName)
    file.writeText(logs)
    println("The log has been saved.")
}

// rewrite println():
fun println(input: String = "") {
    kotlin.io.println(input)
    logs += "$input\n"
}

// rewrite readLine():
fun readLine(): String {
    val value = kotlin.io.readLine()!!
    logs += "$value\n"
    return value
}

// Hardest cards:
fun hardestCard() {
    if (mistakes.isEmpty()) println("There are no cards with errors.")
    else {
        val list = mutableListOf<Int>()
        for (mistake in mistakes) {
            list.add(mistake.value)
        }
        val max = list.maxOrNull()
        val hardestList = mutableListOf<String>()

        for (mistake in mistakes) {
            if (mistake.value == max) hardestList.add(0, "\"${mistake.key}\"")
        }

        val terms = hardestList.joinToString(", ")
        if (hardestList.size == 1) println("The hardest card is \"$terms\". You have $max errors answering it")
        else println("The hardest cards are $terms. You have $max errors answering them")
    }
}

// reset stats:
fun resetStats() {
    mistakes.clear()
    println("Card statistics have been reset.")
}