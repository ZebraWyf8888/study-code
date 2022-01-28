package note.factory.factory;

import note.factory.product.HaierAirCondition;
import note.factory.product.Product;

public class HaierAirFactory implements Factory {
    @Override
    public Product createProduct() {
        return new HaierAirCondition();
    }
}
