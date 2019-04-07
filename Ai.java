package Assignment;
//https://www.journaldev.com/709/java-read-file-line-by-line#java-read-file-line-by-line-using-bufferedreader

import java.io.BufferedReader ;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Ai implements Requirements{
	private float tempatureHotNumerator=0;
	private float tempatureNormalNumerator=0;
	private float tempatureCoolNumerator=0;	
	private float soreThroatNumerator=0;
	private float achesNumerator=0;
	private float Denominator=0;
	private ArrayList Titles = new ArrayList();
	private int[][] results = new int[5][5];
	
	public DataOptions getD(int x) {
		return d[x];
	}
	public void setD(DataOptions[] d) {
		this.d = d;
	}
	int trace =0;
	boolean alreadyExecuted = false;
	DataOptions d[] = null;
	
	public float getTempatureHotNumerator() {
		return tempatureHotNumerator;
	}
	public void setTempatureHotNumerator(float tempatureHotNumerator) {
		this.tempatureHotNumerator = tempatureHotNumerator;
	}
	public float getTempatureNormalNumerator() {
		return tempatureNormalNumerator;
	}
	public void setTempatureNormalNumerator(float tempatureNormalNumerator) {
		this.tempatureNormalNumerator = tempatureNormalNumerator;
	}
	public float getTempatureCoolNumerator() {
		return tempatureCoolNumerator;
	}
	public void setTempatureCoolNumerator(float tempatureCoolNumerator) {
		this.tempatureCoolNumerator = tempatureCoolNumerator;
	}
	public float getSoreThroatNumerator() {
		return soreThroatNumerator;
	}
	public void setSoreThroatNumerator(float soreThroatNumerator) {
		this.soreThroatNumerator = soreThroatNumerator;
	}
	public float getAchesNumerator() {
		return achesNumerator;
	}
	public void setAchesNumerator(float achesNumerator) {
		this.achesNumerator = achesNumerator;
	}
	public float getDenominator() {
		return Denominator;
	}
	public void setDenominator(float denominator) {
		Denominator = denominator;
	}


	public void Bayes() {
	}
	public void ReadData()
	{
		System.out.println("Reading data");
		alreadyExecuted = false;
		BufferedReader reader;//Found a code example of buffer reader online
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/Erik/Desktop/Tonsilitus.txt"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				
				sortData(line);
				line = reader.readLine();
				
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
			while (line != null) {
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
		/*System.out.println("Sore Throat answer"+(soreThroatNumerator/Denominator));
		System.out.println("aches answer"+(achesNumerator/Denominator));
		System.out.println("hot answer"+(tempatureHotNumerator/Denominator));
		System.out.println("cool Throat answer"+(tempatureCoolNumerator/Denominator));
		System.out.println("normal Throat answer"+(tempatureNormalNumerator/Denominator));*/


	}
	public void sortData(String line)
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
			String[] Titles = line.split(" ");
			/*System.out.println("Titles:"+Arrays.toString(Titles));
			System.out.println("Titles Length:"+Titles.length);*/
			
			return ;
		}

		for(int i=0; i<arrx.length;i++) //fills the objects with the possible answers
		{
			arrx[i] = arrx[i].replaceAll("[^A-Za-z]+", "").toLowerCase();
			d[i].countOptions(arrx[i]);
		     //System.out.println("d"+i+d[i].toString());//used to see data options
		}
		//System.out.println(d[2].getNewObj(0));

		

	}
	public ArrayList getTitles() {
		ReadData();
		return (ArrayList) Titles;
	}
	public int getResults(int i,int j) {
		return results[i][j];
	}
	public void setResults(int[][] results) {
		this.results = results;
	}
	public void setTitles(ArrayList titles) {
		Titles = titles;
	}
	public void countData(String line)
	{
		    
		String[] arr = line.split(" ");
		/*for(int i=0; i<arr.length;i++) {
		     System.out.println(arr[i]);
		}*/
		Denominator++;
		if(arr[3].toLowerCase().contentEquals("yes"/*d[3].getNewObj(j)*/))//if the patient has Tonsillitis
		{
			removeTheElement(arr, 3);//this is so that results are not generated for tonsilitus
			for(int i =0;i<arr.length;i++)//reset the results
			{
				for(int j =0; j<(d[i].getNewObj()).size();j++)
				{
					results[i][j] = 0;
				}
				
			}
			for(int i =0;i<arr.length;i++)
			{
				for(int j =0; j<(d[i].getNewObj()).size();j++)
				{
					if(arr[i].contentEquals(d[i].getNewObj(j)));
					{
						/*if(results[i][j] == null)
						{
							results[i][j] =0;
						}*/
	
						results[i][j]++;
					}
				}
				
			}
			//System.out.println("This should say hot"+(StringBuffer) d[0].getObj()[0]);
			if(arr[0].contentEquals(d[0].getNewObj(0)))//check temperature symptom
			{
				tempatureHotNumerator++;
				//System.out.println("Its Hot");
			}
			else if(arr[0].contentEquals("cool"))
			{
				tempatureCoolNumerator++;
				//System.out.println("Its Cool");
			}
			else if(arr[0].contentEquals("normal"))
			{
				tempatureNormalNumerator++;
				//System.out.println("Its Normal");
			}

			if(arr[2].toLowerCase().contentEquals("yes"))//check throat symptom
			{
				soreThroatNumerator++;
			}

			if(arr[1].toLowerCase().contentEquals("yes"))//check aches symptom
			{
				achesNumerator++;
			}	

		}
	}
	public static String[] removeTheElement(String[] arr, //found online
			int index) 
	{ 

		// If the array is empty 
		// or the index is not in array range 
		// return the original array 
		if (arr == null
				|| index < 0
				|| index >= arr.length) { 

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

