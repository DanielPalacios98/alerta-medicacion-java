package espe.edu.ec.medicinealert.core;

public class App {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            AlertSystem.stop();
            System.out.println("Application stopped successfully.");
        }));
        
        AlertSystem.start();
        
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}