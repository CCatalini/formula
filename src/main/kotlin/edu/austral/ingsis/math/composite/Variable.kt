package edu.austral.ingsis.math.composite

class Variable(private val variable : String) : Function {

    override fun evaluate(map: Map<String, Double>): Double {
        return map[variable]!!
    }

    override fun print(): String {
        return variable
    }

    override fun listVariables(): List<String> {
        val names: MutableList<String> = mutableListOf()
        names.add(variable)
        return (names.asSequence()).toList()
    }


}