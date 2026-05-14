package ch17.A2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// FrameObserver는 GraphObserver와 DigitObserver의 기능을 모두 포함하는 관찰자
public class FrameObserver extends Frame implements Observer, ActionListener {
    // GraphText는 통지된 수를 텍스트 필드로 표시하는 static 클래스 
    static class GraphText extends TextField implements Observer {
        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            String text = number + ":";
            for (int i = 0; i < number; i++) {
                text += '*';
            }
            setText(text);
        }
    }

    // GraphCanvas는 통지된 수를 원그래프로 표시하는 static 클래스 
    static class GraphCanvas extends Canvas implements Observer {
        private int number;

        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber();
            repaint();  // 도화지를 클리어하고 paint() 메소드를 호출하여 다시 그린다
        }

        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();

            // 흰색 원
            g.setColor(Color.white);
            g.fillArc(0, 0, width, height, 0, 360);

            // 빨간색 원 호
            g.setColor(Color.red);
            g.fillArc(0, 0, width, height, 90, - number * 360 / 50);
        }
    }

    private GraphText textGraph = new GraphText(60);
    private GraphCanvas canvasGraph = new GraphCanvas();
    private Button buttonClose = new Button("Close");

    public FrameObserver() {
        super("FrameObserver");

        setLayout(new BorderLayout()); // 레이아웃 매니저로 BorderLayout을 설정

        setBackground(Color.lightGray); // 배경색을 밝은 회색으로 설정
        textGraph.setEditable(false); // 텍스트 필드를 편집 불가능하게 설정
        canvasGraph.setSize(500, 500);  // 캔버스의 크기를 500x500으로 설정

        add(textGraph, BorderLayout.NORTH);  // 텍스트 필드를 프레임의 북쪽에 추가
        add(canvasGraph, BorderLayout.CENTER);  // 캔버스를 프레임의 중앙에 추가
        add(buttonClose, BorderLayout.SOUTH);  // 버튼을 프레임의 남쪽에 추가

        buttonClose.addActionListener(this);  // 버튼에 액션 리스너를 등록하여 클릭 이벤트 처리
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void update(NumberGenerator generator) {
        textGraph.update(generator);
        canvasGraph.update(generator);
    }
}

