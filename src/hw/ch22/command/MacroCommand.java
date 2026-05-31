package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements Command {

    private Deque<Command> commands = new ArrayDeque<>();

    // Undo된 명령을 저장하는 Redo 스택
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    @Override
    public void execute() {

        // commands.push()로 저장하면 최신 명령이 앞에 위치함
        // 따라서 가장 먼저 입력된 명령부터 실행하기 위해
        // descendingIterator()를 사용
        Iterator<Command> it = commands.descendingIterator();

        while (it.hasNext()) {
            it.next().execute();
        }
    }

    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException(
                    "infinite loop caused by append");
        }

        commands.push(cmd);

        // 새로운 명령이 실행되면
        // 기존 Redo 기록은 사용할 수 없으므로 삭제
        commandsForRedo.clear();
    }

    public void undo() {

        // 삭제된 명령을 Redo 스택에 저장
        if (!commands.isEmpty()) {
            Command cmd = commands.pop();
            commandsForRedo.push(cmd);
        }
    }

    // Undo된 명령을 다시 복원하는 기능
    public void redo() {

        if (!commandsForRedo.isEmpty()) {

            // Redo 스택에서 꺼내 원래 명령 스택으로 복원
            Command cmd = commandsForRedo.pop();
            commands.push(cmd);
        }
    }

    public void clear() {

        commands.clear();

        // Redo 기록도 함께 삭제
        commandsForRedo.clear();
    }
}