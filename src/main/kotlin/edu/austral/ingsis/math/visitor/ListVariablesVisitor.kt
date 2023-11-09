package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.visitable.*
import edu.austral.ingsis.math.visitor.visitable.Number

class ListVariablesVisitor : Visitor< List<String> > {

    override fun visit(sum: Sum): List<String> {
        return (sum.getFn1().accept(this).asSequence() + sum.getFn2().accept(this).asSequence()).toList()
    }

    override fun visit(sub: Sub): List<String> {
        return (sub.getFn1().accept(this).asSequence() + sub.getFn2().accept(this).asSequence()).toList()
    }

    override fun visit(mul: Mul): List<String> {
        return (mul.getFn1().accept(this).asSequence() + mul.getFn2().accept(this).asSequence()).toList()
    }

    override fun visit(div: Div): List<String> {
        return (div.getFn1().accept(this).asSequence() + div.getFn2().accept(this).asSequence()).toList()
    }

    override fun visit(pow: Pow): List<String> {
        return (pow.getBase().accept(this).asSequence() + pow.getExponent().accept(this).asSequence()).toList()
    }

    override fun visit(sqrt: Sqrt): List<String> {
        return sqrt.getValue().accept(this)
    }

    override fun visit(mod: Module): List<String> {
        return mod.getValue().accept(this)
    }

    override fun visit(number: Number): List<String> {
        return emptyList()
    }

    override fun visit(variable: Variable): List<String> {
        return listOf(variable.getVariable())
    }
}