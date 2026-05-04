package hw.ch12;

public class Main {
    public static void main(String[] args) {
        // MultiStringDisplay 인스턴스 생성 및 데이터 추가
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Hello, Java!");
        md.add("Decorator Pattern");
        md.add("is powerful.");

        // [2-1] 원본 출력: 장식되지 않은 순수 MultiStringDisplay 출력[cite: 1]
        System.out.println("[2-1] 원본 출력");
        md.show();
        System.out.println();

        // [2-2] NumberedBorder 단독 적용: 각 행 앞에 번호(1 | , 2 | ...)가 붙음[cite: 1]
        System.out.println("[2-2] NumberedBorder 단독 적용");
        Display d1 = new NumberedBorder(md);
        d1.show();
        System.out.println();

        // [2-3] FullBorder + NumberedBorder 조합: 번호가 붙은 결과 전체를 테두리로 감쌈[cite: 1]
        System.out.println("[2-3] FullBorder + NumberedBorder 조합");
        Display d2 = new FullBorder(new NumberedBorder(md));
        d2.show();
        System.out.println();

        // [2-4] SideBorder + NumberedBorder + FullBorder 3단 중첩[cite: 1]
        // 1. md를 FullBorder로 감쌈
        // 2. 그 결과를 NumberedBorder로 감싸 행 번호 추가
        // 3. 마지막으로 SideBorder('*')로 양 끝을 장식
        System.out.println("[2-4] SideBorder + NumberedBorder + FullBorder 3단 중첩");
        Display d3 = new SideBorder(new NumberedBorder(new FullBorder(md)), '*');
        d3.show();
    }
}