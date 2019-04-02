/**
 * Heapsort를 하기 위해서는 heap이라는 데이터 구조를 알아야 해.
 * 다양한 데이터 구조가 있어. Array, list, binary tree search 등.
 * Binary tree search는 다음과 같이 작동해.
 * Linear Linked List를 보면 self referential한 데이터였어. 자기 뒷 놈.
 * 얘도 비슷한데, 두 개를 가져. Left child, right child.
 * t -> root -> left child node
 *           \> right child node. 일단 null이겠지?
 * 두 번째 data가 들어오면, root와 비교를 해. 작은 건 왼쪽으로, 큰 건 오른쪽으로.
 * equal은 한 쪽에만 붙으면 돼. Right child node로 갔는데 null이면 저장.
 * t -> 5 ->
 *   \> 3 ->
 *        \>
 * 그 뒤에 7이 들어왔어. 5보다 크네.
 * t -> 5 -> 7 ->
 *  \    \     \>
 *   \    \>
 *    \> 3 ->      
 *         \>
 * 4가 들어가면?
 * t -> 5 -> 7 ->
 *  \    \     \>
 *   \    \>
 *    \> 3 -> 4 ->
 *        \     \>    
 *         \>
 *
 * 이런 식으로 반복하다보면 sorting이 되어있어.
 * 왼쪽, 자기 자신, 오른쪽 순으로 꺼내는 recursion을 구현하면 sorting이 돼.
 * 왼쪽 node가 있으면 항상 우선이고, 그 뒤 자기 자신을 읽고, 그 뒤 오른쪽 node를 읽어.
 * 중복을 허용하면 각각의 수에 있어서 number of occurance를 지정할 수 있겠지?
 * 그게 싫으면 왼쪽이나 오른쪽으로 보내든지.
 * Balance가 잘 맞을 수도 있지만, 한 쪽으로 몰릴 수 있어. Skewed tree.
 * 이걸 해결하기 위한 red-black tree도 있어.
 */

public class HeapSort
{
	public static long sort(int[] a)
	{
		long startTime = System.currentTimeMillis();

		Heap b = new Heap();

		for(int i = 0; i < a.length; i++)
			b.add(a[i]);

		int indexOfA = 0;
		while(!b.isEmpty())
		{
			a[indexOfA++] = b.removeRoot();
		}

		return System.currentTimeMillis() - startTime;
	}
}