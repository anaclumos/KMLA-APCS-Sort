public class InsertionSort4
{//descending, sorting from high to low
	public static void sort(int[] a)
	{
		for(int index = a.length-1 ; index >=0 ; index--)
		{
			int temp = a[index];
			int standard = index + 1;
			while((standard < a.length) && ( a[standard] < temp))
			{
				a[standard-1] = a[standard];
				standard++;
			}
			a[standard - 1] = temp;
		}
	}
}