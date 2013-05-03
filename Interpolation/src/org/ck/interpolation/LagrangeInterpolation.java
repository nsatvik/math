package org.ck.interpolation;

public class LagrangeInterpolation {
	private double [] x_values;
	private double []f_x_values;
	private double []f_dash_x_values;
	
	public LagrangeInterpolation(double []x_values,double []f_x_values, double[] f_dash_x_values)
	{
		this.x_values = x_values;
		this.f_dash_x_values = f_dash_x_values;
		this.f_x_values = f_x_values;
	}
	
	/*
	 * Given a value of x find the output of the interpolation method/function.
	 */
	public double find(double x)
	{
		double result = 0;
		for(int i=0;i<this.x_values.length;i++)
		{			
			result += computeCoefficient(x,i)*this.f_x_values[i];
		}
		return result;
		
	}

	private double computeCoefficient(double x, int index) {
		double numerator = 1;
		double denominator = 1;
		
		for(int i=0;i<this.x_values.length;++i)
		{
			if(i==index)
				continue;
			numerator *= (x-this.x_values[i]);
			denominator *= (this.x_values[index]-this.x_values[i]);
			
		}
		return numerator/denominator;
	}	
}
