# Note
- Info
    - Date : _`2023.03.20`_
    - Git Branch : `0320_Getting-Started_1`

- 내용

        /* 클래스 블록 */
        public class 클래스명 {

        /* 메서드 블록 */
        [public|private|protected] [static] (리턴자료형|void) 메서드명1(입력자료형 매개변수, ...) {
            명령문(statement);
            ...
        }

        /* 메서드 블록 */
        [public|private|protected] [static] (리턴자료형|void) 메서드명2(입력자료형 매개변수, ...) {
            명령문(statement);
            ...
        }

        ...
    }
    - 소스코드 가장바깥쪽영역은 `클래스 블록` 이다. 클래스명은 원하는 이름으로 지을수있다. 단 `public class` 명을 붙힐때 `파일명과 동일하게` 해야하는 규칙이있다.
    - `메서드 블록`란에는 `[public, private, protected]`이 올수있고 또는 `아무것도 없을수도있다`.
        - 접근제어자
            
            > 접근을 허용하는 순

            1. `private`
                > `private`으로 설정되어있다면 `private`이 붙은 변수,메서드는 `해당클레스`에서만 접근이가능하다.
            2. `default`
                > 접근제어자를 별도로 설정하지 않는다면 `default`이다. `해당 패키지 내`에서만 접근이 가능하다.

                house/HouseKim.java

                    package house;  // 패키지가 동일하다.

                    public class HouseKim {
                        String lastname = "kim";  // lastname은 default 접근제어자로 설정된다.
                    }
                house/HousePark.java

                    package house;  // 패키지가 동일하다.

                    public class HousePark {
                        String lastname = "park";

                        public static void main(String[] args) {
                            HouseKim kim = new HouseKim();
                            System.out.println(kim.lastname);  // HouseKim 클래스의 lastname 변수를 사용할 수 있다.
                        }
                    }
            3. `protected`
                > `protected`가 붙은 변수, 메서드는 `동일패키지의 클래스` 또는 `해당 클래스를 상속받은 다른 패키지의 클래스`에서만 접근 가능하다.

                house/HousePark.java

                    package house;  // 패키지가 서로 다르다.

                    public class HousePark {
                        protected String lastname = "park";
                    }
                house/person/EungYongPark.java

                    package house.person;  // 패키지가 서로 다르다.

                    import house.HousePark;

                    public class EungYongPark extends HousePark {  // HousePark을 상속했다.
                        public static void main(String[] args) {
                            EungYongPark eyp = new EungYongPark();
                            System.out.println(eyp.lastname);  // 상속한 클래스의 protected 변수는 접근이 가능하다.
                        }
                    }
                만약 `lastname`접근 제어자가 `protected`가아닌 `default` 이였다면 `eyp.lastname`에서 컴파일 오류가 난다.
            4. `public`
                > 어떤 클래스라도 접근이 가능하다.

                    package house;

                    public class HousePark {
                        protected String lastname = "park";
                        public String info = "this is public message.";
                    }
                위 예제의 HousePark의 info 변수는 public 접근 제어자가 붙어 있으므로 어떤 클래스라도 접근이 가능하다.

                    import house.HousePark;

                    public class Sample {
                        public static void main(String[] args) {
                            HousePark housePark = new HousePark();
                            System.out.println(housePark.info);
                        }
                    }
    - `[static]`은 `정적메소드`로써 `static`이 올수도있고 `없을수도있다`.
        - 정적메소드와 변수
            1. `메모리할당`을 한번만 하게되어 메모리 사용에 이점이있다.
                > 만약 값이 변하지않기를 원한다면 `final`을 사용하자
            2. 같은곳의 메모리 주소를 바라보기때문에 static 변수의 `값을 공유`하게되어 공유의 이점이있다.
            3. 메소드에 설정을하게되면 객체 변수에는 접근이불가하다, 스태틱 변수에는 접근이가능하다.
            4. 싱글톤 패턴
    - `(리턴자료형|void)`메서드가 실행된후 리턴되는 값의 자료형을 의미한다. 필수로 표기해야한다. 그래서 `[]`가 아닌 `()`로 표시
- error2
    > Q: Exception in thread "main" java.lang.Error: Unresolved compilation problem
    
    > A: `package`를 선언안하고 `폴더명/자바파일`로 컴파일을 돌려서 에러가 났다. `package 폴더명`을 선언하자.