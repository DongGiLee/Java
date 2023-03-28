package example;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;


public class exam4 {
    
    public static void main(String[] args) throws IOException {

        /**
         * 1. 입력 숫자의 합
         * 
         * 두개의 숫자를 입력받아 그 합을 출력하는 프로그램을 작성하시오.
         * 
         */
        // InputStream in = System.in;
        // InputStreamReader reader = new InputStreamReader(in);
        // BufferedReader br = new BufferedReader(reader);
        // String a = br.readLine();

        // Scanner sc1 = new Scanner(System.in);
        // int first = sc1.nextInt();
        // System.out.println("첫번쨰 : "+first);
        // int second = sc1.nextInt();
        // System.out.println("두번쨰 : "+second);
        // int total = first+second;
        // System.out.println("합 : "+total);
        // sc1.close();
        
        /**
         * 2. 대문자로 변경하기
         * 
         * 영문을 입력하고 엔터를 입력하면 영문을 대문자로 변경하여 출력하는 프로그램을 작성하시오
         * (단, 사용자가 "END"라는 문자열을 입력하기 전까지 반복해서 문장을 입력받을수 있게할것)
         * 
         */

        // InputStream in = System.in;
        // InputStreamReader reader = new InputStreamReader(in);
        // BufferedReader br = new BufferedReader(reader);
        
        // while(true) {
        //     String a = br.readLine();
        
        //     a = a.toUpperCase().trim();
        //     System.out.println("입력값 :"+a);
        
        //     if (a.equals("END")) {
        //         System.out.println("END!!");
        //         break;
        //     }
        // }
        

        /**
         * 3. 오류 수정하기
         * 
         * 다음은 "sample.txt"라는 파일에 "Write once, run anywhere" 문자열을 저장한 후
         *  다시 그 파일을 읽어서 출력하는 프로그램이다.
         * 
         * import java.io.BufferedReader;
            import java.io.FileReader;
            import java.io.FileWriter;
            import java.io.IOException;


            public class Sample {
                public static void main(String[] args) throws IOException {
                    FileWriter fw = new FileWriter("sample.txt");
                    fw.write("Write once, run anywhere");

                    BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
                    String line = br.readLine();
                    System.out.println(line);  // null 이 출력된다.
                }
            }
         * 
         * 이 프로그램은 우리가 예상한 "Write once, run anywhere"라는 문장을 출력하지 않고 null을 출력한다. 
         * 우리가 예상한 값을 출력할 수 있도록 프로그램을 수정해 보자.
         * 
         * close() 를 사용해야한다.
         */
        // FileWriter fw = new FileWriter("sample.txt");
        // fw.write("Write once, run anywhere");
        // fw.close();

        // BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        // String line = br.readLine();
        // System.out.println(line);  // null 이 출력된다.
        // br.close();

        /**
         * 4. 사용자의 입력을 파일에 저장하기
         * 
         * 사용자의 입력을 파일(sample.txt)에 저장하는 프로그램을 작성해보자.
         * (단 프로글매을 다시 실행하더라도 기존에 작성한 내용을 유지하고 새로 이뵭한 내용을 추가해야한다.)
         * 
         */

        
        // FileWriter fw = new FileWriter("sample2.txt",true);
        // InputStream in = System.in;
        // InputStreamReader reader = new InputStreamReader(in,"UTF8");
        // BufferedReader br = new BufferedReader(reader);
        
        // String a = br.readLine();
        
        // fw.write(a);

        // fw.close();

        // FileWriter fw = new FileWriter("sample2.txt");
        
        // final String FILE_PATH = "sample2.txt";
        
        // FileWriter fw = new FileWriter(FILE_PATH,true);
        // PrintWriter pw = new PrintWriter(fw);
        
        // InputStream in = System.in;
        // InputStreamReader reader = new InputStreamReader(in);
        // BufferedReader br = new BufferedReader(reader);
        // String aa = br.readLine();
        // pw.println(aa);
        // pw.close();
        
        // // byte[] b = new byte[1024];
        // // FileInputStream fi = new FileInputStream(FILE_PATH);
        // // fi.read(b);
        // // System.out.print(new String(b));
        // // fi.close();
        // FileReader fi = new FileReader(FILE_PATH);
        // BufferedReader br2 = new BufferedReader(fi);
        
        // while(true) {
        //     String lines = br2.readLine();
        //     if (lines==null) break;
        //     System.out.println(lines);
        // }
        // br2.close();

        /**
         * 5. 파일 내용 바꾸어 저장하기
         * 
         * 다음과 같은 내용을 지닌 파일 sample3.txt 파일이있다.
         * 이파일의 내용중 "python" 이라는 문자열을 "java"로 바꾸어 저장해보자
         * 
         * Life is too short
            you need python
         */

        final String TEXT_PATH_3 = "sample3.txt";
        BufferedReader br4 = new BufferedReader(new FileReader(TEXT_PATH_3));
        ArrayList<String> data = new ArrayList<>();
        while(true) {
            String lines = br4.readLine();
            if (lines==null) break;
            data.add(lines);
        }
        br4.close();

        System.out.println(data);
        // for(String line : data){
        //     // System.out.println(line.contains("python"));
        //     System.out.println(data.indexOf(line));
        //     if (line.contains("python")) {
        //         line.replaceAll(line, TEXT_PATH_3);
        //     }
        // }
        String replaceData = String.join("\n", data);
        replaceData = replaceData.replaceAll("python", "java");
        System.out.println(replaceData);

        PrintWriter rd = new PrintWriter(TEXT_PATH_3);
        rd.write(replaceData);
        rd.close();
        

    }
}
