/**
 * @author John Chen
 * @Date 20201102
 */
public class SeachPrimeNumber {
    /*
    prime number：除了1和它本身，不能被其他数整除

    列出前6个素数，它们分别是2、3、5、7、11和13。我们可以看出，第6个素数是13。
    第10,001个素数是多少？
     */

    /*
    分析：已知从13开始就是第六个了。
    那么遍历的时候每次+2会快一点，因为像14 16 18这些数肯定是非素数
     */
    static int count = 6;

    public static int seachPN(){
        int temp = 0;
        for (int i = 15; count < 10001; i += 2) {   //count不打到目标不罢休，i直接+=2，提高效率
            for (int j = 3; j <= (i / 2); j++) {    //我们已经排除能被2整除的数了，j就直接从3开始
                if((i % j) == 0)
                    break;
                else if( j == (i / 2)) {              //如果j已经达到最大可达除数，则证明该i是素数
                    count++;
                    temp = i;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("第10001个素数是： " + seachPN());
    }
}
