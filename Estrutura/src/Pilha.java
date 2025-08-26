public class Pilha {
    private No topo; // referência para o topo da pilha

    public Pilha() {
        this.topo = null;
    }

    // Empilhar um nó
    public void push(No no) {
        if (no == null) return;

        // Guarda o "próximo" dentro de filho_direita
        no.setProximo(topo);
        topo = no;
    }

    // Desempilhar (retorna o nó removido)
    public No pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        No no = topo;
        topo = topo.getProximo();
        return no;
    }


    // Olhar o topo sem remover
    public No peek() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return topo;
    }

    // Verificar se está vazia
    public boolean isEmpty() {
        return topo == null;
    }

    // Mostrar todos os elementos da pilha (do topo até a base)
    public void imprimir() {
        No atual = topo;
        System.out.print("Pilha: ");
        while (atual != null) {
            System.out.print(atual.getElemento_armazenado() + " ");
            atual = atual.getProximo(); // segue para o próximo
        }
        System.out.println();
    }
}

