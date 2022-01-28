package macleetcode.code1.observer;

import java.util.ArrayList;
import java.util.List;

public class SharesSystem implements Subject {
    List<Observer> subscribeList = new ArrayList<>();
    int status;

    @Override
    public void delelePerson(Observer observer) {
        subscribeList.remove(observer);
    }

    @Override
    public void addPerson(Observer observer) {
        subscribeList.add(observer);
    }

    @Override
    public void notifyPerson() {
        if (status <= -5) {
            for (Observer o:
                 subscribeList) {
                o.hear();
            }
        }else {
            System.out.println("未达到通知要求");
        }
    }
}
