import java.util.*;
//made by Nihal Shivannagari (so it might not work)

//tuple is super simple and kind of pointless but makes life easier
public class Tuple implements Comparable<Tuple>
{
	private int count;
	private int key;
	private int[] values;

	public Tuple(int count,int key)
	{this.count=count;this.key=key;values=new int[count];}
	public Tuple(int count)
	{this.count=count;this.key=0;values=new int[count];}

	public void setKey(int key)
	{this.key=key;}
	public int getKey()
	{return key;}
	public int getValue(int index)
	{return values[index];}
	public void setValue(int index,int value)
	{values[index]=value;}

	//for the tupleListSort method to function properly
	public int compareTo(Tuple t)
	{
		return values[key]-t.values[t.key];
	}
	public String toString()
	{BasicAlgos ba=new BasicAlgos(); return ba.arrayToString(values);}
}