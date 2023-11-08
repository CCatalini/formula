package edu.austral.ingsis.math.visitor.visitable

import edu.austral.ingsis.math.visitor.Visitor

class Div (private val fn1 : Visitable, private val fn2 : Visitable) : Visitable {

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

    fun getFn1() : Visitable{
        return fn1
    }

    fun getFn2() : Visitable{
        return fn2
    }

}