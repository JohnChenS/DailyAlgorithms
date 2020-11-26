/**
 * @author John Chen
 * @Date 20201026
 */
public class bigPalindrome {
    /*
    002
    回文数就是从前往后和从后往前读都一样的数。由两个2位数相乘得到的最大回文乘积是 9009 = 91 × 99。
    找出由两个3位数相乘得到的最大回文乘积。
     */
    public static int bigPalindrome(){
        //原题解法
        int max = 0;
        for (int i = 999; i > 99 ; i--) {
            for (int j = 999; j > 99 ; j--) {
                int mul = i * j;
                //先把每个乘积反转
                StringBuilder s = new StringBuilder(String.valueOf(mul));
                String num = s.reverse().toString();
                //假若乘积反转后等于原乘积数值，则比较大小
                if(num.equals(String.valueOf(mul))){
                    if(mul > max){
                        max = mul;
                        System.out.println("以上数据作废");
                        System.out.println("第一个乘数为："+ i);
                        System.out.println("第二个乘数为："+ j);
                        System.out.println();
                    }
                }
            }
        }
        return max;
    }

    public static int myBigPalindrome(){
        //若把题目改成两个相同的三位数相乘的回文数，则是这个解法
        for (int i = 999; i > 100 ; i--) {
            int mul = i * i;
            int g,s,b,q,w,sw;//个 十 百 千 万 十万
            g = mul % 10;
            s = mul / 10 % 10;
            b = mul / 100 % 10 ;
            q = mul / 1000 % 10 ;
            w = mul / 10000 % 10 ;
            sw = mul / 100000 ;
            if ((g == sw )&&(s == w)&&(b == q)){
                System.out.println(g);
                System.out.println(s);
                System.out.println(b);
                System.out.println(q);
                System.out.println(w);
                System.out.println(sw);
                System.out.println(i);
                return mul;
            }
        }
        System.out.println("无");
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(bigPalindrome());
        System.out.println("-------------------------------");
        System.out.println(myBigPalindrome());
    }
}
