package example;

import java.util.*;

class HeavyWork implements Runnable {

    String name;

    public HeavyWork(String name) {
        this.name = name;
    }

    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100); // 0.1 초 대기한다.
            } catch (Exception e) {
            }
        }
        System.out.printf("%s done.\n", this.name);
    }
    
}

public class exam5 {

    public static void main(String[] args) {
        /**
         * 1. 패키지 오류 수정하기
         * 
         * 다음처럼 house 패키지로 정의된 클래스가 있다.
         * 
         * package house;
         * 
         * public class HousePark {
         * protected String lastname = "park";
         * 
         * public String getLastname() {
         * return this.lastname;
         * }
         * }
         * 
         * 다음처럼 Sample 클래스에서 HousePark 클래스를 사용하려 한다.
         * 
         * import HousePark;
         * 
         * public class Sample {
         * public static void main(String[] args) {
         * HousePark housePark = new HousePark();
         * System.out.println(housePark.getLastname());
         * }
         * }
         * 
         * 하지만 위와 같이 작성하면 HousePark 클래스를 찾을 수 없다는 오류가 발생한다.
         * 
         * import 문을 수정하여 오류를 해결하시오.
         * 
         * import HosePark -> house.HosePark or house.*
         * 
         */

        // int result = 0;
        // try {
        // int[] a = {1, 2, 3};
        // int b = a[3];
        // ArrayList c = new ArrayList(Arrays.asList("3"));
        // int d = (int) c.get(0);
        // int e = 4 / 0;

        // /**
        // * a = [1,2,3]
        // * b ? error
        // *
        // * 결과 result = 3+4 = 7?
        // */

        // } catch (ClassCastException e) {
        // result += 1;
        // } catch (ArithmeticException e) {
        // result += 2;
        // } catch (ArrayIndexOutOfBoundsException e) {
        // result += 3;
        // } finally {
        // result += 4;
        // }
        // System.out.println(result); // result 의 값은 무엇일까?

        /**
         * 3. 스레드 적용하기
         * 
         * class HeavyWork {
         * String name;
         * 
         * HeavyWork(String name) {
         * this.name = name;
         * }
         * 
         * public void work() {
         * for (int i = 0; i < 5; i++) {
         * try {
         * Thread.sleep(100); // 0.1 초 대기한다.
         * } catch (Exception e) {
         * }
         * }
         * System.out.printf("%s done.\n", this.name);
         * }
         * }
         * 
         * public class Sample {
         * public static void main(String[] args) {
         * long start = System.currentTimeMillis();
         * for (int i = 1; i < 5; i++) {
         * HeavyWork w = new HeavyWork("w" + i);
         * w.work();
         * }
         * long end = System.currentTimeMillis();
         * System.out.printf("elapsed time:%s ms\n", end - start);
         * }
         * }
         * 
         */

        // long start = System.currentTimeMillis();
        // ArrayList<Thread> threadList = new ArrayList<>();
        
        // for (int i = 1; i < 5; i++) {
            
        //     Thread w = new Thread(new HeavyWork("w" + i));
        //     w.start();
        //     threadList.add(w);
        // }

        // for (Thread j : threadList) {
        //     try {
        //         j.join();
        //     } catch (Exception e) {
        //         System.out.println(e);
        //     }
        // }

        // long end = System.currentTimeMillis();
        // System.out.printf("elapsed time:%s ms\n", end - start);
        
        /**
         * 4. 홀수에만 2를 곱하여 리턴하기
         * 
         * import java.util.ArrayList;

            public class Sample {
                public static void main(String[] args) {
                    int[] numbers = {1, 2, 3, 4, 5};
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int num : numbers) {
                        if (num % 2 == 1) {  // 홀수이면 
                            temp.add(num * 2);  // 2를 곱하여 temp에 담는다.
                        }
                    }

                    // 정수 리스트를 정수배열로 변환한다.
                    int[] result = new int[temp.size()];
                    for (int i = 0; i < temp.size(); i++) {
                        result[i] = temp.get(i);
                    }
                }
            }
            * 
            * 위 코드를 함수형 프로그래밍을 사용하여 표현해 보자.
            * 
            */
            // int[] numbers = {1, 2, 3, 4, 5};
            
            // int[] result = Arrays.stream(numbers)
            //         .filter((a)-> a%2==1)
            //         .map((a) -> a*2)
            //         .toArray();
            // System.out.println(result);

            /**
             * 
             * 5. 음수 제거하기
                함수형 프로그래밍을 사용하여 다음의 정수 배열에서 음수를 모두 제거해 보자.

                int[] numbers = {1, -2, 3, -5, 8, -3};
                즉, 프로그램 실행 후 다음과 같은 정수 배열을 얻어야 한다.

                int[] result = {1, 3, 8};
             * 
             */

            int[] numbers = {1, -2, 3, -5, 8, -3};

            int[] result = Arrays.stream(numbers)
                    .filter((a) -> a >=0)
                    .toArray();

    }
}
