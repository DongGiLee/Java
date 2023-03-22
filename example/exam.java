package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;

public class exam {
    public static void main(String[] args){
        
        /**
         * 1. 평균점수 구하기
         * 
         * 국어 : 80
         * 영어 : 75
         * 수학 : 55
         */
        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(80,75,55));

        IntSummaryStatistics statistics = intArray
                .stream()
                .mapToInt(num -> num)
                .summaryStatistics();
        
        int ex1 = (int) statistics.getAverage();
        
        System.out.println(ex1);

        /**
         * 2. 홀수 짝수 판별
         * 
         * 자연수 13이 홀수인지 짝수인지 판별할 수 있는 방법에 대해 작성
         */
        int naturalNumber = 13%2;
        boolean isEven ;
        if (naturalNumber==0) {
            isEven = true;
        } else isEven = false;
        
        System.out.println(isEven);

        /**
         * 3. 주민등록번호 나누기
         * 
         * 홍길동 씨의 주민등록번호는 881120-1068234이다. 
         * 홍길동 씨의 주민등록번호를 연월일(YYYYMMDD) 부분과 그 뒤의 숫자 부분으로 나누어 출력해 보자.
         * 
         */

        String idNumber = "881120-1068234";

        System.out.println(idNumber.substring(0, 6));
        System.out.println(idNumber.substring(7, idNumber.length()));
        
        /**
         * 4. 주민등록번호 인덱싱
         * 
         * 주민등록번호 뒷자리의 맨 첫 번째 숫자는 성별을 나타낸다.
         * 주민등록번호에서 성별을 나타내는 숫자를 출력해 보자.
         * 
         */

        String pin = "881120-1068234";

        System.out.println(pin.charAt(7));

         
        /**
         * 5. 문자열 바꾸기
         * 
         * 다음과 같은 문자열 a:b:c:d가 있다.
         * 문자열의 replace 함수를 사용하여 a#b#c#d로 바꿔서 출력해 보자.
         * 
         */

         String a = "a:b:c:d";

         
         System.out.println(a.replace(":","#"));


        /**
         * 6. 리스트 역순 정렬하기
         * 
         * 다음과 같은 [1, 3, 5, 4, 2] 리스트를
         * [5, 4, 3, 2, 1]로 만들어 보자.
         * 
         */
        
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        myList.sort(Comparator.reverseOrder());
        
        System.out.println(myList); // [1, 3, 5, 4, 2] 출력

        /**
         * 7. 리스트르 문자열로 만들기
         * 
         * 다음과 같은 ['Life', 'is', 'too', 'short'] 리스트를
         * "Life is too short" 문자열로 만들어 출력해 보자.
         * 
         */

         ArrayList<String> myList2 = new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        System.out.println(myList2); // [Life, is, too, short] 출력

        System.out.println(String.join(" ",myList2));


        /**
         * 8. 맵에서 값 추출하기
         * 
         * 다음의 맵 grade에서 "B'에 해당되는 값을 추출해 보자.
         * (추출하고 나면 grade에는 "B"에 해당하는 아이템이 사라져야 한다.)
         * 
         */

        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);

        

        System.out.println(grade);
        System.out.println(grade.remove("B"));
        System.out.println(grade);


        /**
         * 9. 중복 숫자 제거하기
         * 
         * 다음의 numbers 리스트에서 중복 숫자를 제거해 보자.
         * 
         */

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);  // [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5] 출력

        HashSet<Integer> setNumbers = new HashSet<>(numbers);

        System.out.print(setNumbers);


        /**
         * 10. 매직넘버 제거하기
         * 
         * 다음은 커피의 종류(1: 아메리카노, 2:아이스 아메리카노, 3:카페라떼)를 입력하면
         * 커피의 가격을 알려주는 프로그램이다.
         * 
         * 코드에서 1, 2, 3과 같은 매직넘버를 제거하여 프로그램을 개선해보자.
         */

         printCoffeePrice2(CoffeType.AMERICANO);

    }
    enum CoffeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    }
    static void printCoffeePrice2(CoffeType type) {
        HashMap<CoffeType, Integer> priceMap = new HashMap<>();

        priceMap.put(CoffeType.AMERICANO, 3000);
        priceMap.put(CoffeType.ICE_AMERICANO, 4000);
        priceMap.put(CoffeType.CAFE_LATTE, 5000);

        int price = priceMap.get(type);
        System.out.printf("\n커피 가격은 %d원 입니다.", price);
    }

    static void printCoffeePrice(int type) {
        HashMap<Integer, Integer> priceMap = new HashMap<>();
        priceMap.put(1, 3000);  // 1: 아메리카노
        priceMap.put(2, 4000);  // 2: 아이스 아메리카노
        priceMap.put(3, 5000);  // 3: 카페라떼
        int price = priceMap.get(type);
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }
}