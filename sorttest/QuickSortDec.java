public class QuickSortDec extends QuickSort
{
    public static double EPSILON = 10e-15;
    public static void main(String[] args)
    {
    	
        double[] b = {3.3, 7.43, 4.1, 5.5, 1.24, 7.26, 8.3425, 9.35, 3, 5, 1, 4, 23, 13};
        System.out.print("Original:\n");
        printArray(b);
        sortDec(b, 0, b.length-1);
        System.out.print("\nSorted:\n");
        printArray(b);
    }

    public static void sortDec(double[] array, int left, int right)
    {
		int atemp, btemp;
		double pivot, tempo;

        if (left < right)
        {
            atemp = left;
            btemp = right;
            pivot = array[left];

            while (atemp < btemp)
            {
                while (array[btemp] > pivot)
                    {btemp--;}
                while (atemp < btemp && (Math.abs(pivot-array[atemp])<EPSILON || pivot-array[atemp]>0))
                    {atemp++;}
                    tempo = array[atemp];
                    array[atemp] = array[btemp];
                    array[btemp] = tempo;
            }
                    array[left] = array[atemp];
                    array[atemp] = pivot;

				sortDec(array, left, atemp - 1);
				sortDec(array, atemp + 1, right);
        }
    }

    public static void printArray(double[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print("[" + i + "," + a[i] + "] ");
            if((i + 1) % 5 == 0) System.out.println();
        }
    }
}