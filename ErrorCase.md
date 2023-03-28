# ErrorCase

1. 컴파일 에러
    ```
    No enclosing instance of type exam3 is accessible. Must qualify the allocation with an enclosing instance of type exam3 (e.g. x.new A() where x is an instance of exam3).
    ```
    - - - 
    > `static` 메서드안에서 `non-static`메서드를 호출

    ```java
    public static void main(String[] args) {
        
        (...)

        UpgradeCalculator cal = new UpgradeCalculator(); // non-static 부분

        (...)
    }
    ```
    1. `UpgradeCalculator`을 `static` 으로 변경한다.
    2. `main`메소드에 `static` 을 제거한다.
    3. 같은 클래스내에 

2. vscode 에러
    
    ```
    Debug java debug : importing projects check details
    ```

    > 해결방법들중 Ctrl + Shift + p 로 JAVA 로그파일을 삭제얘기가 있어서 해봤는데 동일한 에러가 있었다.

    > setting -> java.jdt.ls.home -> "java.jdt.ls.java.home" : jdk 경로 설정하니 해결
