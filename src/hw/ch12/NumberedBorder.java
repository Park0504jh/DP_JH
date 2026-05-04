package hw.ch12;

/**
 * PDF 요구사항 Step 1: 각 행 앞에 행 번호를 붙여 출력하는 Decorator
 */
public class NumberedBorder extends Border {

    public NumberedBorder(Display display) {
        super(display); // 부모 클래스 Border를 통해 장식할 내용물(display) 저장
    }

    @Override
    public int getColumns() {
        // 요구사항: 행 번호는 %2d | 형식으로 총 4글자(숫자2+공백1+구분자1) 추가
        // 따라서 내용물의 가로 폭에 4를 더한 값을 반환함
        return display.getColumns() + 4;
    }

    @Override
    public int getRows() {
        // 행 번호만 추가될 뿐, 전체 행의 개수는 내용물과 동일함
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        // String.format을 사용하여 "%2d | " 형식(2자리 숫자 + 바)을 맞춤
        // row index는 0부터 시작하므로 사용자에게는 row + 1을 표시함
        return String.format("%2d | ", row + 1) + display.getRowText(row);
    }
}