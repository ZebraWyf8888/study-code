package macleetcode.code1.Iterator;

public class TestClient {
    public static void main(String[] args) {
        Character[] clist = {'a', 'b', 'c', 'd', 'e', 'f'};
        CharObject charObject = new CharObject();
        charObject.setCharLisr(clist);
        Iterator iterator = charObject.CreateIterator();
        System.out.println("向后遍历：");
        while (true) {
            Character after = iterator.getAfter();
            System.out.print(after + "->");
            if (after == null) {
                System.out.println();
                break;
            }
        }
        System.out.println("向前遍历：");
        while (true) {
            Character before = iterator.getBefore();
            System.out.print(before + "->");
            if (before == null) {
                System.out.println();
                break;
            }
        }
    }
}
