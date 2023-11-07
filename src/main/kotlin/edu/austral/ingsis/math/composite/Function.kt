package edu.austral.ingsis.math.composite

interface Function {

    fun evaluate(map: Map<String, Double>) : Double

    fun evaluate() : Double{
        return evaluate(mapOf())
    }

    // para printear la operacion --> "2+3"
    fun print() : String


    fun listVariables(): List<String>
}