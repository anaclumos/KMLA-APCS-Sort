/**
 * Priority queue.
 * 어떤 순서로 들어오든, priority가 높은 놈을 먼저 실행할 수 있음.
 * Queue는 들어오는 순으로 쌓이는 것.
 * Priority queue는 heap 같은 것.
 * Data 출입이 잦은 경우에 쓰면 유용하지 않을까?
 * Torrent에서도 priority queue가 쓰이고, 
 * OS에서도 쓰여. 몇 초 동안 작동하지 않는 놈들은 swap memory로 보내.
 * 우선순위가 떨어지는 놈들을 swap file로 dump해버려.
 */

//import java.util.Arrays;

public class Heap
{
	private int[] elementData;
	private int elementCount = 0;
	private static final int ROOT_INDEX = 1;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int[] EMPTY_LIST = {};


	public Heap()
	{
		this(DEFAULT_CAPACITY);
	}

	public Heap(int initialCapacity)
	{
		if(initialCapacity > 0)
			elementData = new int[initialCapacity];
		else if(initialCapacity == 0)
			elementData = EMPTY_LIST;
		else
			throw new IllegalArgumentException("Illegal Capacity: " + 
												initialCapacity);
	}

	public void add(int element)
	{
		if(elementCount == elementData.length - 1)
		{
			int[] temporaryData = new int[elementData.length * 2];
			for(int i = 0; i < elementData.length; i++)
				temporaryData[i] = elementData[i];
			elementData = temporaryData;
		}

		elementData[++elementCount] = element;

		int tracker = elementCount;
		while(tracker > 1 && elementData[tracker / 2] > elementData[tracker])
		{
			swap(tracker / 2, tracker);
			tracker /= 2;
		}
	}

	
	public Integer removeRoot()
	{
		int removed = elementData[ROOT_INDEX];
		elementData[ROOT_INDEX] = elementData[elementCount--];

		// downheap
		int currentIndex = ROOT_INDEX;
		while(currentIndex * 2 <= elementCount)
		{
			if(currentIndex * 2 + 1 <= elementCount)
			{
				int smallerIndex = elementData[currentIndex * 2] 
				> elementData[currentIndex * 2 + 1] ? currentIndex * 2 + 1 
				: currentIndex * 2;
				swap(currentIndex, smallerIndex);
				currentIndex = smallerIndex;
			}
			else
			{
				swap(currentIndex, currentIndex * 2);
				currentIndex = currentIndex * 2;
			}
		}
		return removed;
	}

	public boolean isEmpty()
	{
		return elementCount == 0 ? true : false;
	}

	public void swap(int index1, int index2)
	{
		int temporary = elementData[index1];
		elementData[index1] = elementData[index2];
		elementData[index2] = temporary;
	}
}