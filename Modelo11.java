public class Modelo11 {

    static class Tarefa extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(200); // simula trabalho
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    public static void executar(int numThreads) {
        System.out.println("\n=== Modelo 1:1 ===");
        System.out.println("Threads criadas: " + numThreads);

        long inicio = System.currentTimeMillis();

        Thread[] threads = new Thread[numThreads];

        // Cria e inicia todas as threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Tarefa();
            threads[i].start();
        }

        // Espera todas terminarem
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                t.interrupt();
            }
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }

    public static void main(String[] args) {
        executar(10);
        executar(100);
        executar(500);
        executar(1000);
    }
}
