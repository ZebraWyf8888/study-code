package note.factory.factory;

import note.factory.product.Product;

/**
 * @Author: WYF
 * @Description: 工厂接口
 */
public interface Factory {
    /**
     * 构建产品
     *
     * @Param void
     * @return
     */
    Product createProduct();

}
