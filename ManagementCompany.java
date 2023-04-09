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

public class ManagementCompany {

   static final int MAX_PROPERTY =5; //maximum of 5 properties
   static final int MGMT_WIDTH = 10; // for plot width
    static final int MGMT_DEPTH = 10; // for plot depth

    private String name;
    private String taxID;
    private double mgmFee;
    private final Plot plot;

    private Property[] properties;
    private int numberOfProperties;

    public ManagementCompany(){

        this.name = "";
        this.taxID = "";
        this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];

    }

    public ManagementCompany(String name, String taxID, double mgmFee)
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany other)
    {
        this.name = other.name;
        this.taxID = other.taxID;
        this.mgmFee = other.mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = other.plot;
    }

    public int addProperty(Property property)
    {
        int status = -1;

        if(property == null) // if the given property is null
        {
             return -2;
        }
        else if(!this.plot.encompasses(property.getPlot())) // if this management plot encompasses the given property
        {
            return -3;
        }

        for(int i = 0; i < properties.length; i++)
        {

            if(properties[i] != null) // if the property is not null
            {
                if(property.getPlot().overlaps(properties[i].getPlot())) // if the given property's plot overlaps with other plots
                {
                    return -4;
                }
            }
            else
                break;
        }

        for(int i = 0; i < properties.length; i++)
        {
            if(properties[i] == null) // if a place in the array is null or empty, add the property
            {
                properties[i] = new Property(property);
                return i;
            }
        }

        return status;
    }

    public int addProperty(String name, String city, double rentAmount, String owner)
    {
        Property property = new Property(name, city, rentAmount, owner);
        return addProperty(property);
    }
    public int addProperty(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
    {
        Property property = new Property(name, city, rentAmount, owner, x, y, width, depth);
        return addProperty(property);
    }
    public double getMgmFeePer()
    {
        return mgmFee;
    }
    public String getName()
    {
        return name;
    }

    public Plot getPlot()
    {
        return plot;
    }

    public String getTaxID()
    {
         return taxID;
    }

    public int getPropertiesCount()
    {
        numberOfProperties = 0;

        for(int i = 0; i < properties.length; i++)
        {
            if(properties[i]!= null) //only add to count if the current index is not empty
            {
                numberOfProperties++;
            }
        }

        return numberOfProperties;
    }

    public Property[] getProperties()
    {
        return this.properties;
    }

    public double getTotalRent()
    {
        double totalRent = 0; // start at zero

        for(int i = 0; i < properties.length; i++)
        {
            if(properties[i] != null){ // if property is not null
               totalRent += properties[i].getRentAmount(); // add to totalRent
            }
            else
                break;
        }

        return totalRent;
    }

    public Property getHighestRentPropperty()
    {
        double max = 0; //set the max to zero since rentAmount cannot be 0 or less than zero
        int index = 0; //set the index to zero as a placeholder (cannot have uninitialized variable)

       for(int i = 1; i < properties.length; i++)
       {
           if(properties[i] != null)// if the current index is not empty or null
           {
               if(properties[i].getRentAmount() > max) {         // if the current property's rentAmount is higher than max
                   max = properties[i].getRentAmount(); // set the current property's rent amount to max variable
                   index = i; // set the index to the value of current index
               }
           }
       }

       return properties[index]; // returns the property from properties array based on the index
    }

    public boolean isManagementFeeValid()
    {
        if(mgmFee > 100 || mgmFee < 0) return false; // if the management fee is within 0 and 100 inclusive

        return true;
    }

    public boolean isPropertiesFull()
    {
        boolean status = true; // set the status to true;

        for(int i = 0; i < properties.length; i++)
        {
            if (properties[i] == null) { //if the current index is null or empty
                status = false; //set the status to false;
                break;
            }
        }

        return status;
    }

    public void removeLastProperty()
    {
        if(isPropertiesFull()) // if the property is full, remove(nullify) the last property
        {
            properties[(properties.length-1)] = null;
        }
    }

    public String toString()
    {
       String list = ""; // initialize the string to empty

       for(int i = 0; i < properties.length; i++)
       {
           if(properties !=null)
               list += properties[i] + "\n";


       }

       return "List of the properties for " + name + ", taxID: " + taxID + "\n" + "\n"
               + list + "\n" + "total management Fee: " + (getTotalRent() * mgmFee/100);


    }

}
