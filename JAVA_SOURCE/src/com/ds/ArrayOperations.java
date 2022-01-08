package com.ds;

public class ArrayOperations {
	
//	second Largest element
	int secondLargestElement(int a[],int n) {
		int largest=0,res=-1;
		for(int i=1;i<n;i++)
		{
			if(a[i]>a[largest]) {
				res=largest;
				largest=i;
			}
			else {
				if(a[i]!=a[largest]) {
					if(res==-1 || a[res]<a[i]) {
						res=i;
					}
				}	
			}
		}
		return res;
	}
//	sorted array
	
	boolean sortedAsc(int a[],int n) {
		for(int i=0;i<n-1;i++) {
			if(a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	
//	reverse of an array
	void reverseArr(int a[],int n) {

		int low=0,high=n-1;
		while(low<high) {
			int temp=a[low];
			a[low]=a[high];
			a[high]=temp;
			low++;
			high--;
		}
		display(a,a.length);
	}
	
	void display(int a[],int n) {
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+"|");
		}
	}
	
//	remove duplicate from a sorted array
	int removeDup(int a[],int n) {
		int size=1;
		for(int i=1;i<n;i++) {
			if(a[i]!=a[size-1]) {
				a[size]=a[i];
				size++;
			}
		}
		return size;	
	}
	
//	move zeroes to the end
	void moveZeroToEnd(int a[],int n) {
		int count=0;
		for(int i=0;i<n;i++) {
			if(a[i]!=0) {
				int temp=a[i];
				a[i]=a[count];
				a[count]=temp;
				count++;
			}
		}
		display(a,a.length);
	}
	
//	left rotation of array
	void leftRotation(int a[],int n) {
		int fEle=a[0],i;
		for(i=0;i<n-1;i++) {
			a[i]=a[i+1];
		}
		a[i]=fEle;
		display(a,a.length);
	}
	
	void reverse(int a[],int low,int high) {
		while(low<high) {
			int temp=a[low];
			a[low]=a[high];
			a[high]=temp;
			low++;
			high--;
		}
	}
	
//	left rotation by d places of an array
	void leftRotationByd(int a[],int n,int d) {
		
		reverse(a,0,d-1);
		reverse(a,d,n-1);
		reverse(a,0,n-1);
		display(a,a.length);
	}
	
//leader in an array
	void leader(int a[],int n) {
		int leader=n-1;
		System.out.print(a[leader]+" ");
		for(int i=n-2;i>=0;i--) {
			if(a[i]>a[leader]) {
				System.out.print(a[i]+" ");
				leader=i;
			}
		}
	}
//max difference
	int maxDiff(int a[],int n) {
		int maxDiff=a[1]-a[0],min=a[0];
		for(int i=1;i<n;i++) {
			maxDiff=(a[i]-min)>maxDiff ?(a[i]-min):maxDiff;
			min=a[i]<min?a[i]:min;
		}
		return maxDiff;
	}
	
//	frequencies in a sorted array
	
	void countFreq(int a[],int n){
		int freq=1,i;
		for(i=0;i<n-1;i++) {
			if(a[i+1]==a[i]) {
				freq++;
			}
			else {
				System.out.println(a[i]+" "+freq);
				freq=1;
			}
		}
		if(a[i]!=a[i-1]) {
			System.out.println(a[i]+" 1");
		}
		else {
			System.out.println(a[i]+" "+freq);
		}	
	}
	
//	buy stocks and sells problem
	int buyStockAndSell(int a[],int n) {
		
		if(n<=1) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		int maxProfit=0;
		for(int i=0;i<n;i++) {
			if(a[i]<min) {
				min=a[i];
			}
			if(maxProfit<a[i]-min) {
				maxProfit=a[i]-min;
			}
		}
		return maxProfit;
	}
	
//	buy stock and sell multiple times
	int buyStockAndSell2(int a[],int n) {
		int profit=0;
		for(int i=1;i<n;i++) {
			if(a[i]>a[i-1]) {
				profit+=a[i]-a[i-1];
			}
		}
		return profit;
	}
	
//	trapping rain water
	int trappingRainWater(int a[],int n) {
		int res=0;
		int lmax[]=new int[n];
		int rmax[]=new int[n];
		lmax[0]=a[0];
		for(int i=1;i<n;i++) {
			if(a[i]>lmax[i-1]) {
				lmax[i]=a[i];
			}
			else {
				lmax[i]=lmax[i-1];
			}
		}
		rmax[n-1]=a[n-1];
		for(int i=n-2;i>=0;i--) {
			if(a[i]>rmax[i+1]) {
				rmax[i]=a[i];
			}
			else {
				rmax[i]=rmax[i+1];
			}
		}
		for(int i=1;i<n-1;i++) {
			int min=(lmax[i]<rmax[i])?lmax[i]:rmax[i];
			res+=min-a[i];
		}
		return res;
	}
	
	//maximum consequtive 1s
	int maxConseq1(int a[],int n) {
		int i,res=0,count=0;
		for(i=0;i<n;i++) {
			if(a[i]!=0) {
				count++;
			}
			if(a[i]==0 || (i==n-1 && a[i]==1)){
				res=count>res?count:res;
				count=0;
			}
		}
		return res;
	}

//	maximum subarray sum
	int maxSubarray(int a[],int n) {
		int sum=0,maxSum=a[0];
		for(int i=0;i<n;i++) {
			sum+=a[i];
			
			maxSum=(maxSum>sum)?maxSum:sum;
			if(sum<0) sum=0;
		}
		return maxSum;
	}
	
//	max length of even odd subarray 
	int maxEvenOddSubarray(int a[],int n) {
		int max=1,count=1;
		for(int i=0;i<n-1;i++) {
			if((a[i]%2==0 && a[i+1]%2==1) ||
				(a[i]%2==1 && a[i+1]%2==0))
			{
				count++;
				if(count>max)max=count;
			}
			else 
				count=1;
		}
		return max;
	}
	
//	max circular sum subarray
	int maxCircularSumSubArray(int a[],int n) {
		//finding out the max sum of normal subarray using kadane's
		int sum=0,max=a[0],totalSum=0,maxCircular;
		for(int i=0;i<n;i++) {
			totalSum+=a[i];
			sum+=a[i];
			if(max<sum)max=sum;
			if(sum<0)sum=0;
		}
		//finding out the min sum of normal subarray using kadane's
		int min=a[0];
		sum=0;
		for(int i=0;i<n;i++) {
			sum+=a[i];
			if(min>sum)min=sum;
			if(sum>0)sum=0;
		}
//		finding out the max circular sum
		int circularSum=totalSum-min;
		return maxCircular=(circularSum>max?circularSum:max);
	}
	
//	index of majority element
	int majorityEle(int a[],int n) {
		int ansIndex=0,count=1;
		for(int i=1;i<n;i++) {
			if(a[i]==a[ansIndex])
				count++;
			else
				count--;
			if(count==0) {
				ansIndex=i;
				count=1;
			}
		}
		int majorityEle=a[ansIndex];
		count=0;
		for(int i=0;i<n;i++) {
			if(a[i]==majorityEle)
				count++;
		}
		if(count>n/2)
			return ansIndex;
		return -1;
	}
	
	void minConseqFlips(int a[],int n) {
		for(int i=1;i<n;i++) {
			if(a[i]!=a[i-1]) {
				if(a[i]!=a[0]) {
					System.out.print("from "+i);
				}
				else {
					System.out.print(" to "+(i-1));
					System.out.println();
				}

			}
		}
		if(a[n-1]!=a[0])
			System.out.print(" to "+(n-1));
		}
	
//	sliding window technique
	
//	sliding window type:1>Q.1> whether a sum present in a subarray(in a window of given size k)
	boolean sumPresentInSubArray(int a[],int n,int k,int sum) {
		int i=0,j=0,curr_sum=0;
		while(j<n) {
			curr_sum+=a[j];
			if((j-i+1)<k) {
				
				j++;
			}
			else if((j-i+1)==k) {
				if(curr_sum==sum) 
					return true;
				curr_sum-=a[i];
				j++;
				i++;
			}
		}
		return false;
	}
	
//	sliding window type:1>Q.2>max sum present in a subarray(in a window of given size k)
	int maxSumInSubarray(int a[],int n,int k) {
		int i=0,j=0,sum=0,max_sum=Integer.MIN_VALUE;
		while(j<n) {
			sum+=a[j];
			if((j-i+1)<k) {
				j++;
			}
			else if((j-i+1)==k) {
				if(sum>max_sum)max_sum=sum;
				sum-=a[i];
				i++;
				j++;
			}
		}
		return max_sum;	
	}

	//	sliding window type:2>Q.3>find if there's a subarray with given sum(when window size isn't given)
	boolean subarrayWithGivenSum(int a[],int n,int sum) {
		int i=0,j=0,curr_sum=0;
		while(i<n) {
			if((curr_sum<sum)&& j>=n) {
				return false;
			}
			if((curr_sum<sum)&& j<n) {
				curr_sum+=a[j];
//				System.out.println(" inside 1st cond. curr_sum="+curr_sum);
				j++;
			}
			else if(curr_sum>sum) {
				curr_sum-=a[i];
				i++;
			}
			else if(curr_sum==sum)
				return true;
//			System.out.println(" at end of while curr_sum="+curr_sum);
		}
		return false;
	}
	
//	sliding window type:1>Q.4>n-bonacci series
	void NbonacciNumbers(int m,int n) {
		int i=1,j=1,curr_sum=0;
		int a[]=new int[m];
		for(int in=0;in<m;in++) {
			a[in]=0;
		}
		a[n-1]=1;
		a[n]=1;
		while(j<m-1) {
			curr_sum+=a[j];
			if(j-i+1 <n)
				j++;
			else if(j-i+1 ==n) {
				j++;
				a[j]=curr_sum;
				curr_sum-=a[i];
				i++;
			}
		}
		display(a,a.length);
	}
	
//	PREFIX-SUM technique
//	PREFIX-SUM> Q.1>according to the queries need to find out the sum between left index and right index in o(1)time
	int prefixSum(int a[],int n,int index) {
		int prefix_sum[]=new int[n];
		prefix_sum[0]=a[0];
		for(int i=1;i<n;i++) {
			prefix_sum[i]=prefix_sum[i-1]+a[i];
		}
		return prefix_sum[index];
	}
	
	int sumBetweenIndex(int a[],int n,int l,int r) {
		if(l==0)
			return prefixSum(a,a.length,r);
		return (prefixSum(a,a.length,r)-prefixSum(a,a.length,l-1));
	}
	
//	PREFIX-SUM> Q.2>finding equilibrium point
	boolean findEquiPoint(int a[],int n) {
		int lsum=0,rsum,sum=0;
		for(int i=0;i<n;i++){
			sum+=a[i];
		}
		for(int i=0;i<n;i++) {
			rsum=sum-a[i];
			if(lsum==rsum)
				return true;
			lsum+=a[i];
			sum=rsum;
		}
		return false;
	}
	
//	PREFIX-SUM> Q.3>find the maximum appearimg element in the range
	 int maxAppearingEleInRange(int l[],int r[],int n) {
		 int temp[]=new int[20];
		 for(int i=0;i<n;i++) {
			 temp[i]=0;
		 }
		 for(int i=0;i<n;i++) {
			 temp[l[i]]++;
			 temp[r[i]+1]--;
		 }
		 int max_sum=temp[0],curr_sum=temp[0],res=0;
		 for(int i=1;i<20;i++) {
			 curr_sum+=temp[i];
			 if(curr_sum>max_sum) {
				 max_sum=curr_sum;
				 res=i;
			 }	 	 
		 }
		 return res;
	 }
	 
//	 Split array in three equal sum subarrays
	 void findSplit(int a[],int n) {
		 int sum=0;
		 for(int i=0;i<n;i++) {
			 sum+=a[i];
		 }
		 if(sum%3!=0) {
			System.out.println("not possible"); 
		 }
		 else {
			 int curr_sum=0,indf=-1,inds=-1;
			 for(int i=0;i<n;i++) {
				 curr_sum+=a[i];
				 if(curr_sum==sum/3 && indf==-1) {
					 indf=i;
					 System.out.print("("+indf+",");
					 curr_sum=0;
				 }
				 else if(curr_sum==sum/3 && inds==-1) {
					 inds=i;
					 System.out.print(inds+")");
					 break;
				 }
			 }
			 if(indf==-1)
				 System.out.println("-1");
		 }
	 }
	 
	public static void main(String[] args) {
		ArrayOperations op=new ArrayOperations();
		int arr[]= {1, 3, 4, 0, 4},arr1[]= {5,8,5,4};
//		System.out.println("index of secondlargest element is "+op.secondLargestElement(arr,arr.length));
//		System.out.println(op.sortedAsc(arr,arr.length)); 
//		op.reverseArr(arr,arr.length);
//		System.out.println(op.removeDup(arr,arr.length));
//		op.moveZeroToEnd(arr,arr.length);
//		op.leftRotation(arr,arr.length);
//		op.leftRotationByd(arr,arr.length,2);
//		op.leader(arr,arr.length);
//		System.out.println(op.maxDiff(arr,arr.length));
//		op.countFreq(arr,arr.length);
//		System.out.println(op.buyStockAndSell(arr,arr.length));
//		System.out.println(op.buyStockAndSell2(arr,arr.length));
//		System.out.println(op.trappingRainWater(arr,arr.length));
//		System.out.println(op.maxConseq1(arr,arr.length));
//		System.out.println(op.maxSubarray(arr,arr.length));
//		System.out.println(op.maxEvenOddSubarray(arr,arr.length));
//		System.out.println(op.maxCircularSumSubArray(arr,arr.length));
//		System.out.println(op.majorityEle(arr,arr.length));
//		op.minConseqFlips(arr,arr.length);
//		System.out.println(op.sumPresentInSubArray(arr,arr.length,3,45));
//		System.out.println(op.maxSumInSubarray(arr,arr.length,2));
//		System.out.println(op.subarrayWithGivenSum(arr,arr.length,3));
//		op.NbonacciNumbers(10,4);
//		System.out.println(op.sumBetweenIndex(arr,arr.length,2,6));
//		System.out.println(op.findEquiPoint(arr,arr.length));
//		System.out.println(op.maxAppearingEleInRange(arr,arr1,arr.length));
		op.findSplit(arr,arr.length);
		
		
	}

}
