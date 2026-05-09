package hw.ch16;

import java.awt.Button;

// Button을 상속받고 Colleague 인터페이스를 구현한다
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    // caption은 화면에서 버튼에 표시되는 문자열이다
    public ColleagueButton(String caption) {
        super(caption);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
