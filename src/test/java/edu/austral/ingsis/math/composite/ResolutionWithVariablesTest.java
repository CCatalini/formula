package edu.austral.ingsis.math.composite;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.austral.ingsis.math.composite.*;
import edu.austral.ingsis.math.composite.Number;
import org.junit.Test;

import java.awt.event.MouseListener;
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
        Function sum = new Sum(new Number(1), new Variable("x"));
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3.0);
        final Double result = sum.evaluate(map);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Function div = new Div(new Number(12), new Variable("div"));
        Map<String, Double> map = new HashMap<>();
        map.put("div", 4.0);
        final Double result = div.evaluate(map);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Function div = new Div(new Number(9), new Variable("x"));
        Function mul = new Mul(div, new Variable("y"));
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3.0);
        map.put("y", 4.0);
        final Double result = mul.evaluate(map);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Function div = new Div(new Number(27), new Variable("a"));
        Function pow = new Pow(div, new Variable("b"));
        Map<String, Double> map = new HashMap<>();
        map.put("a", 9.0);
        map.put("b", 3.0);
        final Double result = pow.evaluate(map);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Function sqrt = new Sqrt(new Variable("z"));
        Map<String, Double> map = new HashMap<>();
        map.put("z", 36.0);
        final Double result = sqrt.evaluate(map);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Function mod = new Module(new Variable("value"));
        Function sub = new Sub(mod, new Number(8));
        Map<String, Double> map = new HashMap<>();
        map.put("value", 8.0);
        final Double result = sub.evaluate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Function mod = new Module(new Variable("value"));
        Function sub = new Sub(mod, new Number(8));
        Map<String, Double> map = new HashMap<>();
        map.put("value", 8.0);
        final Double result = sub.evaluate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Function sub = new Sub(new Number(5), new Variable("i"));
        Function mul = new Mul(sub, new Number(8));
        Map<String, Double> map = new HashMap<>();
        map.put("i", 2.0);
        final Double result = mul.evaluate(map);

        assertThat(result, equalTo(24d));
    }
}