import java.util.Random;
import java.util.Scanner;

/**
 * @author John Chen
 * @Date 20201115
 */
public class chatAI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        boolean flag = true;
        while(flag){
            sc.nextLine();
            int temp = rd.nextInt(3);
            if(temp == 2){
                System.out.println("嗯");
            }else {
                System.out.println("哦");
            }
        }
    }
}
