package Compute_Eigen_Value;

public class Compute_S {

	double[][] comps(double a[][],int m,int n)
	{
		double [][] s = new double[m][n];
		double max,k;
		int rowpos,colpos;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				s[i][j] = -10.0;
			}
		}
		if(a[0][1]<0)
			max = -a[0][1];
		else
			max = a[0][1];
		rowpos = 0;
		colpos = 1;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==j)
					break;
				if(a[i][j]<0)
				{
					k = -a[i][j];
				}
				else
					k = a[i][j];
				if(k>max)
				{
					max = k;
					rowpos = i;
					colpos = j;
				}
			}
		}
		double theta = -100.0f;
		if(rowpos>colpos)
		{
			int temp = -1;
			temp = rowpos; 
			rowpos = colpos;
			colpos  = temp;
		}
		theta = 0.5 * Math.atan((2*a[rowpos][colpos])/(a[rowpos][rowpos]-a[colpos][colpos]));
		s[rowpos][rowpos] = Math.cos(theta);
		s[rowpos][colpos] = -Math.sin(theta);
		s[colpos][rowpos] = Math.cos(theta);
		s[colpos][colpos] = Math.sin(theta);
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(s[i][j]==-10.0)
				{
					if(i==j)
						s[i][j] = 1.0;
						else
							s[i][j] = 0.0;
				}
			}
		}
		/*for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
			System.out.print(s[i][j]);
			System.out.print(" ");
			}
			System.out.println();
		}*/
		return s;
	}
}
