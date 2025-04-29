import java.util.*;

class Prod {
    int num, p;

    Prod() {
        num = 0;
    }

    Prod(int nx) {
        num = nx;
    }

    void getProduct() {
        int n = num;
        p = 1;
        while (n > 0) {
            int y = n % 10; 
            p *= y; 
            n = n / 10;
        }
    }

    public void display() {
        System.out.println("The number is: " + num);
        System.out.println("Product of digits = " + p);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number to find product of digits:");
        int v = sc.nextInt();
        Prod obj = new Prod(v);
        obj.getProduct();
        obj.display();
    }
}
