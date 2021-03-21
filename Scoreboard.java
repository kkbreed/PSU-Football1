import java.util.Random; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.File;  
import java.io.FileWriter; 
import java.io.FileNotFoundException;
import java.io.IOException;

class Scoreboard 
{

	public static int[] getRandomNumArray()
	{
		int[] randArray=new int[4]; 
		Random rn = new Random();

		for (int i=0;i<4 ;i++ ) 
		{				
			randArray[i] = rn.nextInt(13);
		}

		return randArray;
	}

	public static String writeToFile(int[] randArray)
	{
		String fileName="values.txt";

		try 
		{
			FileWriter fw=new FileWriter(fileName); 
			for (int i = 0; i < randArray.length; i++)
			{
				fw.write((int)randArray[i]+"\n");      	
			}
			fw.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error - " + e.toString());
		}
		catch (IOException e) 
		{
			System.out.println("Error - " + e.toString());
		}



		return fileName;
	}

	public static ArrayList<Integer> readFile(String fileName)
	{

		ArrayList<Integer> al=new ArrayList<Integer>();
		try 
		{

			Scanner fin = new Scanner(new File(fileName));

			while(fin.hasNextInt())
			{
				
				al.add(fin.nextInt());
			}

		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error - " + e.toString());
		}

		return al;
	}

	public static void calcPoints(ArrayList<Integer> dataVals)
	{
		System.out.println("Penn State");
		for (int i=0;i<dataVals.size();i++ ) 
		{
			int points=0;
			if (dataVals.get(i)<3) 
			{
				points=0;	
			}
			else if (dataVals.get(i)>=3 && dataVals.get(i)<6) 
			{
				points=3;
			}
			else if (dataVals.get(i)>=6 && dataVals.get(i)<9) 
			{
				points=9;
			}
			else if (dataVals.get(i)>=9 && dataVals.get(i)<=12) 
			{
				points=10;
			}
			System.out.println("Q"+(i+1)+"\t"+points);

		}
	}

	public static void main(String[] args) {

		int[] randArray = getRandomNumArray();

		String fileName = writeToFile(randArray);

		ArrayList<Integer> dataVals = readFile(fileName);

		calcPoints(dataVals);

	}

	
}