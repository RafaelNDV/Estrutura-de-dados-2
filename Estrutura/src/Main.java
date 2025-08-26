public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        // Criando nós (apenas como referência, pois Arvore cria novos nós ao adicionar)
        No raiz = new No(10);
        No filhoE = new No(5);
        No filhoD = new No(15);
        No netoE = new No(3);
        No netoD = new No(7);

        // Inserindo raiz
        arvore.adicionar_esquerda(raiz, null); // se a árvore está vazia, vira raiz

        // Inserindo filhos da raiz
        arvore.adicionar_esquerda(filhoE, raiz);   // filho esquerdo de 10
        arvore.adicionar_direita(filhoD, raiz);    // filho direito de 10

        // Inserindo filhos do nó 5
        arvore.adicionar_esquerda(netoE, filhoE);  // filho esquerdo de 5
        arvore.adicionar_direita(netoD, filhoE);   // filho direito de 5

        // ===== Testando buscas =====
        System.out.println("\n=== Testando buscar_elemento ===");
        System.out.println("Buscando 15: " + (arvore.buscar_elemento(15) != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Buscando 7: " + (arvore.buscar_elemento(7) != null ? "Encontrado" : "Não encontrado"));
        System.out.println("Buscando 99: " + (arvore.buscar_elemento(99) != null ? "Encontrado" : "Não encontrado"));

        // ===== Testando buscar_pai =====
        System.out.println("\n=== Testando buscar_pai ===");
        No paiDe3 = arvore.buscar_pai(arvore.buscar_elemento(3));
        No paiDe7 = arvore.buscar_pai(arvore.buscar_elemento(7));
        No paiDe15 = arvore.buscar_pai(arvore.buscar_elemento(15));
        No paiDaRaiz = arvore.buscar_pai(arvore.getRaiz_arvore());

        System.out.println("Pai do nó 3: " + (paiDe3 != null ? paiDe3.getElemento_armazenado() : "null"));
        System.out.println("Pai do nó 7: " + (paiDe7 != null ? paiDe7.getElemento_armazenado() : "null"));
        System.out.println("Pai do nó 15: " + (paiDe15 != null ? paiDe15.getElemento_armazenado() : "null"));
        System.out.println("Pai da raiz (10): " + (paiDaRaiz != null ? paiDaRaiz.getElemento_armazenado() : "null"));

        // Mostrar estrutura simples da árvore (manual, só pra conferir)
        System.out.println("\n=== Estrutura da árvore ===");
        System.out.println("Raiz: " + arvore.getRaiz_arvore().getElemento_armazenado());
        System.out.println("Filho esquerdo da raiz: " + arvore.getRaiz_arvore().getFilho_esquerda().getElemento_armazenado());
        System.out.println("Filho direito da raiz: " + arvore.getRaiz_arvore().getFilho_direita().getElemento_armazenado());
        System.out.println("Filho esquerdo de 5: " + arvore.getRaiz_arvore().getFilho_esquerda().getFilho_esquerda().getElemento_armazenado());
        System.out.println("Filho direito de 5: " + arvore.getRaiz_arvore().getFilho_esquerda().getFilho_direita().getElemento_armazenado());
    }
}

