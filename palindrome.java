import java.util.*;
public class palindrome {
    public static void main(String[] args) {
        int n,i,rev=0,dg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        n=sc.nextInt();
        for(i=n;i>0;i/=10)
        {
            dg=i%10;
            rev=(rev*10)+dg;
        }
        if(rev==n)
        {
            System.out.println("It is a Palindrome number "+ rev);
        }
        else
        {
            System.out.println("It is not a Palindrome Number");
        }
    }
}
