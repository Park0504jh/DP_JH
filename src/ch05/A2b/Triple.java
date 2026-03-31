package ch05.A2b;

public enum Triple {
    ALPHA, BETA, GAMMA;  // 필요한 만큼 열거 상수 추가

    private Triple() {
        System.out.println("The instance " + this + " is created.");
    }

    public static Triple getInstance(String name) {
        // 특정 이름을 받으면 해당되는 객체 return 함
        return valueOf(name);
    }
}
