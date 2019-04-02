import java.util.Arrays;

public class SearchTest
{
	public static void main(String[] args)
	{
		int[] a = new int[20];

		for(int i = 0; i < a.length; i++)
			a[i] = (int)(Math.random() * 100 + 1);

		int[] b = Arrays.copyOf(a, a.length);

		SelectionSort.sort(b);


		System.out.println(SequentialSearch.isSorted(a, b));



	}
}