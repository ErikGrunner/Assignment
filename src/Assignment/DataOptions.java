package Assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class DataOptions {
	ArrayList newObj = new ArrayList();
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
			//Object[] newObj = appendValue(obj, input);
			Collections.sort(newObj, Collections.reverseOrder());
		}
	}
	private Object[] appendValue(Object[] obj, Object newObj) 
	{
		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
		temp.add(newObj);
		return temp.toArray();

	  }
	public ArrayList getNewObjArray() {
	
		return (ArrayList) newObj;
	}
	public String getNewObj(int x) {
		String y = (String) newObj.get(x);
		return y;
	}
	public void setNewObj(ArrayList<Object> newObj) {
		this.newObj = newObj;
	}
	public ArrayList<Object> getNewObj() {
		return newObj;
	}
	@Override
	public String toString() {
		return "DataOptions [" + "obj=" /*+ Arrays.toString(obj)*/
				+ ", newObj=" + newObj + "]";
	}
}
