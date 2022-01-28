package macleetcode.day912;

class B extends Thread {

   public static void method(Object a){
       System.out.println("object");
   }
   public static void method(String a){
       System.out.println("string");
   }
}

public class Main2 {
    public static void main(String[] args) {
        B.method(null);
    }
}
