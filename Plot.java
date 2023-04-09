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

public class Plot {

    private int x, y, width, depth;

    public Plot() //constructor
    {
        x = 0;
        y = 0;
        width = 1;
        depth = 1;
    }

    public Plot(int x, int y, int width, int depth) // constructor
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) // copy constructor
    {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getDepth() {
        return depth;
    }

    public int getWidth() {
        return width;
    }

    public boolean overlaps(Plot plot)
    {
        boolean status = false;

        //the starting point of current plot
        int bottomLeftX = this.getX();
        int bottomLeftY = this.getY();

        //second point of current plot
        int topRightX = this.getX() + this.getWidth();
        int topRightY = this.getY() + this.getWidth();

        //the starting point of other plot
        int otherBottomLeftX = plot.getX();
        int otherBottomLeftY = plot.getY();

        //second point of other plot
        int otherTopRightX = plot.getX() + plot.getWidth();
        int otherTopRightY = plot.getY() + plot.getDepth();

        //conditions to check if current plot overlaps the other plot
        boolean condition1 = bottomLeftX < otherTopRightX;
        boolean condition2 = topRightX > otherBottomLeftX;
        boolean condition3 = bottomLeftY < otherTopRightY;
        boolean condition4 = topRightY > otherBottomLeftY;


        // return true if the current plot overlaps the other plot
        if(condition1 && condition2 && condition3 && condition4) {
            status = true;
        }

        return status;
    }

    public boolean encompasses(Plot plot)
    {
        boolean status = false;

        //get the starting coordinate for other plot
        int otherX = plot.getX();
        int otherY = plot.getY();

        //get the starting coordinate for current plot
        int x = this.getX();
        int y = this.getY();

        //get the resulting points for other plot
        int otherResultX = otherX + plot.getWidth();
        int otherResultY = otherY + plot.getDepth();

        //get the resulting points for current plot
        int resultX = x + this.getWidth();
        int resultY = y + this.getDepth();

        if((otherX >= x ) && (otherY >= y) && (otherResultX <= resultX) && (otherResultY <= resultY))
        {
            status = true;
        }

        return status;
    }

    public String toString()
    {
        return x + "," + y + "," + width + "," + depth;
    }
}
