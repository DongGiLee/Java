package example;

import java.util.ArrayList;
import java.util.Arrays;
  
class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}    
class UpgradeCalculator extends Calculator {
    
    void minus(int val) {
        this.value -= val;
    }
    
}

class Calculator2 {
    int value;

    Calculator2() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}
class MaxLimitCalculator extends Calculator2 {
    void add(int val) {
        this.value += val;
        if (this.value>100) this.value =100;
    }
}

class Calculator3 {

    boolean isOdd(int val) {
        // if(val%2==1) return true;
        // else return false;
        return val % 2 ==1;
    }
}

class Calculator4 {
    int sum =0;

    int avg(int[] intArray) {
        for(int item : intArray) sum += item;
        return sum/intArray.length;
    }
    int avg(ArrayList<Integer> intArray) {
        for(int item : intArray) sum += item;
        return sum/intArray.size();
    }
}

class Calculator6 {
    Integer value;

    Calculator6() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    public Integer getValue() {
        return this.value;
    }
}
interface Mineral{
    
    int myValue();
}
class Gold implements Mineral{
    public int myValue() {
        return 100;
    }
}

class Silver implements Mineral{
    public int myValue() {
        return 90;
    }
}

class Bronze implements Mineral{
    public int myValue() {
        return 80;
    }
}

class MineralCalculator {
    int value = 0;


    public void add(Mineral mineral) {
         this.value += mineral.myValue();
    }
    
    public int getValue() {
        return this.value;
    }
}


public class exam3 {
  
    public static void main(String[] args) {

        /**
         * 1. UpgradeCalculator
         * 
         * class Calculator {
                int value;

                Calculator() {
                    this.value = 0;
                }

                void add(int val) {
                    this.value += val;
                }

                int getValue() {
                    return this.value;
                }
            }

        public class Sample {
            public static void main(String[] args) {
                Calculator cal = new Calculator();
                cal.add(10);
                System.out.println(cal.getValue());  // 10 출력
            }
        }
         * 
         * Calculator 클래스를 상속하는 UpgradeCalculator를 만들고
         *  값을 뺄 수 있는 minus 메서드를 추가해 보자. 
         * 즉 다음과 같이 동작하는 클래스를 만들어야 한다.
         * 
         * 
         * UpgradeCalculator cal = new UpgradeCalculator();
         * cal.add(10);
         * cal.minus(3);
         * System.out.println(cal.getValue());  // 10에서 7을 뺀 3을 출력
         */

        
        System.out.println("- - - - - - - -1번- - - - - - - -");
        UpgradeCalculator cal = new UpgradeCalculator();
        cal.add(10);
        cal.minus(3);
        System.out.println(cal.getValue());  // 10에서 7을 뺀 3을 출력
        

        /**
         * 2. MaxLimitcalculator
         * 
         * 객체변수 value가 100 보다
         * 큰 값은 가질 수 없도록 제한하는 MaxLimitCalculator 클래스를 만들어 보자.
         * 즉 다음과 같이 동작해야 한다.
         * 
         * MaxLimitCalculator cal = new MaxLimitCalculator();
            cal.add(50);  // 50 더하기
            cal.add(60);  // 60 더하기
            System.out.println(cal.getValue());  // 100 출력
           
         * 단 MaxLimitCalculator 클래스는 반드시 
         * 다음의 Calculator 클래스를 상속해서 만들어야 한다.
         * 
         * class Calculator {
                int value;

                Calculator() {
                    this.value = 0;
                }

                void add(int val) {
                    this.value += val;
                }

                int getValue() {
                    return this.value;
                }
            }
         *  
         */
        
        System.out.println("- - - - - - - -2번- - - - - - - -");
        MaxLimitCalculator cal2 = new MaxLimitCalculator();
        cal2.add(50);
        cal2.add(60);
        System.out.println(cal2.getValue());  // 100 출력


        /**
         * 3. 홀수 짝수 판별하기
         * 
         * 다음과 같이 주어진 정수가 홀수인지 짝수인지 판별해 주는 Calculator 클래스를 작성하시오.
         * (홀수이면 true, 짝수면 false를 리턴해야 한다.)
         * 
         * 
         * Calculator cal = new Calculator();
            System.out.println(cal.isOdd(3));  // 3은 홀수이므로 true 출력
            System.out.println(cal.isOdd(4));  // 4는 짝수이므로 false 출력
         */
        
        System.out.println("- - - - - - - -3번- - - - - - - -");
         Calculator3 cal3 = new Calculator3();

         System.out.println(cal3.isOdd(3));  // 3은 홀수이므로 true 출력
         System.out.println(cal3.isOdd(4));  // 4는 짝수이므로 false 출력

        /**
         * 4. 평균값을 구하는 메서드
         * 
         * 다음과 같이 정수 배열 또는 정수의 리스트로 그 평균값을 구해 
         * 리턴하는 Calculator 클래스를 작성하시오.
         * 
         * int[] data = {1, 3, 5, 7, 9};
            Calculator cal = new Calculator();
            int result = cal.avg(data);
            System.out.println(result);  // 5 출력
         * 
         * ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
            Calculator cal = new Calculator();
            int result = cal.avg(data);
            System.out.println(result);  // 5 출력
         * 
         */
        
        System.out.println("- - - - - - - -4번- - - - - - - -");

        // int[] data = {1, 3, 5, 7, 9};
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));

        Calculator4 cal4 = new Calculator4();
        int result = cal4.avg(data);
        System.out.println(result);  // 5 출력

        /**
         * 5. 리스트와 객체
         * 
         * 다음 프로그램의 출력결과를 예측하고 그이유에 대해서 설명하시오.
         * 
         * import java.util.ArrayList;
            import java.util.Arrays;

            public class Sample {
                public static void main(String[] args) {
                    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
                    ArrayList<Integer> b = a;
                    a.add(4);
                    System.out.println(b.size());
                }
            }

            

            4, 새로운객체를 생성한것이아니라 같은 객체를 가ㄹ리키고 있기때문에
         * 
         */
        System.out.println("- - - - - - - -5번- - - - - - - -");
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = a;
        a.add(4);
        System.out.println(b.size()); 

        /**
         * 6. 생성자와 초깃값
         * 
         * 다음은 Calculator 객체를 생성하고 값을 더한후에 그 결과값을 출력하는 예제이다.
         * 하지만 코드를 실행하면 오류가 발생한다.
         * 이코드의 오류를 수정하시오.
         * 
         * class Calculator {
                Integer value;
                void add(int val) {
                    this.value += val;
                }

                public Integer getValue() {
                    return this.value;
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    Calculator cal = new Calculator();
                    cal.add(3);  // 여기서 NullPointerException 이 발생한다.
                    System.out.println(cal.getValue());
                }
            }
         * 
         */

        
        /**
         * 7. 인터페이스 사용하기
         * 
         * 다음은 광물의 가치를 계산하는 MineralCalculator 클래스와 그 사용법이 담긴 코드이다.
         * 광물 계산기는 금인 경우 100, 은인경우 90, 구리의 경우는 80의 가치를 더하는 기능(add 메서드)
         * 
         * 하지만 이 광물 계산기는 광물이 추가될 때마다 add 메서드를 추가해야 한다는 단점이 있다. 광물이 추가되더라도
         * MineralCalculator 클래스를 변경할 필요가 없도록 코드를 수정하시오.
         * 
         */
        System.out.println("- - - - - - - -6번- - - - - - - -");
        Calculator cal6 = new Calculator();
        cal6.add(3);  // 여기서 NullPointerException 이 발생한다.
        System.out.println(cal6.getValue());


        System.out.println("- - - - - - - -7번- - - - - - - -");
        MineralCalculator cal7 = new MineralCalculator();
        cal7.add(new Gold());
        cal7.add(new Silver());
        cal7.add(new Bronze());
        System.out.println(cal7.getValue());  // 270 출력


        /**
         * 8. 오류 찾기1
         * 
         * interface Predator {
            }

            class Animal {
            }

            class Dog extends Animal {
            }

            class Lion extends Animal implements Predator {
            }

            public class Sample {
                public static void main(String[] args) {
                    Animal a = new Animal();  // 1번 
                    Animal b = new Dog();  // 2번
                    Animal c = new Lion();  // 3번
                    Dog d = new Animal();  // 4번
                    Predator e = new Lion();  // 5번
                }
            }
         * 
         * 
         * 4번, IS-A로 의하여 개는 동물이지만, 여기는 동물은 개 이다. 는 상속관계가 잘못됨
         */

        /**
         * 9. 오류 찾기2
         * 
         * interface Predator {
                String bark();
            }

            abstract class Animal {
                public String hello() {
                    return "hello";
                }
            }

            class Dog extends Animal {
            }

            class Lion extends Animal implements Predator {
                public String bark() {
                    return "Bark bark!!";
                }
            }

            public class Sample {
                public static void main(String[] args) {
                    Animal a = new Lion();
                    Lion b = new Lion();
                    Predator c = new Lion();

                    System.out.println(a.hello());  // 1번
                    System.out.println(a.bark());   // 2번
                    System.out.println(b.hello());  // 3번
                    System.out.println(b.bark());   // 4번
                    System.out.println(c.hello());  // 5번
                    System.out.println(c.bark());   // 6번
                }
            }

            2번 문장과 5번 문장에서 오류가 발생한다.
            2번 문장이 오류가 발생하는 이유는 a 객체가 Animal 타입으로 생성되었기 때문이다.
            Animal 타입의 객체는 hello 메서드만 사용이 가능하다.
            5번 문장이 오류가 발생하는 이유는 c 객체가 Predator 타입으로 생성되었기 때문이다.
            Predator 타입의 객체는 bark 메서드만 사용이 가능하다.
         * 
         */
    }
}
