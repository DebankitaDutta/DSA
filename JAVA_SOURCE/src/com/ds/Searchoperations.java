package com.ds;

public class Searchoperations {
//	iterative binary search
	int binarySearch(int a[],int low,int high,int x) {
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==x) {
				return mid;
			}
			else if(x>a[mid]) 
					 low=mid+1;
				else
					high=mid-1;
		}
		return -1;
	}
	
//	recursive binary search
	int recBinarySearch(int a[],int low,int high,int x) {
		if(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==x)
				return mid;
			
			if(x<a[mid]) return recBinarySearch(a,low,mid-1,x);
			else return recBinarySearch(a,mid+1,high,x);
		}
		return -1;
	}

	//index of 1st occurance in sorted array
	int indexOfFirstOccur(int a[],int low,int high,int x) {
		while(low<=high) {
			int mid=(low+high)/2;
			if(x>a[mid])
				low=mid+1;
			else if(x<a[mid])
				high=mid-1;
			else {
				if(mid==0 || a[mid]!=a[mid-1])
					return mid;
				else
					high=mid-1;
			}
		}
		return -1;
	}

	//index of last occurance in sorted array
	int indexOfLastOccur(int a[],int low,int high,int x) {
		while(low<=high) {
			int mid=(low+high)/2;
			if(x<a[mid]) 
				high=mid-1;
			else if(x>a[mid])
				low=mid+1;
			else {
				if(mid==a.length-1 || a[mid]!=a[mid+1]) 
					return mid;
				else
					low=mid+1;
			}
		}
		return -1;
	}


//	Count Occurrences in Sorted
	int countOccur(int a[],int n,int x) {
		int last;
		int first=indexOfFirstOccur(a,0,n,x);
		if(first==-1)
			return 0;
		else
			 last = indexOfLastOccur(a,0,n,x);
		return last-first+1;
		
	}
	
//	count 1s in a sorted array
	int count1s(int a[],int low,int high) {
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==1) {
				if(mid==0 || a[mid-1]==0) {
					return a.length-mid;
				}
				else {
					high=mid-1;
				}
			}
			else
				low=mid+1;
		}
		return 0;
	}
	
	int squareRoot(int no) {
		int low=0,high=no,ans=-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(mid*mid==no)
				return mid;
			if(mid*mid >no) {
				high=mid-1;
			}
			else {
				low=mid+1;
				ans=mid;
			}
		}
		return ans;
	}
	
//	Search in Infinite Sized sorted Array
	int searchInInfiniteSirtedArr(int a[],int x) {
		if(a[0]==x)
			return 0;
		int i=1;
		while(x>a[i]) {
			i*=2;
		}
		if(a[i]==x)
			return i;
		return binarySearch(a,i/2+1,i-1,x);
	}
	
//	Search in Sorted Rotated Array
	int searchInSortedRotated(int a[],int n,int x) {
		int low=0,high=n-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid]==x)
				return mid;
			if(a[low]<a[mid]) {
				if(a[mid]>x && x>=a[low])
					high=mid-1;
				else
					low=mid+1;
			}
			else {
				if(a[mid]<x && x<=a[high])
					low=mid+1;
				else
					high=mid-1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Searchoperations sp=new Searchoperations();
		int arr[]= {10,20,40,60,5,8};
//		System.out.println(sp.binarySearch(arr,0,arr.length-1,60));
//		System.out.println(sp.recBinarySearch(arr,0,arr.length-1,20));
//		System.out.println(sp.indexOfFirstOccur(arr,0,arr.length-1,20));
//		System.out.println(sp.indexOfLastOccur(arr,0,arr.length-1,20));
//		System.out.println(sp.countOccur(arr,arr.length-1,1));
//		System.out.println(sp.count1s(arr,0,arr.length-1)); 
//		System.out.println(sp.squareRoot(50)); 
//		System.out.println(sp.searchInInfiniteSirtedArr(arr,100));
		System.out.println(sp.searchInSortedRotated(arr,arr.length,6));

	}

}
