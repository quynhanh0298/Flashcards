// write the IceCreamOrder class here
class IceCreamOrder{
    var price: Int = 0
    constructor(popsicles: Int){
        price = 7 * popsicles
    }
    constructor(scoops: Int, toppings: Int){
        price = 5 * scoops + 2 * toppings
    }
}