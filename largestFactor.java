/**
 * @author John Chen
 * @Date 20201026
 */
public class largestFactor {
    public static long primeFactor(long myNumber){

        if(myNumber == 1)
            return 1;

        for (int i = 2; i < myNumber/2 + 1; i++) {   //事实证明myNumber/2+1与单纯myNumber相比，速度没有明显提升
            if (myNumber % i == 0)
                return primeFactor(myNumber / i);
            /*
            此算法的精妙之处：
            此处递归的分析，当一个数除以2能整除的话，它的商即是的最大因数（除了他自己），
            所以递归它的商，来判断它的商是不是质数，若是质数，则它的商是它的最大质因数。
             */
            }
        return myNumber;
    }

    public static void main(String[] args) {
        /*
        13195的所有质因数为5、7、13和29。
        600851475143最大的质因数是多少？

        分析：
        600851475143要用long类型来存储
         */
        long start = System.nanoTime();

        long myNumber = 600851475143L;
        System.out.println( primeFactor(myNumber));

        long end = System.nanoTime();
        long time = end - start;
        System.out.println("用时：" + time);
    }
}
