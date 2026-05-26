package practice.ch22.drawer;

import practice.ch22.command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
    // 그리는 대상 
    protected Drawable drawable;

    // 그리는 위치 
    private Point position;

    // 생성자 
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);  // 그리는 대상.그려라(위치.x, 위치.y)
    }
}
