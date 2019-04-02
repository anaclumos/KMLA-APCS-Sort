import java.util.*;

public class SortTest
{
	public static void main(String[] args) 
	{
		long realstart = System.currentTimeMillis();
		//int size;
		int[] array;
		Scanner sc = new Scanner(System.in);
		System.out.print("array length: ");
		int size = sc.nextInt();
		/*
		if(args.length == 0)
			size = 10;
		else
			size = Integer.parseInt(args[0]);*/

		array = new int[size];
		System.out.print("Rotation Num: ");
		int rotNum = sc.nextInt();

		double allselect1CalTime=0;
		double allselect2CalTime=0;
		double allinsert1CalTime=0;
		double allinsert2CalTime=0;
		double allinsert3CalTime=0;
		double allinsert4CalTime=0;
		double alldimergeCalTime=0;
		double allcomergeCalTime=0;
		double allquickCalTime=0;
		double allheapCalTime=0;

		boolean ss1valid = true;
		boolean ss2valid = true;
		boolean is1valid = true;
		boolean is2valid = true;
		boolean is3valid = true;
		boolean is4valid = true;
		boolean divalid = true;
		boolean covalid = true;
		boolean qsvalid = true;
		boolean hsvalid = true;

		for ( int allo = 0; allo < rotNum; allo++ )
		{

		long start;
		long end;

		Random rand = new Random(10);
		randomInitialize(array, rand);
		
		
		System.out.println("ROT NUM "+allo);
		int[] dupss1 = new int[size];
		System.out.println("Section Sort...");
		duplicateArray(array, dupss1);
		//printArray(dupss1);
		start = System.currentTimeMillis();
		SelectionSort.sort(dupss1);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupss1);
		ss1valid = validTest(dupss1);
		System.out.println("SS1 Valid Test "+ss1valid);
		if(!ss1valid) {System.out.println("FALSE SORT FOUND"); break; }
		double select1CalTime = ((end-start)/1000.0);
		System.out.println("SS1 Calculation time = "+select1CalTime+"s\n");
		allselect1CalTime += select1CalTime;

		System.out.println("ROT NUM "+allo);
		int[] dupss2 = new int[size];
		System.out.println("Section Sort2...");
		duplicateArray(array, dupss2);
		//printArray(dupss2);
		start = System.currentTimeMillis();
		SelectionSort2.sort(dupss2);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupss2);
		ss2valid = validTest(dupss2);
		System.out.println("SS2 Valid Test "+ss2valid);
		if(!ss2valid) {System.out.println("FALSE SORT FOUND"); break; }
		double select2CalTime = ((end-start)/1000.0);
		System.out.println("SS2 Calculation time = "+select2CalTime+"s\n");
		allselect2CalTime += select2CalTime;

		System.out.println("ROT NUM "+allo);
		int[] dupin1 = new int[size];
		System.out.println("Insertion Sort1...");
		duplicateArray(array, dupin1);
		//printArray(dupin1);
		start = System.currentTimeMillis();
		InsertionSort.sort(dupin1);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupin1);
		is1valid = validTest(dupin1);
		System.out.println("IS1 Valid Test "+is1valid);
		if(!is1valid) {System.out.println("FALSE SORT FOUND"); break; }
		double insert1CalTime = ((end-start)/1000.0);
		System.out.println("IS1 Calculation time = "+insert1CalTime+"s\n");
		allinsert1CalTime += insert1CalTime;

		System.out.println("ROT NUM "+allo);
		int[] dupin2 = new int[size];
		System.out.println("Insertion Sort2...");
		duplicateArray(array, dupin2);
		//printArray(dupin2);
		start = System.currentTimeMillis();
		InsertionSort2.sort(dupin2);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupin2);
		is2valid = validTest(dupin2);
		System.out.println("IS2 Valid Test "+is2valid);
		if(!is2valid) {System.out.println("FALSE SORT FOUND"); break; }
		double insert2CalTime = ((end-start)/1000.0);
		System.out.println("IS2 Calculation time = "+insert2CalTime+"s\n");
		allinsert2CalTime += insert2CalTime;

		System.out.println("ROT NUM "+allo);
		int[] dupin3 = new int[size];
		System.out.println("Insertion Sort3...");
		duplicateArray(array, dupin3);
		//printArray(dupin3);
		start = System.currentTimeMillis();
		InsertionSort3.sort(dupin3);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupin3);
		is3valid = validTest(dupin3);
		System.out.println("IS3 Valid Test "+is3valid);
		if(!is3valid) {System.out.println("FALSE SORT FOUND"); break; }
		double insert3CalTime = ((end-start)/1000.0);
		System.out.println("IS3 Calculation time = "+insert3CalTime+"s\n");
		allinsert3CalTime+=insert3CalTime;

		System.out.println("ROT NUM "+allo);
		int[] dupin4 = new int[size];
		System.out.println("Insertion Sort4...");
		duplicateArray(array, dupin4);
		//printArray(dupin4);
		start = System.currentTimeMillis();
		InsertionSort4.sort(dupin4);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupin4);
		is4valid = validTest(dupin4);
		System.out.println("IS4 Valid Test "+is4valid);
		if(!is4valid) {System.out.println("FALSE SORT FOUND"); break; }
		double insert4CalTime = ((end-start)/1000.0);
		System.out.println("IS4 Calculation time = "+insert4CalTime+"s\n");
		allinsert4CalTime += insert4CalTime;
		
		System.out.println("ROT NUM "+allo);
		int[] dupdi = new int[size];
		System.out.println("Dimerge Sort...");
		duplicateArray(array, dupdi);
		//printArray(dupdi);
		start = System.currentTimeMillis();
		dupdi = MergeSort.dimergeSort(dupdi);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupdi);
		divalid = validTest(dupdi);
		System.out.println("Di Valid Test "+divalid);
		if(!divalid) {System.out.println("FALSE SORT FOUND"); break;}
		double dimergeCalTime = ((end-start)/1000.0);
		System.out.println("Di Calculation time = "+dimergeCalTime+"s\n");
		alldimergeCalTime += dimergeCalTime;

		System.out.println("ROT NUM "+allo);
		int[] dupco = new int[size];
		System.out.println("Comerge Sort...");
		duplicateArray(array, dupco);
		//printArray(dupco);
		start = System.currentTimeMillis();
		dupco = MergeSort.comergeSort(dupco);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupco);
		covalid = validTest(dupco);
		System.out.println("Co Valid Test "+covalid);
		if(!covalid) {System.out.println("FALSE SORT FOUND"); break;}
		double comergeCalTime = ((end-start)/1000.0);
		System.out.println("Co Calculation time = "+comergeCalTime+"s\n");
		allcomergeCalTime += comergeCalTime;
		
		System.out.println("ROT NUM "+allo);
		int[] dupqs = new int[size];
		System.out.println("Quick Sort...");
		duplicateArray(array, dupqs);
		//printArray(dupqs);
		start = System.currentTimeMillis();
		QuickSort.sort(dupqs, 0, dupqs.length-1);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(dupqs);
		qsvalid = validTest(dupqs);
		System.out.println("QS Valid Test "+qsvalid);
		if(!qsvalid) {System.out.println("FALSE SORT FOUND"); break;}
		double qsCalTime = ((end-start)/1000.0);
		System.out.println("QS Calculation time = "+qsCalTime+"s\n");
		allquickCalTime += qsCalTime;

		System.out.println("ROT NUM "+allo);
		int[] duphs = new int[size];
		System.out.println("Heap Sort...");
		duplicateArray(array, duphs);
		//printArray(duphs);
		start = System.currentTimeMillis();
		duphs = HeapSort.sort(duphs);
		end = System.currentTimeMillis();
		System.out.print("\nSorted:\n");
		//printArray(duphs);
		hsvalid = validTest(duphs);
		System.out.println("HS Valid Test "+hsvalid);
		if(!hsvalid) {System.out.println("FALSE SORT FOUND"); break;}
		double hsCalTime = ((end-start)/1000.0);
		System.out.println("HS Calculation time = "+hsCalTime+"s\n");
		allheapCalTime += hsCalTime;
		
}

		System.out.println("\n\n\n* * * * * STATS * * * * *\n");
		
		System.out.println("SS1 Valid Test "+ss1valid);
		System.out.println("SS2 Valid Test "+ss2valid);
		System.out.println("IS1 Valid Test "+is1valid);
		System.out.println("IS2 Valid Test "+is2valid);
		System.out.println("IS3 Valid Test "+is3valid);
		System.out.println("IS4 Valid Test "+is4valid);
		System.out.println("Di Valid Test "+divalid);
		System.out.println("Co Valid Test "+covalid);
		System.out.println("QS Valid Test "+qsvalid);
		System.out.println("HS Valid Test "+hsvalid);
		System.out.println("");
		System.out.println("SS1 Calculation time = "+allselect1CalTime+"s");
		System.out.println("SS2 Calculation time = "+allselect2CalTime+"s");
		System.out.println("");
		System.out.println("IS1 Calculation time = "+allinsert1CalTime+"s");
		System.out.println("IS2 Calculation time = "+allinsert2CalTime+"s");
		System.out.println("IS3 Calculation time = "+allinsert3CalTime+"s");
		System.out.println("IS4 Calculation time = "+allinsert4CalTime+"s");
		System.out.println("");
		System.out.println("Di Calculation time  = "+alldimergeCalTime+"s");
		System.out.println("Co Calculation time  = "+allcomergeCalTime+"s");
		System.out.println("");
		
		System.out.println("QS Calculation time = "+allquickCalTime+"s\n");
		System.out.println("HS Calculation time = "+allheapCalTime+"s\n");
		long realend = System.currentTimeMillis();
		double realTime = ((realend-realstart)/1000.0);
		System.out.println("Total time = "+realTime+"s\n");


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
			a[i] = r.nextInt(10000000);
	}

	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "]\t\t");
			if((i + 1) % 5 == 0) System.out.println();
		}
	}

	public static boolean validTest(int[] array)
	{
		boolean validity = true;
		if(array[0] < array[array.length-1])
		{
			for(int n = 1; n<array.length; n++)
			{
				if(array[n]<array[n-1])
					{validity = !validity; System.out.println("FALSE SORT FOUND AT "+n+"th array"); break;}
			}
		}

		if(array[0] > array[array.length-1])
		{
			for(int n = 1; n<array.length; n++)
			{
				if(array[n] > array[n-1]) {validity = !validity; System.out.println("FALSE SORT FOUND AT "+n+"th array"); break;}
			}
		}

		return validity;
	}
}
//end of the code