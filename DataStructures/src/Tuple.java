import java.util.*;
//made by Nihal Shivannagari (so it might not work)

//tuple is super simple and kind of pointless but makes life easier
public class Tuple<V extends Comparable<V>> implements Comparable<Tuple<V>>
{
	private int count;
	private int key;
	private V[] values;

	public Tuple(int count,int key)
	{this.count=count;this.key=key;values=(V[])new Object[count];}
	public Tuple(int count)
	{this.count=count;this.key=0;values=(V[])new Object[count];}

	public void setKey(int key)
	{this.key=key;}
	public int getKey()
	{return key;}
	public V getValue(int index)
	{return values[index];}
	public void setValue(int index,V value)
	{values[index]=value;}

	//for the tupleListSort method to function properly
	public int compareTo(Tuple<V> t)
	{
		return values[key].compareTo(t.values[t.key]);
	}
	public String toString()
	{BasicAlgos ba=new BasicAlgos(); return ba.arrayToString(values);}
}