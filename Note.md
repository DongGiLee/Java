# Note
- Info
    - Date : _`2023.03.27`_
    - Git Branch : [0327_Getting-Started_6](https://github.com/DongGiLee/Java/blob/0327_Getting-Started_6/Note.md)
    - Reference : [점프 투 자바](https://wikidocs.net/887)
    - Archive : [   [메소드모음](Methods.md),
                    [연습문제](/example),
                    [실습코드](Sample.java),
                    [에러모음](ErrorCase.md) 
                ]
- 내용
    - `입출력`
        - Stream 이란
            > 스트림을 가장쉽게 이해하려면 `수도꼭지`를 생각하면된다. 수도 꼭지를 틀면 물이나오고 수도꼭지를 잠그면 물이 나오지 않는다. A라는곳에서부터 B라는곳까지 수도관이 연결되어 있고 A에서 계속 물을 보낸다면 B에서 수도꼭지를 틀때마다 물이 나오게 될 것이다. 여기서 스트림은 A수도관에서 B수도관으로 이동하는 물의 흐름이라고 할 수있다.

            프로그래밍에서는 다음과 같은 것들이 스트림이라고 할 수있다.

            - 파일 데이터 (파일은 그 시작과 끝이 있는 데이터 스트림이다.)
            - HTTP 송수신 데이터 (브라우저가 요청하고 서버가 응답하는 HTTP 형태의 데이터도 스트림이다.)
            - 키보드 입력 (사용자가 키보드로 입력하는 문자열은 스트림이다.)

        그렇다면 사용자가 3 byte를 입력했을때 3 byte를 전부읽고 싶다면

        ```java
        import java.io.IOException;
        import java.io.InputStream;

        public class Sample {
            public static void main(String[] args) {
                InputStream in = System.in;
                
                int a;
                int b;
                int c;

                a = in.read();
                b = in.read();
                c = in.read();

                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
            }
        }
        ```

        ```
        abc (입력 + 엔터)
        97 (출력)
        98 (출력)
        99 (출력)
        ```

        또는 개선된방법으로는

        ```java
        import java.io.IOException;
        import java.io.InputStream;

        public class Sample {
            public static void main(String[] args) throws IOException {
                InputStream in = System.in;

                byte[] a = new byte[3];
                in.read(a);

                System.out.println(a[0]);
                System.out.println(a[1]);
                System.out.println(a[2]);
            }
        }
        ```
        
        길이 3짜리 byte 배열을 만든후 read 메서드의 입력값으로 전달하면 콘솔 입력이 해당 배열에 저장된다. 

        ```
        abc (입력 + 엔터)
        97 (출력)
        98 (출력)
        99 (출력)
        ```
        - InputStreamReader
            > 하지만 읽어드린 값을 항상 아스키코드 값으로 해석해야하는 이방식은 불편하다. `입력한 문자열 그대로의 값으로 읽으려면` `InputStreamReader`를 사용하면된다.

            ```java
            import java.io.IOException;
            import java.io.InputStream;
            import java.io.InputStreamReader;

            public class Sample {
                public static void main(String[] args) {
                    InputStream in = System.in;
                    InputStreamReader reader = new InputStreamReader(in);
                    char[] a = new char[3];
                    reader.read(a);

                    System.out.println(a);
                }
            }
            ```

            `InputStreamReader`를 이용하면 다음처럼 `byte` 대신 `char` 배열을 사용할 수 있다.

        - BufferedReader
            > 고정된 길이로만 스트림을 읽어야한다는점이다. 사용자가 엔터를 칠때까지 사용자의 입력을 전부 받아보자.
            
            ```java
            import java.io.IOException;
            import java.io.BufferedReader;
            import java.io.InputStream;
            import java.io.InputStreamReader;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    InputStream in = System.in;
                    InputStreamReader reader = new InputStreamReader(in);
                    BufferedReader br = new BufferedReader(reader);

                    String a = br.readLine();
                    System.out.println(a);
                }
            }
            ```

            이제 `BufferedReader`의 `readLine`메서드를 이용하면 사용자가 엔터키를 입력할 때까지 입력했던 문자열 전부를 읽을 수 있게 된다

        - 정리
            - InputStream - `byte`
            - InputStreamReader - `character`
            - BufferedReader - `String`

            > `InputStream` 은 `바이트`를 읽고, `InputStreamReader` 은 `문자`를 읽고, `BufferedReader` 은 `문자열`을 읽는다.

        - Scanner
            > J2SE 5.0 부터 Scanner 라는 `java.util.Scanner` 클래스가 새로 추가되었다. `Scanner` 클래스를 이용하면 콘솔입력을 보다 쉽게 처리 할 수있다.

            ```java
            import java.util.Scanner;

            public class Sample {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println(sc.next());
                }
            }
            ```

            > `Scanner` 객체의 `next()`메서드는 단어 하나(Token)를 읽어들인다. `Scanner`클래스는 단어뿐아니라 숫자, 문자열등 다양하게 읽어 들일수있다.
            - next : 단어
            - nextLine : 라인
            - nextInt : 정수

    - 콘솔출력
        > `System.out.println` 메서드는로 출력을 해왔는데 `System.out`은 `PrintStream`클래스 객체이다.

        `System.err`도 있는데 `System.out`과 같은 역할을한다. 다만 `오류 메세지`를 출력할때 사용한다.
        
        - __Unix 콘솔의 `System.out` 과 `System.err`__

            ```java
            public class Sample {
                public static void main(String[] args) {
                    System.out.println("일반 출력");
                    System.err.println("에러 출력");
                }
            }
            ```
            
            위와 같은 `Sample.java` 소스를 컴파일하여 `Sample.class` 파일을 생성한후 아래 코드처럼 실행하면 `out.txt` 파일에는 "일반 출력", `error.txt` 에는 "에러 출력"이라는 문자열이 저장된다.

            ```bash
            $ java Sample > out.txt 2> error.txt
            ```
            > 유닉스에서 `>` 는 일반 출력, `2>`는 오류 출력에 해당된다.

    - 파일 입출력
        
        - 파일쓰기
            
            ```java
            import java.io.FileOutputStream;
            import java.io.IOException;
            
            public class Sample {
                public static void main(String[] args) {
                    FileOutputStream output = FileOutputStream("c:/out.txt");
                    output.close();
                }
            }
            ```

            파일을 생성하기위해 `FileOutputStream`클래스를 사용했다. `FileOutputStream`객체를 생성하기위해서는 생성자의 입력으로 파일명을 넘겨줘야한다.

            위 예제에서는 경로를 포함하여 `c:/out.txt`라는 파일명을 생성자 입력으로 전달하였다.

            `output.close()`라는 문장이 있는데 이것은 사용한 파일 객체를 닫아주는것이다. 사실 이문장은 생략해도된다. 왜냐하나면 자바 프로그램이 종료할때 사용한 파일객체를 자동으로 닫아주기 떄문이다. 하지만 직접 사용한 파일을 닫아주는 것이좋다. 사용했던 파일을 닫지않고 다시 사용하려고 할 경우에는 오류가 발생하기 때문이다.

        - FileOutputStream
            ```java
            import java.io.FileOutputStream;
            import java.io.IOException;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    FileOutputStream output = new FileOutputStream("c:/out.txt");
                    for(int i=1; i<11; i++) {
                        String data = i+" 번째 줄입니다.\r\n";
                        output.write(data.getBytes());
                    }
                    output.close();
                }
            }
            ```
            `InputStream`과 마찬가지로 `OutputStream` 역시 바이트 단위로 데이터를 처리하는 클래스이다.

            `FileOutputStream`은 `OutputStream` 클래스를 상속받아 만든 클래스인데 `바이트 단위로 데이터를 처리`하게끔 되어있다.
            > unix환경에서는 `/n`만있어도 줄바꿈 처리가되지만 윈도우즈 환경에서는 `/r/n`처럼 `/r`문자를 추가해야 노트패드같은 에디터에서 줄바꿈이 제대로 표시되어보인다.

        - FileWriter
            > `byte 배열`대신에 `문자열`을 사용할수있다.

            ```java
            import java.io.FileWriter;
            import java.io.IOException;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    FileWriter fw = new FileWriter("c:/out.txt");
                    for(int i=1; i<11; i++) {
                        String data = i+" 번째 줄입니다.\r\n";
                        fw.write(data);
                    }
                    fw.close();
                }
            }
            ```

        - PrintWriter
            > `FileWriter`을 사용하더라도 `\r\n`을 사용해야하는 불편함이 남아있다. 이문제를 해소하려면 `PrintWriter`를 사용하면된다. `/r/n`를 붙히는대신에 `println`이라는 메서드를 사용할 수 있다.

            ```java
            import java.io.IOException;
            import java.io.PrintWriter;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    PrintWriter pw = new PrintWriter("c:/out.txt");
                    for(int i=1; i<11; i++) {
                        String data = i+" 번째 줄입니다.";
                        pw.println(data);
                    }
                    pw.close();
                }
            }
            ```

        - 파일에 내용 추가하기
            
            ```java
            import java.io.FileWriter;
            import java.io.IOException;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    FileWriter fw = new FileWriter("c:/out.txt");
                    for(int i=1; i<11; i++) {
                        String data = i+" 번째 줄입니다.\r\n";
                        fw.write(data);
                    }
                    fw.close();

                    FileWriter fw2 = new FileWriter("c:/out.txt", true);  // 파일을 추가 모드로 연다.
                    for(int i=11; i<21; i++) {
                        String data = i+" 번째 줄입니다.\r\n";
                        fw2.write(data);
                    }
                    fw2.close();
                }
            }
            ```
            > `fw2` 객체는 `FileWriter("c:/out.txt", true)` 와 같이 두번째 파라미터를 추가로 전달하여 생성했다. 두번째 `boolean` 입력 파라미터는 파일을 추가모드(append)로 열것인지에 대한 구분값이다.

            
            _PrintWriter를 사용할경우_
            ```java
            import java.io.FileWriter;
            import java.io.IOException;
            import java.io.PrintWriter;

            public class Sample {
                public static void main(String[] args) throws IOException {
                    PrintWriter pw = new PrintWriter("c:/out.txt");
                    for(int i=1; i<11; i++) {
                        String data = i+" 번째 줄입니다.";
                        pw.println(data);
                    }
                    pw.close();


                    PrintWriter pw2 = new PrintWriter(new FileWriter("c:/out.txt", true));
                    for(int i=11; i<21; i++) {
                        String data = i+" 번째 줄입니다.";
                        pw2.println(data);
                    }
                    pw2.close();
                }
            }
            ```
            `PrintWriter`를 사용하려면 추가모드로 열린 `FileWriter` 객체를 전달해야한다.
    
    - 파일읽기
        ```java
        import java.io.FileInputStream;
        import java.io.IOException;

        public class Sample {
            public static void main(String[] args) throws IOException {
                byte[] b = new byte[1024];
                FileInputStream input = new FileInputStream("c:/out.txt");
                input.read(b);
                System.out.println(new String(b));  // byte 배열을 문자열로 변경하여 출력
                input.close();
            }
        }
        ```
        
        파일을 읽기 위해서는 위 예처럼 `FileInputStream` 클래스를 이용한다. 다만 `byte 배열`을 이용하여 파일을 읽어야 하기 때문에 읽어야 하는 정확한 길이를 모를 경우에는 좀 불편한 방법이다.

        > 바이트 배여을 문자열로 변경할 떄는 `new String(바이트 배열)` 처럼 사용하여 변경한다.

        파일을 `라인단위`로 읽는 방법은 아래와 같다.
        ```java
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

        public class Sample {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new FileReader("c:/out.txt"));
                while(true) {
                    String line = br.readLine();
                    if (line==null) break;
                    System.out.println(line);
                }
                br.close();
            }
        }
        ```