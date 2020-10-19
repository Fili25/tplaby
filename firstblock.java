import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class firstblock {
    public static void main (String[] Args) {
        Scanner scan = new Scanner (System.in);
        
        
        //  Задача 1 
        System.out.println(" ZADANIE 1 enter 2 numbers");
        int numb1= scan.nextInt();
        int numb2=scan.nextInt();
        int result = reminder(numb1, numb2);
        System.out.println("result " + result );
        
        // Задача 2
        System.out.println(" ZADANIE 2 enter 2 numbers ");
        int base= scan.nextInt();
        int height=scan.nextInt();
        int result2=triArea(base,height);
        System.out.println("result " + result2);


        // Задача 3 
        System.out.println(" ZADANIE 3 enter 3 numbers");
        int chick = scan.nextInt();
        int cow = scan.nextInt();
        int pig = scan.nextInt();
        int result3= animals(chick, cow, pig);
        System.out.println("result = " + result3);

        // Задача 4
        System.out.println("ZADANIE 4 enter 3 numbers");
        float prob = scan.nextFloat();
        float prize = scan.nextFloat();
        float pay = scan.nextFloat();
        boolean result4=profitableGamble(prob, prize, pay);
        System.out.println(result4);

        // Задача 5
        System.out.println("ZADANIE 5 enter 3 numbers");
        int n=scan.nextInt();
        int a=scan.nextInt();
        int b=scan.nextInt();
        String result5=operation(n, a, b);
        System.out.println(result5);
        // Задача 6
        System.out.println("ZADANIE 6 enter character");
        
        char ASCII = scan.next().charAt(0);
        int res6=ctoa(ASCII);
        System.out.println(res6);

        // Задача 7
        System.out.println("ZADANIE 7 enter number");
        
        int last=scan.nextInt();
        int res7=addUpto(last);
        System.out.println(res7);
        
        // Задача 8
        System.out.println("ZADANIE 8 enter 2 edge");
        
        int firstedge=scan.nextInt();
        int secondedge=scan.nextInt();
        int res8=nextedge(firstedge,secondedge);
        System.out.println(res8);
        // задача9
        System.out.println("ZADANIE 9 enter length");
        int length=scan.nextInt();
        int mas[]=new int [length];
        System.out.println("elements");
        for(int i=0;i<length;i++){
        mas[i]=scan.nextInt();
        }
        System.out.println("ur array");
        for(int i=0;i<length;i++){
        System.out.print(mas[i] + " ");
        }
        System.out.println("");
        int result9=sumofCubes(mas, length);
        System.out.println(result9);
        
        // Задача 10
        System.out.println("ZADANIE 10 enter a b c");
        int A1=scan.nextInt();
        int B1=scan.nextInt();
        int C1=scan.nextInt();
        boolean res10=abcmath(A1,B1,C1);
        System.out.println(res10);

    }


    public static int animals(int a,int b,int c) {
        int legs = a*2 + b*4 + c*4;
        return legs;
    }

    public static int reminder (int a, int b) {
        int rem = a%b;
        return rem;
    }

    public static int triArea (int a, int b){
        int s = (a*b)/2;
        return s;
    }
    
    public static boolean profitableGamble(float prob, float prize, float pay){
        boolean q;
        if ((prob * prize) > pay )
        {
             q = true;
            return q;
        }
        else
            {
                q = false;
                return q;
            }
    }
    public static String operation(int n, int a, int b){
        String res;
        if (a+b==n){ 
            res="added";
        }
        else if (a-b==n){
            res="subtracted";
        }
        else if (a*b==n){
            res="multiplied";
        }
        else if (a/b==n){
            res="divided";
        }
        else{
            res="none";
        }
        return res; 
    }

    public static int ctoa(char a){

    char charact = a;       
    int Ascii = (int) charact;
    return Ascii;
    }

    public static int addUpto(int a){
        int summa=0;
        for(int i = 1; i <= a; i++) {
            summa=summa+i;
         }
        return summa;
        }

    public static int nextedge(int a,int b){
    int edgex=a+b-1;
    return edgex;
    }
    public static boolean abcmath(int a,int b,int c){
        boolean del;
        for(int i = 1; i <= b; i++) {
            a=a+a;
         }
        
        if (a%c==0){
        del=true;
        }
        else{
        del=false;
        }
        return del;
    }
    public static int sumofCubes(int [] mas, int a){
        int res=0;
        for (int i=0; i<a; i++){
        mas[i]=mas[i]*mas[i]*mas[i];
        res=res + mas[i];
        }
        return res;
        }

}