/**
 * 
 * @author Joseph Pickering
 * BMI Calculator
 * Exercise: http://programmingbydoing.com/a/bmi-calculator.html
 *
 */

import java.util.Scanner;

public class BMICalculator
{
	// Creating global variables
  	public static String name;
  	public static double weight;
  	public static double height;
  	public static double bmi;
  	
    public String format()
    {
    	// Returning the necessary values
        return String.format( "Name:\t%s", name + "\nWeight:\t" + weight + "kg" + "\nHeight:\t" + height + "m" +
        																			"\nBMI Status:\t" + bmiStatus() );
    }
    
    public void display()
    {
    	// Printing out the format method
        System.out.println( format() );
    }
    
    // Setting the name and then returning it
    public void setName( String n )
    {
    	name = n;
    }
    public String getName()
    {
    	return name;
    }
    
    // Setting the weight and then returning it
    public void setWeight( double w )
    {
    	weight = w;
    }
    public double getWeight()
    {
    	return weight;
    }
    
    // Setting the height and then returning it
    public void setHeight( double h )
    {
    	height = h;
    }
    public double getHeight()
    {
    	return height;
    }
    
    // Converting the Stone and Inches into Kilograms and Metres
    public void addImperial() 
    {
    	setWeight( weight * 6.35029 );
    	setHeight( height * 0.024 );
    }
    
    // Calculating the BMI
    public double bmiCalculator()
    {
    	double bmi = Math.round(( getWeight() / getHeight() ) / getHeight());
    	return bmi;
    }
    
    // Calculating the BMI Status of the person
    public String bmiStatus() 
	{
	  	String bmiCategory = " ";
	  	
	  	if( bmi <= 19.5 )
	  	{
	  		bmiCategory = "Underweight";
	  	}
	  	if( 19.5 >bmi && bmi<= 24.9 )
	  	{
	  		bmiCategory = "Ideal";
	  	}
	  	if( 24.9 >bmi && bmi<= 29.9 )
	  	{
	  		bmiCategory = "Overweight";
	  	}
	  	if( bmi >= 30 )
	  	{
	  		bmiCategory = "Obese";
	  	}
	  	
		return bmiCategory;
	}


	public static void main(String[] args)
	{
		BMICalculator b = new BMICalculator();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Your name:");
		String name = scan.nextLine();
		b.setName( name );
		
		System.out.println("Your weight in stone:");
		int weight = scan.nextInt();
		b.setWeight( weight );	// Stone
		
		System.out.println("Your height in inches:");
		int height = scan.nextInt();
		b.setHeight( height );	// Inches
		b.addImperial();
	    
		if( b.getWeight() <= 0 || b.getHeight() <= 0 )
		{
			System.out.println( "Invalid weight or height value!" );
		}
		else
		{
	        b.display();
		}
	}
}


