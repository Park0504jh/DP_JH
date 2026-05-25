package hw.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {

    private char charname;
    private String fontdata;

    // ANSI 색상 초기화 코드
    // 색 출력 후 원래 터미널 색으로 되돌리기 위해 사용
    private static final String RESET = "\u001B[0m";

    // 생성자
    public BigChar(char charname) {
        this.charname = charname;

        try {
            String filename = "big" + charname + ".txt";

            StringBuilder sb = new StringBuilder();

            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }

            this.fontdata = sb.toString();

        } catch (IOException e) {

            this.fontdata = charname + "?";
        }
    }

    // 기존 출력 메서드 (수정 X)
    public void print() {
        System.out.print(fontdata);
    }

    // 오버로드된 메서드 추가
    // 색상 코드를 외부(Main)에서 받아 출력
    // → 색상은 외재 상태이므로 객체 내부에 저장하지 않음
    public void print(String colorCode) {

        // [색상 시작 코드] + [문자 데이터] + [색상 초기화]
        System.out.print(colorCode + fontdata + RESET);
    }
}