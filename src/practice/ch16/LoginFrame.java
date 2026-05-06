package practice.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ActionListener는 OK 버튼과 Cancel 버튼이 눌렸을 때의 처리를 위해서 구현한다
public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 4×2 그리드를 만든다
        setLayout(new GridLayout(4, 2));

        // Colleague를 생성한다  => 생성했다고 바로 보이는 것은 아님 => 반드시 배치해야 보인다
        createColleagues();

        // 배치한다 (배치단계 따로)
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다 (상태가 변화했을 때 호출된다)
        colleagueChanged();

        // 표시한다 (필수) 
        // pack()는 프레임의 크기를 자동으로 조절 및 정리 / setVisible(true)는 프레임을 화면에 보이도록 한다
        pack();
        setVisible(true);
    }

    // Colleague를 생성한다 (생성단계 따로)
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) { // if를 통해 체크박스의 상태를 판정한다 (Guest이면...)
            // 게스트 로그인 
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else { // Login이면...
            // 사용자 로그인 
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {  // textUser에 문자열이 입력되어 있으면...
            textPass.setColleagueEnabled(true);  // textPass를 활성화한다
            if (textPass.getText().length() > 0) {  // textPass에도 문자열이 입력되어 있으면...
                buttonOk.setColleagueEnabled(true);  // OK 버튼을 활성화한다
            } else {  // textPass에 문자열이 입력되어 있지 않으면...
                buttonOk.setColleagueEnabled(false);  // OK 버튼을 비활성화한다
            }
        } else {  // textUser에 문자열이 입력되어 있지 않으면...
            textPass.setColleagueEnabled(false);  // textPass를 비활성화한다
            buttonOk.setColleagueEnabled(false);  // OK 버튼을 비활성화한다
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
