/**
 * @author John Chen
 * @Date 20201027
 */
public class CoinsGame {
    /*
    *****
    英国的货币单位包括英镑£和便士p，在流通中的硬币一共有八种：
    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), £2 (200p)
    以下是组成£2的其中一种可行方式：
    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
    不限定使用的硬币数目，组成£2有多少种不同的方式？
     */


    public static int coinsSum(int totalMoney,int index){
        int money[] = {1, 2, 5, 10, 20, 50, 100, 200};
        int sum = 0;
        for (int i = index; i < money.length; i++) {
            if(totalMoney - money[i] == 0){
                sum++;
                break;
            }
            if(totalMoney - money[i] > 0)
                sum += coinsSum(totalMoney - money[i], i);
        }
        return sum;
    }


    public static void main(String[] args) {
        /*
        Solution 1 - 暴力求解
        暴力循环，只需要达到：
        X1×£1 + X2×50p + X3×20p + X4×5p + X5×2p + X6×1p == 2p
        其中，X1, X2, ..., X6是未知整数，找出所有可能的组合。
        缺点：用六层循环
         */
        double sum = 1;     //省略最内一层循环，即一个200的硬币的组合
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 41; k++) {
                    for (int l = 0; l < 21; l++) {
                        for (int m = 0; m < 11; m++) {
                            for (int n = 0; n < 5; n++) {
                                for (int o = 0; o < 3; o++) {
                                    if(( i + 2 * j + 5 * k + 10 * l + 20 * m + 50 * n + 100 * o)==200)
                                        sum += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("一共"+ sum +"种组合。");

        System.out.println("--------------------------------------------");

        /*totalMoney是表示总的金额，index表示的是需要的货币面额从什么开始
          比如index为0，表示使用所有面额的货币，为5，则只使用面额为100和200的货币
         */
        System.out.println(coinsSum(200,0));

    }
}
