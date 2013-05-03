package org.ck.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.ck.interpolation.HermiteInterpolation;
import org.ck.interpolation.LagrangeInterpolation;

public class MainClass {
	
	public static void main(String [] args)
	{
		ArrayList<Double> x_values = new ArrayList<Double>();
		ArrayList<Double> f_x_values = new ArrayList<Double>();
		ArrayList<Double> f_dash_x_values = new ArrayList<Double>();
		readerFunc("Enter the values of x", x_values);
		readerFunc("Enter the values of f(x)", f_x_values);
		readerFunc("Enter the values of f'(x)", f_dash_x_values);
		double []x = new double[x_values.size()];
		double []f_x = new double[f_x_values.size()];
		double []f_dash_x = new double[f_dash_x_values.size()];
		for(int i=0;i<x.length;i++)
		{
			x[i] = x_values.get(i);
			f_x[i] = f_x_values.get(i);
			f_dash_x[i] = f_dash_x_values.get(i);
			
		}
		
		HermiteInterpolation hip = new HermiteInterpolation(x,f_x, f_dash_x);
		LagrangeInterpolation lip = new LagrangeInterpolation(x,f_x, f_dash_x);
		double xval = 0;
		System.out.println("Enter the value of x : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			xval = Double.parseDouble(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
		}
		//hip.dump();
		System.out.println("Hermite Interpolation Estimated Value = "+hip.find(xval));
		System.out.println("Lagrange Interpolation Estimated Value = "+lip.find(xval));
	}	
	
	public static void readerFunc(String text, ArrayList<Double> dataHolder)
	{
		System.out.println(text);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while((line= br.readLine())!=null)
			{
				dataHolder.add(Double.parseDouble(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(NumberFormatException nfe)
		{
			System.out.println("Data Accepted "+dataHolder);
		}
	}

}
