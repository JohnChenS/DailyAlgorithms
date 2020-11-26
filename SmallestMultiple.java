/**
 * @author John Chen
 * @Date 20201030
 */
public class SmallestMultiple {
    /*
    2520是最小的能够被1到10整除的数。
    最小的能够被1到20整除的正数是多少？
     */

    /*
    分析：肯定是要用到循环来遍历，那如何改进这个循环的效率，像这种大型数字，
    逐次加一肯定是低效的，那只能找到一个合适的参数，让每次遍历即能达到一个较大的步长，
    又不会错过期间的一些数字。
    比如能整除1-10里的数，都是10 * (10 - 1)的倍数
    故我们能知道能整除1-20里的数，都是20 * (20 - 1)的倍数
    根据这个线索，我们就找到了遍历的步长，问题也就迎刃而解
     */
    public static int findMultiple(){
        for (int i = 1; i < Integer.MAX_VALUE ; i++) {
            for (int j = 2; j <= 20; j++) {
                if(((i * 380) % j) != 0)
                    break;           //这一步也能提高效率，当1-20中任意数无法整除时，直接跳出内层循环，搞下一个数字
                if((j == 20)&&(((i * 380) % j) == 0))
                    return (i * 380);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("能整除1-20的最小整数是：" + findMultiple());
    }
    /*
    在if语句里不要嫌麻烦，多打一些括号，让逻辑变得清晰，有时候不知道哪来的bug也得到解决！
     */
}
