package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;

public class exam2 {
    public static void main(String[] args) {

        /**
         * 1. 조건문의 참과 거짓
         * 
         * 다음 코드의 출력 결과는 무엇일까? (눈으로 해석하고 풀어보자.)
         */

        String a = "write once, run anywhere";
        if (a.contains("wife")) {
            System.out.println("wife");
        } else if (a.contains("once") && !a.contains("run")) {
            System.out.println("once");
        } else if (!a.contains("everywhere")) {
            System.out.println("everywhere");
        } else if (a.contains("anywhere")) {
            System.out.println("anywhere");
        } else {
            System.out.println("none");
        }

        // A: everywhere

        /**
         * 2. 3의 배수의 합
         * 
         * while문을 사용해 1부터 1000까지의 자연수 중 3의 배수의 합을 구해 보자.
         * 
         */
        int sumNum = 0;
        int i = 2;

        while (i < 1000) {
            if (i % 3 == 0)
                sumNum += i;
            i++;
        }
        System.out.println(sumNum);

        /**
         * 3. 별 표시하기
         * 
         * while문 또는 for 문을 사용하여 다음과 같이 별(*)을 표시하는 프로그램을 작성해 보자.
         * 
         * *
         * **
         * ***
         * ****
         * *****
         * 
         */
        for (int j = 1; j < 6; j++) {

            for (int l = 0; l < j; l++) {
                System.out.printf("*");
            }
            System.out.println();
        }

        /**
         * 4. 1부터 100까지 출력하기
         * 
         * for문을 사용해 1부터 100까지의 숫자를 출력해 보자.
         * 
         */

        for (int hun=1; hun<101; hun++){
            System.out.println(hun);
        }

        /**
         * 5. 평균점수 구하기
         * 
         * A 학급에 총 10명의 학생이 있다. 이 학생들의 중간고사 점수는 다음과 같다.
         * for each 문을 사용하여 A 학급의 평균 점수를 구해 보자.
         * 
         */

        int[] marks = {70, 60, 55, 75, 95, 90, 80, 80, 85, 100};

        int average = 0;

        for(Integer aver: marks) {
            average += aver;
        }
        System.out.println(average/marks.length);
    }
}