/**
 * @author John Chen
 * @Date 20201028
 */
public class CarelessMing {
    /*
    小明是个急性子，上小学的时候经常把老师写在黑板上的题目抄错了。
    有一次，老师出的题目是：36 x 495 = ?
    他却给抄成了：396 x 45 = ?
    但结果却很戏剧性，他的答案竟然是对的！！
    因为 36 * 495 = 396 * 45 = 17820
    类似这样的巧合情况可能还有很多，比如：27 * 594 = 297 * 54
    ***************************************************************
    假设 a b c d e 代表1~9不同的5个数字（注意是各不相同的数字，且不含0）//这一句为重点
    ***************************************************************
    能满足形如： ab * cde = adb * ce 这样的算式一共有多少种呢？
    请你利用计算机的优势寻找所有的可能，并回答不同算式的种类数。
    满足乘法交换律的算式计为不同的种类，所以答案肯定是个偶数。
    答案直接通过浏览器提交。
    注意：只提交一个表示最终统计种类数的数字，不要提交解答过程或其它多余的内容。
    142，暴力到没朋友，填空题暴力枚举就好，别想什么回溯
     */

    public static int carelessBoy(){
        /*
        如果不考虑abcde各为各不相同的算式，则用这个算法
         */
        int sum = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 10; j < 100; j++) {

                //旧乘数的积
                int oldResult = i * j;

                //接下来就是把第一个乘数的十位给到第二个乘数的十位，构成两个新乘数
                int newI = i % 10 + ( i / 100 )* 10;
                int newJ = j % 10 + ( j / 10 ) * 100 + ( i % 100 / 10 ) *10;

                //新乘数的积
                int newResult = newI * newJ;

                if(oldResult == newResult){
                    sum++;
                    System.out.println(i + " * " + j + " = " + newI + " * " + newJ + " = " + oldResult + " " + newResult);
                }
            }
        }
        return sum;
    }

    public static int carelessNotSameNumber(){
        int sum = 0;
        for (int i = 102; i < 990 ; i++){
            for (int j = 10; j < 99; j++) {
                int oldResult = i * j;

                int ig = i % 10;
                int is = i % 100 / 10;
                if((ig == is) || (ig == 0) || (is == 0))
                    continue;;

                int ib = i / 100;
                if((ig == ib) || (is == ib) || (ib == 0))
                    continue;;

                int jg = j % 10;
                if((ig == jg) || (is == jg) || (ib ==jg) || (jg == 0))
                    continue;

                int js = j / 10;
                if((ig == js) || (is == js) || (ib == js) || (jg == js) || (js == 0))
                    continue;

                int newI = (ig + (ib * 10));
                int newJ = (jg + (is * 10) + (js * 100));
                int newResult = newI * newJ;

                if(newResult == oldResult) {
                    sum++;
                    System.out.println(i + " * " + j + " = " + newI + " * " + newJ + " = " + oldResult + " " + newResult);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("若不考虑abcde不能为同个数字，则有： " + carelessBoy() + " 种");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("若考虑abcde不能为同个数字且不含0，则有： " + carelessNotSameNumber() + " 种");

        /*
        总结：要多看题意啊，不要匆匆作答！
         */

    }
}
