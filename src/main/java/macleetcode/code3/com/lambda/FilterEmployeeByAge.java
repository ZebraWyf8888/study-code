package macleetcode.code3.com.lambda;

public class FilterEmployeeByAge implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee t) {
        return t.getAge() >= 35;
    }
}
