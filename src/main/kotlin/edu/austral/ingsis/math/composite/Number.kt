package edu.austral.ingsis.math.composite

class Number(private val value : Double) : Function {

    override fun evaluate(map: Map<String, Double>): Double {
        return value
    }

    override fun print(): String {
        return if (value % 1.0 == 0.0){
            value.toInt().toString()
        }else value.toString()
    }

    override fun listVariables(): List<String> {
        return listOf()
    }
}