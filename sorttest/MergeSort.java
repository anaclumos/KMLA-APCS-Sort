public class MergeSort
{
	public static int[] dimergeSort(int[] array)
	{
		int[][] a = new int[array.length][1];
		for(int d = 0; d < array.length; d++)
		{
			a[d][0] = array[d];
		}

		while(true)
		{
			int[][] b = new int[a.length/2][array.length*2/a.length];
			for(int a1 = 0; a1 < b.length; a1++)
			{
				b[a1] = dimerge(a[2*a1],a[2*a1+1]);
			}
			a=b;
			if(a[0].length == array.length) break; // ERROR!
		}
		//printArray(a[0]);
		return a[0];
	}

	public static int[] comergeSort(int[] array)
	{
		int[][] a = new int[array.length][1];
		for(int d = 0; d < array.length; d++)
		{
			a[d][0] = array[d];
		}

		while(true)
		{
			int[][] b = new int[a.length/2][array.length*2/a.length];
			for(int a1 = 0; a1 < b.length; a1++)
			{
				b[a1] = comerge(a[2*a1],a[2*a1+1]);
			}
			a=b;
			if(a[0].length == array.length) break;
		}
		//printArray(a[0]);
		return a[0];
	}

	public static int[] dimerge(int[] a, int[] b)
	{
		int[] ab = new int[a.length + b.length];
		int aindex = 0; boolean adeplete = false;
		int bindex = 0; boolean bdeplete = false;
		int temp = 0;

		while(true)
		{
			//System.out.println("aindex: ["+aindex+","+a[aindex]+"], bindex: ["+bindex+","+b[bindex]+"]");
			//System.out.println("adeplete: "+adeplete+"\nbdeplete: "+bdeplete);

			if(a[aindex] >= b[bindex] && !bdeplete && !adeplete)
				{
					//System.out.println("1 initiated: b is smaller");
					ab[temp] = b[bindex];
					//System.out.println("input ab[" + (temp) + "," + ab[temp] + "]\n");
					if(bindex==b.length-1) {bdeplete = true; temp++;}
					else {bindex++; temp++;}
					continue;
				}

			if(a[aindex] < b[bindex] && !adeplete && !bdeplete)
				{
					//System.out.println("2 initiated: a is smaller");
					ab[temp] = a[aindex];
					//System.out.println("input ab[" + (temp) + "," + ab[temp] + "]\n");
					if(aindex==a.length-1) {adeplete = true; temp++;}
					else {temp++; aindex++;}
					continue;
				}

			if(adeplete != bdeplete)
			{
				if(adeplete) 
					{
						//System.out.println("3 initiated: a delpeted");
						ab[temp] = b[bindex];
						//System.out.println("input ab[" + (temp) + "," + ab[temp] + "]\n");
						if(bindex==b.length-1) {bdeplete = true; temp++;} 
						else {bindex++; temp++;}
						continue;
					}

				if(bdeplete)
					{
						//System.out.println("4 initiated: b depleted");
						ab[temp] = a[aindex];
						//System.out.println("input ab[" + (temp) + "," + ab[temp] + "]\n");
						if(aindex==a.length-1) {adeplete = true; temp++;}
						else {aindex++; temp++;}
						continue;
					}
			}

			if(adeplete && bdeplete) {/*System.out.println("BREAK");*/ break;}
		}

		return ab;
	}

	public static int[] comerge(int[] a, int[] b)
	{
		int[] ab = new int[a.length + b.length];
		int[] abtemp = new int[a.length + b.length];

		for(int i = 0; i < a.length; i++)
		{
			abtemp[i] = a[i];
		}

		for(int k = 0; k < b.length; k++)
		{
			abtemp[ab.length-1-k] = b[k];
		}

		int aindex = 0;
		int bindex = abtemp.length-1; 
		int temp = 0;

		while(true)
		{
			//System.out.println("aindex: ["+aindex+","+abtemp[aindex]+"], bindex: ["+bindex+","+abtemp[bindex]+"]");
			if(aindex == bindex) {ab[temp] = abtemp[bindex]; /*System.out.println("BREAK");*/ break;}

			if(abtemp[aindex] >= abtemp[bindex])
				{
					//System.out.println("1 initiated: b is smaller");
					ab[temp] = abtemp[bindex];
					//System.out.println("input ab[" + (temp) + "," + ab[temp] + "]\n");
					bindex--;
					temp++;
					continue;
				}

			if(abtemp[aindex] < abtemp[bindex])
				{
					//System.out.println("2 initiated: a is smaller");
					ab[temp] = abtemp[aindex];
					//System.out.println("input ab[" + (temp) + "," + ab[temp] + "]\n");
					aindex++;
					temp++;
					continue;
				}
		}

		return ab;
	}

	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[" + i + "," + a[i] + "]");
			if((i + 1) % 10 == 0) System.out.println();
		}
		System.out.println("");
	}
}