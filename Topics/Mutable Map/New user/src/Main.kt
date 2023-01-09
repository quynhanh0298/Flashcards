fun addUser(userMap: Map<String, String>, login: String, password: String): MutableMap<String, String> {
    // write your code here
    var userList = emptyMap<String,String>()
    if (userMap.containsKey(login)) {
        userList = userMap
        println("User with this login is already registered!")
    }
    else {
        userList = userMap + Pair(login, password)
    }
    return userList.toMutableMap()
}