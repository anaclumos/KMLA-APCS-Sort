public class MSTest
{
	public static void main(String[] args)
	{
		
		int[] b = {1, 3, 23, 56, 89, 2, 4, 1, 423, 65, 13, 9238, 32, 43, 654, 24354};
		printArray(b);
		int[] ab = MergeSort.comergeSort(b);
		printArray(ab);
		/*
		InsertionSort3.sort(b);
		printArray(b);
		int[] ab2 = MergeSort.comerge(a,b);
		System.out.println("AB2 Complete");
		printArray(ab2);
		*/

	}

	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "]");
		}
		System.out.println("\n");
	}
}