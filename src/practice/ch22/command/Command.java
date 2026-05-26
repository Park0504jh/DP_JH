package practice.ch22.command;

public interface Command {
    public abstract void execute();  // 뭔가 하는 일을 나타냄
    // 어떤 일을 하는지는 자식이 결정한다
}
