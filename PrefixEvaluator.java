//This evaluates the operation. Do not use this to convert sums and do not use this on the contest.
//made by Nihal Shivannagari (so it might not work)
import java.util.*;
public class PrefixEvaluator 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String[] tokens=tokenize(sc.nextLine());
		Tree connections= treeConstruction(tokens);
		System.out.println(operate(connections));
	}
	public static boolean isNum(String str)
	{
		char c=str.charAt(0);
		return c>47&&c<58;
	}
	public static String[] tokenize(String exp)
	{
		ArrayList<String> tokens=new ArrayList<String>();
		boolean lastString=false;
		tokens.add(exp.substring(0,1));
		for(int x=1;x<exp.length();x++)
		{
			if(exp.charAt(x)==' ')
			{
				tokens.add("");
			}
			else
			{
				tokens.set(tokens.size()-1, tokens.get(tokens.size()-1)+exp.charAt(x));
			}
		}
		String[]tokensarr=new String[tokens.size()];
		for(int x=0;x<tokens.size();x++)
		{
			tokensarr[x]=tokens.get(x);
		}
		return tokensarr;
	}
	public static Tree treeConstruction(String[] tokens)
	{
		Tree connections= new Tree(tokens[0],null);
		Tree currParent=connections;
		for(int x=1;x<tokens.length;x++)
		{
			if(isNum(currParent.getValue()))
			{
				currParent=currParent.getParent();
			}
			while(currParent.getLeaves().size()>1)
			{
				currParent=currParent.getParent();
			}
			currParent= new Tree(tokens[x],currParent);
		}
		return connections;
	}
	public static double operate(Tree connections)
	{
		if(isNum(connections.getValue()))
		{
			return Double.parseDouble(connections.getValue());
		}
		else if(connections.getValue().equals("+"))
		{
			return operate(connections.getLeaves().get(0))+operate(connections.getLeaves().get(1));
		}
		else if(connections.getValue().equals("-"))
		{
			return operate(connections.getLeaves().get(0))-operate(connections.getLeaves().get(1));
		}
		else if(connections.getValue().equals("*"))
		{
			return operate(connections.getLeaves().get(0))*operate(connections.getLeaves().get(1));
		}
		else if(connections.getValue().equals("/"))
		{
			return operate(connections.getLeaves().get(0))/operate(connections.getLeaves().get(1));
		}
		else
		{
			return Math.pow(operate(connections.getLeaves().get(0)),operate(connections.getLeaves().get(1)));
		}
	}
	public class Tree
	{
		private String pointVal;
		private Tree parent;
		private ArrayList<Tree> leaves;
		
		//if this node is the original, set parent to null
		public Tree(String value,Tree parent)
		{
			pointVal=value;
			this.parent=parent;
			leaves=new ArrayList<Tree>();
			if(parent!=null)
			{
				parent.leaves.add(this);
			}
		}
		public void addLeaf(String value)
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
		public String getValue()
		{
			return pointVal;
		}
		public ArrayList<Tree> getLeaves()
		{
			return leaves;
		}
		
		//this is a Depth First Search
		//this will not search for anything that is not contained with this Tree's leaves or lower
		public boolean contains(String value)
		{
			if(pointVal.equals(value))
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
}
