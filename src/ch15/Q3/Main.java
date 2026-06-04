package ch15.Q3;

public class Main {
    public static void main(String[] args) {
        String html = """
        <!DOCTYPE html>
        <html>
            <head>
                <title>Welcome!</title>
            </head>
            <body>
                <h1 style="text-align: center">Hello, world!</h1>
            </body>
        </html>
        """;  
        // 큰 따옴표 3개로 여러 줄 문자열을 표현할 수 있다.
        // 텍스트 블럭은 큰 따옴표를 기준점으로 들여쓰기를 판단한다.

        System.out.print(html);
    }
}
