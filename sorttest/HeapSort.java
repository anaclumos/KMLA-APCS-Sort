public class HeapSort
{

	public static void main(String[] args)
	{
		int[] a = {99, 1, 3, 5, 2, 3, 6, 2, 1, 32, 52};
		printArray(a);
		a = sort(a);
		printArray(a);
	}

	public static int[] sort(int[] array)
	{
		int temp;
		int arraytrv = array.length-1;
		do{
			downHeap(array,arraytrv);
			temp = array[arraytrv];
			array[arraytrv] = array[0];
			array[0] = temp;
			arraytrv--;
		}while(arraytrv != -1);

		return array;
	}

	public static void downHeap(int[] array, int arraytrv)
	{
		boolean changed;
		while(true){
			changed = false;
			int temp;
			for(int tr = 0; tr <= arraytrv; tr++)
			{

				if(array[tr]>array[tr/2])
				{
					//System.out.println(tr+"번째의 원소(실제 값:"+array[tr]+")과 "+tr/2+"번째 원소(실제 값:"+array[tr/2]+")이 바뀜.");
					temp = array[tr];
					array[tr] = array[tr/2];
					array[tr/2] = temp;
					changed = true;
					//printArray(array);
				}
			}
			if(!changed) break;
		}
	}

	 public static void printArray(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print("[" + i + "," + a[i] + "]   ");
        }
        System.out.println();
    }
}