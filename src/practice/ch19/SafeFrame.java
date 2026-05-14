package practice.ch19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);		// 현재 시간 표시
    private TextArea textScreen = new TextArea(10, 60);	// 경비 센터 출력
    private Button buttonUse = new Button("금고 사용");	// 금고 사용 버튼
    private Button buttonAlarm = new Button("비상벨");	// 비상벨 버튼
    private Button buttonPhone = new Button("일반 통화");	// 일반 통화 버튼
    private Button buttonExit = new Button("종료");		// 종료 버튼


    // State가 부모 타입이므로 모든 상태 구현 가능
    // 가장 중요한 속성: 상태 패턴의 현재 상태를 나타내는 속성
    private State state = DayState.getInstance();		// 현재 상태 

    // 생성자 
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock 배치 
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen 배치 
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // 패널에 버튼 저장
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 그 패널을 배치 
        add(panel, BorderLayout.SOUTH);
        // 표시 
        pack();
        setVisible(true);
        // 리스너 설정 
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // 버튼이 눌리면 여기로 온다
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {		// 금고 사용 버튼
            state.doUse(this);   // 현재 상태 객체에게 위힘 (가장 중요!! 자기가 일하는 게 아니라 상태 객체가 일하도록 위임. 야간 또는 주간 상태 객체가 일하도록 위임)
        } else if (e.getSource() == buttonAlarm) {	// 비상벨 버튼 
            state.doAlarm(this);  // 현재 상태 객체에게 위힘
        } else if (e.getSource() == buttonPhone) {	// 일반 통화 버튼  
            state.doPhone(this);  // 현재 상태 객체에게 위힘
        } else if (e.getSource() == buttonExit) {	// 종료 버튼 
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }

    // 시간 설정  : 1초에 한 번씩 시계에서 호출한다
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockstring);
        textClock.setText(clockstring);

        state.doClock(this, hour);  // 현재 상태 객체에게도 시간을 알려준다. 상태 객체는 시간에 따라 상태 변화가 필요한지 판단한다.
    }

    // 상태 변화 
    @Override
    public void changeState(State state) {  // 현재 상태를 인자로 들어온 상태로 바꿈
        System.out.println(this.state + "에서" + state + "으로 상태가 변화했습니다.");
        this.state = state;
    }

    // 경비 센터 경비원 호출
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // 경비 센터 기록 
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
