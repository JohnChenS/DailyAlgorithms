/**
 * @author John Chen
 * @Date 20201120
 */
public class HowManyGrid {
    /*
    2018年第九届蓝桥杯省赛试题及详解（Java本科B组）第二题
    方格计数
    如图p1.png所示，在二维平面上有无数个1x1的小方格。
    我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
    你能计算出这个圆里有多少个完整的小方格吗？
     */

    /*
    思路：根据圆的对称性，我们其实只要对1/4的正半轴圆（也就是右上角的四分之一圆）进行暴力枚举每个方格，
    这里我们可以转换下关注点，用右上角的点代表一个方格，因为右上角圆只要有了右上角的点则就算一个完整的小方格，
    因为它是最远点，距离公式
    答案：3137548，做法其实还有很多，不过填空题这样最快最稳
     */
    public static void main(String[] args) {
        int r = 1000;
        int count = 0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < r; j++) {
                if(( i * i + j * j ) <= r * r )
                    count++;
            }
        }
        count *= 4;
        System.out.println(count);
    }
}
