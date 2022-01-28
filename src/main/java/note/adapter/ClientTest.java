package note.adapter;

import note.adapter.twomethod.ClassAdapter;
import note.adapter.twomethod.ObjectAdapter;

public class ClientTest {
    public static void main(String[] args) {
        Target classAdapter = new ClassAdapter();
        classAdapter.request();
        Target objectAdapter = new ObjectAdapter();
        objectAdapter.request();
    }
}
