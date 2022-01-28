package macleetcode.code3.com.lambda;//package macleetcode.code3.com.lambda;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class TestLambda2 {
//    List<Employee> employes = Arrays.asList(
//            new Employee("张三", 18,9999.99),
//            new Employee("李四", 38,5555.99),
//            new Employee("王五", 50,6666.66),
//            new Employee("赵六", 16,3333.33),
//            new Employee("田七", 10,7777.77)
//    );
//
//    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
//        List<Employee> emps = new ArrayList<>();
//
//        for (Employee employe : list){
//            if (mp.test(employe)){
//                emps.add(employe);
//            }
//        }
//        return emps;
//    }
//
//    //方法一：策略设计模式
//    @Test
//    public void test1(){
//        List<Employee> list = filterEmployee(this.employes, new FilterEmployeeByAge());
//        list.forEach(System.out::println);
//    }
//
//    //优化方式二：匿名内部类
//    @Test
//    public void test2(){
//        List<Employee> list = filterEmployee(this.employes, new MyPredicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getSalary() >= 5000;
//            }
//        });
//        list.forEach(System.out::println);
//    }
//
//    //方法三：Lambda表达式
//    @Test
//    public void test3(){
//        List<Employee> list = filterEmployee(this.employes, t -> t.getSalary() >= 5000);
//        list.forEach(System.out::println);
//    }
//
//    //方法五？Stream API
//    @Test
//    public void test5(){
//        this.employes.stream()
//                .filter(x->x.getAge()>=30)
//                .forEach(System.out::println);
//
//        System.out.println("--------------------------------------");
//        this.employes.stream()
//                .filter(x->x.getSalary()>=5000)
//                .forEach(System.out::println);
//    }
//}
