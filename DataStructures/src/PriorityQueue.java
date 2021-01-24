import java.util.*;
//made by Nihal Shivannagari (so it might not work)

//for a normal queue just leave the value at index 1 the same number for all tuples
//larger number for rank has higher priority
public class PriorityQueue<V extends Comparable<V>>
{
	private ArrayList<V> queue;
	private ArrayList<Integer> priority;
	public PriorityQueue()
	{
		queue=new ArrayList<V>();priority=new ArrayList<Integer>();
	}
	public void enqueue(V value,int rank)
	{
		BasicAlgos ba=new BasicAlgos();
		int k=ba.indexOfClosestValue(priority, rank);
		while(k>=0&&priority.get(k)>=rank)
		{k--;}
		k++;queue.add(k,value);priority.add(k,rank);
	}
	public V dequeue()
	{
		return queue.remove(queue.size()-1);
	}
}