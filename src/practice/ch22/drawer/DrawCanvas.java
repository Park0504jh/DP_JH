package practice.ch22.drawer;

import practice.ch22.command.MacroCommand;

import java.awt.Canvas;  // AWT의 캔버스 클래스, 흰색 도화지
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리는 색 
    private Color color = Color.red;
    // 그리는 점의 반지름 
    private int radius = 6;
    // 이력 
    private MacroCommand history;  // 지금까지의 그리기 명령들을 모아둔 곳

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 이력 전체 다시 그리기 
    @Override
    public void paint(Graphics g) {  // REPAINT 이벤트가 발생했을 때 호출되는 메소드
        history.execute();
    }

    // 그리기 
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        // (원이 그려질 위치.x - 반지름, 위치.y - 반지름, 반지름 * 2, 반지름 * 2)
    }
}
