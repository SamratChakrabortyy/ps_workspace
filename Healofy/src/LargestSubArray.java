import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers xs
 * Find the largest subarray that contains at most n distinct numbers (n will be given as input)
 * Return the start and end indexes of the subarray.
 *
 *   xs := []int{ -1, 2, -1, -1, 5, 5, 20 , 20, 20 , 20 , 20 , 7}
 *   // f(2) = 0 1
 *   // f(3) = 3 6
 *   // f(4) = 1 6
 *          0       1       2       3       4      5        6      7       8      9       10      11
 *          -1      2       -1      -1      5       5       20     20      20      20      20      7
 *                          l                                                               r
 *
 *    n = 3
 *
 *    ans -> {0, 5}
 *    max = 5
 *
 *   {
 *      -1 -> 2
 *       5 -> 2
 *       20 -> 1
 *   }
 */

public class LargestSubArray {

    public static void main(String[] args) {
        //             l                   r
        //int[] arr = { -1, 2, -1, -1, 5, 5, 20 , 20, 20 , 20 , 20 , 5, 20, 5, 7};
        int[] arr = {1 ,1 ,1 ,2 ,2 ,3 ,4  ,4  ,3 ,2 ,3 ,4 ,4 ,1 ,1 ,1 ,3 ,3 ,2};

        System.out.println(largestSubArray(arr, 2));
        System.out.println(largestSubArray(arr, 3));
        System.out.println(largestSubArray(arr, 4));
        System.out.println(largestSubArray(arr, 5));
        System.out.println(largestSubArray(arr, 6));
    }


    public static Pair largestSubArray(int[] arr, int n) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        int l = 0, r = 0, max = -1, length = arr.length;

        Pair ans = new Pair(0, length - 1);

        while(l <= r && r < length) {
           int freq = freqMap.getOrDefault(arr[r], 0);
           freqMap.put(arr[r], freq + 1);
           if(freqMap.size() > n){
               int len = r - l - 1;
               if(len > max) {
                   max = len;
                   ans = new Pair(l, r-1);
               }
               for(; l <= r && freqMap.size() > n; l++) {
                   freq = freqMap.getOrDefault(arr[l], 1);
                   if(freq == 1) {
                       freqMap.remove(arr[l]);
                   } else {
                       freqMap.put(arr[l], freq - 1);
                   }
               }
           }
           r++;
        }
        return ans;
    }

}

class Pair {
    private final int first;
    private final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
