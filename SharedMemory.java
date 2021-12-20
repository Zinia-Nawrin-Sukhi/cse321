import java.util.ArrayList;
import java.util.List;

class SharedMemory {

  public int pointer = -1;

  private List<String> registers = new ArrayList<>();

  public synchronized String readFromReg() throws InterruptedException {
   
   if (pointer == -1) {
    wait();
   }
   
   String strng = registers.get(pointer);
   registers.remove(pointer);
   pointer--;
   
   return strng;
  }

  public synchronized void writeToReg(String value) {
   
   registers.add(value);
   pointer++;
   
   if(pointer == 0) {
    notifyAll();
   }
  }
}

class WriterThread extends Thread {

  private String[] values = {
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "Nunc et velit nec eros molestie sagittis.",
          "Aliquam ut ligula ut tortor iaculis dapibus eget et arcu.",
          "Proin tempor purus ut purus vehicula, eu faucibus ipsum fringilla.",
          "Praesent id justo ac diam aliquet iaculis.",
          "Suspendisse dignissim turpis malesuada, ultricies turpis in, molestie lorem.",
          "Nulla auctor elit eget felis congue, sit amet molestie mi mattis.",
          "Nam nec est nec felis ullamcorper accumsan.",
          "Maecenas posuere magna a eros semper elementum.",
  };

  SharedMemory sharedMemory;

  public WriterThread(SharedMemory sharedMemory) {
    this.sharedMemory = sharedMemory;
  }

  @Override
  public void run() {
    for (int i = 0 ; i < values.length ; i++) {
      try {
        sharedMemory.writeToReg(values[i]);
        sleep((int)(Math.random() * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class ReaderThread extends Thread {

  SharedMemory sharedMemory;

  public ReaderThread(SharedMemory sharedMemory) {
    this.sharedMemory = sharedMemory;
  }

  @Override
  public void run() {
    try {
      while (true) {
        System.out.println(Thread.currentThread().getName() + " prints: " + sharedMemory.readFromReg());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}


