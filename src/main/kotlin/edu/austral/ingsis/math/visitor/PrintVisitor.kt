package edu.austral.ingsis.math.visitor

import edu.austral.ingsis.math.visitor.visitable.*
import edu.austral.ingsis.math.visitor.visitable.Number

class PrintVisitor  : Visitor<String> {

    override fun visit(sum: Sum): String {
        return "${sum.getFn1().accept(this)} + ${sum.getFn2().accept(this)}"
    }

    override fun visit(sub: Sub): String {
       return "${sub.getFn1().accept(this)} - ${sub.getFn2().accept(this)}"
    }

    override fun visit(mul: Mul): String {
        return "${mul.getFn1().accept(this)} * ${mul.getFn2().accept(this)}"
    }

    override fun visit(div: Div): String {
        return "${div.getFn1().accept(this)} / ${div.getFn2().accept(this)}"
    }

    override fun visit(pow: Pow): String {
        return "${pow.getBase().accept(this)} ^ ${pow.getExponent().accept(this)}"
    }

    override fun visit(sqrt: Sqrt): String {
        return "sqrt(${sqrt.getValue().accept(this)})"
    }

    override fun visit(mod: Module): String {
        return "|${mod.getValue().accept(this)}|"
    }

    override fun visit(number: Number): String {
        return "${number.getValue().toInt()}"
    }

    override fun visit(variable: Variable): String {
        return variable.getVariable()
    }


}