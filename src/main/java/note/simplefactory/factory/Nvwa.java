package note.simplefactory.factory;

import note.simplefactory.product.Man;
import note.simplefactory.product.Person;
import note.simplefactory.product.Woman;

public class Nvwa {
    public Person makePerson(String Type) {
        if (Type.equalsIgnoreCase("Woman")) {
            return new Woman();
        } else if (Type.equalsIgnoreCase("Man")) {
            return new Man();
        }else {
            throw new RuntimeException("\"类型不存在\"");
        }
    }
}