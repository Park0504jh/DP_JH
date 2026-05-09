package hw.ch16;

import java.awt.Color;
import java.awt.Label;


public class ColleagueLabel extends Label implements Colleague {
    private Mediator mediator; 

    public ColleagueLabel(String text) {
        super(text);
    }

    // Mediator 설정
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator의 지시에 따라 활성/비활성 상태를 시각적으로 업데이트
    @Override
    public void setColleagueEnabled(boolean enabled) {
        if (enabled) {
            // 로그인 가능할 때: 파란색 글씨와 "로그인 가능" 텍스트 설정 
            setText("로그인 가능");
            setForeground(Color.blue);
        } else {
            // 로그인 불가할 때: 회색 글씨와 "로그인 불가" 텍스트 설정 
            setText("로그인 불가");
            setForeground(Color.gray);
        }
    }
}