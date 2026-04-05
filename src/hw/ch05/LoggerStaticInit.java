package hw.ch05;

public class LoggerStaticInit {
    // (3) 클래스 로드 시점에 인스턴스를 미리 생성
    private static final LoggerStaticInit instance = new LoggerStaticInit();
    private StringBuilder logBuffer;

    // (1) 생성자를 private으로 선언하여 외부 생성을 차단
    private LoggerStaticInit() {
        System.out.println("[LoggerStaticInit] 인스턴스를 생성했습니다."); 
        logBuffer = new StringBuilder(); 
    }

    // (2) 생성된 인스턴스를 반환하는 static 메소드
    public static LoggerStaticInit getInstance() {
        return instance; 
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n"); 
        System.out.println("[LoggerStaticInit] " + message); 
    }

    public String getLog() {
        return logBuffer.toString();
    }
}