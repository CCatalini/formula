package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.*;
import edu.austral.ingsis.math.composite.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";

        Function fun = new Sum(new Number(1), new Number(6));
        final String result = fun.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";

        Function fun = new Div(new Number(12), new Number(2));
        final String result = fun.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";

        Function fun = new Mul( new Div( new Number(9), new Number(2)), new Number(3));
        final String result = fun.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";

        Function fun = new Pow( new Div( new Number(27), new Number(6)), new Number(2));
        final String result = fun.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";

        Function fun = new Sub( new Module(new Variable("value") ) , new Number(8));
        final String result = fun.print();

        assertThat(result, equalTo(expected));
    }



    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";

        final String result = expected;

        assertThat(result, equalTo(expected));
    }
}
