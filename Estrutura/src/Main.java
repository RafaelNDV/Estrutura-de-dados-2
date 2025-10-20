public class Main {
    public static void main(String[] args) {
        ArvoreBusca arvore = new ArvoreBusca();

        // Inserindo elementos
        arvore.adicionarElemento(50);
        arvore.adicionarElemento(30);
        arvore.adicionarElemento(70);
        arvore.adicionarElemento(20);
        arvore.adicionarElemento(40);
        arvore.adicionarElemento(60);
        arvore.adicionarElemento(80);

        // Exibir árvore em ordem
        System.out.println("Árvore em ordem (in-order):");
        imprimirEmOrdem(arvore.getRaiz());
        System.out.println();

        // Buscar elementos
        System.out.println("\n--- Teste de busca ---");
        No no40 = arvore.buscar_elemento(new No(40));
        No no60 = arvore.buscar_elemento(new No(60));
        No no100 = arvore.buscar_elemento(new No(100)); // não existe

        System.out.println("Buscando 40 -> " + (no40 != null ? "encontrado" : "não encontrado"));
        System.out.println("Buscando 60 -> " + (no60 != null ? "encontrado" : "não encontrado"));
        System.out.println("Buscando 100 -> " + (no100 != null ? "encontrado" : "não encontrado"));

        // Buscar pai
        System.out.println("\n--- Teste buscaPai ---");
        No pai40 = arvore.buscaPai(new No(40));
        No pai20 = arvore.buscaPai(new No(20));
        No pai50 = arvore.buscaPai(new No(50)); // raiz não tem pai

        System.out.println("Pai de 40: " + (pai40 != null ? pai40.getElemento_armazenado() : "null"));
        System.out.println("Pai de 20: " + (pai20 != null ? pai20.getElemento_armazenado() : "null"));
        System.out.println("Pai de 50 (raiz): " + (pai50 != null ? pai50.getElemento_armazenado() : "null"));

        // Remoção de elementos
        System.out.println("\n--- Teste de remoção ---");
        arvore.removerElemento(new No(20)); // nó folha
        arvore.removerElemento(new No(30)); // nó com um filho
        arvore.removerElemento(new No(50)); // raiz (tem dois filhos)

        System.out.println("Árvore após remoções (in-order):");
        imprimirEmOrdem(arvore.getRaiz());
        System.out.println();
    }

    // Impressão in-order para visualizar a árvore
    public static void imprimirEmOrdem(No raiz) {
        if (raiz != null) {
            imprimirEmOrdem(raiz.getFilho_esquerda());
            System.out.print(raiz.getElemento_armazenado() + " ");
            imprimirEmOrdem(raiz.getFilho_direita());
        }
    }
}
