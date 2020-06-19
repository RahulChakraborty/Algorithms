/**
 * Created by rahulchakraborty on 8/14/16.
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if((m+n)%2==0){
            return (
                    findKth((m+n)/2,    nums1, 0,  nums2, 0) +
                            findKth((m+n)/2+1,  nums1, 0, nums2, 0)
            )/2.0;
        }else{
            return findKth((m+n)/2+1, nums1, 0, nums2, 0);
        }
    }

    //k starts with 1
    public static int findKth(int k, int [] A, int aStart, int[] B, int bStart){
        if(aStart>=A.length){
            return B[bStart+k-1];
        }
        if(bStart>=B.length){
            return A[aStart+k-1];
        }
        if(k==1)
            return Math.min(A[aStart], B[bStart]);

        int aMid = aStart+k/2-1;
        int bMid = bStart+k/2-1;

        int aValue = aMid<A.length?A[aMid]:Integer.MAX_VALUE;
        int bValue = bMid<B.length?B[bMid]:Integer.MAX_VALUE;

        if(aValue<bValue){
            return findKth(k-k/2, A, aMid+1, B, bStart);
        }else{
            return findKth(k-k/2, A, aStart, B, bMid+1);
        }

    }

    public static void main(String[] args){
        int [] a={2,3,4,5};
        int [] b={0,1,2,6,7};
        System.out.println(findMedianSortedArrays(a,b));

    }
}
