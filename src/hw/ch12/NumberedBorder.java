package hw.ch12;


public class NumberedBorder extends Border {

    public NumberedBorder(Display display) {
        super(display); // 부모 클래스 Border를 통해 장식할 내용물(display) 저장
    }

    @Override
    public int getColumns() {
        //행 번호는 %2d|  형식 (숫자 2자리 + |, 함계 4글자) 
        return display.getColumns() + 4;
    }

    @Override
    public int getRows() {
        // 행 수는 내용물과 동일함
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        // 행 번호는 1번부터 시작해야 하므로 row + 1 
        return String.format("%2d | ", row + 1) + display.getRowText(row);
    }
}