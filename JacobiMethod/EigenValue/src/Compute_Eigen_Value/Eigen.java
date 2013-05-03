package Compute_Eigen_Value;
import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class Eigen {

	
	public static void main(String[] args) {
		
		int m,n;
		System.out.println("Enter the or3der of the matrix");
		Scanner z = new Scanner(System.in);
		m = z.nextInt();
		n = z.nextInt();
		if(m!=n)
			{
			System.out.println("Enter a symmetric matrix");
			return;
			}
		double [][] a = new double[m][n];
		double [][] s = new double[m][n];
		System.out.println("Enter the elements of the matrix");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j] = z.nextFloat();
			}
		}
		Compute_S obj1 = new Compute_S();
		Rotation obj2 = new Rotation();
		s = obj1.comps(a, m, n);
		a = obj2.rotate(a, s, m, n);
		
		
			/*for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i!=j && a[i][j]!=0)
					{
						s = obj1.comps(a, m, n);
						a = obj2.rotate(a, s, m, n);
					}
				}
			}*/
			int i=0,j=0;
			while(i<(m))
			{
				while(j<(n))
				{
					if(i!=j && a[i][j]!=0)
					{
						s = obj1.comps(a, m, n);
						a = obj2.rotate(a, s, m, n);
						j=0;
					}
					j++;
				}
				i++;
			}
		
			
			System.out.println("The Eigen Values are");
			for(i=0;i<m;i++)
			{
				System.out.println(a[i][i]);
			}
	}

}
