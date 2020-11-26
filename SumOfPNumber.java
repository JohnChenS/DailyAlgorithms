import java.util.ArrayList;

/**
 * @author John Chen
 * @Date 20201031
 */
public class SumOfPNumber {
    /*
    完全数是指真因数之和等于自身的那些数。例如，28的真因数之和为
    1 + 2 + 4 + 7 + 14 = 28，因此28是一个完全数。
    一个数n被称为亏数，如果它的真因数之和小于n；反之则被称为盈数。
    由于12是最小的盈数，它的真因数之和为1 + 2 + 3 + 4 + 6 = 16，
    所以最小的能够表示成两个盈数之和的数是24。
    通过数学分析可以得出，所有大于28123的数都可以被写成两个盈数的和；
    尽管我们知道最大的不能被写成两个盈数的和的数要小于这个值，但这是
    通过分析所能得到的最好上界。
    找出所有不能被写成两个盈数之和的正整数，并求它们的和。
     */

    /*

    分析：1.找出所有盈数，放进数组
    2.创建一个1-28123的数组nums[]
    3.让盈数们两两相加，把结果在nums[]中删去（若存在）
    4.让nums中数依次相加，return

    疑惑：
    1.数组该搞多大，用ArrayList应该好点

     */

    public static int sumAll(){

        //1.找出所有盈数，放进数组
        //已知信息已提示最小的盈数为12
        ArrayList <Integer> excessNums = new ArrayList<>();
        for (int i = 11; i < 28123; i++) { //题目并没有说要打到的盈数的最大值，故我们先保守地试一下到28123
            //以下写一个找盈数的算法
            if (excessValue(i))
                excessNums.add(i);
        }
        System.out.println(excessNums);
        System.out.println(excessNums.size());

        //2.创建一个1-28123的数组nums[]
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i < 28124; i++) {
            nums.add(i);
        }

        //3.让盈数们两两相加，把结果在nums[]中删去（若存在）
        for (int i = 0; i < excessNums.size(); i++) {             //遍历任意两盈数之和
            for (int j = 0; j < excessNums.size(); j++) {
                int temp = excessNums.get(i) + excessNums.get(j); //任意两盈数之和
                if(nums.contains(temp))
                    nums.remove(Integer.valueOf(temp));
            }
        }

        //4.让nums中数依次相加，return
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    public static boolean excessValue(int myNum){   //判断一个数是否为盈数
        boolean flag = false;
        int temp = 0;

        for (int i = 2; i < ((myNum / 2) + 1); i++) {     //从2开始，最后记得再加一个1回去就好
            if(myNum % i != 0)
                continue;
            else {
                temp += i;
            }
        }
        temp += 1;                             //记得把1加回去，如12的因数为 1 2 3 4 6，记得加回这个1
        if(myNum < temp)
            flag = true;
        
        return flag;
    }
    
    public static void main(String[] args) {

        //这个算法跑了两分钟
        System.out.println("所有不能被写成两个盈数之和的正整数的和为： " + sumAll());

        
    }
}
