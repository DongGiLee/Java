# Note
- Info
    - Date : _`2023.03.22`_
    - Git Branch : `0322_Getting-Started_3`
    - Reference : https://wikidocs.net/887
    - Archive : `Methods.md`
- 내용
    - 자료형
        - Enum
            > 서로 관련있는 상수 집합을 정의할때 사용한다.

            ```java
            public class Sample {
                enum CoffeeType {
                    AMERICANO,
                    ICE_AMERICANO,
                    CAFE_LATTE
                };

                public static void main(String[] args) {
                    System.out.println(CoffeType.AMERICANO); // AMERICANO 출력
                    System.out.println(CoffeType.ICE_AMERICANO); // ICE_AMERICANO 출력
                    System.out.println(CoffeType.CAFE_LATTE); // CAFE_LATTE 출력
                }
            }
            ```
            ```java
            AMERICANO
            ICE_AMERICANO
            CAFE_LATTE
            ```
            
            `CoffeeType.values()`는 CoffeType의 배열을 리턴한다.

            - 장점

                ```java
                /**
                * countSellCoffee는 판매된 커피의 갯수를 리턴하는 메서드이다.
                * @param type 커피의 종류 (1: 아메리카노, 2: 아이스 아메리카노, 3: 카페라떼)
                */
                int countSellCoffee(int type) {
                    ... 생략 ...
                }
                ```
                ```java
                int americano = countSellCoffee(1);
                ```
                아메리카노의 판매갯수를 알기위해서는 위처럼 숫자 1을 넘겨야한다.

                또한 숫자 1이 아메리카노인것을 기억을해야한다.

                ```java
                enum CoffeeType {
                    AMERICANO,
                    ICE_AMERICANO,
                    CAFE_LATTE
                };
                
                /**
                * countSellCoffee는 판매된 커피의 갯수를 리턴하는 메서드이다.
                * @param type 커피의 종류 (CoffeType)
                */
                int countSellCoffee(CoffeType type) {
                    ... 생략 ...
                }
                ```
                ```java
                int americano = countSellCoffee(CoffeType.AMERICANO); // 아메리카노의 판매갯수
                ```

                숫자 1을 사용했을때보다 코드가 명확해지고, CoffeType에 정의된 상수만 전달 할 수 있기 때문에 99처럼 엉뚱한 숫자값에 의한 오류가 발생하지않는다.
                - 매직넘버(1과 같은 숫자 상수값)를 사용할 때보다 코드가 명확 해진다.
                - 잘못된 값을 사용함으로 인해 발생할수 있는 위험성이 사라진다.
                > 상수로 선언하지 않은 숫자를 매직넘버라고한다.
    
    - 형변환
        - 문자열 -> 정수
            ```java
            public class Sample {
                public static void main(String[] args) {
                    String num = "123";
                    int n = Integer.parseInt(num);
                    System.out.println(n);  // 123 출력
                }
            }
            ```
            > Integer 는 int 자료형의 Wrapper 클래스이다.

        - 정수 -> 문자열
            1. 빈문자열 (`""`) 더하기

                ```java
                public class Sample {
                    public static void main(String[] args) {
                        int n = 123;
                        String num = "" + n;
                        System.out.println(num); // 123 출력
                    }
                }
                ```
            2. Wrapper 객체 메소드 사용
                ```java
                public class Sample {
                    public static void main(String[] args) {
                        int n = 123;
                        String num1 = String.valueOf(n);
                        String num2 = Integer.toString(n);
                        System.out.println(num1);  // 123 출력
                        System.out.println(num2);  // 123 출력
                    }
                }
                ```
                `String.valueOf(정수)`, `Integer.toString(정수)` 모두 정수를 문자열로 바꾸어 리턴
        
        - 문자열 -> 실수
            ```java
            public class Sample {
                public static void main(String[] args) {
                    String num = "123.456";
                    double d = Double.parseDouble(num);
                    System.out.println(d);
                }
            }
            ```
            ```java
            123.456
            ```
            `Double.parseDouble` or `Float.parseFloat` 를 사용하여 형변환 할수있다.

        - 정수 -> 실수
            > 자주사용되진 않음
            ```java
            public class Sample {
                public static void main(String[] args) {
                    int n1 = 123;
                    double d1 = n1;  // 정수를 실수로 바꿀때에는 캐스팅이 필요없다.
                    System.out.println(d1);  // 123.0 출력

                    double d2 = 123.456;
                    int n2 = (int) d2; // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅해 주어야 한다.
                    System.out.println(n2);  // 소숫점이 생략된 123 출력
                }
            }
            ```
            ```java
            123.0
            123
            ```
            실수를 정수로 변환하면 실수의 소숫점은 제거된다. 
            `int n2 = (int) d2;`에서 d2앞의 `(int)`는 자료형을 강제로 int 형으로 바꾼다는 의미이고 캐스팅(casting) 이라고 한다.

        - 문자열(실수 형태) -> 정수
            > Error가뜬다. `NumberFormatException`이 발생하므로 주의해야한다.
        
    - final
        > 자료형에 값을 한번만 설정할수 있게 강제하는 키워드이다. 즉 값을 한번 설정하면 그값을 다시 설정할수없다는 말이다.

        ```java
        public class Sample {
            public static void main(String[] args) {
                final int n = 123;  // final 로 설정하면 값을 바꿀수 없다.
                n = 456;  // 컴파일 에러 발생
            }
        }
        ```
        리스트의 경우도 final로 선언시 재할당은 불가능하다.
        ```java
        import java.util.ArrayList;
        import java.util.Arrays;

        public class Sample {
            public static void main(String[] args) {
                final ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b"));
                a = new ArrayList<>(Arrays.asList("c", "d"));  // 컴파일 에러 발생
            }
        }
        ```
        final은 프로그램 수행도중 그겂이 변경되면 안되는 상황에 사용한다.

        > Unmodifiable List
            
            리스트의 경우 final로 선언시 리스트에 값을 더하거나(add) 빼는(remove) 것은 가능하다.
            다만 재할당만 불가능할 뿐이다. 만약 그값을 더하거나 빼는 것도 불가능하게 하고 싶은 경우에는 List.of로 수정이 불가능한 리스트(Unmodifiable List)를 사용해야한다.

        ```java
        import java.util.List;

        public class Sample {
            public static void main(String[] args) {
                final List<String> a = List.of('a','b');
                a.add('c'); // UnsupportedOperationException 발생
            }
        }
        ```
    - 제어문
        - if
            > 타 언어와 똑같다.

            - contains
                > List자료형에 해당아이템이 있는지 조사할때 쓰임.

                ```java
                ArrayList<String> pocket = new ArrayList<String>();
                pocket.add("paper");
                pocket.add("handphone");
                pocket.add("money");

                if (pocket.contains("money")) {
                    System.out.println("택시를 타고 가라");
                }else {
                    System.out.println("걸어가라");
                }
                ```
        - switch/case
        - while
        - for
            > 형식은 : for (초기치; 조건문; 증가치) { ... }
        - for each
            
            _기존 for 문_
            ```java
            String[] numbers = {"one","two","three"};

            for(int i=0; i<numbers.length; i++){
                System.out.println(numbers[i]);
            }
            ```

            _for each 문_
            ```java
            for (type var: iterate) {
                body-of-loop
            }
            ```
            위에서 iterate는 루프를 돌릴 객체이고 iterate 객체에서 한개씩 순차적으로 대입되어 for 문이 수행된다.
            사용할수 있는 자료형은 `배열` 및 `ArrayList` 등만 가능하다.

            위 코드를 ArrayList로 구현한 예제이다.

            ```java
            import java.util.ArrayList;
            import java.util.Arrays;

            public class Sample {
                public static void main(String[] args) {
                    ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three"));
                    for (String number : numbers) {
                        System.out.println(number);
                    }
                }
            }
            ```