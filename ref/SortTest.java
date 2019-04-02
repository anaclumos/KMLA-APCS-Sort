import java.util.*;
import java.io.*;

public class SortTest
{
	public static void main(String[] args)
	throws FileNotFoundException, UnsupportedEncodingException
	{
		Random rand = new Random(10);
		int size;
		int[] array;
		int[] dup;
		int repeatTimes = 1;
		int average = 0;

		PrintWriter pr = new PrintWriter("Result.txt", "UTF-8");

		for(int elementCount = 1000; elementCount <= (args.length == 0 ? 50000 : 
			Integer.parseInt(args[0])); elementCount += 1000)
		{
			pr.printf("%d\t", elementCount);
			array = new int[elementCount];
			dup = new int[elementCount];
			randomInitialize(array, rand);

			for(int i = 0; i < repeatTimes; i++)
			{
				duplicateArray(array, dup);
				average += SelectionSort.sort(dup);
			}
			pr.printf("%d\t", average / repeatTimes);
			average = 0;

			for(int i = 0; i < repeatTimes; i++)
			{
				duplicateArray(array, dup);
				average += InsertionSort.sort(dup);
			}
			pr.printf("%d\t", average / repeatTimes);
			average = 0;

			for(int i = 0; i < repeatTimes; i++)
			{
				duplicateArray(array, dup);
				average += HeapSort.sort(dup);
			}
			pr.printf("%d\t", average / repeatTimes);
			average = 0;

			for(int i = 0; i < repeatTimes; i++)
			{
				duplicateArray(array, dup);
				average += MergeSort.sort(dup);
			}
			pr.printf("%d\t", average / repeatTimes);
			average = 0;

			for(int i = 0; i < repeatTimes; i++)
			{
				duplicateArray(array, dup);
				average += QuickSort.sort(dup);
			}
			pr.printf("%d\n", average / repeatTimes);
			average = 0;

			for(int j = 0; j < 30; j++) System.out.print("\b");
			System.out.print("Finished round " + elementCount + ".");
		}
		pr.close();
	}

	public static void duplicateArray(int[] array, int[] dup)
	{
		int n = array.length;

		for(int i = 0; i < n; i++)
		{
			dup[i] = array[i];
		}
	}

	public static void randomInitialize(int[] a, Random r)
	{
		for(int i = 0; i < a.length; i++)
			a[i] = r.nextInt(100);
	}

	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.printf("[%2d, %2d] ", i, a[i]);
			if((i + 1) % 10 == 0) System.out.println();
		}
	}
}
