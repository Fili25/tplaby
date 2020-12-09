import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.security.MessageDigest;
public class fifthblock {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задача ?");
        int n = scan.nextInt();


        switch(n){
            case 1:
            System.out.println("Задача 1");
            System.out.println(encrypt("Hello"));
            int[] mas = { 72, 33, -73, 84, -12, -3, 13, -13, -68 };
            System.out.println(decrypt(mas));
                break;
            case 2:
            System.out.println("Задача 2");
            System.out.println(canMove("horse", "A1", "B3"));
                break;
            case 3:
            System.out.println("Задача 3");
            System.out.println(canComplete("bbutl", "beautiful"));
                break;
            case 4:
            System.out.println("Задача 4");
            System.out.println(sumDigProd(99, 999, 9, 4, 5, 6));
                break;
            case 5:
            System.out.println("Задача 5");
            String[] mas2 = { "hoops", "chuff", "bot", "bottom" };
            System.out.println(sameVowelGroup(mas2));
                break;
            case 6:
            System.out.println("Задача 6");
            System.out.println(validateCard(1234567890123456L));
                break;
            case 7:
            System.out.println("Задача 7");
            System.out.println(toStarShorthand(""));
                break;
            case 8:
            System.out.println("Задача 8");
            System.out.println(bytesToHex("Fluffy@home"));
                break;
            case 9:
            System.out.println("Задача 9");
            System.out.println(toCamelCase("jOn SnoW, kINg IN thE noRth."));
                break;
            case 10:
            System.out.println("Задача 10");
            System.out.println(hexLattice(37));
                break;
            
        }
    }
        // Задача1
        public static String encrypt(String str) {
            char[] ch = str.toCharArray();
            String newstr = "[" + (int) ch[0] + ", ";
            for (int i = 1; i < ch.length; i++) {
                newstr += (int) ch[i] - (int) ch[i - 1] + ", ";
            }
            return newstr.substring(0, newstr.length() - 2) + "]";
        }
    
        public static String decrypt(int[] mas) {
            String newstr = "" + (char) mas[0];
            int sum = mas[0];
            for (int i = 1; i < mas.length; i++) {
                sum += mas[i];
                newstr += (char) sum;
            }
            return newstr;
        }
        // Задача2
        public static boolean canMove(String fig, String xod1, String xod2) {
            xod1 = xod1.toUpperCase();
            xod2 = xod2.toUpperCase();
            fig = fig.toUpperCase();
            if (xod1.matches("([A-H]{1}[1-8]{1})") && xod2.matches("([A-H]{1}[1-8]{1})") && xod1.equals(xod2) == false) {
                if (fig.equals("PAWN")) {
                    if (xod1.charAt(1) >= 50 && xod1.charAt(1) <= 55 && xod2.charAt(0) == xod1.charAt(0)
                            && (int) xod2.charAt(1) == (int) xod1.charAt(1) + 1)
                        return true;
                    else
                        return false;
                }
                if (fig.equals("ROOK")) {
                    if (xod2.charAt(0) == xod1.charAt(0) || xod2.charAt(1) == xod1.charAt(1))
                        return true;
                    else
                        return false;
                }
                if (fig.equals("BISHOP")) {
                    if (Math.abs((int) xod2.charAt(0) - (int) xod1.charAt(0)) == Math.abs(xod2.charAt(1) - xod1.charAt(1)))
                        return true;
                    else
                        return false;
                }
                if (fig.equals("QUEEN")) {
                    if (xod2.charAt(0) == xod1.charAt(0) || xod2.charAt(1) == xod1.charAt(1) || Math
                            .abs((int) xod2.charAt(0) - (int) xod1.charAt(0)) == Math.abs(xod2.charAt(1) - xod1.charAt(1)))
                        return true;
                    else
                        return false;
                }
                if (fig.equals("KING")) {
                    if (Math.abs((int) xod2.charAt(0) - (int) xod1.charAt(0)) <= 1
                            && Math.abs(xod2.charAt(1) - xod1.charAt(1)) <= 1)
                        return true;
                    else
                        return false;
                }
                if (fig.equals("HORSE")) {
                    if (Math.abs((int) xod2.charAt(0) - (int) xod1.charAt(0)) == 1
                            && Math.abs(xod2.charAt(1) - xod1.charAt(1)) == 2
                            || Math.abs((int) xod2.charAt(0) - (int) xod1.charAt(0)) == 2
                                    && Math.abs(xod2.charAt(1) - xod1.charAt(1)) == 1)
                        return true;
                    else
                        return false;
                }
            }
            return false;
        }
        // Задача3
        public static boolean canComplete(String str1, String str2) {
            String fin = str2;
            String fin2 = "" + str1.charAt(0);
            ;
            char[] ch = str1.toCharArray();
            String newstr = "" + str1.charAt(0);
            String newstr2 = "";
            int k = 0;
            if (str1.charAt(0) != str2.charAt(0))
                return false;
            while (str2.length() > 1 && k < str1.length() - 1) {
                if (str2.indexOf(ch[k]) != -1) {
                    if (str1.charAt(k) == str1.charAt(k + 1)) {
                        newstr2 = str2.substring(str2.indexOf(ch[k]) + 1);
                        if (newstr2.indexOf(ch[k + 1]) == -1) {
                            return false;
                        }
    
                    }
                    if (str2.indexOf(ch[k + 1]) != -1) {
                        fin2 += ch[k + 1];
                        newstr += str2.substring(str2.indexOf(ch[k]) + 1, str2.indexOf(ch[k + 1]) + 1);
                        str2 = str2.substring(str2.indexOf(ch[k + 1]));
                    } else
                        return false;
                } else
                    return false;
                k++;
            }
            return fin.equals(newstr) && fin2.equals(str1);
        }
        // Задача4
        public static int sumDigProd(int... mas) {
            int rezult = 0;
            String im = "";
            for (int n : mas)
                rezult += n;
            while (Integer.toString(rezult).length() != 1) {
                im = Integer.toString(rezult);
                rezult = 1;
                for (int i = 0; i < im.length(); i++)
                    rezult *= Integer.parseInt(im.substring(i, i + 1));
            }
            return rezult;
        }
        // Задача5
        public static String sameVowelGroup(String[] mas) {
            String str = mas[0];
            String pervoeSlovo = "";
            String sledSovo = "";
            String sl = "";
            String Otvet = "['" + str + "',";
            boolean a = true;
            int k1 = 0, k2 = 0;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                        || str.charAt(i) == 'u' || str.charAt(i) == 'y') {
                    if (pervoeSlovo.indexOf(str.charAt(i)) == -1)
                        k1++;
                    pervoeSlovo += str.charAt(i);
                }
            }
            for (int i = 1; i < mas.length; i++) {
                sledSovo = mas[i].toLowerCase();
                for (int j = 0; j < sledSovo.length(); j++) {
                    if (sledSovo.charAt(j) == 'a' || sledSovo.charAt(j) == 'e' || sledSovo.charAt(j) == 'i'
                            || sledSovo.charAt(j) == 'o' || sledSovo.charAt(j) == 'u' || sledSovo.charAt(j) == 'y') {
                        if (pervoeSlovo.indexOf(sledSovo.charAt(j)) != -1) {
                            if (sl.indexOf(sledSovo.charAt(j)) == -1) {
                                k2++;
                            }
                            sl += sledSovo.charAt(j);
                        } else
                            a = false;
                    }
                }
                if (a == true && k1 == k2) {
                    Otvet += "'" + sledSovo + ",'";
                }
                a = true;
                k2 = 0;
                sl = "";
            }
            return Otvet.substring(0, Otvet.length() - 2) + "']";
        }

        // Задача6
        public static boolean validateCard(long num) {
            if (("" + num).length() <= 14 && ("" + num).length() >= 19) {
                return false;
            }
            String s;
            int sum = 0;
            int kontrolChifra = Integer.parseInt(("" + num).substring(("" + num).length() - 1));// Последняя цифра
            int len = ("" + num).length() - 2;
            while (len >= 0) {
                s = "" + ("" + num).charAt(len);//Переворот цифр
                if (Integer.parseInt(s) % 2 != 0) {
                    s = "" + Integer.parseInt(s) * 2;
                    if (s.length() > 1) {
                        s = "" + (Integer.parseInt(s.substring(0, 1)) + Integer.parseInt(s.substring(1, 2)));
                    }
                }
                sum += Integer.parseInt(s);
                len--;
            }
            return ("" + (10 - Integer.parseInt(("" + sum).substring(("" + sum).length() - 1)))).equals("" + kontrolChifra);
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
        public static String bytesToHex(String str) {
            try{
                MessageDigest dig = MessageDigest.getInstance("SHA-256");
                byte[] hesh = dig.digest(str.getBytes("UTF-8"));
                StringBuffer hexStr = new StringBuffer();
                for (int i = 0; i < hesh.length; i++) {
                    String hexS = Integer.toHexString(0xff & hesh[i]);
                    if(hexS.length() == 1)
                        hexStr.append('0');
                    hexStr.append(hexS);
                }
                return hexStr.toString();
            } catch(Exception exc){
               throw new RuntimeException(exc);
            }
        }
        // задача9
        public static String toCamelCase(String str) {
            str = str.toLowerCase();
            char[] newstr = str.toCharArray();
            newstr[0] = Character.toUpperCase(newstr[0]);
            str = "";
            for (int i = 0; i < newstr.length; i++) {
                if (newstr[i] == ' ' || newstr[i] == '-') {
                    if ((newstr[i + 1] == 'i' && newstr[i + 2] == 'n')
                            || (newstr[i + 1] == 'a' && newstr[i + 2] == 'n' && newstr[i + 3] == 'd')
                            || (newstr[i + 1] == 't' && newstr[i + 2] == 'h' && newstr[i + 3] == 'e')
                            || (newstr[i + 1] == 'o' && newstr[i + 2] == 'f')) {
                    } else
                        newstr[i + 1] = Character.toUpperCase(newstr[i + 1]);
                }
                str += newstr[i];
            }
            return str;
        }


         // задача10
         public static String hexLattice(int n) {
            String res = "";
            int c, i, j;
            double x = 1 / 2.0 + 1 / 6.0 * Math.sqrt(12.0 * n - 3); // hexagonal formula
            if (Math.ceil(x) == Math.floor(x)) { // check integer
                c = (int) x;
                for (i = 0; i < c; i++) { // each string to half
                    for (j = 0; j < c - i; j++) // spaces before
                        res += " ";
                    for (j = 0; j < c + i; j++) // letters "o"
                        res += "o ";
                    for (j = 0; j < c - i - 1; j++) // spaces after
                        res += " ";
                    res += "\n"; // next string
                }
                for (i = c - 2; i >= 0; i--) { // each string from half+1 to end
                    for (j = 0; j < c - i; j++) // spaces before
                        res += " ";
                    for (j = 0; j < c + i; j++) // letters "o"
                        res += "o ";
                    for (j = 0; j < c - i - 1; j++) // spaces after
                        res += " ";
                    res += "\n"; // next string
                }
            } else
                res = "Invalid";
            return res;
        }
}