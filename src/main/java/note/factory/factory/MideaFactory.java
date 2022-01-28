package note.factory.factory;

import note.factory.product.MideaAirCondition;
import note.factory.product.Product;

public class MideaFactory implements Factory {

    @Override
    public Product createProduct() {
        return new MideaAirCondition();
    }
}
