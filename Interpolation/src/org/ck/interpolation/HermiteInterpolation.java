package org.ck.interpolation;

public class HermiteInterpolation {
	private double [] x_values;
	private double []f_x_values;
	private double []f_dash_x_values;
	private AlgebraicExpression []L_values;
	private AlgebraicExpression []L_dash_values;
	
	
	public HermiteInterpolation(double []x_values,double []f_x_values, double[] f_dash_x_values)
	{
		this.x_values = x_values;
		this.f_dash_x_values = f_dash_x_values;
		this.f_x_values = f_x_values;
		this.L_values = new AlgebraicExpression[f_x_values.length];
		this.L_dash_values = new AlgebraicExpression[f_x_values.length];
		computeLValues();
		
	}


	private void computeLValues() {
		for(int i=0;i<f_x_values.length;i++)
		{
			L_values[i] = computeLValue(i);
			L_dash_values[i] = L_values[i].differenciate();
		}
		
	}


	private AlgebraicExpression computeLValue(int index) {
		AlgebraicExpression result = new AlgebraicExpression(new double[]{1});
		float denominator = 1;
		for(int i=0;i<x_values.length;++i)
		{
			if(i==index)
				continue;
			result = result.multiply(new AlgebraicExpression(new double[]{-this.x_values[i],1}));
			denominator *= (this.x_values[index]-this.x_values[i]);
		}
		System.out.println("Denominator for index "+index+"is "+denominator);
		result.divide(denominator);
		return result;
	}
	/*
	 * Given a value of x find the output of the interpolation method/function.
	 */
	public double find(double x)
	{
		
		double result = 0;
		for(int i=0;i<this.x_values.length;i++)
		{
			double temp = L_values[i].compute(x);
			temp *= temp;
			double diff = (double)(x-this.x_values[i]);
			double a = (double)(1-2*diff*L_dash_values[i].compute(this.x_values[i]))*temp;
			
			double b = (double)diff*temp;
			System.out.println("a = "+a+"   b = " + b);
			result += (a*this.f_x_values[i] + b*this.f_dash_x_values[i]);
		}
		return result;
		
	}


	public void dump() {
		System.out.println("L Values ");
		for(int i=0;i<this.L_values.length;++i)
			System.out.println(this.L_values[i].toString()+" "+this.L_values[i].compute(this.x_values[i]));
		System.out.println("L' Values");
		for(int i=0;i<this.L_values.length;++i)
			System.out.println(this.L_dash_values[i].toString()+" "+this.L_dash_values[i].compute(this.x_values[i]));
		
	}
}
