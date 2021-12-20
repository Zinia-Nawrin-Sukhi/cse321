public class LabTask1 {

 public static void main(String[] args) throws InterruptedException {
  
  SharedMemory sharedMemory = new SharedMemory();

     ReaderThread readerThread = new ReaderThread(sharedMemory);
     WriterThread writerThread = new WriterThread(sharedMemory);

     writerThread.start();
     readerThread.start();

     writerThread.join();
     readerThread.stop();

 }

}