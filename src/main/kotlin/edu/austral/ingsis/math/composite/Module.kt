package edu.austral.ingsis.math.composite

import kotlin.math.abs

class Module(private val function: Function) : Function {

    override fun evaluate(map: Map<String, Double>) : Double {
        return abs(function.evaluate(map))
    }

    override fun print(): String {
        return "|" + function.print() + "|"
    }

    override fun listVariables(): List<String> {
        return function.listVariables().toList()
    }
}