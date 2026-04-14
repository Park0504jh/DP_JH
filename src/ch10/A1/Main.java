package ch10.A1;

public class Main {
    public static void main(String[] args) {  
        // args라는 문자열 배열에 명령행에서 입력한 인자들이 저장됨 (문자열로 전달된다는 것 기억하기!)
        // (terminal에서 java Main 314 15 라고 입력하면 args[0]에는 "314", args[1]에는 "15"가 저장됨)
        if (args.length != 2) {  // 명령행 인자의 개수가 2개가 아니면 사용법을 출력하고 종료
            System.out.println("Usage: java Main randomseed1 randomseed2");  // 이 밑이 사용법
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }

        // 명령행 인자가 문자열이므로 정수로 변환해야 함
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("Taro", new ProbStrategy(seed1));  // 본 예제에서는 seed 값을 직접 입력받도록 했었음. 여기서는 명령행 인자로 입력받도록 변경함
        Player player2 = new Player("Hana", new RandomStrategy(seed2));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
