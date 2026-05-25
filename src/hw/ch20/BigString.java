package hw.ch20;

public class BigString {

    // 큰 문자 배열
    private BigChar[] bigchars;

    // 생성자
    public BigString(String string) {

        BigCharFactory factory = BigCharFactory.getInstance();

        bigchars = new BigChar[string.length()];

        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] =
                    factory.getBigChar(string.charAt(i));
        }
    }

    // 기존 출력 메서드 (수정 X)
    public void print() {
        for (BigChar bc : bigchars) {
            bc.print();
        }
    }

    // 오버로드 메서드 추가
    // 문자마다 다른 색상을 적용하기 위해
    // String[] 배열을 전달받음
    public void print(String[] colors) {

        // 각 문자에 대응하는 색상 적용
        for (int i = 0; i < bigchars.length; i++) {

            // BigChar의 새로운 print(colorCode) 호출
            bigchars[i].print(colors[i]);
        }
    }
}