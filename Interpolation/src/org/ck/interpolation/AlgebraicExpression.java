package org.ck.interpolation;


public class AlgebraicExpression {
	
	private double[] co_efficients;
	public AlgebraicExpression(double[] co_effs)
	{
		this.co_efficients = co_effs;
		
	}
	
	public void multiply(double constant)
	{
		for(int i=0;i<co_efficients.length;i++)
			this.co_efficients[i] *= constant;
	}
	public AlgebraicExpression add(AlgebraicExpression operand)
	{
		AlgebraicExpression result = new AlgebraicExpression(new double[Math.max(getOrder(),operand.getOrder())]);
		for(int i=0;i<operand.getOrder();++i)
		{
			result.setCoefficient(i, result.getCoefficient(i)+operand.getCoefficient(i));
		}
		for(int i=0;i<this.getOrder();++i)
		{
			result.setCoefficient(i, result.getCoefficient(i)+this.getCoefficient(i));
		}
		return result;
	}
	public AlgebraicExpression multiply(AlgebraicExpression operand)
	{
		AlgebraicExpression result = new AlgebraicExpression(new double[this.getOrder()+operand.getOrder()+1]);
		for(int i=0;i<this.co_efficients.length;i++)
		{
			for(int j=0;j<(operand.getOrder()+1);j++)
				result.setCoefficient(i+j, result.getCoefficient(i+j)+
						this.getCoefficient(i)*operand.getCoefficient(j));
		}
		return result;
	}
	public AlgebraicExpression differenciate()
	{
		if(this.getOrder()<0)
			return new AlgebraicExpression(new double[1]);
		AlgebraicExpression result = new AlgebraicExpression(new double[this.getOrder()]);
		for(int i=this.getOrder();i>0;i--)
		{
			result.setCoefficient(i-1, this.getCoefficient(i)*i);
		}
		return result;
	}
	public void divide(double constant)
	{
		for(int i=0;i<co_efficients.length;i++)
			this.co_efficients[i] /= constant;
	}
	
	public double getCoefficient(int index) throws ArrayIndexOutOfBoundsException
	{
		return co_efficients[index];
	}
	
	public void setCoefficient(int index, double value) throws ArrayIndexOutOfBoundsException
	{
		co_efficients[index]=value;
	}
	
	public int getOrder()
	{
		return this.co_efficients.length-1;
	}
	public String toString()
	{
		String output = "";
		for(int i=this.co_efficients.length-1;i>=0;i--)
			output += "("+this.co_efficients[i]+") x^"+i+"+";
		
		return output.substring(0, output.length()-1);
	}

	public double compute(double d) {
		double result = 0;
		for(int i=this.co_efficients.length-1;i>=0;i--)
		{
			result *= d;
			result += this.co_efficients[i];
		}
		return result;
	}
}
