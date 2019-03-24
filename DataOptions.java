package Assignment;

import java.util.Arrays;
import java.util.ArrayList;

public class DataOptions {
	private String[] array;
	Object[] obj = new Object[] {};
	ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(obj));
	
	@SuppressWarnings({ "unused", "unlikely-arg-type" })
	public void countOptions(String input)
	{
		if(newObj.contains(input))//Arrays.asList(newObj).contains(input))
		{
			//System.out.println("beep");
		}
		else
		{
			newObj.add(input);
			Object[] newObj = appendValue(obj, input);
		}
	}
	private Object[] appendValue(Object[] obj, Object newObj) 
	{
		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
		temp.add(newObj);
		return temp.toArray();

	  }

	@Override
	public String toString() {
		return "DataOptions [ array=" + Arrays.toString(array) + ", obj=" + Arrays.toString(obj)
				+ ", newObj=" + newObj + "]";
	}
}
