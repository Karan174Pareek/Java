import java.util.Scanner;
public class BinaryDecimalConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Binary to Decimal and Decimal to Binary Converter");
        System.out.println("Enter 1 to convert Binary to Decimal or 2 to convert Decimal to Binary;");
        int choice = sc.nextInt();

        if(choice==1){
        System.out.print("Enter a Binary Number:");
        String binaryInput = sc.next();
        int decimalResult = binaryToDecimal(binaryInput);
        System.out.println("Decimal result: "+decimalResult);
        }
        else if (choice == 2) {
            System.out.print("Enter a decimal number: ");
            int decimalInput = sc.nextInt();
            String binaryResult = decimalToBinary(decimalInput);
            System.out.println("Binary result: " + binaryResult);
        } else {
            System.out.println("Invalid choice. Please enter 1 for Binary to Decimal or 2 for Decimal to Binary.");
        }
        sc.close();
    } 
    public static int binaryToDecimal(String binary)
    {
        return Integer.parseInt(binary, 2);
    }
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }
}
