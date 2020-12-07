import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class fourthblock {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задача ?");
        int n = scan.nextInt();


        switch(n){
            case 1:
            System.out.println("Задача 1");
            System.out.println(bessy(10, 7, "hello my name is Bessie and this is my essay"));
                break;
            case 2:
            System.out.println("Задача 2");
            System.out.println(split("((()))(())()()(()())"));
                break;
            case 3:
            System.out.println("Задача 3");
            System.out.println(toCamelCase("is_modal_open"));
            System.out.println(toSnakeCase("helloEdabitBruh"));
                break;
            case 4:
            System.out.println("Задача 4");
            System.out.println(overTime(13.25, 15, 30, 1.5));
                break;
            case 5:
            System.out.println("Задача 5");
            System.out.println(BMI("205 pounds", "73 inches"));
            System.out.println(BMI("55 kilos", "1.65 meters"));
            System.out.println(BMI("154 pounds", "2 meters"));
                break;
            case 6:
            System.out.println("Задача 6");
            System.out.println(bugger(999));
                break;
            case 7:
            System.out.println("Задача 7");
            System.out.println(toStarShorthand(""));
                break;
            case 8:
            System.out.println("Задача 8");
            System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
                break;
            case 9:
            System.out.println("Задача 9");
            System.out.println(trouble(666789, 1234566));
                break;
            case 10:
            System.out.println("Задача 10");
            System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
                break;
            
        }
    }
        // Задача1
        public static String bessy(int n, int k, String str) {
            String newstr = "";
            String str2 = "";
            int sum = 0;
            int sum2 = 0;
            for (int i = 0; i < str.length(); i++) {
                sum++;
                if (str.charAt(i) == ' ') {
                    str2 = str.substring(i);
                    sum2 = str2.split("\\ ")[1].length();
                    sum--;
                }
                if (sum+sum2<= k) {
                    sum2=0;
                    newstr += str.charAt(i);
                } else if(str.charAt(i) != ' '){
                    newstr += "\n" + str.charAt(i);
                    sum = 0;
                }
            }
            return newstr;
    
        }
        // Задача2
        public static String split(String str) {
            int open = 0;
            int close = 0;
            String newstr = "['";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    newstr += "(";
                    open++;
                }
                if (str.charAt(i) == ')') {
                    newstr += ")";
                    close++;
                }
                if (open == close) {
                    if (i != str.length() - 1)
                        newstr += "','";
                    else
                        newstr += "']";
                }
            }
            return newstr;
        }

        // Задача3
        public static String toCamelCase(String str) {
            char[] newstr = str.toCharArray();
            str = "";
            for (int i = 0; i < newstr.length; i++) {
                if (newstr[i] == '_')
                    newstr[i + 1] = Character.toUpperCase(newstr[i + 1]);
                else
                    str += newstr[i];
            }
            return str;
        }
    
        public static String toSnakeCase(String str) {
            char[] newstr = str.toCharArray();
            str = "";
            for (int i = 0; i < newstr.length; i++) {
                if (Character.isUpperCase(newstr[i])) {
                    str += "_" + Character.toLowerCase(newstr[i]);
                } else
                    str += newstr[i];
            }
            return str;
        }
        // Задача4
        public static String overTime(double x, double y, double c, double dp) {
            String dolar = "$";
            double s = 0;
            if (y > 17) {
    
                s = y - 17;
                s = (y - x - s) * c + (s * 30 * dp);
            } else {
                s = (y - x) * c;
            }
            return dolar + String.format("%.2f", s);
        }
        // Задача5
        public static String BMI(String str1, String str2) {
            double ves = Double.parseDouble(str1.substring(0, str1.indexOf(' ')));
            if (str1.endsWith("pounds")) {
                ves = ves * 0.453592;
            }
            double rost = Double.parseDouble(str2.substring(0, str2.indexOf(' ')));
            if (str2.endsWith("inches")) {
                rost = rost * 0.0254;
            }
            double IBM = ves / Math.pow(rost, 2);
            if (IBM < 18.5) {
                return String.format("%.1f", IBM) + " NeDostatochnyi Ves";
            }
            else if(IBM<24.9)
                return String.format("%.1f", IBM)+ " Normalniy Ves";
            else
                return String.format("%.1f", IBM)+ " Izbitochniy Ves";
    
        }

        // Задача6
        public static int bugger(int n) {
            String str = "" + n;
            int sum = 0;
            int s = 0;
            while (str.length() > 1) {
                sum = 1;
                for (int i = 0; i < str.length(); i++) {
                   sum = sum * Integer.parseInt("" +str.charAt(i));
                }
                s++;
                str = "" + sum;
            }
            return s;
        }
        // задача7
        public static String toStarShorthand(String str) {
            if(str=="")
                return "";
            char save = str.charAt(0);
            int kol = 1;
            String newst = "";
            for(int i=1;i<str.length();i++)
            {
                if(str.charAt(i) != save)
                {
                    if(kol>1)
                    {
                        newst += ""+save+ "*"+ kol;
                    }
                    else
                        newst += ""+save;
                    kol = 1;
                    if(i!=str.length()-1)
                        save = str.charAt(i);
                    else
                        newst+=str.charAt(i);
                }
                else
                {
                    kol++;
                    if(i== str.length()-1)
                    {
                        newst += ""+save+ "*"+ kol;
                    }
                }
            }
            return newst;
        }
        
        // задача8
        public static boolean doesRhyme(String str1, String str2) {
            String s1 = "", s2 = "";
            char v = ' ';
            str1 = str1.substring(str1.lastIndexOf(" ") + 1);
            for (int i = 0; i < str1.length(); i++) {
                v = Character.toLowerCase(str1.charAt(i));
                if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'y') {
                    s1 += v;
                }
            }
            str2 = str2.substring(str2.lastIndexOf(" ") + 1);
            for (int i = 0; i < str2.length(); i++) {
                v = Character.toLowerCase(str2.charAt(i));
                if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'y') {
                    s2 += v;
                }
            }
            return  s1.equals(s2);
        }

        public static boolean trouble(long a, long b) {
            String str1 = "" + a;
            String str2 = "" + b;
            int kol = 0, kol2 = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (i != str1.length() - 1) {
                    if (str1.charAt(i) == str1.charAt(i + 1))
                        kol++;
                    else
                        kol = 0;
                    if (kol == 2) {
                        for (int j = 0; j < str2.length(); j++) {
                            if (str1.charAt(i) == str2.charAt(j)) {
                                kol2++;
                            } else {
                                kol2 = 0;
                            }
                            if (kol2 == 2) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }



        public static int countUniqueBooks(String str, char ch) {
            String newstr1 = "";
            String newstr2 = "";
            String fin = "";
            int ind1 = 0, ind2 = 0;
            while(str.length()!= 0)
            {
                if(str.indexOf(ch)!=-1)
                {
                    newstr1 = str.substring(str.indexOf(ch)+1);
                    ind1 = str.indexOf(ch)+1;
                    str = str.substring(ind1);
                }
                if(newstr1.indexOf(ch)!=-1)
                {
                    newstr2 = newstr1.substring(0,newstr1.indexOf(ch));
                    ind2 = newstr1.indexOf(ch)+1;
                    str = str.substring(ind2);
                }
                for(int i=0;i<newstr2.length();i++)
                {
                    if(fin.indexOf(newstr2.charAt(i))==-1)
                    {
                        fin += newstr2.charAt(i);
                    }
                }
            }
            return fin.length();
        }
}