/**
 * Created by jacky on 17-4-25.
 */
public class Problem6 {

    public static String convert(String s, int numRows) {
        if (numRows==1) return s;
        int count=0,c=0,k=numRows-2;
        char[][] t=new char[numRows][s.length()/2+1];
        while (count<s.length()){
            if (c%(numRows-1)==0){
                for (int i=0;i<numRows;i++){
                    t[i][c]=s.charAt(count++);
                    if (count>=s.length()) break;
                }
                c++;
            }else {
                t[k--][c]=s.charAt(count++);
                c++;
                if (k==0)k=numRows-2;
            }
        }
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<numRows;i++){
            for (int j=0;j<c;j++){
                if (t[i][j]!='\u0000') {
                    builder.append(t[i][j]);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("A",1));
    }
}
