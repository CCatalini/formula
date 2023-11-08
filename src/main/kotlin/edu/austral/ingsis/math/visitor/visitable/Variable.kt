package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.Visitor

class Variable(private val variable: String) : Visitable {

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getVariable() : String{
        return variable
    }
}