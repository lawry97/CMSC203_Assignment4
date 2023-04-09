package com.propertymanagement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlotTestStudent {

    private Plot plotExample1, plotExample2;

    @Before
    public void setUp()
    {
        plotExample1 = new Plot(5,6,3,5);
        plotExample2 = new Plot(3,4, 4,6);
    }

    @After
    public void tearDown()
    {
        plotExample1 = plotExample2 = null;
    }
    @Test
    public void setX() {

        plotExample1.setX(6);
        assertEquals(6, plotExample1.getX());

        plotExample2.setX(1);
        assertEquals(1, plotExample2.getX());



    }

    @Test
    public void setY() {

        plotExample1.setY(6);
        assertEquals(6, plotExample1.getY());

        plotExample2.setY(1);
        assertEquals(1, plotExample2.getY());

    }

    @Test
    public void setWidth() {

        plotExample1.setWidth(6);
        assertEquals(6, plotExample1.getWidth());

        plotExample2.setWidth(1);
        assertEquals(1, plotExample2.getWidth());

    }

    @Test
    public void setDepth() {

        plotExample1.setDepth(6);
        assertEquals(6, plotExample1.getDepth());

        plotExample2.setDepth(1);
        assertEquals(1, plotExample2.getDepth());

    }

    @Test
    public void getX() {

        assertEquals(5, plotExample1.getX());
        assertEquals(3, plotExample2.getX());
    }

    @Test
    public void getY() {

        assertEquals(6, plotExample1.getY());
        assertEquals(4, plotExample2.getY());
    }

    @Test
    public void getDepth() {

        assertEquals(5, plotExample1.getDepth());
        assertEquals(6, plotExample2.getDepth());
    }

    @Test
    public void getWidth() {
        assertEquals(3, plotExample1.getWidth());
        assertEquals(4, plotExample2.getWidth());
    }

    @Test
    public void overlaps() {
        assertEquals(true, plotExample2.overlaps(plotExample1));

        Plot plot = new Plot();

        assertEquals(false, plotExample2.overlaps(plot));
    }

    @Test
    public void encompasses() {

        assertEquals(false, plotExample2.encompasses(plotExample1));

        Plot plot = new Plot(4,5,2,2);

        assertEquals(true, plotExample2.encompasses(plot));
    }
}