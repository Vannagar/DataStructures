import java.util.*;
//made by Nihal Shivannagari (so it might not work)

//this is extremely primitive and isn't very spatially efficient
//this only works for integers
public class PrimitiveMap
{
	private int maximum;
	private int minimum;
	private int[] map;

	//gap between max value and min value must be under 2*10^9
	public PrimitiveMap(int maxValue,int minValue)
	{
		maximum=maxValue;
		minimum=minValue;
		map=new int[maximum-minimum+1];
	}
	public PrimitiveMap(ArrayList<Integer> list)
	{
		int min=list.get(0);int max=list.get(0);
		for(int x=1;x<list.size();x++)
		{
			if(list.get(x)<min){min=list.get(x);}
			if(list.get(x)>max){max=list.get(x);}
		}
		minimum=min;maximum=max;map=new int[maximum-minimum+1];
		for(int x=0;x<list.size();x++)
		{
			map[list.get(x)]++;
		}
	}
	
	//returns how many of this value there are
	public int contains(int value)
	{
		return map[value-minimum];
	}

	//can't add over 2*10^9 of the same value
	public  void add(int value)
	{
		map[value-minimum]++;
	}

	//will return how many of that value is left
	//if a value is removed when there is nothing there, nothing will happen
	public int remove(int value)
	{
		if(map[value-minimum]>0)
		{map[value-minimum]--;}
		return map[value-minimum];
	}
	public ArrayList<Integer> toArrayList()
	{
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int x=0;x<map.length;x++)
		{
			for(int y=0;y<map[x];y++)
			{
				a.add(x+minimum);
			}
		}
		return a;
	}
}
