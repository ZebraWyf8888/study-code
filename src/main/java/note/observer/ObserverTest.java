package note.observer;

public class ObserverTest {
    public static void main(String[] args) {
        SharesSystem sharesSystem = new SharesSystem();
        sharesSystem.addPerson(new SharesPerson());
        System.out.println("当跌了3%时候");
        sharesSystem.status = -3;
        sharesSystem.notifyPerson();
        System.out.println("当跌了6%时候");
        sharesSystem.status = -6;
        sharesSystem.notifyPerson();
    }
}
