import java.util.Calendar;

/**
 * @author John Chen
 * @Date 20201027
 */
public class Doomsday {
    /*
    2013年第四届蓝桥杯省赛试题及详解（Java本科B组）第一题
    曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。
    还有人称今后的某个世纪末的12月31日，如果是星期一则会....
    有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!!
    于是，“谣言制造商”又修改为星期日......
    1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
    请回答该年份（只写这个4位整数，不要写12月31等多余信息）

    答案：2299，Calender类可用于1970年以后的日期操作
    提示：Java中Calendar类的常用方法https://blog.csdn.net/yx0628/article/details/79317440
     */

    /*
    下面是我自己写的解法
     */
    public static boolean oneMoreDay(int year){           //方法名为判断是否为闰年，多一天
        if((year % 100 == 0)&&(year % 400 == 0))     //整百倍数年份判断
            return true;
        else if((year % 4 == 0 )&&(year % 100 !=0 ))
            return true;
        else return false;
    }

    public static void main(String[] args) {
        long days = 0;
        for (int i = 2000; i < 10000; i++) {
            //循环判断1999后的每一年是否为闰年，并加上一年的天数
            boolean flag = oneMoreDay(i);
            if(flag == true)
                days += 366;
            else days += 365;

            //判断是否为99年
            if(i % 100 == 99)
            {
                long weekday = 0;
                //若是99年，则再计算是为星期几
                weekday = (days + 5) % 7;
                if(weekday == 0)
                    System.out.println(i + "年的12月31号是周日");
            }
        }

        System.out.println("---------------------------------------------");
    /*
    下面为标准答案，直接调用API
     */
        Calendar calendar = Calendar.getInstance();//可用于1970年后操作日期用
        for (int year = 1999; year < 10000; year+=100) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,11);//12月  只有月份是0开始的，0对应1月
            calendar.set(Calendar.DAY_OF_MONTH,31);
            System.out.println(year+" "+calendar.get(Calendar.DAY_OF_WEEK));
            if(calendar.get(Calendar.DAY_OF_WEEK)==1){//1：星期天 2：星期一 外国人的第一天是星期天
                break;                                //如果找到了直接退出
            }
        }

    }



}
