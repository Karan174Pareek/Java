import java.util.*;

class MyString {
    String Str;

    MyString() {
        Str = "";
    }

    void readString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a sentence= ");
        Str = sc.nextLine();
    }

    void results() {
        String temp = "";
        int v = 0, c = 0;
        System.out.println("The original sentence = " + Str);
        int len = Str.length();
        System.out.print("WORDS\t\tVOWELS\tCONSONANTS\n");
        for (int j = 0; j < len; j++) {
            char ch = Str.charAt(j);
            if (ch != ' ') {
                temp = temp + ch;
            } else {
                v = 0;
                c = 0;
                int y = temp.length();
                for (int i = 0; i < y; i++) {
                    char ss = temp.charAt(i);
                    if (ss == 'A' || ss == 'a' || ss == 'E' || ss == 'e' || ss == 'I' || ss == 'i' || ss == 'O' || ss == 'o' || ss == 'U' || ss == 'u')
                        v++;
                    else
                        c++;
                }
                System.out.print(temp + "\t\t" + v + "\t" + c + "\n");
                temp = "";
            }
        }
        v = 0;
        c = 0;
        int y = temp.length();
        for (int i = 0; i < y; i++) {
            char ss = temp.charAt(i);
            if (ss == 'A' || ss == 'a' || ss == 'E' || ss == 'e' || ss == 'I' || ss == 'i' || ss == 'O' || ss == 'o' || ss == 'U' || ss == 'u')
                v++;
            else
                c++;
        }
        System.out.print(temp + "\t\t" + v + "\t" + c + "\n");
    }

    public static void main(String[] args) {
        MyString obj = new MyString();
        obj.readString();
        obj.results();
    }
}
