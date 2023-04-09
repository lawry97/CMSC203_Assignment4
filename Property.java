/*Class: CMSC203CRN 30376
        Program: Assignment 4 Design
        Instructor: Grinberg, Grigoriy
        Summary of Description:
        A property management company manages individual properties they will build to rent, and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap each other, and each property must be within the limits of the management company’s plot.  Write an application that lets the user create a management company and add the properties managed by the company to its list. Assume the maximum number of properties handled by the company is 5.

        Due Date: <04/3/2023>
        Integrity Pledge: I pledge that I have completed the programming assignment independently.
        I have not copied the code from a student or any source.
        Student: Full Name : Lawrence Aryeh
*/

package com.propertymanagement;

public class Property {

    private String propertyName;
    private String city;
    private String owner;
    private double rentAmount;
    private Plot plot;

    public Property(){
        propertyName = "";
        city = "";
        rentAmount = 0;
        owner = "";
        plot = new Plot(0,0,1,1);
    }

    public Property( String propertyName, String city, double rentAmount, String owner)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot(0,0,1,1);

    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);

    }

    public Property (Property otherProperty)
    {
        this.propertyName = otherProperty.propertyName;
        this.owner = otherProperty.owner;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.plot = otherProperty.plot;
    }


    public Plot getPlot()
    {
        return plot;
    }
    public String getPropertyName()
    {
        return propertyName;
    }

    public String getCity()
    {
        return city;
    }

    public double getRentAmount()
    {
        return rentAmount;
    }

    public String getOwner()
    {
        return owner;
    }

    public String toString()
    {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }

}
