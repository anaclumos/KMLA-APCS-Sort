/**
 * Big-O analysis: O(nlogn).
 * 쪼개는 건 logn.
 * 그 뒤 step은 각각 n씩.
 * 따라서 nlogn
 * 쪼개진 두 개 중 하나를 뒤집어서 양 끝을 index로 둔 뒤,
 * 두 index가 만날 때까지 하는 방법도 있어.
 * 다 나눠놓고 올라오기 때문에 stacking되는 부분이 있어.
 */

public class MergeSort
{
	static int[] b;

	public static long sort(int[] a)
	{
		long startTime = System.currentTimeMillis();

		int length = a.length;
		b = new int[length];
		divide(a, 0, length - 1);

		return System.currentTimeMillis() - startTime;
	}

	public static void divide(int[] a, int start, int end)
	{
		if(start >= end) return;
		int mid = (start + end) / 2;
		divide(a, start, mid);
		divide(a, mid + 1, end);
		merge(a, start, end);
	}

	public static void merge(int[] a, int start, int end)
	{
		for(int i = start; i <= end; i++)
			b[i] = a[i];
		int mid = (start + end) / 2;

		int i = start; int j = mid + 1;
		int k = start;

		while(i <= mid && j <= end)
		{
			if(b[i] > b[j])
				a[k++] = b[j++];
			else
				a[k++] = b[i++];
		}

		while(i <= mid)
			a[k++] = b[i++];
	}

	/* //Optional way; half reversal.
	public static void merge(int[] a, int start, int end)
	{
		int mid = (start + end) / 2;

		for(int i = start; i <= mid; i++)
			b[i] = a[i];
		for(int i = mid + 1, j = end; i <= end; i++, j--)
			b[i] = a[j];


		int i = start; int j = end;
		int k = start;

		while(i <= j)
		{
			if(b[i] > b[j])
				a[k++] = b[j--];
			else
				a[k++] = b[i++];
		}
	}
	//*/
}