package com.propertymanagement;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class PropertyTestStudent {

    private Property propExample;
    @Before
    public void setUp() {
        propExample = new Property("Law LLC" ,"Rockville", 2450.00, "Law");
    }

    @After
    public void tearDown() {
        propExample = null;
    }

    @Test
    public void getPlot() {

        Plot plot = new Plot();

        assertThat(propExample.getPlot()).usingRecursiveComparison().isEqualTo(plot);
    }

    @Test
    public void getPropertyName() {

        assertEquals("Law LLC", propExample.getPropertyName());
    }

    @Test
    public void getCity() {

        assertEquals("Rockville", propExample.getCity());
    }

    @Test
    public void getRentAmount() {
        assertEquals(2450.00, propExample.getRentAmount(), .0001);
    }

    @Test
    public void getOwner() {

        assertEquals("Law", propExample.getOwner());
    }

    @Test
    public void testToString() {

        //create mock property
        Property mock = new Property("Law LLC" ,"Rockville", 2450.00, "Law");

        assertEquals(mock.toString(), propExample.toString());
    }
}