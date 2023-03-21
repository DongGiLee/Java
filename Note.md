# Note
- Info
    - Date : _`2023.03.21`_
    - Git Branch : `0321_Getting-Started_2`
- 내용
    - 자료형
        - int
        - long
        - double
        - boolean
        - char
        - String
        - StringBuffer
            > 문자열을 주로 추가하거나 변경할떄 주로 사용하는 자료형이다.

            - append
                > StringBuffer 자료형은 append 메서드를 사용하여 문자열을 계속추가해 나간다. 그후 `toString()` 메서드를 이용하여 `String`자료형으로 변경할수있다.
            - insert
                > 특정 위치에 원하는 문자열을 삽입할 수 있다.
            - substring
                > (시작위치, 끝위치)와 같이 사용하면 StringBuffer 객체의 시작위치에서 끝위치의 문자를 뽑아낸다.
        - StringBuilder
            > `StringBuffer`는 `멀티 스레드 환경`에서 안전하다는 장점이 있고 `StringBuilder`는 `StringBuffer`보다 `성능이 우수`한 장점이 있다. 따라서 동기화를 고려할 필요가 없는 상황에서는 `StringBuffer` 보다는 StringBuilder를 사용하는 것이 유리하다.
        
        - List
            > 리스트와 배열의 가장 큰 차이는 `배열`은 `크기가 정해져 있지만` `리스트`는 `크기가 정해져 있지 않고 동적으로 변한다`는 점이다.

            - ArrayList
                > List 자료형에는 ArrayList, Vector, LinkedList 등의 인터페이스를 구현한 자료형이있다.
                
                > ArrayList를 사용하기위해선 `import java.util.ArrayList` 를 사용해줘야한다.

                - add
                    ```java
                    import java.util.ArrayList;

                    public class Sample {
                        public static void main(String[] args) {
                            ArrayList pitches = new ArrayList();
                            pitches.add("138");
                            pitches.add("129");
                            pitches.add("142");
                        }
                    }
                    ```
                    

                    첫번째 자리에 값을 넣고싶다면
                    ```java
                    pitches.add(0,'값');
                    ```
                    > __제네릭스__
                        자바25SE 5.0 버전 이후부터는 `ArrayList<String> pitches = new ArrayList<>();` 처럼 객체를 포함한 자료형도 어떤객체를 포함하는지에 대해서 명확하게 할것을 권고하고있다.
                - get
                    > 특정인덱스의 값을 추출할수있다.
                    ```java
                    import java.util.ArrayList;

                    public class Sample {
                        public static void main(String[] args) {
                            ArrayList pitches = new ArrayList();
                            pitches.add("138");
                            pitches.add("129");
                            pitches.add("142");
                            System.out.println(pitches.get(1));
                        }
                    }
                    ```
                    
                    ```java
                    129       
                    ```
                - size
                    > ArrayList의 갯수를 리턴한다.
                    ```java
                    System.out.println(pitches.size());
                    ```
                    
                    ```java
                    3
                    ```
                - contains
                    > 리스트안에 해당항목이 있는지를 판별하여 결과를 리턴으로 돌려준다.
                    ```java
                    System.out.println(pitches.contains('142'));
                    ```
                    ```java
                    true
                    ```
                - remove
                    > 두가지 방식이있다. (이름은 같지만 입력파라미터가 다르다.)
                    1. remove(객체)
                        > 리스트에서 객체에 해당되는 항목을 삭제하고 삭제한 결과(true, false)를 리턴한다.
                    
                        ```java
                        System.out.println(pitches.remove("129"));
                        ```
                        
                        ```java
                        true
                        ```
                        129는 삭제되고 `true`를 리턴한다.

                    2. remove(인덱스)
                        > 해당 인덱스항목을 삭제하고 상제된 항목을 리턴한다.
                        ```java
                        System.out.println(pitches.remove(0));
                        ```
                        
                        ```java
                        138
                        ```
                - Generics (제네릭스)
                    ```java
                    ArrayList<String> pitches = new ArrayList<string>();
                    ```
                    보통 뒷부분의 자료형은 굳이 적지않아도 명확하기 떄문에 다음표기법을 주로사용한다.
                    ```java
                    ArrayList<String> pitches = new ArrayList<>();
                    ```

                    제네릭스를 사용하지않을경우
                    
                    ```java
                    ArrayList pitches = new ArrayList();
                    pitches.add("138");
                    pitches.add("129");

                    String one = (String) pitches.get(0);
                    String two = (String) pitches.get(1);
                    ```
                    Array안에 추가되는 객체는 모든 객체가 상속하고있는 기본적인 자료형인Object 자료형으로 인식된다.

                    값을 넣을떄는 문제가 안되지만 값을 가져올경우에는 항상 Object형에서 String 자료형으로 다음과같이 `형변환(casting)`을 해야한다.
                    ```java
                    String one = (String) pitches.get(0); // Object 자료형을 String 자료형으로 캐스팅한다.
                    ```
                    
                    위 코드를 제네릭스를 사용하도록 변경하면 아래와같다.

                    ```java
                    ArrayList<String> pitches = new ArrayList<>();
                    pitches.add("138");
                    pitches.add("129");

                    String one = pitches.get(0);  // 형 변환이 필요없다.
                    String two = pitches.get(1);  // 형 변환이 필요없다.
                    ```
                - asList
                    > 이미 배열이 존재하는경우 보다 편하게 ArrayList를 생성할수있다.

                    ```java
                    import java.util.ArrayList;
                    import java.util.Arrays;

                    public class Sample {
                        public static void main(String[] args) {
                            String[] data = {'138','129','142'};

                            ArrayList<String> pitches = new ArrayList<>(Arrays.asList(data));
                            // or
                            <!-- 
                            ArrayList<String> pitches = new ArrayList<>(Arrays.asList('138','129','142')); 
                            -->
                            System.out.println(pitches);
                        }
                    }
                    ```
                    
                    ```java
                    [138,129,142]
                    ```
                - String.join
                    > `String.join("구분자",리스트객체)`와 같이 사용하여 리스트의 각 요소에 "구분자"를 삽입하여 하나의 문자열로 만들 수 있다.

                    > 배열에서도 사용할수있다.
                
                - 리스트 정렬하기

                    ```java
                    import java.util.ArrayList;
                    import java.util.Arrays;
                    import java.util.Comparator;

                    public class Sample {
                        public static void main(String[] args) {
                            ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
                            pitches.sort(Comparator.naturalOrder());  // 오름차순으로 정렬
                            System.out.println(pitches);  // [129, 138, 142] 출력
                        }
                    }
                    ```
                    ```java
                    [129,138,142]
                    ```
                    - 오름차순 정렬 : `Comparator.naturalOrder()`
                    - 내림차순 정렬 : `Comparator.reverseOrder()`
        - Map
            > 사전(dictionary)과 비슷하다. Key, Value를 한쌍으로 갖는 자료형이다.
            > 리스트나 배열처럼 순차적으로 해당요소를 구하지않고 key를 통해 value를 얻는다.

            - HashMap
                > Map 역시 List와 마찬가지로 인터페이스이다. 인터페이스를 구현한 Map 자료형에는 HashMap, LinkedHashMap, TreeMap 등이 있다.

                - put
                    ```java
                    import java.util.HashMap;

                    public class Sample {
                        public static void main(String[] args) {
                            HashMap<String, String> map = new HashMap<>();
                            map.put("people", "사람");
                            map.put("baseball", "야구");
                        }
                    }
                    ```
                    HashMap 역시 제네릭스를 이용한다.위 선언대로면 HashMap의 제네릭스는 Key,Value 모두 String 이다.
                
                - get
                    > key에 해당하는 value값을 얻기위해 get 메서드를 사용.

                    ```java
                    System.out.println(map.get("people")); // 사람 출력
                    ```
                    ```java
                    사람
                    ```
                - getOrDefault
                    > key의 해당하는 값이 없을경우 default값을 리턴
                    ```java
                    System.out.println(map.get("java")); // null 출력
                    ```
                    get은 key의 대응되는 값이 없을경우 null을 출력
                    ```java
                    System.out.println(map.getOrDefault("java","자바")); // 자바 출력
                    ```
                - containsKey
                    > Map에서 해당 Key가 있는지 조사하여 유무를 참,거짓 으로 리턴한다.
                    ```java
                    System.out.println(map.containsKey("people")); // true 출력
                    ```

                - remove
                    > Map의 항목을 삭제하는 메서드로 key값에 해당되는 아이템(key,value)을 `삭제한 뒤 value 값을 리턴`한다.

                    ```java
                    System.out.println(map.remove('사람')) // "사람" 출력
                    ```
                    ```
                    사람
                    ```

                - size
                    > Map의 갯수를 리턴한다.

                    ```java
                    System.out.println(map.size());
                    ```
                    ```java
                    1
                    ```
                - keySet
                    > Map의 모든 Key를 모아서 리턴한다.

                    ```java
                    import java.util.HashMap;

                    public class Sample {
                        public static void main(String[] args) {
                            HashMap<String, String> map = new HashMap<>();
                            map.put("people","사람");
                            map.put("baseball","야구");

                            System.out.println(map.keySet()); // [baseball, people] 출력
                        }
                    }
                    ```
                    ```java
                    [baseball, people]
                    ```
                    Key를 모아서 `Set` 자료형으로 리턴한다.

                    Set 자료형은 다음과 같이 List 자료형으로 바꾸어 사용할수도 있다.
                    ```java
                    List<String> keyList = new ArrayList<>(map.keySet());
                    ```
            - 순서가 필요한 Map
                > __LinkedHashMap__ : 입력된 순서대로 데이터를 저장하는 특징을 갖고있다.

                > __TreeMap__ : 입력된 key의 오름차순 순서로 데이터를 저장하는 특징을 가지고있다.
        - Set
            > Set 자료형에는 HashSet, TreeSet, LinkedHashSet 등의 Set 인터페이스를 구현한 자료형이 있다.

            - 중복을 허용하지않는다.
            - 순서가 없다.
            - 자료형의 중복을 제거하기 위한 필터 역할로 종종 사용한다.

            - __교집합, 합집합, 차집합 구하기__

                ```java
                import java.util.Arrays;
                import java.util.HashSet;

                public class Sample {
                    public static void main(String[] args) {
                        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
                        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8,9));
                    }
                }
                ```
                > 제네릭스로 `int`를 사용하고 싶은 경우에는 int의 Wrapper 클래스인 Integer를 대신 사용해야한다.

            1. 교집합
                
                ```java
                    import java.util.Arrays;
                    import java.util.HashSet;

                    public class Sample {
                        public static void main(String[] args) {
                            HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
                            HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

                            HashSet<Integer> intersection = new HashSet<>(s1);  // s1으로 intersection 생성
                            intersection.retainAll(s2);  // 교집합 수행
                            System.out.println(intersection);  // [4, 5, 6] 출력
                        }
                    }
                ```
                ```java
                [4,5,6]
                ```
                    __retainAll__ 메서드를 이용하면 교집합을 간단하게 구할수있다.
                    s1의 데이터를 유지하기 위해 s1으로 intersection이라는 HashSet객체를 Copy하여 생성하였다.
                    만약 intersection 대신 s1에 retainAll 메서드를 사용하면 s1의 내용이 변경될것이다.
            
            2. 합집합
                ```java
                import java.util.Arrays;
                import java.util.HashSet;

                public class Sample {
                    public static void main(String[] args) {
                        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
                        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

                        HashSet<Integer> union = new HashSet<>(s1);  // s1으로 union 생성
                        union.addAll(s2); // 합집합 수행
                        System.out.println(union);  // [1, 2, 3, 4, 5, 6, 7, 8, 9] 출력
                    }
                }
                ```
                ```java
                [1,2,3,4,5,6,7,8,9]
                ```
                4,5,6 처럼 중복해서 포함된값은 한개씩만 표현된다.

            3. 차집합

                ```java
                import java.util.Arrays;
                import java.util.HashSet;

                public class Sample {
                    public static void main(String[] args) {
                        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
                        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

                        HashSet<Integer> substract = new HashSet<>(s1);  // s1으로 substract 생성
                        substract.removeAll(s2); // 차집합 수행
                        System.out.println(substract);  // [1, 2, 3] 출력
                    }
                }
                ```
                ```java
                [1,2,3]
                ```
            - 집합 자료형 관련 메서드

                - 값추가하기 (add)
                    > 집합 저료형에 값을 추가할 때에는 add 메서드를 사용한다.
                    ```java
                    import java.util.HashSet;

                    public class Sample {
                        public static void main(String[] args) {
                            HashSet<String> set = new HashSet<>();
                            set.add("Jump");
                            set.add("To");
                            set.add("Java");
                            System.out.println(set);  // [Java, To, Jump] 출력
                        }
                    }
                    ```
                    ```java
                    [Java, To, Jump]
                    ```
                - 값 여러 개 추가하기(addAll)
                    > 여러 개의 값을 한꺼번에 추가할 떄는 addAll 메서드를 사용한다.

                    ```java
                    import java.util.Arrays;
                    import java.util.HashSet;

                    public class Sample {
                        public static void main(String[] args) {
                            HashSet<String> set = new HashSet<>();
                            set.add("Jump");
                            set.addAll(Arrays.asList("To", "Java"));
                            System.out.println(set);  // [Java, To, Jump] 출력
                        }
                    }
                    ```
                    ```java
                    [Java, To, Jump]
                    ```
                - 특정 값 제거하기(remove)
                    ```java
                    import java.util.Arrays;
                    import java.util.HashSet;

                    public class Sample {
                        public static void main(String[] args) {
                            HashSet<String> set = new HashSet<>(Arrays.asList("Jump", "To", "Java"));
                            set.remove("To");
                            System.out.println(set);  // [Java, Jump] 출력
                        }
                    }
                    ```
                    ```java
                    [Java, Jump]
                    ```

                - TreeSet과 LinkedHashSet
                
                        Set 자료형은 순서가 없다. 하지만 가끔 Set에 입력된 순서대로 데이터를 가져오고 싶은 겨우도 있고
                        떄로는 오름차순으로 정렬된 데이터를가져오고 싶을 수도 있을 것이다.
                        이런경우에는 TreeSet과 LinkedHashSet을 사용한다
                    - __TreeSet__ - 오름차순으로 값을 정렬하여 저장하는 특지이 있다.
                    - __LinkedHashSet__ - 입력한 순서대로 값을 정렬하여 저장하는 특징이 있다.


    - 배열
        > 배열이란 자료형의 종류가 아닌 `자료형의 집합`을 의미한다.
        1. 배열의 길이는 고정되어있다.
            ```java
            String[] weeks = new String[7];
            weeks[0] = "월";
            weeks[1] = "화";
            weeks[2] = "수";
            weeks[3] = "목";
            weeks[4] = "금";
            weeks[5] = "토";
            weeks[6] = "일";
            ```
        배열의 길이를 먼저 설정하여 배열 변수를 먼저 생성한 다음 그 값은 나중에 대입하는 방법이다. 단, 위 예처럼 초기값 없이 배열 변수를 만들때에는 반드시 길이에 대한 7과 같은 숫자값이 필요하다. 즉, 다음과 같은 코드는 불가능하다.

            String[] weeks = new String[];    // 길이에 대한 숫자값이 없으므로 컴파일 오류가 발생한다.
        2. 빈번한 배열의 오류
            ```bash
            ArrayIndexOutOfBoundsException
            ```
            다음의 예처럼 요일 배열의 길이는 총 7개인데 만약 8번째 값을 얻으려고 시도하면 이와 같은 오류가 발생한다.

            ```java
            System.out.println(weeks[7]);  // 8번째 배열값이 없으므로 ArrayIndexOutOfBoundsException 오류가 발생한다.
            ```

    - 사용자 정의 자료형

            ```java
            class Animal {
                ...
            }
            ```
        사용자가 정의한 자료형 변수를 만들수있다.
        Animal 자료형에 해당되는 값만 담을수있다.

            Animal cat;

    - 명명 규칙
        - 카멜케이스
    - 문자열 포맷팅
        - %s	문자열(String)
        - %c	문자 1개(character)
        - %d	정수(Integer)
        - %f	부동소수(floating-point)
        - %o	8진수
        - %x	16진수
        - %%	Literal % (문자 % 자체)
    - 포맷 코드
        
        1. 정렬과 공백

            ``` java        
            System.out.println(String.format("%10s", "hi"));  // "        hi" 출력 
            ```

            
            ```java
                    hi        
            ```

            앞의 예문에서 `%10s`는 `전체 길이가 10개인 문자열 공간`에서 대입되는 값을 `오른쪽으로 정렬`하고 그 앞의 나머지는 공백으로 남겨 두라는 의미이다.

            그렇다면 반대쪽인` 왼쪽 정렬`은 `%-10s`이다
                
            ```java
            System.out.println(String.format("%-10sjane.", "hi"));  // "hi        jane." 출력
            ```

            

                hi        jane.
        2. 소수점 표현하기
            ```java
            System.out.println(String.format("%.4f", 3.42134234));  // 3.4213 출력
            ```
            
            ```java
                3.4213    
            ```    

            3.42134234를 소수점 네 번째 자리까지만 나타내고 싶은 경우에는 위와 같이 사용한다.

            즉 여기서 `'.'의 의미`는 `소수점 포인트`를 말하고 `그 뒤의 숫자` 4는 소수점 `뒤에 나올 숫자의 개수`를 말한다.

            다음 예는 숫자 3.42134234를 소수점 네 번째 자리까지만 표시하고 전체 길이가 10개인 문자열 공간에서 오른쪽으로 정렬하는 예를 보여 준다.
            ```java
            System.out.println(String.format("%10.4f", 3.42134234));  // '    3.4213' 출력
            ```
            
            ```java
                    3.4213        
            ```

    - __System.out.printf__
    
        String.format 메서드는 포매팅된 문자열을 리턴한다. 따라서 포매팅된 문자열을 출력하려면 다음처럼 System.out.println 메서드를 함께 사용해야 한다.
        ```java
        System.out.println(String.format("I eat %d apples.", 3));
        ```
        하지만 `System.out.printf` 메서드를 사용하면 `String.format 메서드 없이도` 동일한 형식으로 포매팅된 문자열을 출력할 수 있다.
        ```java
        System.out.printf("I eat %d apples.", 3);  // "I eat 3 apples." 출력
        ```
        
        ```java
            I eat 3 apples.            
        ```

        `String.format` 과 `System.out.printf`의 차이는 전자는 문자열을 리턴하는 메서드이고 후자는 문자열을 출력하는 메서드라는 점이다. 상황에 맞게 선택하여 사용하자.