package macleetcode.code1.command.commandtest;

public class OpenCommand implements Command {
    @Override
    public void excute() {
        new BoardScreen().open();
    }

}
