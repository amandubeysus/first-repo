class Binarysearch{
   int binarysearch(int arr[],int l,intr,int x)
{
if(r>=1){
int mid=1+(r-1)/2;
if(arr[mid]==x)
  return mid;
if(arr[mid]>x)
     return binarysearch(arr,l,mid-1,x);
return binarysearch(arr,mid+1,r,x);
}
  return-1;
}
   public static void main(String[] args)
{
Binarysearch ob=new Binarysearch();
  int arr[]={2,3,4,10,40};
int n=arr.length;
int x=10;
int result=ob.binarysearch(arr,0,n-1,x);
  if(result==-1)
System.out.println("element not present:")
else
System.out.println("element found at index"+result);
}
}