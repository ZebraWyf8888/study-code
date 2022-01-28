package macleetcode.code1.studysynchronizer;


/**
* @Author: WYF
* @Description: 枚举 数字对应着一个个国家
* @Create: 2020/3/22 18:26
* @Version: 1.0
*/
public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    private Integer retCode;
    private String retMessage;

    /**
     * 因为是枚举，不用set方法，有默认值
    */
    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum foreach_CountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element:
             myArray) {
            if (index == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}
