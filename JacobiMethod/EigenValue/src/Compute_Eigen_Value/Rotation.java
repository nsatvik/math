package Compute_Eigen_Value;

public class Rotation {
	double[][] rotate(double a[][],double s[][],int m,int n)
	{
		double[][] st = new double[m][n];
		double[][] b = new double[m][n];
		double[][] b1 = new double[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				st[j][i] = s[i][j];
		}
		double sum=0.0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<m;j++)
			{
				for(int k=0;k<m;k++)
				{
					sum = sum+st[i][k]*a[k][j];
				}
				b[i][j] = sum;
				sum = 0;
			}
		}
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<m;j++)
			{
				for(int k=0;k<m;k++)
				{
					sum = sum+b[i][k]*s[k][j];
				}
				b1[i][j] = sum;
				sum = 0;
			}
		}
		
		return b1;
	}

}
