package macleetcode.code1.command.commandtest;

public class EditCommand implements Command {
    @Override
    public void excute() {
        new BoardScreen().edit();
    }
}
