package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.visitable.*;
import edu.austral.ingsis.math.visitor.visitable.Number;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Sum(new Number(1), new Variable("x")));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Map<String, Double> map = new HashMap<>();
        map.put("div", 4.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Div(new Number(12), new Variable("div")));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3.0);
        map.put("y", 4.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        Div div = new Div(new Number(9), new Variable("x"));
        final Double result = visitor.visit(new Mul(div, new Variable("y")));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Map<String, Double> map = new HashMap<>();
        map.put("a", 9.0);
        map.put("b", 3.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        Div div = new Div(new Number(27), new Variable("a"));
        final Double result = visitor.visit(new Pow(div, new Variable("b")));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Map<String, Double> map = new HashMap<>();
        map.put("z", 36.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Sqrt(new Variable("z")));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Map<String, Double> map = new HashMap<>();
        map.put("value", 8.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Sub(new Module(new Variable("value")), new Number(8)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Map<String, Double> map = new HashMap<>();
        map.put("value", 8.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        final Double result = visitor.visit(new Sub(new Module(new Variable("value")), new Number(8)));
        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Map<String, Double> map = new HashMap<>();
        map.put("i", 2.0);
        Visitor<Double> visitor = new EvaluateVisitor(map);
        Sub sub = new Sub(new Number(5), new Variable("i"));
        final Double result = visitor.visit(new Mul(sub, new Number(8)));

        assertThat(result, equalTo(24d));
    }
}