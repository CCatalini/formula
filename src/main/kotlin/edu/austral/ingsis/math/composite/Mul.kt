package edu.austral.ingsis.math.composite

class Mul(private val function1: Function, private val function2: Function) : Function {

    override fun evaluate(map: Map<String, Double>): Double {
        return function1.evaluate(map) * function2.evaluate(map)
    }

    override fun print(): String {
        return if (function1::class.simpleName == "Operand"){
            function1.print() + " * " + function2.print()
        }else "(" + function1.print() + ")" + " * " + function2.print()
    }

    override fun listVariables(): List<String> {
        return (function1.listVariables().asSequence() + function2.listVariables().asSequence()).toList()
    }

}