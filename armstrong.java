import java.util.*;
public class armstrong {
    public static void main(String[] args) {
        int n,i,sum=0,dg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        n=sc.nextInt();
        for(i=n;i>0;i/=10)
        {
            dg=i%10;
            sum=sum+dg*dg*dg;
        }
        if(sum==n)
        {
            System.out.println(sum+ " Is a Armstrong Number");
        }
        else
        {
            System.out.println(n+" Is not a Armstrong Number");
        }
    }
}
