package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.*;
import edu.austral.ingsis.math.composite.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {

        Function fun = new Sum(new Number(1), new Number(6));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {

        Function fun = new Div(new Number(12), new Number (2));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {

        Function fun = new Mul( new Div(new Number(9), new Number(2)), new Number(3));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {

        Function fun = new Pow( new Div(new Number(27), new Number(6)), new Number(2));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {

        Function fun = new Pow(new Number(36), new Div(new Number(1), new Number(2)));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {

        Function fun = new Module(new Number(136));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {

        Function fun = new Module(new Number(-136));
        final Double result = fun.evaluate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {

        Function fun = new Mul(new Sub(new Number(5) , new Number(5) ), new Number(8));
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }
}
