package com.propertymanagement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.*;

public class ManagementCompanyTestStudent {

    ManagementCompany example = new ManagementCompany();
    @Before
    public void setUp() {

        example = new ManagementCompany("Law LLC", "123", 10);

        Property propExample = new Property("Property1", "Gaithersburg", 200, "Lionel Messi", 1,1,1,1);
        Property propExample2 = new Property( "Property2", "Rockville", 400, "Cristiano Ronaldo", 5,5,3,3);
        Property propExample3 = new Property("Property3", "Bethesda", 900, "Paulo Dybala", 9,9,1,1);

        example.addProperty(propExample);
        example.addProperty(propExample2);
        example.addProperty(propExample3);

    }

    @After
    public void tearDown() {
        example = null;
    }

    @Test
    public void  addProperty() {
        assertEquals(3, example.addProperty("Property4", "Baltimore", 700, "Arjen Robben"), .001);
        assertEquals(4, example.addProperty("Property5", "Germantown", 1000, "NeYo", 8,8,1,1), .001);
        assertEquals(-1, example.addProperty("Fail","Fail", 50, "failus", 3,3, 1,1), .001);
    }

    @Test
    public void getMgmFeePer() {

        assertEquals(10, example.getMgmFeePer(), .0001);
    }


    @Test
    public void getName() {

        assertEquals("Law LLC", example.getName());
    }

    @Test
    public void getPlot() {

        ManagementCompany pseudo = new ManagementCompany("Law LLC", "123", 10);
        Plot plot = new Plot(0,0,10,10);
        Plot plot1 = example.getPlot();

        //test field by field to compare Plot objects
        assertEquals(plot.getX(), plot1.getX());
        assertEquals(plot.getY(), plot1.getY());
        assertEquals(plot.getWidth(), plot1.getWidth());
        assertEquals(plot.getDepth(), plot1.getDepth());

    }

    @Test
    public void getTaxID() {

        assertEquals("123", example.getTaxID());
    }

    @Test
    public void getPropertiesCount() {


        assertEquals(3, example.getPropertiesCount());

        example.addProperty("Lae", "Montgomery", 400, "Lia");

        assertEquals(4, example.getPropertiesCount());
    }

    @Test
    public void getProperties() {

        //create properties like example object  and add it to the properties array
        Property propExample = new Property("Property1", "Gaithersburg", 200, "Lionel Messi", 1,1,1,1);
        Property propExample2 = new Property( "Property2", "Rockville", 400, "Cristiano Ronaldo", 5,5,3,3);
        Property propExample3 = new Property("Property3", "Bethesda", 900, "Paulo Dybala", 9,9,1,1);
        Property [] propertiesExample = new Property[5];
        propertiesExample[0] = propExample;
        propertiesExample[1] = propExample2;
        propertiesExample[2] = propExample3;

        Property [] example1 = example.getProperties();

        assertThat(propertiesExample).usingRecursiveComparison().isEqualTo(example1);
    }

    @Test
    public void getTotalRent() {

        assertEquals(1500, example.getTotalRent(), .0001);
    }

    @Test
    public void getHighestRentPropperty() {

        Property property = new Property("Property3", "Bethesda", 900, "Paulo Dybala", 9,9,1,1);
        assertThat(example.getHighestRentPropperty()).usingRecursiveComparison().isEqualTo(property);
    }

    @Test
    public void isManagementFeeValid() {
        assertEquals(true, example.isManagementFeeValid());

    }

    @Test
    public void isPropertiesFull() {

        assertEquals(false, example.isPropertiesFull());

        //make the example array full
        example.addProperty("Property4", "Baltimore", 700, "Arjen Robben");
        example.addProperty("Property5", "Germantown", 1000, "NeYo", 8,8,1,1);

        assertEquals(true, example.isPropertiesFull());



    }

    @Test
    public void removeLastProperty() {

        //set up mock properties array
        Property propExample = new Property("Property1", "Gaithersburg", 200, "Lionel Messi", 1,1,1,1);
        Property propExample2 = new Property( "Property2", "Rockville", 400, "Cristiano Ronaldo", 5,5,3,3);
        Property propExample3 = new Property("Property3", "Bethesda", 900, "Paulo Dybala", 9,9,1,1);
        Property [] propertiesExample = new Property[5];
        propertiesExample[0] = propExample;
        propertiesExample[1] = propExample2;
        propertiesExample[2] = propExample3;

        //use remove last property method(it will not execute the method because the properties are not full)
        example.removeLastProperty();

        //test that the example's properties remained unchanged
        assertThat(example.getProperties()).usingRecursiveComparison().isEqualTo(propertiesExample);

        //make one more property and add to mock property array. Make the example properties full to use the method
        Property propExample4 = new Property("Property4", "Baltimore", 700, "Arjen Robben");
        example.addProperty("Property4", "Baltimore", 700, "Arjen Robben");
        example.addProperty("Property5", "Germantown", 1000, "NeYo", 8,8,1,1);

        propertiesExample[3] = propExample4;

        //use the method(it will execute since example's properties are full
        example.removeLastProperty();

        //test that the last property is removed
        assertThat(example.getProperties()).usingRecursiveComparison().isEqualTo(propertiesExample);



    }

    @Test
    public void testToString() {

        //set up mock Management Company object
        Property propExample = new Property("Property1", "Gaithersburg", 200, "Lionel Messi", 1,1,1,1);
        Property propExample2 = new Property( "Property2", "Rockville", 400, "Cristiano Ronaldo", 5,5,3,3);
        Property propExample3 = new Property("Property3", "Bethesda", 900, "Paulo Dybala", 9,9,1,1);

        ManagementCompany pseudo = new ManagementCompany("Law LLC", "123", 10);;

        pseudo.addProperty(propExample);
        pseudo.addProperty(propExample2);
        pseudo.addProperty(propExample3);

       //test that the toString() method are the same
       assertThat(example.toString()).isEqualTo(pseudo.toString());
    }
}