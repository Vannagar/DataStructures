import java.util.*;
//made by Nihal Shivannagari (so it might not work)
public class Tree
	{
		private int pointVal;
		private Tree parent;
		private ArrayList<Tree> leaves;
		
		//if this node is the original, set parent to null
		public Tree(int value,Tree parent)
		{
			pointVal=value;
			this.parent=parent;
			leaves=new ArrayList<Tree>();
			if(parent!=null)
			{
				parent.leaves.add(this);
			}
		}
		public void addLeaf(int value)
		{
			leaves.add(new Tree(value,this));
		}
		public void addBranch(Tree branch)
		{
			branch.parent=this;
			if(!leaves.contains(this)){leaves.add(branch);}
		}
		public void setParent(Tree tree)
		{
			parent=tree;
			if(!parent.leaves.contains(this)){parent.leaves.add(this);}
		}
		public Tree getParent()
		{
			return parent;
		}
		public int getValue()
		{
			return pointVal;
		}
		public ArrayList<Tree> getLeaves()
		{
			return leaves;
		}
		
		//this is a Depth First Search
		//this will not search for anything that is not contained with this Tree's leaves or lower
		public boolean contains(int value)
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
		
		public Tree topNode()
		{
			if(parent==null)
			{return this;}
			else
			{return parent.topNode();}
		}
	}
