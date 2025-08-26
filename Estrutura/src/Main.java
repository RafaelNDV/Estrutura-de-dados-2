public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        // Criando nós
        No n10 = new No(10);
        No n5 = new No(5);
        No n15 = new No(15);
        No n3 = new No(3);
        No n7 = new No(7);
        No n12 = new No(12);
        No n18 = new No(18);

        // Adicionando na árvore
        arvore.adicionar_esquerda(n10, null); // raiz
        arvore.adicionar_esquerda(n5, n10);
        arvore.adicionar_direita(n15, n10);
        arvore.adicionar_esquerda(n3, n5);
        arvore.adicionar_direita(n7, n5);
        arvore.adicionar_esquerda(n12, n15);
        arvore.adicionar_direita(n18, n15);

        System.out.println("Árvore inicial (Varredura em largura):");
        arvore.varredura_largura().imprimir();  // Esperado: 10 5 15 3 7 12 18
        System.out.println("-------------------------");

        // Testando busca
        System.out.println("Buscando elemento 7:");
        No buscado = arvore.buscar_elemento(7);
        System.out.println(buscado != null ? "Encontrado: " + buscado.getElemento_armazenado() : "Não encontrado");
        System.out.println("-------------------------");

        // Remoção de nó folha
        System.out.println("Removendo nó folha (3):");
        arvore.remover_elemento(3);
        System.out.println("Varredura em largura após remoção:");
        arvore.varredura_largura().imprimir();  // Esperado: 10 5 15 7 12 18
        System.out.println("-------------------------");

        // Remoção de nó com 1 filho
        System.out.println("Removendo nó com 1 filho (12):");
        arvore.remover_elemento(12);
        System.out.println("Varredura em largura após remoção:");
        arvore.varredura_largura().imprimir();  // Esperado: 10 5 15 7 18
        System.out.println("-------------------------");

        // Remoção de nó com 2 filhos
        System.out.println("Removendo nó com 2 filhos (5):");
        arvore.remover_elemento(5);
        System.out.println("Varredura em largura após remoção:");
        arvore.varredura_largura().imprimir();  // Esperado: 10 7 15 18
        System.out.println("-------------------------");

        // Mostrando todas as varreduras finais
        System.out.println("Varredura em PROFUNDIDADE VLR (pré-ordem):");
        arvore.varredura_profundidade_vlr().imprimir();  // Esperado: 10 7 15 18

        System.out.println("Varredura em PROFUNDIDADE LVR (em-ordem):");
        arvore.varredura_profundidade_lvr().imprimir();  // Esperado: 7 10 15 18

        System.out.println("Varredura em PROFUNDIDADE LRV (pós-ordem):");
        arvore.varredura_profundidade_lrv().imprimir();  // Esperado: 7 18 15 10
    }
}
