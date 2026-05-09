package hw.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;
    // 새로운 ColleagueLabel 필드 추가 
    private ColleagueLabel statusLabel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(5, 2));  // 그리드 레이아웃을 5x2로 변경 
        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        add(statusLabel);  // 마지막 행에 상태 표시 라벨 배치

        colleagueChanged(); 
        pack();
        setVisible(true);
    }


    @Override
    public void createColleagues() {

        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // statusLabel 생성 및 초기 설정
        statusLabel = new ColleagueLabel(" 로그인 불가");
        statusLabel.setMediator(this); // Mediator 등록

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }


    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) { 
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }

        // buttonOk의 활성 여부와 statusLabel을 연동
        if (buttonOk.isEnabled()) {
            // OK 버튼이 활성화될 때 -> "로그인 가능" 상태로 업데이트
            statusLabel.setColleagueEnabled(true);
        } else {
            // OK 버튼이 비활성화될 때 -> "로그인 불가" 상태로 업데이트 
            statusLabel.setColleagueEnabled(false);
        }
    }

    private void userpassChanged() {
        if (textUser.getText().length() >= 4) {    // 사용자 이름이 4자 미만일 때는 비활성화
            textPass.setColleagueEnabled(true);  
            if (textPass.getText().length() >= 4) {  
                buttonOk.setColleagueEnabled(true); 
            } else { 
            }
        } else {  
            textPass.setColleagueEnabled(false); 
            buttonOk.setColleagueEnabled(false);  
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
