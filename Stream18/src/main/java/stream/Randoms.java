package stream;

import java.util.Random;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/8 17:26
 */
public class Randoms {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            doubleColorBall();
        }

    }

    private static void doubleColorBall() {
        new Random()
                .ints(1, 33)
                .distinct()
                .limit(6)
                .sorted()
                .forEach(ele ->{
                    System.out.print(ele +" ");
                });
        new Random()
                .ints(1, 16)
                .distinct()
                .limit(1)
                .sorted()
                .forEach(System.out::println);
    }


}
