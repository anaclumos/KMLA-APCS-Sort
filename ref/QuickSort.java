/**
 * 일반적인 상황에서 가장 빠른 소팅 알고리즘.
 * O(n)짜리도 있지만, constraint가 있어.
 * 어떤 놈을 pivot으로 사용할지는 마음대로. 앞, 가운데, 끝 중 하나 대충.
 * Pivot을 final 위치로 보낸다! 앞에 있는 모든 element는 pivot보다 작거나 같고,
 * 뒤에 있는 모든 element는 pivot보다 크거나 같다!
 * 이를 recursive하게 짜면 되겠지?
 * Final position에 위치하게 하는 logic만 구현하면 되겠다.
 * 두 개의 index가 각각 1(왜냐하면 0이 pivot이거든), 끝에서 시작하고 좁혀와.
 * Pivot을 중심으로, 왼쪽에서 pivot보다 작은 놈을, 오른쪽에서 pivot보다 큰 놈을 찾을 수 있겠지.
 * 두 개 바꾸면 되겠지? 두 index가 겹칠 때까지 반복.
 * Index가 겹치는 순간, 그 index의 값이 pivot보다 크면, 바로 그 앞에 있는 애랑 pivot swap.
 * pivot보다 작거나 같으면 걔와 pivot swap.
 * Best case: O(nlogn)
 * Worst case: O(n^2)
 */

public class QuickSort
{
	public static long sort(int[] a)
	{
		long startTime = System.currentTimeMillis();

		quicksort(a, 0, a.length - 1);

		return System.currentTimeMillis() - startTime;
	}

	public static void quicksort(int[] a, int start, int end)
	{
		if(start >= end) return;

		int pivot = a[end];
		int divider = start;

		for(int i = start; i < end; i++) 
			if(a[i] < pivot) 
				swap(a, divider++, i);

		swap(a, divider, end);
		quicksort(a, start, divider - 1);
		quicksort(a, divider + 1, end);
	}

	 // in Hungarian folk dance version
	public static void quicksort(int[] a, int start, int end)
	{
		if(start >= end) return;
		int pivot = a[start];

		int i = start + 1;
		int j = end;

		while(i != j)
		{
			while(i != j && a[j] > pivot)
				j--;
			while(i != j && a[i] < pivot)
				i++;
			swap(a, i, j);
		}
		if(a[i] > pivot) swap(a, --i, start);
		else swap(a, i, start);
		quicksort(a, start, i - 1);
		quicksort(a, i + 1, end);
	}
	//*/

	public static void swap(int[] a, int p, int q)
	{
		int temp = a[p];
		a[p] = a[q];
		a[q] = temp;
	}
}