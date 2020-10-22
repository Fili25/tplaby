import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class thirdblock {
    public static void main(String[] Args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        // zad1
        System.out.println("ZADANIE 1 enter a b c a^2*x+b*x+c=0");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int result1 = solutions(a,b,c);
        System.out.println(result1);
        // zad2
        System.out.println("ZADANIE 2 ZIPZIP?");
        String zip = scan2.nextLine();
        int result2 = findZip(zip);
        System.out.println(result2);
        // zad3
        System.out.println("ZADANIE 3 Check perfect? Enter your number:");
        int perf = scan.nextInt();
        boolean result3 = CheckPerfect(perf);
        System.out.println(result3);
        // zad4
        System.out.println("ZADANIE 4 Flip first and last");
        String flipflap = scan2.nextLine();
        String result4 = flipEndChars(flipflap);
        System.out.println(result4);
        // zad5
        System.out.println("ZADANIE 5 HEX checking:");
        String HEX = scan2.nextLine();
        boolean result5 = isValidHexCode(HEX);
        System.out.println(result5);
        // zad6
        System.out.println("ZADANIE 6 Enter length first array");
        int lengtharray1=scan.nextInt();
        int mas61[]= readarrow(lengtharray1);
        System.out.println("Enter length second array");
        int lengtharray2=scan.nextInt();
        int mas62[]= readarrow(lengtharray2);
        System.out.println("  ");
        boolean result6=same(mas61,mas62,lengtharray1,lengtharray2);
        System.out.println(result6);
        //zad7
        System.out.print("ZADANIE 7 Enter number: ");
        int kapr = scan.nextInt();
        String result7 = isKaprekar(kapr);
        System.out.println(result7);
        //zad8
        System.out.println("ZADANIE 8 Введите двоичную строку: ");
        String onezeroone = scan2.nextLine();
        String result8 = longestZero(onezeroone);
        System.out.println(result8);
        // zad9
        System.out.println("ZADANIE 9 Check prime:");
        int gg = scan.nextInt();
        int result9 = NextPrime(gg);
        System.out.println(result9);
        // zad10
        System.out.println("ZADANIE 10 Check right angled triangle:");
        int a9 = scan.nextInt();
        int b9 = scan.nextInt();
        int c9 = scan.nextInt();
        boolean result10 = rightTriangle(a9,b9,c9);
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
    public static int solutions(int a, int b, int c) {
        int kol;
        if ((b*b-4*a*c)>0)
        {
            kol=2;
        }
        else if ((b*b-4*a*c)==0)
        kol=1;
        else
        kol=0;
        return kol;
    }
    // ZADACHA2
    public static int findZip(String st2){
    int z = st2.indexOf("zip", st2.indexOf("zip") + 1);
    return z;
            }
    // ZADACHA3
    public static boolean CheckPerfect(int a) {
        boolean perf;
        int sum=0;
        for (int i=1;i<a;i++)
        {
                if(a%i==0)
                    sum=sum+i;

        }
        if (sum==a)
            perf=true;
        else
            perf=false;
        return perf;
    }

    // ZADACHA4
public static String flipEndChars(String gucciflipflap){
        String a;
        if (gucciflipflap.length()>2){
            char[] MAS = gucciflipflap.toCharArray(); 
            if(MAS[0]!=MAS[gucciflipflap.length()-1]){
                char b=MAS[0];
                MAS[0]=MAS[gucciflipflap.length()-1];
                MAS[gucciflipflap.length()-1]=b;
                a = new String(MAS);
            }
            else
                a="Two's a pair.";
        }
        else
            a="Incompatible.";
      
    return a;
}
    
// ZADACHA5
public static boolean isValidHexCode(String FULL){
    int sum = 0;
    Boolean RESULT;
    if (FULL.charAt(0) == '#' && FULL.length() == 7){
        for (int i = 1; i <= 6 ; i++){
            int a5 = ((int) FULL.charAt(i));
            if (((a5 >= 48) && (a5 <= 57)) ||((a5 >= 65) && (a5 <= 70)) ||((a5 >= 97) && (a5 <= 102)) ){
                sum +=1;
            }
        }
    }else{
        RESULT = false;
    }
    if(sum == 6){
        RESULT = true;
    }else{
        RESULT = false;
    }
    return RESULT;
}

// ZADACHA6
public static boolean same(int[] mas,int[] mas2,int a, int b){
        boolean proof;
        int[] copy = new int[mas.length];
        int res = 0;
        int countNum = 0;
        int count = 0;
        for (int i = 0; i <copy.length ; i++) {
            copy[i] = 0;
        }

        for (int i = 0; i < mas.length; i++) {
            if (copy[i]==0){
                for (int j = 0; j < mas.length; j++) {
                    if (mas[i]==mas[j]){
                        copy[j] = 1;
                        count++;
                    }
                }
            }
            if (countNum<count){
                countNum = count;
                res++;
            }
        }
        
        int res2 = 0;
        countNum = 0;
        count = 0;
        for (int i = 0; i <copy.length ; i++) {
            copy[i] = 0;
        }

        for (int i = 0; i < mas2.length; i++) {
            if (copy[i]==0){
                for (int j = 0; j < mas2.length; j++) {
                    if (mas2[i]==mas2[j]){
                        copy[j] = 1;
                        count++;
                    }
                }
            }
            if (countNum<count){
                countNum = count;
                res2++;
            }
        }
        if (res==res2)
            proof=true;
        else
            proof=false;
        return proof;
}
 //ZADACHA7
 public static String isKaprekar(int k){
    String res7 = "[eq";
    String Left;
    String Right;
    int k2 =0;
    int l = 0;
    int l1 = 0;
    int r1 = 0;
    String k1;
    
    if ( k > 0 ){
        k2 = k*k;
        l = String.valueOf(k2).length();
        if (k2 < 10){
            l1 = 0;
            r1 = k2;
            if (l1 + r1 == k){
                res7 = "true";
            }
            else{
                res7 = "false";
            }
        }else
        if (l % 2 == 0 ){
            k1 = Integer.toString(k2);
            Left = k1.substring(0,l/2);
            l1 = Integer.parseInt(Left.trim());
            Right = k1.substring(l/2);
            r1 = Integer.parseInt(Right.trim());
            if (l1 + r1 == k){
                res7 = "true";
            }
            else{
                res7 = "false";
            }
         
        }else if(l % 2 != 0 ){
            k1 = Integer.toString(k2);
            Left = k1.substring(0,(l-1)/2);
            l1 = Integer.parseInt(Left.trim());
            Right = k1.substring((l-1)/2);
            r1 = Integer.parseInt(Right.trim());
            if (l1 + r1 == k){
                res7 = "true";
            }
            else{
                res7 = "false";
            }
        }
    }else{
        return " Введите другое число!";
    }
    return res7;
}


 //ZADACHA8
public static String longestZero(String s8){
    int maxl = 1;
    int curl = 1;
    String res8 = "";
    int one = 0;
    for(int i = 0 ; i < s8.length()-1; i++){
        if(s8.charAt(i) == '1'){
            one+=1;  
        }
        else
        {
            if (s8.charAt(i) == s8.charAt(i+1) ){
                curl+=1;
            }
            else{
                if(curl > maxl){
                    maxl = curl;
                }
                curl = 1;
        }
    }
    }
    if (one == s8.length() -1 ){
        return res8;   
    }
    if(curl > maxl){
     maxl = curl;
        }
    
    for (int i = 0; i < maxl ; i++){
        res8 += "0";
    }
    return res8;
}



// ZADACHA9
public static int NextPrime (int a){
    int res=0;
    while (res<a){
        res++;
        while(isprime(res)==false)
            res++;
     }
    return res; 
}

public static boolean isprime (int n){
	for(int d=2; d*d<=n; d++){ 
		if(n%d==0) 
        return false;
		}
	return true;
    }





// ZADACHA10
public static boolean rightTriangle(int a,int b, int c){
    boolean res;
    if ((a*a==(b*b+c*c))||(c*c==(b*b+a*a))||(b*b==(c*c+a*a)))
        res=true;
    else 
        res=false;
    return res; 
}
    
}
