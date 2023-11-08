package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.Visitor

class Pow(private val base : Visitable, private val exponent : Visitable) : Visitable {

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getBase() : Visitable{
        return base
    }

    fun getExponent() : Visitable{
        return exponent
    }
}