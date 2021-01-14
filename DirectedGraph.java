import java.util.*;
//compiled by Nihal Shivannagari from independent work and outside sources (so it might not work)
//for this class, you should make a dataset that pairs each point to a value for convenience
public class DirectedGraph
{
	private int points;
	private ArrayList<Integer>[] originConnections;
	private ArrayList<Integer>[] destinationConnections;
	private Matrix adjacencyMatrix;
	public DirectedGraph(int points)
	{
		this.points=points;
		originConnections=new ArrayList[points];
		destinationConnections=new ArrayList[points];
		for(int x=0;x<points;x++)
		{originConnections[x]=new ArrayList<Integer>();
		destinationConnections[x]=new ArrayList<Integer>();}
		adjacencyMatrix=new Matrix(points,points);
	}
	public DirectedGraph(Matrix m)
	{
		DirectedGraph dg=new DirectedGraph(m.show().length);
		for(int x=0;x<dg.points;x++)
		{
			for(int y=0;y<dg.points;y++)
			{
				dg.addConnection(x,y);
			}
		}
		points=dg.points;
		originConnections=dg.originConnections;
		destinationConnections=dg.destinationConnections;
		adjacencyMatrix=dg.adjacencyMatrix;
	}
	public void addConnection(int origin,int destination)
	{
		//finding the location to input new connections
		origin--;destination--;
		BasicAlgos b=new BasicAlgos();
		int x=0;
		if(originConnections[origin].size()>0)
		{x=b.indexOfClosestValue(originConnections[origin],destination);
		if(originConnections[origin].get(x)==destination)
		{return;}
		if(originConnections[origin].get(x)>destination)
		{x--;}}
		int y=0;
		if(destinationConnections[destination].size()>0)
		{y=b.indexOfClosestValue(destinationConnections[destination],origin);
		if(destinationConnections[destination].get(y)>origin)
		{y--;}}

		//inputing the connection
		if(originConnections[origin].get(x)!=destination)
		{originConnections[origin].add(x);}
		if(destinationConnections[destination].get(x)!=origin)
		{destinationConnections[destination].add(y);}
		adjacencyMatrix.setPoint(1, origin, destination);
	}
	
	public void removeConnection(int origin,int destination)
	{
		//finding the location to input new connections
		origin--;destination--;
		BasicAlgos b=new BasicAlgos();
		int x=0;
		if(originConnections[origin].size()>0)
		{x=b.indexOfClosestValue(originConnections[origin],destination);
		if(originConnections[origin].get(x)==destination)
		{return;}
		if(originConnections[origin].get(x)>destination)
		{x--;}}
		int y=0;
		if(destinationConnections[destination].size()>0)
		{y=b.indexOfClosestValue(destinationConnections[destination],origin);
		if(destinationConnections[destination].get(y)>origin)
		{y--;}}
		//inputing the connection
		if(originConnections[origin].get(x)==destination)
		{originConnections[origin].remove(x);}
		if(destinationConnections[destination].get(x)==origin)
		{destinationConnections[destination].remove(y);}
		adjacencyMatrix.setPoint(0, origin, destination);
	}

	//retrieval methods
	public ArrayList<Integer>[] getOriginConnections()
	{return originConnections;}
	public ArrayList<Integer>[] getDestinationConnections()
	{return destinationConnections;}
	public Matrix getAdjacencyMatrix()
	{return adjacencyMatrix;}

	public boolean isAcyclic()
	{
		{ 
			// Create a array to store 
			// indegrees of all 
			// vertices. Initialize all 
			// indegrees as 0. 
			int indegree[] = new int[points]; 

			// Traverse adjacency lists 
			// to fill indegrees of 
			// vertices. This step takes 
			// O(V+E) time 
			for (int i = 0; i < points; i++) { 
				ArrayList<Integer> temp 
				= (ArrayList<Integer>)originConnections[i]; 
				for (int node : temp) { 
					indegree[node]++; 
				} 
			} 

			// Create a queue and enqueue 
			// all vertices with indegree 0 
			Queue<Integer> q 
			= new LinkedList<Integer>(); 
			for (int i = 0; i < points; i++) { 
				if (indegree[i] == 0) 
					q.add(i); 
			} 

			// Initialize count of visited vertices 
			int cnt = 0; 

			// Create a vector to store result 
			// (A topological ordering of the vertices) 
			Vector<Integer> topOrder = new Vector<Integer>(); 
			while (!q.isEmpty()) { 
				// Extract front of queue 
				// (or perform dequeue) 
				// and add it to topological order 
				int u = q.poll(); 
				topOrder.add(u); 

				// Iterate through all its 
				// neighbouring nodes 
				// of dequeued node u and 
				// decrease their in-degree 
				// by 1 
				for (int node : originConnections[u]) { 
					// If in-degree becomes zero, 
					// add it to queue 
					if (--indegree[node] == 0) 
						q.add(node); 
				} 
				cnt++; 
			} 

			// Check if there was a cycle 
			if (cnt != points) { return false;} 
			else
			{return true;}
		} 
	}

	public ArrayList<Integer> topologicalSort()
	{
		{ 
			// Create a array to store 
			// indegrees of all 
			// vertices. Initialize all 
			// indegrees as 0. 
			int indegree[] = new int[points]; 

			// Traverse adjacency lists 
			// to fill indegrees of 
			// vertices. This step takes 
			// O(V+E) time 
			for (int i = 0; i < points; i++) { 
				ArrayList<Integer> temp 
				= (ArrayList<Integer>)originConnections[i]; 
				for (int node : temp) { 
					indegree[node]++; 
				} 
			} 

			// Create a queue and enqueue 
			// all vertices with indegree 0 
			Queue<Integer> q 
			= new LinkedList<Integer>(); 
			for (int i = 0; i < points; i++) { 
				if (indegree[i] == 0) 
					q.add(i); 
			} 

			// Initialize count of visited vertices 
			int cnt = 0; 

			// Create a vector to store result 
			// (A topological ordering of the vertices) 
			Vector<Integer> topOrder = new Vector<Integer>(); 
			while (!q.isEmpty()) { 
				// Extract front of queue 
				// (or perform dequeue) 
				// and add it to topological order 
				int u = q.poll(); 
				topOrder.add(u); 

				// Iterate through all its 
				// neighboring nodes 
				// of dequeued node u and 
				// decrease their in-degree 
				// by 1 
				for (int node : originConnections[u]) { 
					// If in-degree becomes zero, 
					// add it to queue 
					if (--indegree[node] == 0) 
						q.add(node); 
				} 
				cnt++; 
			} 

			// Check if there was a cycle 
			if (cnt != points) { 
				return null;
			} 

			ArrayList<Integer>sol=new ArrayList<Integer>();
			for (int i : topOrder) { 
				sol.add(i+1); 
			} 
			return sol;
		} 
	}
	public boolean areConnected(int origin,int destination)
	{
		return adjacencyMatrix.getPoint(origin, destination)==0;
	}
}
