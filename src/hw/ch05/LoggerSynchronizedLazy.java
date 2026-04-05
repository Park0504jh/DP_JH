package hw.ch05;

public class LoggerSynchronizedLazy {
    // 인스턴스를 미리 생성하지 않고 참조 변수만 선언
    private static LoggerSynchronizedLazy instance;
    private StringBuilder logBuffer;

    // 생성자 private 선언
    private LoggerSynchronizedLazy() {
        System.out.println("[LoggerSynchronizedLazy] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    // synchronized 키워드로 한 번에 하나의 스레드만 접근하도록 제어 
    public static synchronized LoggerSynchronizedLazy getInstance() {
        if (instance == null) {
            instance = new LoggerSynchronizedLazy(); // 호출 시점에 생성  
        }
        return instance;
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerSynchronizedLazy] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}