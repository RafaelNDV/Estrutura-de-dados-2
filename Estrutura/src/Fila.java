public class Fila {
    private No[] elementos;
    private int frente;
    private int tras;
    private int tamanhoMax;

    public Fila() {
        tamanhoMax = 100;       // capacidade máxima
        elementos = new No[tamanhoMax];
        frente = 0;
        tras = 0;
    }

    // enfileira elemento
    public void enfileirar(No n) {
        if (tras < tamanhoMax) {
            elementos[tras] = n;
            tras++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

    // desenfileira elemento
    public No desenfileirar() {
        if (!filaVazia()) {
            No n = elementos[frente];
            frente++;
            return n;
        } else {
            System.out.println("Fila vazia!");
            return null;
        }
    }

    // verifica se a fila está vazia
    public boolean filaVazia() {
        return frente == tras;
    }
}
