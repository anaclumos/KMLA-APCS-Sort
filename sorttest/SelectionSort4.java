public class SelectionSort4
{ //descending, sorting from high to low
	public static void sort(int[] a)
	{
		int n = a.length;

		for(int i = n-1; i >= 0; i--)
		{
			int highest = i;
			int highkey = a[i];

			for(int j = i - 1; j >= 0; j--)
			{
				if(a[j] > highkey)
				{
					highest = j;
					highkey = a[j];
				}

			}
			int temp = highest;
			int tempkey = a[i];
			a[i] = highkey;
			a[temp] = tempkey;

			//System.out.println("Round "+i+" over: highest " + temp+", highkey "+a[i]);
		}
	}
}
