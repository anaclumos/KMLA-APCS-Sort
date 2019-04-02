/**
* 관심 있는 부분에서 가장 작은 놈을 최종 위치로 보낸다!
* Best case, worst case 속도 n * n / 2로 일정.
*/
public class SelectionSort
{
	public static long sort(int[] a)
	{
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < a.length - 1; i++)
		{
			int maxIndex = i;
			int maxValue = a[i];

			for(int j = i + 1; j < a.length; j++)
			{
				if(a[j] < maxValue)
				{
					maxIndex = j;
					maxValue = a[j];
				}
			}

			a[maxIndex] = a[i];
			a[i] = maxValue;
		}

		return System.currentTimeMillis() - startTime;
	}
}