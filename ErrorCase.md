# ErrorCase

1. 
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