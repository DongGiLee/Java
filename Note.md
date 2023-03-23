# Note
- Info
    - Date : _`2023.03.23`_
    - Git Branch : `0323_Getting-Started_4`
    - Reference : https://wikidocs.net/887
    - Archive : [`"Methods.md"`, `"example/"`]
- 내용
    - class
        > 보통 클래스는 클래스명.java 파일에 단독으로 작성하는것이 일반적이다.
        ex)_ class Animal{...} => Animal.java

        - 객체 변수는 공유되지않는다.
    - method
        > 타언어는 함수라는 것이 별도로 존재한다. 하지만 자바는 클래스를 떠나 존재하는 것은 있을수 없기 때문에 자바의 함수는 따로 존재하지않고 클래스 내에 존재한다.

        > 자바는 이러한 클래스 내의 함수를 메서드라고 부른다.

        - `매개변수(parameter)` : 메서드에 전달된 값을 저장하는 변수
        - `인수(arguments)` : 메서드를 호출할 때 전달하는 입력값

        - 구조
            ```
            리턴자료형 메서드명(입력자료형1 매개변수1, 입력자료형2 매개변수2, ...) {
                ...    
                return 리턴값;  // 리턴자료형이 void 인 경우에는 return 문이 필요없다.
            }
            ```
    - Call By Value
        > 메서드에 객체를 전단할경우 메서드에서 객체의 객체변수(속성) 값을 변경할 수 있다.

        - 객체의 값을 보내면 객체의 값을 변경 할 수 없지만
        - 객체 자체를 보내면 값을 변경할 수 있다.

    - 상속
        > 클래스 상속을 위해서는 `extends` 라는 키워드를 사용한다.
        
        
        ```java
        class Animal {
            String name;

            void setName(String name) {
                this.name = name;
            }
        }

        class Dog extends Animal {  // Animal 클래스를 상속한다.
        }

        public class Sample {
            public static void main(String[] args) {
                Dog dog = new Dog();
                dog.setName("poppy");
                System.out.println(dog.name);
            }
        }
        ```
        - 부모 클래스의 기능을 확장
            ```java
            class Animal {
                String name;

                void setName(String name) {
                    this.name = name;
                }
            }

            class Dog extends Animal {
                void sleep() {
                    System.out.println(this.name+" zzz");
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    Dog dog = new Dog();
                    dog.setName("poppy");
                    System.out.println(dog.name);
                    dog.sleep();
                }
            }
            ```
            이렇게 보통 부모 클래스를 상속받은 자식 클래스는 부모 클래스의 기능에 더하여 좀 더 많은 기능을 갖도록한다.

        - IS-A 관계
            > Dog 클래스는 Animal 클래스를 상속했다. 즉 Dog는 Animal의 하위 개념이라고 할 수 있다. Java 는 이런관계를 `IS-A` 관계라고 한다. 즉 "Dog `is a` Animal"
            
            > 이렇게 IS-A관계(상속관계)에 있을 때 자식 클래스의 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다.
            
            ```java
            Animal dog = new Dog(); // Dog is a Animal
            ```
            - __주의__
            
                ```java
                Dog dog = new Animal(); // 컴파일 오류 : 부모 클래스로 만든 객체는 자식 클래스의 자료형으로 사용할수 없다.
                ```
                
                ```java
                Animal dog = new Dog(); // Dog is a Animal (O)
                ```

                위 코드를 해석하면 "개로 만들어진 객체는 동물 자료형이다."

                ```java
                Dog dog = new Animal(); // Animal is a Dog (X)
                ```
                위 코드를 해석하면 "동물로 만든 객체는 개 자료형이다" 이기때문에 성립이 안된다.

        - Object 클래스
            > 자바에서 만드는 모든 클래스는 Object 클래스를 상속받는다. 사실 우리가 만든 Animal 클래스는 다음과 기능적으로 완전히 동일하다. 하지만 굳이 아래코드 처럼 Object 클래스를 상속하도록 코딩하지않아도 자바에서 만들어지는 모든 클래스는 Object 클래스를 자동으로 상속받게끔 되어 있다.

            ```java
            class Animal extends Object {
                String name;

                void setName(String name) {
                    this.name = name;
                }
            }
            ```

            ```java
            Object animal = new Animal(); // Animal is Obejct
            Obejct dog = new Dog(); // Dog is Object
            ```

        - 메서드 오버라이딩 (Method overriding)
            > 부모 클래스의 메서드를 자식 클래스가 동일한 형태로 또 다시 구현하는 행위를 `매서드 오버라이딩(Method Overriding)` 이라한다. (메서드 덮어쓰기)
            ```java
            class Animal {
                String name;

                void setName(String name) {
                    this.name = name;
                }
            }

            class Dog extends Animal {
                void sleep() {
                    System.out.println(this.name+" zzz");
                }
            }

            class HouseDog extends Dog {
                void sleep() {
                    System.out.println(this.name+" zzz in house");
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    HouseDog houseDog = new HouseDog();
                    houseDog.setName("happy");
                    houseDog.sleep();  // happy zzz 출력
                }
            }
            ```
        - 메소드 오버로딩 (Method overloading)
            > 입력항목이 다른경우 동일한 이름의 메서드를 만들수있다. 이것을 메서드 오버로딩`(method overloading)`이라고 한다.

            > `method overriding`은 `변경`, `method loading`은 `추가` 이다

            ```java
            class Animal {
                String name;

                void setName(String name) {
                    this.name = name;
                }
            }

            class Dog extends Animal {
                void sleep() {
                    System.out.println(this.name + " zzz");
                }
            }

            class HouseDog extends Dog {
                void sleep() {
                    System.out.println(this.name + " zzz in house");
                }

                void sleep(int hour) {
                    System.out.println(this.name + " zzz in house for " + hour + " hours");
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    HouseDog houseDog = new HouseDog();
                    houseDog.setName("happy");
                    houseDog.sleep();  // happy zzz in house 출력
                    houseDog.sleep(3);  // happy zzz in house for 3 hours 출력
                }
            }
            ```
        - 다중 상속
            > 클래스가 동시에 하나이상의 클래스를 상속받는 것을 뜻한다. 많은 언어들이 다중상속을 지원하지만 `Java는 다중 상속을 지원하지 않는다.`
    
    - 생성자(Constructor)

        > 객체변수에 무조건 값을 생성해야지만 객체가 생성 될수 있도록 강제할수있다.
        _Sample.java_
        ```java
        class Animal {
            String name;

            void setName(String name) {
                this.name = name;
            }
        }

        class Dog extends Animal {
            void sleep() {
                System.out.println(this.name + " zzz");
            }
        }

        class HouseDog extends Dog {
            void sleep() {
                System.out.println(this.name + " zzz in house");
            }

            void sleep(int hour) {
                System.out.println(this.name + " zzz in house for " + hour + " hours");
            }
        }

        public class Sample {
            public static void main(String[] args) {
                HouseDog houseDog = new HouseDog();
                houseDog.setName("happy");
                houseDog.sleep();
                houseDog.sleep(3);
            }
        }
        ```

        - 생성자(Constructor) 사용
            
            > `메서드 명이 클래스명과 동일`하고 `리턴자료형을 정의하지 않는 메서드`를 생성자라고한다.
            
            _생성자의 규칙_
            1. 클래스명과 메서드 명이 동일하다.
            2. 리턴타입을 정의하지 않는다. (void도 사용하지 않는다.)

            ```java
            (... 생략 ...)

            class HouseDog extends Dog {
                HouseDog(String name) {
                    this.setName(name);
                }

                void sleep() {
                    System.out.println(this.name + " zzz in house");
                }

                void sleep(int hour) {
                    System.out.println(this.name + " zzz in house for " + hour + " hours");
                }
            }

            (... 생략 ...)
            ```

            생성자는 객체가 생성될때 호출된다. 즉 생성자는 다음과 같이 new 키워드가 사용될 때 호출된다.
            ```
            new 클래스명(입력인수,...)
            ```

        - 디폴트(default) 생성자
            > 생성자의 입력 항목이 없고 생성자 내부에 아무 내용이 없는 위와 같은 생성자를 디폴트 생성자라고 한다.

            ```java
            class Dog extends Animal {
                Dog() {
                }

                void sleep() {
                    System.out.println(this.name + " zzz");
                }
            }
            ```

            > 만약 클래스에 생성자가 `하나도 없다면` 컴파일러는 자동으로 위와같은 `디폴트 생성자를 추가한다`. 하지만 사용자가 작성한 생성자가 `하나라도 구현되어 있다면` 컴파일러는 `디폴트 생성자를 추가하지않는다.`
        
        - 생성자 오버로딩
            > 메서드에 오버로딩이 있는것과 마찬가지로 생성자에게도 오버로딩이 있다.

            ```java
            class Animal {
                String name;

                void setName(String name) {
                    this.name = name;
                }
            }

            class Dog extends Animal {
                void sleep() {
                    System.out.println(this.name + " zzz");
                }
            }

            class HouseDog extends Dog {
                HouseDog(String name) {
                    this.setName(name);
                }

                HouseDog(int type) {
                    if (type == 1) {
                        this.setName("yorkshire");
                    } else if (type == 2) {
                        this.setName("bulldog");
                    }
                }

                void sleep() {
                    System.out.println(this.name + " zzz in house");
                }

                void sleep(int hour) {
                    System.out.println(this.name + " zzz in house for " + hour + " hours");
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    HouseDog happy = new HouseDog("happy");
                    HouseDog yorkshire = new HouseDog(1);
                    System.out.println(happy.name);  // happy 출력
                    System.out.println(yorkshire.name);  // yorkshire 출력
                }
            }
            ```
        - 인터페이스
            
            _Sample.java_
 
            ```java
            class Animal {
                String name;

                void setName(String name) {
                    this.name = name;
                }
            }

            class Tiger extends Animal {
            }

            class Lion extends Animal {
            }

            class ZooKeeper {
                void feed(Tiger tiger) {  // 호랑이가 오면 사과를 던져 준다.
                    System.out.println("feed apple");
                }

                void feed(Lion lion) {  // 사자가 오면 바나나를 던져준다.
                    System.out.println("feed banana");
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    ZooKeeper zooKeeper = new ZooKeeper();
                    Tiger tiger = new Tiger();
                    Lion lion = new Lion();
                    zooKeeper.feed(tiger);  // feed apple 출력
                    zooKeeper.feed(lion);  // feed banana 출력
                }
            }
            ```

            - 인터페이스 사용

                동물이 추가 될때마다 feed 메서드를 추가해야한다면 효율적이지가 않다. 그래서 __인터페이스__ 를 사용한다

                ```java
                interface Predator {
                }

                class Animal {
                    String name;

                    void setName(String name) {
                        this.name = name;
                    }
                }

                (... 생략 ...)
                ```
                > interface 라는 키워드를 사용하며 작성한다.
                
                > 클래스와 마찬가지로 Predator.java와 같은 단독 파일로 저장하는것이 일반적인 방법이다.

                동물 클래스들은 인터페이스를 구현하도록(Implements) 수정하자

                ```java
                (... 생략 ...)

                class Tiger extends Animal implements Predator {
                }

                class Lion extends Animal implements Predator {    
                }

                (... 생략 ...)
                ```

                > 인터페이스 구현은 위와같이 Implements 라는 키워드를 사용한다.

                _before_
                
                ```java
                (... 생략 ...)

                class ZooKeeper {
                    void feed(Tiger tiger) {
                        System.out.println("feed apple");
                    }

                    void feed(Lion lion) {
                        System.out.println("feed banana");
                    }
                }

                (... 생략 ...)
                ```

                _after_

                ```java
                (... 생략 ...)

                class ZooKeeper {
                    void feed(Predator predator) {
                        System.out.println("feed apple");
                    }
                }

                (... 생략 ...)
                ```

                - tiger - Tiger 클래스의 객체, Predator 인터페이스의 객체
                - lion - Lion 클래스의 객체, Predator 인터페이스의 객체          

            - 인터페이스의 메서드

                위와 같은 코드를 작성했을때 어떤 동물이 오던지 무조건 "feed apple" 이라는게 출력된다. 인터페이스 메서드를 사용하면 해결
                
                > 인터페이스의 메서드는 항상 public 으로 구현해야한다.

                ```java
                interface Predator {
                    String getFood();
                }

                (... 생략 ...)
                ```

                위 코드를 작성하면 인터페이스를 구현한 클래스들에서 컴파일 오류가 발생한다. 해결하려면 클래스마다 getFood 메서드를 구현해야한다.

                ```java
                (... 생략 ...)

                class Tiger extends Animal implements Predator {
                    public String getFood() {
                        return "apple";
                    }
                }

                class Lion extends Animal implements Predator {
                    public String getFood() {
                        return "banana";
                    }
                }

                (... 생략 ...)
                ```
                
                ZooKeeper 클래스도 아래와 같이 변경가능하다.

                ```java
                (... 생략 ...)

                class ZooKeeper {
                    void feed(Predator predator) {
                        System.out.println("feed "+predator.getFood());
                    }
                }

                (... 생략 ...)
                ```
            - 인터페이스의 핵심과 개념
                    
                동물들의 수만큼 feed 메서드가 필요했던 ZooKeeper 클래스를
                Predator 인터페이스를 이용하여 구현했더니 한개의 feed메서드로 구현이가능해졌다.


                중요한점은 메서드의 갯수가 줄어들었다는 점이 아니라 ZooKeeper 클래스가 동물들의 종류에 의존적인 클래스에서 동물들의 종류와 상관없는 `독립적인 클래스`가 되었다는 점이다.

            - __상속과 인터페이스__

                > 상속으로 사용했을시에는 `강제성`을 갖지 못한다. 인터페이스는 `강제성`을 갖기 때문에 상황에 맞게 사용하자
            
            - 디폴트 메서드
                
                > 자바8 버전이후로는 디폴트 메서드(default method)를 사용할 수 있다. 인터페이스의 메서드는 몸통(구현체)을 가질수 없지만 디폴트 메서드를 사용하면 실제 구현된 형태의 메서드를 가질 수 있다.

                ```java
                interface Predator {
                    String getFood();

                    default void printFood() {
                        System.out.printf("my food is %s\n", getFood());
                    }
                }
                ```

                디폴트 메서드는 메서드명 가장앞에 `default`라고 표기해야한다.
                인터페이스를 구현한 클래스에서는 `printFood`를 구현하지 않아도 사용할수 있다. 그리고 `디폴트 메서드는 오버라이딩이 가능하다` 즉 `printFood`메서드를 실제 클래스에서 다르게 구현하여 사용할수있다.

            - 스태틱 메서드

                > 자바8 버전 이후부터는 인터페이스에 스태틱 메서드(static method)를 사용할 수 있다. 인터페이스에 스태틱 메서드를 구현하면 `인터페이스명.스태틱메서드명`과 같이 사용하여 일반 `클래스의 스태틱 메서드를 사용하는것과 동일하게 사용`할 수 있다.

                ```java
                interface Predator {
                    String getFood();

                    default void printFood() {
                        System.out.printf("my food is %s\n", getFood());
                    }

                    int LEG_COUNT = 4;  // 인터페이스 상수

                    static int speed() {
                        return LEG_COUNT * 30;
                    }
                }
                ```
                
                ```java
                Predator.speed();
                ```

            - 인터페이스 상수
                위 코드에 있는 `int LEG_COUNT = 4;`문장은 인터페이스에 정의한 상수이다. `int LEG_COUNT = 4;`처럼 `public static final`을 생략해도 자동으로 `public static final`이 적용된다.
                (다른 형태의 상수 정의는 불가능하다.)
    
    - 다형성(폴리모피즘, polymorphism)
    
        _Sample.java_
