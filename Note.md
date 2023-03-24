# Note
- Info
    - Date : _`2023.03.24`_
    - Git Branch : [0324_Getting-Started_5](https://github.com/DongGiLee/Java/blob/0324_Getting-Started_5/Note.md)
    - Reference : [점프 투 자바](https://wikidocs.net/887)
    - Archive : [   [메소드모음](Methods.md),
                    [연습문제](/example),
                    [실습코드](Sample.java),
                    [에러모음](ErrorCase.md) 
                ]
    
- 내용
    - 다형성(폴리모피즘, Polymorphism)
        
        _Sample.java_
        ```java
        interface Predator {
            (... 생략 ...)
        }

        class Animal {
            (... 생략 ...)
        }

        class Tiger extends Animal implements Predator {
            (... 생략 ...)
        }

        class Lion extends Animal implements Predator {
        (... 생략 ...)
        }

        class ZooKeeper {
            (... 생략 ...)
        }

        class Bouncer {
            void barkAnimal(Animal animal) {
                if (animal instanceof Tiger) {
                    System.out.println("어흥");
                } else if (animal instanceof Lion) {
                    System.out.println("으르렁");
                }
            }
        }

        public class Sample {
            public static void main(String[] args) {
                Tiger tiger = new Tiger();
                Lion lion = new Lion();

                Bouncer bouncer= new Bouncer();
                bouncer.barkAnimal(tiger);
                bouncer.barkAnimal(lion);
            }
        }
        ```
        - _Remind_

            - IS-A 관계
                > 자식 클래스에 의해서 만들어진 객체는 언제나 부모 클래스의 자료형으로 사용할 수 있다.

                ```java
                Animal tiger = new Tiger(); // tiger is a Animal;
                Animal lion = new Lion(); // lion is a Animal;
                ```
        - 다형성 적용
            > 인터페이스는 콤마(,)를 이용하여 여러개를 implements 할 수 있다.

            ```java
                interface Predator {
                    (... 생략 ...)
                }

                interface Barkable {
                    void bark();
                }

                class Animal {
                    (... 생략 ...)
                }

                class Tiger extends Animal implements Predator, Barkable {
                    public String getFood() {
                        return "apple";
                    }

                    public void bark() {
                        System.out.println("어흥");
                    }
                }

                class Lion extends Animal implements Predator, Barkable {
                    public String getFood() {
                        return "banana";
                    }

                    public void bark() {
                        System.out.println("으르렁");
                    }
                }

                class ZooKeeper {
                    (... 생략 ...)
                }

                class Bouncer {
                    void barkAnimal(Barkable animal) {  // Animal 대신 Barkable을 사용
                        animal.bark();
                    }
                }

                public class Sample {
                    (... 생략 ...)
                }
            ```

            > 이렇게 하나의 객체가 __여러개의 자료형 타입을 가질 수 있는 것__ 을 객체지향 세계에서는 `다형성(Polymorphism)` 이라고 한다.

            `Predator`로 선언된 predator 객체와 `Barkable`로 선언된 barkable 객체는 사용할 수 있는 메서드가 서로 다르다는 점이다.

            predator 객체는 `getFood()`메서드가 선언된 Predator 인터페이스의 객체이므로 getFood 메서드만 호출 가능하다.  이와 마찬가지로 Barable로 선언된 barkable 객체는 bark 메서드만 호출이 가능하다.



            ```java
            interface Predator {
                (... 생략 ...)
            }

            interface Barkable {
                void bark();
            }

            interface BarkablePredator extends Predator, Barkable {
            }

            (... 생략 ...)
            ```
            > 인터페이스는 일반 클래스와 달리 __extends__ 를 이용하여 여러개의 인터페이스를 동시에 상속할 수 있다. 즉 다중 상속이 지원된다.

            
            ```java
            (... 생략 ...)

            class Lion extends Animal implements BarkablePredator {
                public String getFood() {
                    return "banana";
                }

                public void bark() {
                    System.out.println("으르렁");
                }
            }

            (... 생략 ...)
            ```

    - 추상 클래스
        
        > `인터페이스의 역할`도 하면서 `클래스의 기능`도 가지고 있다.

        기존인터페이스에서 추상 클래스로 변경해보자

        ```java
        abstract class Predator extends Animal {
            abstract String getFood();

            ~~default~~ void printFood() {  // default 를 제거한다.
                System.out.printf("my food is %s\n", getFood());
            }

            static int LEG_COUNT = 4;  // 추상 클래스의 상수는 static 선언이 필요하다.
            static int speed() {
                return LEG_COUNT * 30;
            }
        }

        (... 생략 ...)
        ```

        - 추상 클래스를 만들기 위해서는 class 앞에 `abstract` 라고 표기해야한다.

        - 또한 인터페이스의 메서드와 같은 역할을 하는 메서드(여기서는 getFood)에도 역시 `abstract`를 붙여야한다.
        
        - 인터페이스의 디폴트 메서드는 더이상 사용할 수 없으므로 `default` 키워드를 삭제하여 일반 메서드로 변경

        - LEG_COUNT 상수도 인터페이스에서는 자동으로 `static`으로 인식하지만 추상 클래스는 명시적으로 `static` 이라고 적어줘야한다.

        > 추상 클래스는 일반 클래스와는 달리 `단독으로 객체를 생성할 수 없다`. 반드시 추상 클래스를 상속한 `실제 클래스를 통해서만 객체를 생성할 수 있다`.

        >  추상클래스에 `abstract`로 선언된 메서드는 인터페이스의 메서드와 마찬가지로 반드시 구현해야 하는 메서드이다.

        - 인터페이스와 추상 클래스의 차이
            > 자바8 버전 부터는 인터페이스에 `deafult` 메서드가 추가되어 추상 클래스와의 차이점이 모호해졌다. 하지만 추상 클래스는 인터페이스와 달리 일반 클래스처럼 `객체변수`, `생성자`, `prtivate 메서드` 등을 가질수 있다.

    - 콘솔 입출력
        
        - _콘솔이란_
            > 콘솔은 환경에 따라 변경될 수 있다. 만약 이프로그램을 인텔리제이에서 실행했다면 인텔리제이 콘솔창이 콘솔이 될것이고 윈도우 명령창에서 이프로그램을 실행했다면 명령창이 콘솔이 된다. 즉 콘솔은 `사용자 입력을 받거나 사용자에게 문자열을 출력해 주는 역할을 하는것을 통칭하는 말`이다.

        - 콘솔입력
            > 사용자가 입력한 문자열을 얻기 위해서는 자바의 `System.in`을 사용한다.

            ```java
            import java.io.IOException;
            import java.io.InputStream;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    InputStream in = System.in;

                    int a;
                    a = in.read();

                    System.out.println(a);

                }
            }
            ```

            `InputStram`은 자바의 내장클래스이다. 자바의 내장 클래스중에 `java.lang` 패키지에 속해 있지 않은 클래스는 위 코드처럼 필요할때 항상 `import` 해서 사용해야 한다.

            그동안 사용해왔던 `System`이나 `String` 등의 클래스는 `java.lang` 패키지에 속해 있는 클래스이므로 별도의 `import`과정이 필요없었다.

            `System.in`은 `InputStream`의 객체임을 알수있다.
            ```java
            InputStream in = System.in;
            ```

            `InputStream의` `read` 메서드는 `1 byte`의 사용자의 입력을 받아들인다.
            ```java
            int a;
            a = in.read();
            ```
            
            - __IOException__
                > main 메서드를 보면 `throws IOException` 을 사용한 부분이 있다. `InputStream` 으로 값을 읽어 들일때는 `IOException`이 발생할 수 있기 때문에 예외처리를 해야하는데 `throws`로 그 예외처리를 뒤로 미루게한것이다.

            