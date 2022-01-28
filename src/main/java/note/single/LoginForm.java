package note.single;

public class LoginForm {
    volatile private static LoginForm singleTon = null;
    private LoginForm(){
        System.out.println("登录界面类LoginForm弹出");
    }

    public static LoginForm getInstance(){
        if (singleTon == null){
            synchronized (SingleTon.class){
                if (singleTon == null) {
                    singleTon = new LoginForm();
                }else {
                    System.out.println("程序已运行");
                }
            }
        }else {
            System.out.println("程序已运行");
        }
        return singleTon;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                LoginForm.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
