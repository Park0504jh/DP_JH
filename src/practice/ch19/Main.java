package practice.ch19;

public class Main {
    public static void main(String[] args) {

        // GUI 프레임 생성
        SafeFrame frame = new SafeFrame("State Sample");

        // 시계 역할 구현 
        // 1초마다 현재 시간을 얻어서 SafeFrame의 setClock()에 전달한다
        // Thread.sleep(1000): 1초 대기하는 메소드
        while (true) {  // 무한 루프
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);   // 시간 설정 
                try {
                    Thread.sleep(1000);  // 1초 대기
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
