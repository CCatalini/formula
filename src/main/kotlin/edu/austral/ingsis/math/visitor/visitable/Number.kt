package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.Visitor

class Number (private val value : Double) : Visitable {

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getValue(): Double{
        return value
    }
}