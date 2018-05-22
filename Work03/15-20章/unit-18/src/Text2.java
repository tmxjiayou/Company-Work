public class Text2 {  
  
    public static void main(String[] args) {  
        OneThread one = new OneThread("add");  
        Thread t1 = new Thread(one);  
        Thread t2 = new Thread(one);  
          
        OneThread two = new OneThread("minus");  
        Thread t3 = new Thread(two);  
        t3.setPriority(9);  
        Thread t4 = new Thread(two);  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();   
    }  
}  
  
class Singleton {  
    private static Singleton instance = null;  
    private static int number = 0;  
  
    private Singleton() {  
    }  
  
    public static Singleton getInstance() {  
        if (instance == null)  
            instance = new Singleton();  
        return instance;  
    }  
  
    public synchronized int Add(){  
        try{  
            System.out.println("执行加操作前为 "+number);  
            return ++number;  
        }finally{  
            System.out.println("执行加操作后为 "+number);  
            System.out.println("-------------------");  
        }  
    }  
  
    public synchronized int minus() {         
        try{  
            System.out.println("执行减操作前为 "+number);  
            return --number;  
        }finally{  
            System.out.println("执行减操作后为 "+number);  
            System.out.println("-------------------");  
        }  
    }  
}  
  
class OneThread implements Runnable {  
    private Singleton singleton;  
    private String status;  
  
    OneThread(String status) {  
        singleton = Singleton.getInstance();  
        this.status = status;  
    }  
  
    @Override  
    public void run() {  
        if ("add".equals(this.status)) {  
            System.out.println(singleton.Add());  
        } else {  
            System.out.println(singleton.minus());  
        }  
    }  
  
}  