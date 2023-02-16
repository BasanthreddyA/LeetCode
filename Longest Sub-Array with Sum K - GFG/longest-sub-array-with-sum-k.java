//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        Map<Integer,Integer> mp=new HashMap<>();
        int maxi=Integer.MIN_VALUE,sum=0;
        
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            
            if(sum==K){
                maxi=Math.max(maxi,i+1);
            }
            
            int required=sum-K;
            
            if(mp.containsKey(required)){
                
                maxi=Math.max(maxi,(i-mp.get(required)));
            }
            if(!mp.containsKey(sum)){
            mp.put(sum,i);
            }
            
        }
        
        if(maxi==Integer.MIN_VALUE){
            return 0;
        }
        
    //}
     /* int sum=0;
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(sum==K) max=Math.max(max,i+1);
            if(hm.containsKey(sum-K)) max=Math.max(max,(i-hm.get(sum-K)));
            if(!hm.containsKey(sum)) hm.put(sum,i);
        }
        if (max == Integer.MIN_VALUE){
            return 0;
        }
        return max;*/
        return maxi;
    }
    
    
}


