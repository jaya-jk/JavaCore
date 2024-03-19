import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.*;

public class Calci {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("type here : ");
        String input = sc.nextLine();
        sc.close();
        int[] number = getNum(input);
        /*for (int a:number
             ) {
            System.out.print(a+" ");
        } */
        char[] opirends = getOpirends(input);
       /* for (char a:opirends
             ) {
            System.out.print(a+" ");
        } */
        float res = getResult(number,opirends);
        System.out.println("ans = "+ res);
    }
    public static int[] getNum(String s){
        String[] str = s.split("[/*+-]+");
        int[] arr = new int[str.length];

        for (int i = 0; i <arr.length ; i++) {
            arr[i]= Integer.parseInt(str[i]);
        }
        return arr;
    }
    public  static char[] getOpirends(String s){
        String[] op = s.split("[0-9]+");
        //char[] symbols = new char[op.length];
        StringBuilder sb = new StringBuilder();
        for (String pass:op
             ) {
            sb.append(pass);
        }
        return sb.toString().toCharArray();
    }
    public static float getResult(int[] number, char[] ope) {
        float res = number[0];
        //int len = number.length;
        for (int i = 0; i < ope.length; i++) {
            int j =i+1;
            switch (ope[i]){
                case '+':
                    res += number[j];
                    break;
                case '-':
                    res -= number[j];
                    break;
                case '*':
                    res *= number[j];
                    break;
                case '/':
                    res /= number[j];
                    break;
                default:
                    System.out.println("something wents worng !");
            }
        }
        return  res;
    }
}
