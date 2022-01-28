package macleetcode.code1.observer;

public interface Subject {
    void delelePerson(Observer observer);
    void addPerson(Observer observer);
    void notifyPerson();
}
