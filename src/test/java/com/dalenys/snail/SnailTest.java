package com.dalenys.snail;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnailTest {

    private static final String tableBegin = "<html><table border=\"1\">";
    private static final String tableEnd = "</table></html>";

    private Snail snail;

    @Before
    public void setUp() {
        snail = new Snail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_when_n_is_negative_or_0() {
        snail.compute(-8);
    }

    @Test
    public void should_compute_a_correct_html_when_n_is_one() {
        assertEquals(
                tableBegin + "<tr><td>1</td></tr>" + tableEnd,
                snail.compute(1)
        );
    }

    @Test
    public void should_compute_a_correct_html_when_n_is_two() {
        assertEquals(
                tableBegin
                        + "<tr><td>1</td><td>2</td></tr>"
                        + "<tr><td>4</td><td>3</td></tr>"
                        + tableEnd,
                snail.compute(2)
        );
    }

    @Test
    public void should_compute_a_correct_html_when_n_is_three() {
        assertEquals(
                tableBegin
                        + "<tr><td>1</td><td>2</td><td>3</td></tr>"
                        + "<tr><td>8</td><td>9</td><td>4</td></tr>"
                        + "<tr><td>7</td><td>6</td><td>5</td></tr>"
                        + tableEnd,
                snail.compute(3)
        );
    }

    @Test
    public void should_compute_a_correct_html_when_n_is_four() {
        assertEquals(
                tableBegin
                        + "<tr><td>1</td><td>2</td><td>3</td><td>4</td></tr>"
                        + "<tr><td>12</td><td>13</td><td>14</td><td>5</td></tr>"
                        + "<tr><td>11</td><td>16</td><td>15</td><td>6</td></tr>"
                        + "<tr><td>10</td><td>9</td><td>8</td><td>7</td></tr>"
                        + tableEnd,
                snail.compute(4)
        );
    }

}