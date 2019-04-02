public class QuickSort
{
    public static void main(String[] args)
    {
    	//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        int[] b = {3, 7, 4, 5, 1, 7, 8, 9, 3, 5, 1, 4, 23, 13};
        //printArray(b);
        sort(b, 0, b.length-1);
        //printArray(b);
        validTest(b);
    }

    public static void sort(int[] array, int left, int right)
    {
		int atemp;
		int btemp;
		int pivot;
		int tempo;

        if (left < right)
        {
            atemp = left;
            btemp = right;
            pivot = array[left];

        	//System.out.println(left+" is left, "+right+" is right, value "+ array[left] +" is pivot");
   			//System.out.println("atemp is " + atemp);
        	//System.out.println("btemp is " + btemp);


            while (atemp < btemp)
            {
                while (array[btemp] > pivot) 
                	{btemp--; 
                		//System.out.print("btemp decreased to "+ btemp + " Array: "); //printArray(array);
                	}
                while (atemp < btemp && array[atemp] <= pivot) 
                	{atemp++; 
                		//System.out.print("atemp increased to "+ atemp + " Array: "); //printArray(array);
                	}

                 //System.out.println("array[atemp] " + array[atemp] + " and array[btemp] " + array[btemp]+" changed");
                 tempo = array[atemp];
                 array[atemp] = array[btemp];
                 array[btemp] = tempo;

            }
            	//System.out.println("array[left] is array["+left+"], and it's " + array[left]);
            	//System.out.println("array[atemp] is array["+atemp+"], and it's " + array[atemp]);
				//System.out.println("atemp is " + atemp);
				//System.out.println("btemp is " + btemp);
				//System.out.println("pivot is " + pivot);
				array[left] = array[atemp];
				array[atemp] = pivot;

				//System.out.println("\n\n");

				sort(array, left, atemp - 1);
				sort(array, atemp + 1, right);
        }

        else {
        //System.out.println(left+" is left, "+right+" is right, value ");
        //printArray(array);
        //System.out.println("But nothing happened\n");
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


    public static boolean validTest(int[] array)
    {
        boolean validity = true;
        if(array[0] < array[array.length-1])
        {
            for(int n = 1; n<array.length; n++)
            {
                if(array[n]<array[n-1])
                    {validity = !validity;
                    	System.out.println("FALSE SORT FOUND AT "+n+"th array"); break;
                    }
            }
        }

        if(array[0] > array[array.length-1])
        {
            for(int n = 1; n<array.length; n++)
            {
                if(array[n] > array[n-1]) {
                	validity = !validity; 
                	//System.out.println("FALSE SORT FOUND AT "+n+"th array"); 
                	break;}
            }
        }

        //System.out.println("Validity Test "+validity);
        return validity;
    }
}