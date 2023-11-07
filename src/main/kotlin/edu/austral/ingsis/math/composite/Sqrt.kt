package edu.austral.ingsis.math.composite

import kotlin.math.sqrt

class Sqrt(private val base: Function) : Function {

    override fun evaluate(map: Map<String, Double>): Double {
        if(   base.evaluate(map) < 0.0 ) throw Exception("base negativa")
        return sqrt(base.evaluate(map))
    }

    override fun print(): String {
        return "sqrt( " + base.print() + " )"
    }

    override fun listVariables(): List<String> {
        return base.listVariables()
    }
}