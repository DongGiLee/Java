# Methods

## 내장 메소드

### `equals`
> 두개의 문자열이 동일한지 비교하여 결과값 boolean을 리턴 
```java
String a = 'hello;';
String b = 'Welcome;';
String c = 'hello;';

a.equals(b); // false
a.equals(c); // true
```    

### `indexOf`
> 문자열에서 특정 문자열이 시작되는 위치(인덱스)를 리턴한다.
```java
String a = 'Hello World';

a.indexOf('World'); // 6
```

### `contains`
> 문자열에서 특정문자열이 포함되어 있는지의 여부를 리턴한다.
```java
String a = 'Hello World';
a.contains("World"); // true
```

### `charAt`
> 문자열에서 특정 위치의 문자(char)를 리턴합니다.
```java
String a = 'Hello World';
a.charAt(6); // "W"
```

### `replaceAll`
> 문자열 중 특정 문자열을 다른 문자열로 바꾸고자 할때 사용한다.
```java
String a = 'Hello World';
a.replaceAll('World','Java'); // a = "Hello Java"
```

### `substring`
> 문자열중 특정 부분을 뽑아낼 경우에 사용한다.
```java
String a = 'Hello World';
a.substring(0,4); // "Hell"
```

### `toUpperCase`
> 문자열을 전부 대문자로 변경할때사용한다. (반대로 소문자로할땐 toLowerCase)
```java
String a = 'Hello World';
a.toUpperCase(); // "HELLO WORLD"
```

### `split`
```java
String a = 'a:b:c:d';
String[] result = a.split(":") // result는 {"a","b","c","d"}
```

### `instanceof`
> 어떤 객체가 특정 클래스의 객체인지 조사할때 사용한다.
```java
class Animal {...}

class Tiger extends Animal {...}

Tiger tiger = new Tiger();

tiger instanceof Animal // true
```
