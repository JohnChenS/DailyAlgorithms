import java.util.Scanner;

/**
 * @author John Chen
 * @Date 20201127
 */

/*
   题目来源：洛谷 P1002 过河卒

   棋盘上 AA 点有一个过河卒，需要走到目标 BB 点。卒行走的规则：可以向下、或者向右。
   同时在棋盘上 CC 点有一个对方的马，该马所在的点和所有跳跃一步可达的点称为对方马的
   控制点。因此称之为“马拦过河卒”。
   棋盘用坐标表示，AA 点 (0, 0)(0,0)、BB 点 (n, m)(n,m)，同样马的位置坐标是需要给出的。

   现在要求你计算出卒从 AA 点能够到达 BB 点的路径的条数，假设马的位置是固定不动的，并不是卒走一步马走一步。

   输入格式
   一行四个正整数，分别表示 BB 点坐标和马的坐标。
   输出格式
   一个整数，表示所有的路径条数。样例：输入 6 6 3 3 输出 6
 */


public class EvilHorse {

    private static int[][] horseTerritory = new int[30][30];

    //把马的势力范围标记为1，以供主函数判断
    public static void horseTerritory(int horseA, int horseB){

        //马走日，除了自己当前位置，可达位置也要标记
        //末尾统一+2，是为了把棋盘总体向下和向右移两位，以防止马的势力范围在加减后变成负数
        horseTerritory[horseA+2][horseB+2] = 1;
        horseTerritory[horseA-1+2][horseB-2+2] = 1;
        horseTerritory[horseA-2+2][horseB-1+2] = 1;
        horseTerritory[horseA-1+2][horseB+2+2] = 1;
        horseTerritory[horseA-2+2][horseB+1+2] = 1;
        horseTerritory[horseA+1+2][horseB+2+2] = 1;
        horseTerritory[horseA+2+2][horseB+1+2] = 1;
        horseTerritory[horseA+1+2][horseB-2+2] = 1;
        horseTerritory[horseA+2+2][horseB-1+2] = 1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //可达方案棋盘，每个坐标的值代表有多少条路径可到达此坐标，初始化为0
        int[][] map = new int[30][30];

        System.out.println("请输入终点坐标和马的坐标：");
        int bingoA, bingoB, horseA, horseB;
        bingoA = sc.nextInt();
        bingoB = sc.nextInt();
        horseA = sc.nextInt();
        horseB = sc.nextInt();

        //标记马的势力范围
        horseTerritory(horseA, horseB);

        //把边界起始可达路径置为1
        map[2][1] = 1;

        //从2开始，是把棋盘总体向下向右移了两位
        for (int i = 2; i <= bingoA + 2; i++) {
            for (int j = 2; j <= bingoB + 2; j++) {
                //如果不是马的势力范围，就按坐标的左边和上面来确定拥有的可达方案
                if(horseTerritory[i][j] != 1){         //因为我们总体向右和向下移了2，所以要减回去
                    //每个坐标的可达路径为它上面一个点的可达路劲和它左边一个点的可达路径相加的结果
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }else{
                    map[i][j] = 0;
                }
            }
        }

        int solutions = map[bingoA+2][bingoB+2];

        System.out.println("可行方案共有：" + solutions + "个");

    }
}
