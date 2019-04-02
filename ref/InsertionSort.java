/**
* 정렬된 부분과 그렇지 않은 부분을 구분한다!
* ListNode를 사용하면 훨씬 효율적으로 만들 수 있을 것 같은데?
* 한 칸씩 다 shift하지 않아도 되니까.
* 다만 overhead가 걸려. (화살표, nextNode같은 것들이 있어야 함.)
*
* 아무튼 방법이 여러가지로 갈림.
* 우선 ascending하는 방향으로 sorting할지, descending하는 방향으로 sorting할지 결정.
* 계속해서 swap할지, 위치 찾아서 한 번에 shift할지. 속도는 같음.
* Big-O analysis해보면, n * n / 2 해서 O(n^2).
* 이미 정렬되어있으면 가장 빠르고, 내림차순으로 되어있으면 가장 느림.
*/
public class InsertionSort
{
	// swapping method
	public static long sort(int[] a)
	{
		long startTime = System.currentTimeMillis();

		for(int i = 1; i < a.length; i++)
		{
			int currentIndex = i;
			while(currentIndex != 0 && a[currentIndex] < a[currentIndex - 1])
			{
				int temporary = a[currentIndex];
				a[currentIndex] = a[--currentIndex];
				a[currentIndex] = temporary;
			}
		}

		return System.currentTimeMillis() - startTime;
	}

	// shifting method
	public static void sort2(int[] a)
	{
		for(int i = 1; i < a.length; i++)
		{
			int inserted = a[i];
			int currentIndex = i;

			while(currentIndex != 0 && inserted < a[currentIndex - 1])
				a[currentIndex] = a[--currentIndex];

			a[currentIndex] = inserted;
		}
	}


}