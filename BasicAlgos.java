import java.util.ArrayList;
import java.util.Collections;
//made by Nihal Shivannagari (so it might not work)
public class BasicAlgos
	{
		public BasicAlgos()
		{/*Just to access the methods*/}
		public int indexOfClosestValue(ArrayList<Integer>list,int target)
		{
			int low=0;int high=list.size()-1;

			//edge cases
			if(list.get(0)>target) {return 0;}
			if(list.get(high)<target) {return high;}

			//find index of closest value less than target
			int sol=0;
			while(low<=high)
			{
				if(low==high)
				{sol=low;break;}

				int med=(low+high)/2;
				if(list.get(med)<target&&list.get(med+1)>target)
				{sol=med;break;}
				else if(list.get(med)<target&&list.get(med+1)<target)
				{low=med+1;}
				else if(list.get(med)>target&&list.get(med+1)>target)
				{high=med-1;}
			}

			if(sol<high&&list.get(sol+1)-target<target-list.get(sol))
			{return sol+1;}
			else
			{return sol;}
		}
		public String arrayToString(int[]array)
		{
			String sol="[";
			sol+=array[0];
			for(int x=1;x<array.length;x++)
			{sol+=(", "+array[x]);}
			return sol+"]";
		}
		public void tupleListSort(ArrayList<Tuple>list,int key)
		{
			for(int x=0;x<list.size();x++)
			{
				list.get(x).setKey(key);
			}
			Collections.sort(list);
		}
	}