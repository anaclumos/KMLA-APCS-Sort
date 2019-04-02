public class InsertionSort2
{//ascending, sorting from high to low
	public static void sort(int[] a)
	{
		for(int index = 1 ; index < a.length ; index++)
		{
			int temp = a[index];
			int standard = index - 1;
			while((standard >= 0) && ( a[standard] < temp))
			{
				a[standard+1] = a[standard];
				standard--;
			}
			a[standard + 1] = temp;
		}
	}
}