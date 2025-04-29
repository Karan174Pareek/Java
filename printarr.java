import java.util.*;
public class printarr {
    public static void main(String args[])
    {
        int n;
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array elemets");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Printing the array elemets");
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}
