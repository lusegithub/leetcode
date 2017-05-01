package aliTest;

import java.util.Scanner;

/**
 * Created by jacky on 17-4-26.
 */
public class Problem1 {
    public static int match(String matchString,String pattern){
        if (matchString.charAt(0)!=pattern.charAt(0)) return 0;
        int count=1,p=1,flag=0;
        while (count<matchString.length()){
            if (pattern.charAt(p)==matchString.charAt(count)) {
                count++;
                p++;
                continue;
            }
            if (pattern.charAt(p)!=matchString.charAt(count)){
                if (pattern.charAt(p)=='?'){
                    count++;
                    p++;
                    continue;
                }else if (pattern.charAt(p)=='*'){
                    if (pattern.charAt(p+1)==matchString.charAt(count)){
                        p++;
                        continue;
                    }else {
                        count++;
                        continue;
                    }
                }else {
                    break;
                }
            }
        }
        if (count==matchString.length()) flag=1;
        return flag;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int i=0;
        String[] s=new String[2];
        while (i<2){
            s[i]=in.nextLine();
            i++;
        }
        System.out.println(match(s[0],s[1]));
    }
}
