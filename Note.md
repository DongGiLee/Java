# Note
- Info
    - Date : _`2023.03.28`_
    - Git Branch : [0328_Getting-Started_7](https://github.com/DongGiLee/Java/blob/0328_Getting-Started_7/Note.md)
    - Reference : [점프 투 자바](https://wikidocs.net/887)
    - Archive : [   [메소드모음](Methods.md),
                    [연습문제](/example),
                    [실습코드](Sample.java),
                    [에러모음](ErrorCase.md),
                    [이미지](/img)
                ]
- 내용
    - 패키지
        - 패키지 (package)
            
            > 네이밍 규칙은 패키지는 `소문자` 클래스명은 `파스칼케이스`

            > 비슷한 성격의 자바 클래스들을 모아 놓은 `자바의 디렉토리` 이다.

            - `인텔리제이`에서 package 생성할때
                ![인텔리제이 패키지생성](/img/ij9.png)
            - `vscode`에서 package 생성할때
                ![vscode 패키지생성](/img/create_package_vscode.png)
                
        - 서브패키지 (Subpackage)
            
            > 패키지 아래에 하위로 패키지를 생성하면된다.

        - 패키지 사용방법
            ```java
            import [package|package.subpackage|package.*]
            ```
        - 패키지 사용이유
            1. 클래스의 분류가 용이하다. (비슷한 것 끼리 묶는다.)
            2. 패키지가 다르다면 동일한 클래스명을 사용할 수 있다.

    - 접근제어자
    - 스태틱(static)
        [Note](https://github.com/DongGiLee/Java/blob/0320_Getting-Started_1/Note.md) 참조
    
    - 예외처리 (Exception)
        - 예외 처리하기
            ```java
            try{
                ...
            } catch (예외1) {
                ...
            } catch (예외2) {
                ...
            }
            ```
            기본적으로 다른 언어들과 같다. 예외란에 예외객체를 처리한다.
        - finally
            > 어떤 예외가 발생하더라도 반드시 실행되어야 하는 부분이 있다면 `finally`에 넣어주자

            ```java
            try {
                ...
            } catch {
                ...
            } finally {
                ...
            }
            ```
        - RuntimeException 과 Exception
            > 예외 객체를 만들어서 처리할수도있다.

            ```java
            class FoolException extends RuntimeException {
                ...
            }
            
            public class Sample {
                public void sayNick(String nick) {
                    if ("fool".equals(nick)) {
                        throw new FoolException();
                    }
                    System.out.println("당신의 별명은 "+nick+"입니다.");
                }

                public static void main(String[] args) {
                    Sample sample = new Sample();
                    sample.sayNick("fool");
                    sample.sayNick("genious");
                }
            }
            ```
            
            `FoolException` 으로 던져준 구간에서 다음과 같은 예외가 발생한다.

            ```
            Exception in thread "main" FoolException
                at Sample.sayNick(Sample.java:7)
                at Sample.main(Sample.java:14)
            ```
            - Exception의 종류
                - RuntimeException
                    - 실행시 발생하는 예외
                    - 발생 할수도 안 할수도 있는경우 작성
                - Exception
                    - 컴파일시 발생하는 예외
                    - 프로그램 작성시 이미 예측가능한 예외를 작성할때 사용

                > 위와 같이 Exception을 `Checked Exception`, `RuntimeException`, `Unchecked Exception` 이라고도한다.
        
        - Exception
            
            위 RuntimeException을 Exception으로 바꿔보자

            ```java
            class FoolException extends Exception {
                ...
            }
            ```
            이렇게하면 Sample 클래스에서 컴파일 오류가 발생할 것이다.

            예측 가능한 `Checked Exception` 이기 때문에 예외처리를 컴파일러가 강제하기 때문이다.

            ```java
            class FoolException extends Exception {
                }

                public class Sample {
                    public void sayNick(String nick) {
                        try {
                            if("fool".equals(nick)) {
                                throw new FoolException();
                            }
                            System.out.println("당신의 별명은 "+nick+" 입니다.");
                        }catch(FoolException e) {
                            System.err.println("FoolException이 발생했습니다.");
                        }
                    }

                    public static void main(String[] args) {
                        Sample sample = new Sample();
                        sample.sayNick("fool");
                        sample.sayNick("genious");
                    }
                }
            ```
            컴파일 오류를 막기위해 `sayNick` 메서드에서 `try ... catch ` 문으로 `FoolException`을 처리해야한다.
        
        - 예외 던지기 (throws)

            `FoolException` 을 발생시키고 예외처리도 `sayNick` 메서드에서 했는데 이렇게 하지않고 호출한곳에서 `FoolException`을 처리하도록 예외를 위로 던질 수 있는 방법이다.

            ```java
            public class Sample {
                public void sayNick(String nick) throws FoolException {
                    // try ... catch 문을 삭제할수있다.
                    if ("fool".euqals(nick)){
                        throw new FoolException();
                    }
                    System.out.println("당신의 별명은 "+nick+" 입니다.");
                }
                public static void main(String[] args) {
                        Sample sample = new Sample();
                        sample.sayNick("fool");
                        sample.sayNick("genious");
                    }
            }
            ```
            
            `sayNick` 메서드 뒷부분에 `throws` 라는 구문을 이용하여 `FoolException`을 위로 보낼수 있다. ("예외를 뒤로 미루기" 라고도한다.)

            이와같이 `sayNick` 메서드를 변경하면 이제 `main` 메서드에서 컴파일 에러가 발생할 것이다.
            
            `throws` 구문 떄문에 `FoolException`의 예외를 처리해야 하는 대상이 `sayNick` 메서드에서 `main` 메서드(sayNick 메서드를 호출하는 메서드)로 변경 되었기 때문이다.

        - 트랜잭션 (Transaction)
            > 트랜잭션은 하나의 작업 단위를 뜻한다.

            예를 들어 쇼핑몰의 "상품발송"이라는 트랜잭션을 가정해보자.

            "상품발송"이라는 트랜잭션에는 다음과 같은 작업들이 있을 수 있다.
            
            - 포장
            - 영수증 발행
            - 발송

            쇼핑몰의 운영자는 이 3가지 일들 중 하나라도 실패하면 3가지 모두 취소하고 "상품발송" 전의 상태로 되돌리고 싶을 것이다.
            
            > 모두 취소하지 않으면 데이터의 정합성이 크게 흔들리게 된다. 이렇게 모두 취소하는 행위를 전문용어로 `롤백(Rollback)`이라고 말한다.

            - _상품발송 수도코드_
                > 수도코드(슈도코드, pseudocode)는 일반적인 언어로 코드를 흉내내어 알고리즘을 써놓은 코드

                ```java
                상품발송() {
                    포장();
                    영수증발행();
                    발송();
                }

                포장() {
                    ...
                };
                영수증발행() {
                    ...
                };
                발송() {
                    ...
                };

                ```

                - 트랜잭션 처리방법
                ```java
                상품발송() {
                    try {
                        포장();
                        영수증발행();
                        발송();
                    }catch(예외) {
                        모두취소();  // 하나라도 실패하면 모두 취소한다.
                    }
                }

                포장() throws 예외 {
                ...
                }

                영수증발행() throws 예외 {
                ...
                }

                발송() throws 예외 {
                ...
                }
                ```
    - 쓰레드 (Thread)
        > 동작하고 있는 프로그램을 `프로세스(Process)` 라고 한다. 보통 한 개의 프로세스는 한 가지의 일을 하지만 `쓰레드`를 이용하면 한 프로세스 내에서 `두 가지 또는 그이상의 일을 동시에` 할 수 있다.

        - Thread
            
            ```java
            public class Sample extends Thread {
                public void run() { // Thread 를 상속하면 run 메서드를 구현해야한다.
                    System.out.println("thread run.");
                }

                public static void main(String[] args) {
                    Sample sample = new Sample();
                    sample.start();
                }
            }
            ```
            Sample 클래스가 Thread 클래스를 상속했다. Thread 클래스의 run 메서드를 구현하면 위 예제와 같이 `sample.start()` 실행시 `sample` 객체의 `run` 메서드가 수행된다.

            > `Thread` 클래스를 extends 했기 때문에 `start` 메서드 실행시 `run` 메서드가 수행된다. `Thread` 클래스는 `start` 실행 시 `run` 메서드가 수행되도록 내부적으로 동작한다

            _쓰레드의 동작을 확인할 수 있는 예제_
            ```java
            public class Sample extends Thread {
                int seq;

                public Sample(int seq) {
                    this.seq = seq;
                }

                public void run() {
                    System.out.println(this.seq + " thread start.");  // 쓰레드 시작
                    try {
                        Thread.sleep(1000);  // 1초 대기한다.
                    } catch (Exception e) {
                    }
                    System.out.println(this.seq + " thread end.");  // 쓰레드 종료 
                }

                public static void main(String[] args) {
                    for (int i = 0; i < 10; i++) {  // 총 10개의 쓰레드를 생성하여 실행한다.
                        Thread t = new Sample(i);
                        t.start();
                    }
                    System.out.println("main end.");  // main 메서드 종료
                }
            }
            ```
            
            ```
            0 thread start.
            4 thread start.
            6 thread start.
            2 thread start.
            main end.
            3 thread start.
            7 thread start.
            8 thread start.
            1 thread start.
            9 thread start.
            5 thread start.
            0 thread end.
            4 thread end.
            2 thread end.
            6 thread end.
            7 thread end.
            3 thread end.
            8 thread end.
            9 thread end.
            1 thread end.
            5 thread end.
            ```
            
            결과를 보면 쓰레드가 순서대로 실행되지 않고 `순서와 상관없이 동시에 실행` 된다 라는것을 확인할수 있다.
            
            또한 쓰레드가 종료되기 전에 `main` 메서드가 종료되었다는 사실이다.

        - Join
            
            모든 쓰레드가 종료된후 `main` 메서드를 종료시키고 싶은 경우는 어떻게해야할까?

            ```java
            import java.util.ArrayList;

            public class Sample extends Thread {
                int seq;
                public Sample(int seq) {
                    this.seq = seq;
                }

                public void run() {
                    System.out.println(this.seq+" thread start.");
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e) {
                    }
                    System.out.println(this.seq+" thread end.");
                }

                public static void main(String[] args) {
                    ArrayList<Thread> threads = new ArrayList<>();
                    for(int i=0; i<10; i++) {
                        Thread t = new Sample(i);
                        t.start();
                        threads.add(t);
                    }

                    for(int i=0; i<threads.size(); i++) {
                        Thread t = threads.get(i);
                        try {
                            t.join(); // t 쓰레드가 종료할 때까지 기다린다.
                        }catch(Exception e) {
                        }
                    }
                    System.out.println("main end.");
                }
            }
            ```

            위 처럼 `join` 을 사용하게되면 쓰레드가 종료되지 않았는데 쓰레드가 종료된줄알고 그 다음 로직을 수행하게 되는일을 막을수있다.


        - Runnable
            
            > 다른 클래스를 상속받을일이 있고 쓰레드를 사용해야할일도 있다면 쓰레드를 `Runnable 인터페이스`로 구현하여 사용하자

            ```java
            import java.util.ArrayList;

            public class Sample implements Runnable {
                int seq;

                public Sample(int seq) {
                    this.seq = seq;
                }

                public void run() {
                    System.out.println(this.seq+" thread start.");

                    try {
                        Thread.sleep(1000);
                    } catch(Exception e) {

                    }
                    System.out.println(this.seq+" thread end.");
                }

                public static void main(String[] args) {
                    ArrayList<Thread> threads = new ArrayList<>();
                    
                    for(int i=0; i<10; i++) {
                        Thread t = new Thread(new Sample(i));
                        t.start();
                        threads.add(t);
                    }

                    for (int i=0; i<threads.size(); i++) {
                        Thread t = threads.get(i);
                        try {
                            t.join();
                        }catch(Exception e) {

                        }
                    }
                    System.out.println("main end.");
                }
            }
            ```

            `Thread` 를 `extends` 하던 것에서 `Runnable` 을 `implements` 하도록 변경하였다.

            > `Runnable` 인터페이스는 `run` 메서드를 구현하도록 강제한다.

            그리고 쓰레드를 생성하는 부부을 다음과 같이 변경했다.
            ```java
            Thread t = new Thread(new Sample(i));
            ```

            Thread의 생성자로 Runnable 인터페이스를 구현한 객체를 넘길수 있는데 이방법을 사용한것이다.

    - 함수형 프로그래밍
        
        > 자바8버전 이후부터 `람다(Lambda)`와 `스트림(Stream)`을 사용하여 함수형 프로그래밍 스타일로 자바코드를 작성할수있다.

        - Lambda
            > 람다는 익명 함수를 의미한다.
        

            _일반적인 코드_

            ```java
            interface Calculator {
                int sum(int a, int b);
            }

            class MyCalculator implements Calculator {
                public int sum(int a, int b) {
                    return a+b;
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    MyCalculator mc = new MyCalculator();
                    int result = mc.sum(3, 4);
                    System.out.println(result);  // 7 출력
                }
            }
            ```

            _람다를 적용한 코드_

            ```java
            interface Calculator {
                int sum(int a, int b);
            }

            public class Sample {
                public static void main(String[] args) {
                    Calculator mc = (int a, int b) -> a + b;
                    int result = mc.sum(3, 4);
                    System.out.println(result);
                }
            }
            ```

            _위 코드에서 사용한 람다 함수_

            ```java
            (int a, int b) -> a + b
            ```

            괄호 사이의 int a, int b는 Calculator 인터페이스의 sum 함수의 입력항목에 해당하고 `->` 뒤의 `a+b 가 리턴값`에 해당한다. 이렇게 람다함수를 사용하면 MyCalculator와 같은 실제 클래스 없이도 Calculator 객체를 생성할 수 있다.

            - 인터페이스 사용시 주의사항
                > Calculator 인터페이스의 `메서드가 1개 이상`이면 람다 함수를 사용할수 없다.

                ```java
                interface Calculator {
                    int sum(int a, int b);
                    int mul(int a, int b);  // mul 메서드를 추가하면 컴파일 에러가 발생한다.
                }
                ```

                > 람다 함수로 사용할 인터페이스는 다음처럼 `@FunctionalInterface` 어노테이션을 사용하는것이 좋다. `@FunctionalInterface` 어노테이션을 사용하면 다음 처럼 2개 이상의 메서드를 가진 인터페이스를 작성하는것이 `불가능해진다`.

                ```java
                @FunctionalInterface
                interface Calculator {
                    int sum(int a, int b);
                    int mul(int a, int b);  // @FunctionalInterface 는 두 번째 s메서드를 허용하지 않는다.
                }
                ```
            
            - 람다 축약
                
                > 아까 위 코드를 좀더 축약할수있다.

                ```java
                (a, b) -> a + b
                ```
                
                인터페이스에 이미 입출력에 대한 타입이 정의되어 있으므로 입력값의 타입인 `int`는 생략가능하다.

                - _Integer.sum_
                    
                    > 두수를 더하여 결과를 리턴하는 함수 `(a,b) -> a+b` 는 `Integer.sum(int a, int b)` 와 동일하기 때문에 다음과 같이 축약이 가능하다

                    ```java
                    Integer::sum
                    ```
                    어떤 클래스의 메서드를 사용할 때는 위와 같이 `::` 기호를 사용하여 클래스와 메서드를 구분하여 표기한다.

                    _Integer::sum 을 적용한 코드_

                    ```java
                    @FunctionalInterface
                    interface Calculator {
                        int sum(int a, int b);
                    }

                    public class Sample {
                        public static void main(String[] args) {
                            Calculator mc = Integer::sum;
                            int result = mc.sum(3, 4);
                            System.out.println(result);
                        }
                    }
                    ```

                - 람다 함수 인터페이스
                    > 인터페이스를 생성하는 대신 함수형 프로그래밍을 위해 제공되는 인터페이스들을 사용하여 위코드를 더축약할수있다.

                자바가 제공하는 `BiFunction` 인터페이스를 사용하면 `Calculator 인터페이스`를 대신하여 다음과 같이 작성할 수 있다.

                ```java
                import java.util.function.BiFunction;

                public class Sample {
                    public static void main(String[] args) {
                        BiFunction<Integer, Integer, Integer> mc = (a, b) -> a + b;
                        int result = mc.apply(3, 4); // sum이 아닌 apply 메서드를 사용해야한다.
                        System.out.println(result); // 7 출력
                    }
                }
                ```

                `BiFunction`의 `<Integer, Integer, Integer>` 제네릭스는 순서대로 `입력항목 2개, 출력항목 1개` 를의미한다.

                그리고 BiFunction 인터페이스의 `apply 메서드를 호출`하면 `람다함수 (a, b) -> a+ b 가 실행`된다.

                > BiFunction 은 입출력 항목의 타입을 다양하게 사용할 수 있다.

                작성한코드를 자세히보면 입출력 항목의 타입이 모두 `Integer`로 동일하다는 것을 알수있다.

                이렇게 입출력 항목이 모두 동일한 경우에는 다음의 `BinaryOperator`를 사용하여 더 간단하게 표현할수있다.

                ```java
                import java.util.function.BinaryOperator;

                public class Sample {
                    public static void main(String[] args) {
                        BinaryOperator<Integer> mc = (a, b) -> a + b;
                        int result = mc.apply(3, 4);
                        System.out.println(result);  // 7 출력
                    }
                }
                ```
                > 자바가 람다 함수를 위해 제공하는 인터페이스는 이 외에도 상당히 많다. 추후 알아보자

    - 스트림 (Stream)
        > 글자 그대로 해석하면 `"흐름"` 이다. 데이터가 물결처럼 흘러가면서 필터링 과정을 통해 여러번 변경되어 반환 되기 때문에 이러한 이름을 갖게되었다.

        - 문제

            다음과 같은 정수 배열이 있다.
            ```java
            int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
            ```
            이 배열에서 짝수만 뽑아 중복을 제거한 후에 역순으로 정렬하는 프로그램을 작성하시오.

            즉 프로그램의 수행 결과는 다음과 같아야한다.
            ```java
            int[] result = {8, 6, 4, 2};
            ```

            참조 : [Sample2.java](Sample2.java)

            - 스트림을 이용하여 해결
                ```java
                import java.util.Arrays;
                import java.util.Comparator;

                public class Sample {
                    public static void main(String[] args) {
                        int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
                        int[] result = Arrays.stream(data) // IntStream을 생성한다.
                                .boxed()    // IntStream을 Stream<Integer>로 변경한다.
                                .filter( (a) -> a % 2 == 0) // 짝수만 뽑아낸다.
                                .distinct() // 중복을 제거한다.
                                .sorted(Comparator.reverseOrder())  // 역순으로 정렬한다.
                                .mapToInt(Integer::intValue)    // Stream<Integer>를 IntStream 으로 변경한다.
                                .toArray()  // int[] 배열로 반환한다.

                    }
                }
                ```

                위 코드는 다음과 같은순서로 동작한다.
                1. `Arrays.stream(data)`로 정수 배열을 InStream 으로 생성한다.
                2. `.boxed()` 로 IntStream을 Integer의 Stream 으로 변경한다. 이렇게 하는 이유는 뒤에서 사용할 `Comparator.reverseOrder` 메서드는 원시타입인 int 대신 Integer를 사용해야 하기 때문이다.
                3. `.filter( (a) -> a % 2 == 0)`로 짝수만 필터링한다. 이 때 사용한 `(a) -> a % 2 == 0` 구문은 위에서 공부한 람다 함수이다. 입력 a가 짝수인지를 조사하는 람다 함수로 짝수에 해당되는 데이터만 필터링한다.
                4. `.distinct()`로 스트림에서 중복을 제거한다.
                5. `.sorted(Comparator.reverseOrder())`로 역순 정렬한다.
                6. `.mapToInt(Integer::intValue)`로 Integer의 Stream을 IntStream으로 변경한다. 왜냐하면 최종적으로 int[] 타입의 배열을 리턴해야 하기 때문이다.
                7. `.toArray()`를 호출하여 IntStream의 배열인 `int[]` 배열을 리턴한다.

                스트림 방식은 일반적인 코드보다 확실히 간결하고 가독성이 좋다는 것을 확인할 수 있을 것이다.

            