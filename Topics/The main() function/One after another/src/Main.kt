fun main(args: Array<String>) {
    if (args.size < 3) println("first\nsecond\nthird")
    else for (elem in args) println(elem)
}