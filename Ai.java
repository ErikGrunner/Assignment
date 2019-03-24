package Assignment;
//https://www.journaldev.com/709/java-read-file-line-by-line#java-read-file-line-by-line-using-bufferedreader

import java.io.BufferedReader ;
import java.io.FileReader;
import java.io.IOException;

public class Ai implements Requirements{
	private float tempatureNormalNumerator=0;
	private float tempatureCoolNumerator=0;	
	private float soreThroatNumerator=0;
	private float achesNumerator=0;
	private float Denominator=0;
	private float tempatureHotNumerator=0;
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
		BufferedReader reader;//Found a code example of buffer reader online
		try {
			System.out.println("test1");
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
			System.out.println("test1");
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
		System.out.println("Sore Throat answer"+(soreThroatNumerator/Denominator));
		System.out.println("aches answer"+(achesNumerator/Denominator));
		System.out.println("hot answer"+(tempatureHotNumerator/Denominator));
		System.out.println("cool Throat answer"+(tempatureCoolNumerator/Denominator));
		System.out.println("normal Throat answer"+(tempatureNormalNumerator/Denominator));


	}
	public void sortData(String line)
	{
		String[] arrx = line.split(" ");
	
		if(!alreadyExecuted) 
		{
			d = new DataOptions[arrx.length+1];
			for(int i=0; i<arrx.length;i++) 
			{
				d[i] = new DataOptions();
			}
			alreadyExecuted = true;
		}

		for(int i=0; i<arrx.length;i++) 
		{
			arrx[i] = arrx[i].replaceAll("[^A-Za-z]+", "").toLowerCase();
			d[i].countOptions(arrx[i]);
		     System.out.println("d"+i+d[i].toString());
		}
	}
	public void countData(String line)
	{
		String[] arr = line.split(" ");    

		/*for(int i=0; i<arr.length;i++) {
		     System.out.println(arr[i]);
		}*/
		Denominator++;
		if(arr[3].toLowerCase().contentEquals("yes"))//if the patient has Tonsillitis
		{
			System.out.println("it works erik");
			if(arr[0].contentEquals("hot"))//check temperature symptom
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
}
