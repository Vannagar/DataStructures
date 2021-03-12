import java.util.*;
public class FundamentalStatistics
{
	//class will often pass border values for some variables
	public FundamentalStatistics()
	{/*shell class to house methods*/}

	//method can breach the long max value
	//factorial isn't applicable to a value less than 0
	public long factorial(int x)
	{
		int xi=1;
		long j=1;
		while(xi<=x)
		{j*=xi;}
		return j;
	}

	//method can breach the long max value
	//n and r can't be less than 0
	public long nCr(int n,int r)
	{
		int xi=Math.max(r,n-r);
		int yi=n-xi;
		long j=1;
		while(n>xi)
		{j*=n;n--;}
		return j/factorial(yi);
	}

	//method can breach the long max value
	//n and r can't be less than 0
	public long nPr(int n,int r)
	{
		long j=1;
		while(n>r)
		{j*=n;n--;}
		return j;
	}

	//set terms to 0 or less to calculate the sum of an infinite series, but will return 
	//will return 0 if the infinite series diverges or diverges while oscillating
	//initial is term 1
	public double sumOfGeometricSeries(double initial,double ratio,int terms)
	{
		if(terms<1&&ratio<1)
		{return initial/(1.0-ratio);}
		else if(terms>=1)
		{return (initial*(Math.pow(ratio,terms-1)-1)/(ratio-1));}
		else
		{return 0;}
	}

	//not typically used in statistics but could be useful
	//terms must be greater than 0
	//initial is term 1
	public double sumOfArithmeticSeries(double initial,double rate,int terms)
	{
		return (terms/2.0*(2*initial+(terms-1)*rate));
	}

	//not typically used in statistics but could be useful
	//initial is term 1
	public double termInArithmeticSeries(double initial,double rate,int terms)
	{
		return  initial+rate*(terms-1);
	}

	//initial is term 1
	public double termInGeometricSeries(double initial,double ratio,int term)
	{
		return  initial*Math.pow(ratio,term-1);
	}
	public int[] prefixSum(int[]r)
	{
		int[]q=new int[r.length+1];
		for(int x=0;x<r.length;x++)
		{
			q[x+1]=q[x]+r[x];
		}
		return q;
	}
}
