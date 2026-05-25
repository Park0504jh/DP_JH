package hw.ch19;

// State 인터페이스 구현
public class ClosingState implements State {

    // Singleton 패턴 적용
    private static ClosingState singleton = new ClosingState();

    // 외부에서 new ClosingState()를 못하게 막음
    private ClosingState() {
    }
    
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {

        // 17시 이전이면 마감 시간이 아니므로 주간 상태로 변경
        if (hour < 17) {
            context.changeState(DayState.getInstance());
        }

        // 20시 이후면 야간 상태로 변경
        // 마감 상태는 17시~20시만 유지
        else if (20 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {

        // 마감 상태에서 금고 사용 시
        // 경비 센터에 "마감 금고 점검"을 알림
        context.callSecurityCenter("마감 금고 점검");
    }

    @Override
    public void doAlarm(Context context) {

        // 마감 상태에서 비상벨 발생 시
        // 경비 센터에 비상벨을 알리고
        context.callSecurityCenter("비상벨(마감)");

        // 즉시 비상 상태(UrgentState)로 전환
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("퇴근 확인 통화(마감)");
    }

    @Override
    public String toString() {
        return "[마감]";
    }
}