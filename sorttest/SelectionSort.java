public class SelectionSort
{
	public static void sort(int[] a)
	{
		int n = a.length;

		for(int i = 0; i < n - 1; i++)
		{
			int lowest = i;
			int lowkey = a[i];

			for(int j = i + 1; j < n; j++)
			{
				if(a[j] < lowkey)
				{
					lowest = j;
					lowkey = a[j];
				}

			}
			int temp = lowest;
			int tempkey = a[i];
			a[i] = lowkey;
			a[temp] = tempkey;

			//System.out.println("Round "+i+" over: lowest " + temp+", lowkey "+a[i]);
			//System.out.println("Chap "+i+" Finished\n");
		}
	}
}
