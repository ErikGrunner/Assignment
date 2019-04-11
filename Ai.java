package Assignment;
//https://www.journaldev.com/709/java-read-file-line-by-line#java-read-file-line-by-line-using-bufferedreader

import java.io.BufferedReader ;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ai implements Requirements{
	private float Denominator=0;
	private ArrayList Titles = new ArrayList();
	private int[][] results = new int[5][5];//fix
	int trace =0;
	boolean alreadyExecuted = false;
	DataOptions d[] = null;
	
	public DataOptions getD(int x) {
		return d[x];
	}	
	public float getDenominator() {
		return Denominator;
	}
	public void ReadData(int slider)
	{
		int count = 0;
		System.out.println("Reading data");
		alreadyExecuted = false;
		BufferedReader reader;//Found a code example of buffer reader online
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/Erik/Desktop/Tonsilitus.txt"));
			String line = reader.readLine();
			
			while (line != null) {
				//System.out.println(line);
				
				sortData(line,slider);
				line = reader.readLine();
				count++;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Failed to read");
			e.printStackTrace();
		}
		
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/Erik/Desktop/Tonsilitus.txt"));
			String line = reader.readLine();
			Denominator=0;
			for (int i =0; i<count;i++) {
				//System.out.println(line);
				//line = line.replaceAll("[^A-Za-z]+", "").toLowerCase();
				countData(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Failed to read");
			e.printStackTrace();
		}
	}
	public void sortData(String line,int slider)
	{
		
		String[] arrx = line.split(" ");
	
		if(!alreadyExecuted) //creates the objects that hold possible answers
		{
			d = new DataOptions[arrx.length+1];
			for(int i=0; i<arrx.length;i++) 
			{
				d[i] = new DataOptions();
				if(!Titles.contains(arrx[i]))//add the titles into a arraylist
					Titles.add(arrx[i]);
			}
			alreadyExecuted = true;
			//String[] Titles = line.split(" ");
			return ;
		}
		Denominator=0;
		for(int i =0;i<arrx.length;i++)//reset the results
		{
			for(int j =0; j<(d[i].getNewObj()).size();j++)
			{
				results[i][j] = 0;
			}
			
		}
		//System.out.println(Arrays.deepToString(results));
		for(int i=0; i<arrx.length*(slider/100);i++) //fills the objects with the possible answers
		{
			arrx[i] = arrx[i].replaceAll("[^A-Za-z]+", "").toLowerCase();
			d[i].countOptions(arrx[i]);
		     //System.out.println("d"+i+d[i].toString());//used to see data options
		}
	}
	public ArrayList getTitles() {
		ReadData(100);
		return (ArrayList) Titles;
	}
	public int getResults(int i,int j) {
		return results[i][j];
	}
	public void countData(String line)
	{
		    
		String[] arr = line.split(" ");
		Denominator++;
		if(arr[3].toLowerCase().contentEquals("yes"/*d[3].getNewObj(j)*/))//if the patient has Tonsillitis
		{
			
			removeTheElement(arr, 3);//this is so that results are not generated for tonsilitus
			
			for(int i =0;i<arr.length;i++)
			{
				arr[i] = arr[i].replaceAll("[^A-Za-z]+", "").toLowerCase();
				for(int j =0; j<((d[i].getNewObj()).size());j++)
				{

					if(arr[i].contentEquals(d[i].getNewObj(j)))//this counts up the amount of times each results happens for each question
					{
						results[i][j]++;
						//System.out.println(Arrays.deepToString(results));
					}
				}
				
			}	

		}
	}
	public int totalAnswers()
	{
		int answer=0;
		for(int i=0; i<d.length-2;i++) //fills the variable with the possible answers
		{

			answer += (d[i].getNewObj()).size();
		}
		System.out.println("total"+answer);
		return answer;
	}
	public static String[] removeTheElement(String[] arr, //found online
			int index) 
	{ 
		// If the array is empty 
		// or the index is not in array range 
		// return the original array 
		if (arr == null|| index < 0|| index >= arr.length) 
		{ 
			return arr; 
		} 
		// Create another array of size one less 
		String[] anotherArray = new String[arr.length - 1]; 
		// Copy the elements except the index 
		// from original array to the other array 
		for (int i = 0, k = 0; i < arr.length; i++) { 
			// if the index is 
			// the removal element index 
			if (i == index) { 
				continue; 
			} 
			// if the index is not 
			// the removal element index 
			anotherArray[k++] = arr[i]; 
		} 
		// return the resultant array 
		return anotherArray; 
	} 
}

