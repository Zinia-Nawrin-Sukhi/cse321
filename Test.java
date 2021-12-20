class MyThread extends Thread{
    
    public MyThread(String name){
        super(name);
    }
    
    @Override
    public void run(){
       //System.out.println("Hello World");
       //System.out.println(Thread.currentThread().getName());
       for(int i = 0; i<5; i++ ){
         yield();
         System.out.println("This is the output : "+ getName() + ":"+ i );  
         try{
            sleep(10); 
         }
         catch(InterruptedException e){
           e.printStackTrace();  
         }
         
       }
    }
}
/*class MyThreadFromRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName()); 
    }
}*/
public class Test{
    public static void main(String[]args){
        //System.out.println("Hello World");
        //System.out.println(Thread.currentThread().getName());
        MyThread myThread1 = new MyThread("My Thread 1");
        MyThread myThread2 = new MyThread("My Thread 2");
        MyThread myThread3 = new MyThread("My Thread 3");
        MyThread myThread4 = new MyThread("My Thread 4");
        
        //System.out.println(myThread1.getState());
        
        //myThread4.setPriority(Thread.MAX_PRIORITY);
        //myThread2.setPriority(Thread.MIN_PRIORITY);
        
           
        //Thread myThreadRunnable = new Thread(new MyThreadFromRunnable(), "My Thread 2");
        //myThreadRunnable.start();
        //myThread.start();
        //myThreadRunnable.run();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        
           try{
            myThread1.join(); 
            myThread2.join(); 
            myThread3.join(); 
            myThread4.join(); 
         }
         catch(InterruptedException e){
           e.printStackTrace();  
         }
        if(!myThread2.isAlive()){
            System.out.println(myThread2.getName() + " Is dead !!!");
            
        }
        //System.out.println(myThread1.getState());
        System.out.println("All Threads are done !!! ");
    }
}