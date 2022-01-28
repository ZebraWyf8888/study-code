package note.command.commandtest;

public class CreateCommand implements Command {
    @Override
    public void excute() {
        new BoardScreen().create();
    }
}
