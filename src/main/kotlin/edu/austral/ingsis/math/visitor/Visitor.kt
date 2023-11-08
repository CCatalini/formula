package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.visitable.*
import edu.austral.ingsis.math.visitor.visitable.Number

interface Visitor<T> {

    fun visit(sum: Sum) : T
    fun visit(sub: Sub) : T
    fun visit(mul: Mul) : T
    fun visit(div: Div) : T
    fun visit(pow: Pow) : T
    fun visit(sqrt: Sqrt) : T
    fun visit(mod: Module) : T
    fun visit(number: Number) : T
    fun visit(variable: Variable) : T

}
