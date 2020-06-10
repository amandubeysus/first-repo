class Insertionsort{
  void sort(int arr[])
{  int n=arr.length;
    for(int i=0;i<n-1;++i)
  {int key=arr[i];
int j=i-1;
while(j>=0 && arr[j]>key){

arr[j+1]=arr[j];
j=j-1;
}
arr[j+1]=key;
}
}
static void printarray(int arr[])
{int n=arr.length;
for(int i=0;i<n;++i)
System.out.print(arr[i]+" ");
System.out.println();
}
public static void main(String[] args)
{int arr[]={12,11,13,5,6,7};
Insertionsort ob=new Insertionsort();
ob.sort(arr);
ob.printarray(arr);
}
}

