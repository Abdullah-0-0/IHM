package ihm.td4.calculatriceMVC.modele
class Model(){
    var operation1 : Int = 0
    var operation2 : Int = 0

    fun addiction(): Int{
        return operation1 + operation2
    }
    fun soustration() : Int{
        return this.operation1 - operation2
    }
    fun multiplier(): Int{
        return  this.operation1 * this.operation2
    }
    fun diviser(): Double {
        return  (this.operation2 / this.operation2).toDouble()
    }
}
