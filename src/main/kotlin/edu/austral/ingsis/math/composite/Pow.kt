package edu.austral.ingsis.math.composite

import kotlin.math.pow

class Pow (private val base: Function, private val exponente: Function) : Function {

    override fun evaluate(map: Map<String, Double>): Double {
        //aunque la base y el exponente sean funciones primero se evaluan y despues se hace la potencia
        return base.evaluate(map).pow(exponente.evaluate(map))
    }

    override fun print(): String {
        return if (base::class.simpleName == "Operand"){
            base.print() + " ^ " + exponente.print()
        }else "(" + base.print() + ")" + " ^ " + exponente.print()
    }

    override fun listVariables(): List<String> {
        return (base.listVariables().asSequence() + exponente.listVariables().asSequence()).toList()
    }

}
