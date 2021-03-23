import java.util.Scanner;

public class ProvaPratica {
    static class QuickSort {
        /*
         * This function takes last element as pivot, places the pivot element at its
         * correct position in sorted array, and places all smaller (smaller than pivot)
         * to left of pivot and all greater elements to right of pivot
         */
        int partition(int arr[], int low, int high) {
            int pivot = arr[high];
            int i = (low - 1); // index of smaller element
            for (int j = low; j < high; j++) {
                // If current element is smaller than or
                // equal to pivot
                if (arr[j] <= pivot) {
                    i++;

                    // swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // swap arr[i+1] and arr[high] (or pivot)
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }

        /*
         * The main function that implements QuickSort() arr[] --> Array to be sorted,
         * low --> Starting index, high --> Ending index
         */
        int[] sort(int arr[], int low, int high) {
            if (low < high) {
                /*
                 * pi is partitioning index, arr[pi] is now at right place
                 */
                int pi = partition(arr, low, high);

                // Recursively sort elements before
                // partition and after partition
                sort(arr, low, pi - 1);
                sort(arr, pi + 1, high);
            }
            return arr;
        }
    }

    static int[] binarySearch(int arr[], int x) {
        int res[] = new int[2];
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] < x) {
                res[0] = arr[m];
                res[1] = m;

                return res;
            }

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return res;
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int qtd = leia.nextInt();
        int quadradonia[] = new int[qtd];
        int nlogonia[] = new int[qtd];
        int aux1[] = new int[qtd];
        int aux2[] = new int[qtd];

        for (int i = 0; i < qtd; i++) {
            aux1[i] = leia.nextInt();
        }

        for (int i = 0; i < qtd; i++) {
            aux2[i] = leia.nextInt();
        }

        QuickSort quick = new QuickSort();
        quadradonia = quick.sort(aux1, 0, aux1.length - 1);
        nlogonia = quick.sort(aux2, 0, aux2.length - 1);

        int cont = 0;
        int res[] = new int[2];
        for (int i = 0; i < qtd; i++) {
            res = binarySearch(quadradonia, nlogonia[i]);
            if (!(res[0] == 0 && res[1] == 0)) {
                quadradonia[res[1]] = nlogonia[i];
                // nlogonia[i] = -1;
                cont++;
                // quadradonia = quick.sort(quadradonia, 0, quadradonia.length - 1);
            }
        }

        System.out.println(cont);
    }
}
