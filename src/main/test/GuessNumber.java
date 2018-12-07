import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Integer number = generateNum();
        guessNum(number);
    }

    /**
     * 生成一个随机数字，并返回该数字
     * @return 随机生成的数字
     */
    private static Integer generateNum() {
        Random random = new Random();
        Integer i = random.nextInt(100) + 1;
        System.out.println("随机生成了一个0~100以内的数字，猜猜看它是多少:");
        return i;
    }

    /**
     * 猜数字游戏
     * @param randomNumber 随机生成的数字
     */
    private static void guessNum(Integer randomNumber){
        boolean flag = true;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            if (randomNumber == -1) {
                randomNumber = generateNum();
            }
            String number = scanner.nextLine().trim();
            //只允许用户输入一个1-3位的数字,否则让用户重新输入
            while ("".equals(number) || !number.matches("^\\d{1,3}$")) {
                System.out.println("请输入一个数字:");
                number = scanner.nextLine();
            }
            count += 1;

            Integer inputNum = Integer.parseInt(number);

            if (inputNum > randomNumber) {
                System.out.println("第"+ count + "次,比随机生成的数字大了一点哦~");
            } else if(inputNum < randomNumber) {
                System.out.println("第"+ count + "次,比随机生成的数字小了一点哦~");
            }  else{
                System.out.println("恭喜您猜对了~， 共猜了" + count + "次");
                System.out.println("输入1继续游戏，其他任意键退出.");
                String flagStr = scanner.nextLine().trim();
                if (!flagStr.equals("1")) {
                    flag = false;
                } else {
                    System.out.println("游戏继续:");
                    randomNumber = -1;
                }
            }

        }
        System.out.println("游戏结束.");
    }
}
