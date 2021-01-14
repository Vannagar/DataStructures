import java.util.*;
//made by Nihal Shivannagari (so it might not work)

//for a normal queue just leave the value at index 1 the same number for all tuples
//larger number for rank has higher priority
public class PriorityQueue
{
	private ArrayList<Integer> queue;
	private ArrayList<Integer> priority;
	public PriorityQueue()
	{
		queue=new ArrayList<Integer>();priority=new ArrayList<Integer>();
	}
	public void enqueue(int value,int rank)
	{
		BasicAlgos ba=new BasicAlgos();
		int k=ba.indexOfClosestValue(priority, rank);
		while(k>=0&&priority.get(k)>=rank)
		{k--;}
		k++;queue.add(k,value);priority.add(k,rank);
	}
	public Tuple dequeue()
	{
		Tuple t=new Tuple(2,1);
		t.setValue(0,queue.remove(queue.size()-1));
		t.setValue(1,priority.remove(priority.size()-1));
		return t;
	}
}