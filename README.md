# Comparativo-Threads-N-M-e-1-1

=== Modelo N:M ===
Threads de usuário: 10 | Threads do SO disponíveis no pool: 4
Tempo total: 645 ms

=== Modelo N:M ===
Threads de usuário: 100 | Threads do SO disponíveis no pool: 4
Tempo total: 5016 ms

=== Modelo N:M ===
Threads de usuário: 500 | Threads do SO disponíveis no pool: 4
Tempo total: 25074 ms

=== Modelo N:M ===
Threads de usuário: 1000 | Threads do SO disponíveis no pool: 4
Tempo total: 50243 ms

===============================================================

=== Modelo N:M ===
Threads de usuário: 10 | Threads do SO disponíveis no pool: 250
Tempo total: 209 ms

=== Modelo N:M ===
Threads de usuário: 100 | Threads do SO disponíveis no pool: 250
Tempo total: 210 ms

=== Modelo N:M ===
Threads de usuário: 500 | Threads do SO disponíveis no pool: 250
Tempo total: 418 ms

=== Modelo N:M ===
Threads de usuário: 1000 | Threads do SO disponíveis no pool: 250
Tempo total: 828 ms

===============================================================

=== Modelo 1:1 ===
Threads criadas: 10
Tempo total: 206 ms

=== Modelo 1:1 ===
Threads criadas: 100
Tempo total: 229 ms

=== Modelo 1:1 ===
Threads criadas: 500
Tempo total: 237 ms

=== Modelo 1:1 ===
Threads criadas: 1000
Tempo total: 264 ms

===============================================================

Gráfico:
<img width="516" height="333" alt="image" src="https://github.com/user-attachments/assets/71a805d4-e56d-4559-9347-3ee0a1ac2204" />

===============================================================

Análise:
Modelo N:M com poucas threads de SO (4 threads):
O tempo cresce proporcionalmente ao número de threads de usuário. Há formação de fila, pois o pool só consegue executar 4 threads por vez. Esse comportamento demonstra claramente o custo da multiplexação.


Modelo N:M com muitas threads de SO (250 threads):
O tempo cai drasticamente.O desempenho se aproxima muito do modelo 1:1. Aqui quase não há espera, pois a quantidade de threads do pool é suficiente para atender a demanda.


Modelo 1:1:
O tempo se mantém quase constante, mesmo com 1000 threads. Cada thread do Java vira uma thread real no SO, o que reduz espera. Entretanto, criar muitas threads reais pode consumir mais memória e gerar overhead no sistema operacional.

