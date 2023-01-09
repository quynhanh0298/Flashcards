fun makeMyWishList(wishList: Map<String, Int>, limit: Int): MutableMap<String, Int> {
    // write here
    var wishListMap = mutableMapOf<String, Int>()
    for (item in wishList){
        if (item.value <= limit) wishListMap[item.key] = item.value
    }
    return wishListMap
}