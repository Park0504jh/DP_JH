package hw.ch12;

import java.util.ArrayList;
import java.util.List;

/**
 * PDF 제공 코드 분석 항목: 여러 문자열을 표시하는 컴포넌트
 */
public class MultiStringDisplay extends Display {
    private List<String> body = new ArrayList<>(); // 문자열을 저장할 리스트
    private int columns = 0; // 최대 폭 저장 변수

    // 문자열을 추가하고 최대 폭(columns)을 갱신함
    public void add(String string) {
        body.add(string);
        if (string.length() > columns) {
            columns = string.length();
        }
        updatePadding(); // 기존 문자열들의 공백 패딩을 맞춤
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 모든 행의 길이를 최대 폭(columns)에 맞춰 공백으로 채움[cite: 1]
    private void updatePadding() {
        for (int i = 0; i < body.size(); i++) {
            String s = body.get(i);
            int paddingCount = columns - s.length();
            if (paddingCount > 0) {
                body.set(i, s + " ".repeat(paddingCount));
            }
        }
    }
}