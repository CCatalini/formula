package edu.austral.ingsis.math.visitor

import com.sun.org.apache.xpath.internal.operations.Mod
import edu.austral.ingsis.math.visitor.visitable.*
import edu.austral.ingsis.math.visitor.visitable.Number
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test

class ListVariablesTest {
    private val visitor = ListVariablesVisitor()

    /**
     * Case 1 + 6
     */
    @Test
    fun shouldListVariablesFunction1() {
        val result = visitor.visit(Sum(Number(1.0), Number(6.0)))
        MatcherAssert.assertThat(result, Matchers.empty())
    }

    /**
     * Case 12 / div
     */
    @Test
    fun shouldListVariablesFunction2() {
        val result = visitor.visit(Div(Number(12.0), Variable("div")))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("div"))
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    fun shouldListVariablesFunction3() {
        val div = Div(Number(9.0), Variable("x"))
        val result = visitor.visit(Mul(div, Variable("y")))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("x", "y"))
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    fun shouldListVariablesFunction4() {
        val div = Div(Number(27.0), Variable("a"))
        val result = visitor.visit(Pow(div, Variable("b")))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("a", "b"))
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    fun shouldListVariablesFunction5() {
        val result = visitor.visit(Sqrt(Variable("z")))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("z"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction6() {
        val result = visitor.visit(Sub(Module(Variable("value")), Number(8.0)))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("value"))
    }

    /**
     * Case |value| - 8
     */
    @Test
    fun shouldListVariablesFunction7() {
        val result = visitor.visit(Sub(Module(Variable("value")), Number(8.0)))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("value"))
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    fun shouldListVariablesFunction8() {
        val sub = Sub(Number(5.0), Variable("i"))
        val result = visitor.visit(Mul(sub, Number(8.0)))
        MatcherAssert.assertThat(result, Matchers.containsInAnyOrder("i"))
    }
}