public class Lista {
    private int[] elementos;
    private int tamanho;

    public Lista() {
        elementos = new int[100];
        tamanho = 0;
    }

    public void adicionarFinal(int valor) {
        if (tamanho < elementos.length) {
            elementos[tamanho] = valor;
            tamanho++;
        } else {
            System.out.println("Lista cheia! Não é possível adicionar mais elementos.");
        }
    }

    public void adicionarInicio(int valor) {
        if (tamanho < elementos.length) {
            for (int i = tamanho; i > 0; i--) {
                elementos[i] = elementos[i - 1];
            }
            elementos[0] = valor;
            tamanho++;
        } else {
            System.out.println("Lista cheia! Não é possível adicionar mais elementos.");
        }
    }

    public int get(int indice) {
        if (indice >= 0 && indice < tamanho) {
            return elementos[indice];
        } else {
            System.out.println("Índice inválido!");
            return -1;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public boolean buscarElemento(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
