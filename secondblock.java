import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class secondblock {
    public static void main(String[] Args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        //zad1
        System.out.println("ZADANIE 1 Enter one word");
        String word = scan.nextLine();
        System.out.println("How many times");
        int r = scan.nextInt();
        System.out.println(word);
        String result1 = repeat(word, r);
        System.out.println(result1);
        //zad2
        System.out.println("ZADANIE 2  Enter length");
        int length2=scan.nextInt();
        int mas2[]= readarrow(length2);
        System.out.println("");
        int result2=differenceMaxMin(mas2,length2);
        System.out.println(result2);
        //zad3
        System.out.println("ZADANIE 3 Enter length");
        int length3=scan.nextInt();
        int mas3[]= readarrow(length3);
        System.out.println("");
        boolean result3=isAvgWhole(mas3,length3);
        System.out.println(result3);
        //zad4
        System.out.println("ZADANIE 4 Enter length");
        int length4=scan.nextInt();
        int mas4[]= readarrow(length4);
        System.out.println("");
        int[] result4=cumulativeSum(mas4,length4);
        for(int i=0;i<length4;i++){
        System.out.println(result4[i]);
        }
        //zad5
        System.out.println("ZADANIE 5 Enter number");
        String z5=scan.next();
        System.out.println(getDecimalPlaces(z5));
        //zad6
        System.out.println("ZADANIE 6 Enter number");
        int fibo=scan.nextInt();      
        int result6=Fibonacci(fibo);
        System.out.println(result6);
        // zad7
        System.out.println("ZADANIE 7 Enter INDEX");
        String index=scan2.nextLine();
        boolean result7=isValid(index);
        System.out.println(result7);

        // zad8
        System.out.println("ZADANIE 8 Enter 2 string");
        String str1 = scan2.nextLine();
        String str2 = scan2.nextLine();
        boolean result8 = isStrangePair(str1, str2);
        System.out.println(result8);
        
        // zad9
        System.out.println("ZADANIE 9");
        System.out.println("Enter ur word");
        String z9 = scan.next();
        System.out.println("Enter line");
        String z9line = scan.next();
        int num9 = scan.nextInt();
        switch (num9){
        case 1:
        Boolean result91 = isPrefix(z9, z9line);
        System.out.println(result91);
        break;
        case 2:
        Boolean result92 = isSuffix(z9, z9line);
        System.out.println(result92);
        break;
        }
        //zad10
        System.out.println("ZADANIE 10");
        System.out.println("Enter step");
        int st=scan.nextInt();
        int result10 = boxSeq(st);
        System.out.println(result10);
        


    }

    // readarrow
    public static int[] readarrow(int sz) {
        Scanner scan1 = new Scanner(System.in);
        int mas[] = new int[sz];
        System.out.println("Enter elements");
        for (int i = 0; i < sz; i++) {
            mas[i] = scan1.nextInt();
        }
        return mas;
    }
    // ZADACHA1
    public static String repeat(String a, int b) {
        String result = "";
        for (int i = 0; i < a.length(); i++) {
        for (int j = 0; j < b; j++) 
            {
                result = result + String.valueOf(a.charAt(i));
            }
        }
             return result;
        }
    // ZADACHA2
    public static int differenceMaxMin(int[] mas, int length) {
        int res;
        int min = mas[0];
        int max = mas[0];
        for (int i = 1; i < length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
            if (mas[i] < min) {
                min = mas[i];
            }

        }
        res = max - min;
        return res;
    }

    // ZADACHA3
    public static boolean isAvgWhole(int[] mas, int length) {
        int summa = 0;
        boolean avgcel;
        for (int i = 0; i < length; i++) {
            summa = summa + mas[i];
        }

        if (summa % length == 0) {
            avgcel = true;
        } else {
            avgcel = false;
        }

        return avgcel;
    } 

    // ZADACHA4
    public static int[] cumulativeSum(int[] mas, int length) {
        int summa = 0;
        int[] resmas = new int[length];
        for (int i = 0; i < length; i++) {
            summa = summa + mas[i];
            resmas[i] = summa;
        }
        return resmas;
    }

    // zadacha5
    public static int getDecimalPlaces(String a) {
        int res;
        String sub = ".";
        String sub2 = ",";
            if (a.indexOf(sub) != -1)
               res=String.valueOf(a).split("\\.")[1].length();
            else if (a.indexOf(sub2) != -1)
                res=String.valueOf(a).split("\\,")[1].length();
            else
        res=0;
        return res;
    }

    // zadacha6
    public static int Fibonacci(int n) {
        int a;
        int a1 = 1;
        int a2 = 1;
        if (n < 2) {
            a2 = 1;
        }
        for (int i = 3; i < n + 2; i++) {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
        }
        return a2;
    }

    // zadacha7
    public static boolean isValid(String s) {

        boolean a;
        if (s.length() < 6) {
            try {
                int num = Integer.parseInt(s);
                a = true;
            } catch (NumberFormatException e) {
                a = false;
            }
        } else {
            a = false;
        }
        return a;
    }

    // zadacha8
    public static boolean isStrangePair(String first,String second){
        boolean a;
        
            char[] MAS1 = first.toCharArray();
            char[] MAS2 = second.toCharArray();
            int len1=first.length();
            int len2=second.length();
            if (((MAS1[0]==MAS2[len2-1]) && (MAS1[len1-1]==MAS2[0])) || (len1==0 && len2==0)){
                a=true;}
            else
                a=false;
            
        return a;
    }
    // zadacha9
    public static boolean isPrefix (String x, String y){
        boolean res;
        y = y.replace("-", "");
        if (x.startsWith(y)== true)
        {
        res=true;
        }
        else  {
        res=false;
        }
        return res;
        }
        
        public static boolean isSuffix (String x, String y){
        boolean res;
        y = y.replaceFirst("-", "");
        if (x.endsWith(y) == true)
        {
        res=true;
        }
        else  {
        res=false;
        }
        return res;
        }
        // zadacha10
        public static int boxSeq(int a){
            int result = 0;
            if (a==0){
            result = 0;
            }
            else{
            for (int i = 1; i <= a; i++){
            if (i%2!=0){
            result = result + 3;
            }
            else{
            result = result -1;
            }
            }
            }
            return result;
            }
        
}