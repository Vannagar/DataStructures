import java.util.*;
//made by Nihal Shivannagari (so it might not work)
public class Tree<V>
	{
		private V pointVal;
		private Tree<V> parent;
		private ArrayList<Tree<V>> leaves;
		
		//if this node is the original, set parent to null
		public Tree(V value,Tree<V> parent)
		{
			pointVal=value;
			this.parent=parent;
			leaves=new ArrayList<Tree<V>>();
			if(parent!=null)
			{
				parent.leaves.add(this);
			}
		}
		public void addLeaf(V value)
		{
			leaves.add(new Tree<V>(value,this));
		}
		public void addBranch(Tree<V> branch)
		{
			branch.parent=this;
			if(!leaves.contains(this)){leaves.add(branch);}
		}
		public void setParent(Tree<V> tree)
		{
			parent=tree;
			if(!parent.leaves.contains(this)){parent.leaves.add(this);}
		}
		public Tree<V> getParent()
		{
			return parent;
		}
		public V getValue()
		{
			return pointVal;
		}
		public ArrayList<Tree<V>> getLeaves()
		{
			return leaves;
		}
		
		//this is a Depth First Search
		//this will not search for anything that is not contained with this Tree's leaves or lower
		public boolean contains(V value)
		{
			if(pointVal==value)
			{return true;}
			for(int x=0;x<leaves.size();x++)
			{
				if(leaves.get(x).contains(value))
				{return true;}
			}
			return false;
		}
		
		public Tree<V> topNode()
		{
			if(parent==null)
			{return this;}
			else
			{return parent.topNode();}
		}
	}
