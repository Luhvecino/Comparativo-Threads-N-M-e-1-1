import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ModeloNM {

    // tarefa usada pelas threads
    static class Tarefa implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(200); // simula trabalho
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void executar(int numThreadsUsuario, int numThreadsSistema) {
        System.out.println("\n=== Modelo N:M ===");
        System.out.println("Threads de usuário: " + numThreadsUsuario +
                " | Threads do SO disponíveis no pool: " + numThreadsSistema);

        long inicio = System.currentTimeMillis();

        // M threads do sistema operacional (pool fixo)
        ExecutorService pool = Executors.newFixedThreadPool(numThreadsSistema);

        // N threads de usuário (tarefas)
        for (int i = 0; i < numThreadsUsuario; i++) {
            pool.submit(new Tarefa());
        }

        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }

    public static void main(String[] args) {
        executar(10, 1000);
        executar(100, 1000);
        executar(500, 1000);
        executar(1000, 1000);
    }
}
