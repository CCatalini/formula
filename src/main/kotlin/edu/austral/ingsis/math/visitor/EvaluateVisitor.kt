package edu.austral.ingsis.math.visitor


import edu.austral.ingsis.math.visitor.visitable.*
import edu.austral.ingsis.math.visitor.visitable.Number
import kotlin.math.abs
import kotlin.math.pow

class EvaluateVisitor(private val map: Map<String, Double>) : Visitor<Double> {

    constructor() : this(mapOf())

    override fun visit(sum: Sum): Double {
        return sum.getFn1().accept(this) + sum.getFn2().accept(this)
    }

    override fun visit(sub: Sub): Double {
        return sub.getFn1().accept(this) - sub.getFn2().accept(this)
    }

    override fun visit(mul: Mul): Double {
        return mul.getFn1().accept(this) * mul.getFn2().accept(this)
    }

    override fun visit(div: Div): Double {
        return div.getFn1().accept(this) / div.getFn2().accept(this)
    }

    override fun visit(pow: Pow): Double {
        return pow.getBase().accept(this).pow(pow.getExponent().accept(this))
    }

    override fun visit(sqrt: Sqrt): Double {
       return sqrt.getValue().accept(this).pow(0.5)
    }

    override fun visit(mod: Module): Double {
        return abs(mod.getValue().accept(this))
    }

    override fun visit(number: Number): Double {
       return number.getValue()
    }

    override fun visit(variable: Variable): Double {
        return if (map.containsKey(variable.getVariable())){
            map[variable.getVariable()]!!
        }else 0.0
    }

}
