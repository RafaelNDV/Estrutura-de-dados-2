public class Arvore {
    private No raiz_arvore;

    public Arvore(){
        this.setRaiz_arvore(null);
    }
    public boolean arvore_vazia(){
        if(getRaiz_arvore() == null){
            return true;
        }else{
            return false;
        }
    }
    public No buscar_elemento(int e){
        if (this.arvore_vazia()){
            return null;
        }else{
            Pilha p = new Pilha();
            p.push(this.getRaiz_arvore());
            while(!p.isEmpty()){
                No auxiliar = p.pop();
                if(auxiliar.getElemento_armazenado() == e){
                    return auxiliar;
                }
                if (auxiliar.getFilho_direita() !=  null){
                    p.push(auxiliar.getFilho_direita());
                }
                if (auxiliar.getFilho_esquerda() != null){
                    p.push(auxiliar.getFilho_esquerda());
                }
            }
        }
        return null;
    }
    public void adicionar_esquerda(No e, No p){
        No novo = new No(e.getElemento_armazenado());
        if (!this.arvore_vazia()){
            No pai = this.buscar_elemento(p.getElemento_armazenado());
            if (pai != null){
                if (pai.getFilho_esquerda() == null){
                    pai.setFilho_esquerda(novo);
                }else{
                    System.out.println("Nó já possui filho a esuqerda");
                }
            }else{
                System.out.println("Elemento não está na árvore");
            }
        }else{
            this.setRaiz_arvore(novo);
        }
    }
    public void adicionar_direita(No e, No p){
        No novo = new No(e.getElemento_armazenado());
        if (!this.arvore_vazia()){
            No pai = this.buscar_elemento(p.getElemento_armazenado());
            if (pai != null){
                if (pai.getFilho_direita() == null){
                    pai.setFilho_direita(novo);
                }else{
                    System.out.println("Nó já possui filho a esuqerda");
                }
            }else{
                System.out.println("Elemento não está na árvore");
            }
        }else{
            this.setRaiz_arvore(novo);
        }
    }
    public No buscar_pai(No e){
        if (this.arvore_vazia()){
            return null;
        }else{
            Pilha p = new Pilha();
            p.push(this.getRaiz_arvore());
            while(!p.isEmpty()){
                No auxiliar = p.pop();
                if (auxiliar.getFilho_direita() == e || auxiliar.getFilho_esquerda() == e){
                    return auxiliar;
                }
                if (auxiliar.getFilho_direita() != null){
                    p.push(auxiliar.getFilho_direita());
                }if (auxiliar.getFilho_esquerda() != null){
                    p.push(auxiliar.getFilho_esquerda());
                }
            }
        }
        return null;
    }
    public No remover_elemento(int e){
        No removido = null;
        if (!this.arvore_vazia()){
            removido = this.buscar_elemento(e);
            if (removido != null){
                No esquerda = removido.getFilho_esquerda();
                No direita = removido.getFilho_direita();
                No pai = buscar_pai(removido);
                if (esquerda == null && direita == null){
                    if (pai.getFilho_esquerda() == removido){
                        pai.setFilho_esquerda(null);
                    }else{
                        pai.setFilho_direita(null);
                    }
                } else if (esquerda != null && direita != null) {
                    if (pai.getFilho_esquerda() == removido){
                        pai.setFilho_esquerda(esquerda);
                        while(esquerda.getFilho_esquerda() != null){
                            esquerda = esquerda.getFilho_esquerda();
                        }
                        esquerda.setFilho_esquerda(direita);
                    }else{
                        pai.setFilho_direita(direita);
                        while(direita.getFilho_direita() != null){
                            direita = direita.getFilho_direita();
                        }
                        direita.setFilho_direita(esquerda);
                    }
                }else{
                    if (pai.getFilho_esquerda() == removido){
                        if(esquerda == null){
                            pai.setFilho_esquerda(direita);
                        }else{
                            pai.setFilho_esquerda(direita);
                        }
                    }else{
                        if (direita == null){
                            pai.setFilho_direita(esquerda);
                        }else{
                            pai.setFilho_direita(direita);
                        }
                    }
                }
            }
        }else{
            System.out.println("Estrutura vazia!");
        }
        return removido;
    }
    public Lista varredura_largura(){
        Lista lista = new Lista();
        if (this.arvore_vazia()){
            return null;
        }else{
            Fila fila = new Fila();
            fila.enfileirar(this.getRaiz_arvore());
            while(!fila.filaVazia()){
                No auxiliar = fila.desenfileirar();
                lista.adicionarFinal(auxiliar.getElemento_armazenado());
                if (auxiliar.getFilho_esquerda() != null){
                    fila.enfileirar(auxiliar.getFilho_esquerda());
                }
                if (auxiliar.getFilho_direita() != null){
                    fila.enfileirar(auxiliar.getFilho_direita());
                }
            }
        }
        return lista;
    }
    public Lista varredura_profundidade_vlr(){
        Lista lista = new Lista();
        if (this.arvore_vazia()){
            return null;
        }else{
            Pilha pilha = new Pilha();
            pilha.push(this.getRaiz_arvore());
            while(!pilha.isEmpty()){
                No auxiliar = pilha.pop();
                lista.adicionarFinal(auxiliar.getElemento_armazenado());
                if (auxiliar.getFilho_direita() != null){
                    pilha.push(auxiliar.getFilho_direita());
                }if (auxiliar.getFilho_esquerda() != null){
                    pilha.push(auxiliar.getFilho_esquerda());
                }
            }
        }
        return lista;
    }
    public Lista varredura_profundidade_lvr(){
        Lista lista = new Lista();
        if (this.arvore_vazia()){
            return null;
        }else{
            Pilha p = new Pilha();
            No ax = this.getRaiz_arvore();
            p.push(ax);
            while(!p.isEmpty()){
                if (ax.getFilho_esquerda() != null && !lista.buscarElemento(ax.getElemento_armazenado())){
                    p.push(ax.getFilho_esquerda());
                    ax = ax.getFilho_esquerda();
                }else {
                    ax = p.pop();
                    lista.adicionarFinal(ax.getElemento_armazenado());
                }if (ax.getFilho_direita() != null){
                    p.push(ax.getFilho_direita());
                    ax = ax.getFilho_direita();
                }
            }
        }
        return lista;
    }
    public Lista varredura_profundidade_lrv(){
        Lista lista = new Lista();
        if (this.arvore_vazia()){
            return null;
        }else{
            Pilha pilha = new Pilha();
            No aux = this.getRaiz_arvore();
            pilha.push(aux);
            while(!pilha.isEmpty()){
                aux = pilha.pop();
                if (aux.getFilho_esquerda() != null){
                    pilha.push(aux.getFilho_esquerda());
                }if (aux != null && !lista.buscarElemento(aux.getElemento_armazenado())){
                    lista.adicionarInicio(aux.getElemento_armazenado());
                    if (aux.getFilho_direita() != null){
                        pilha.push(aux.getFilho_direita());
                        aux = aux.getFilho_direita();
                    }
                }
            }
        }
        return lista;
    }
    public No getRaiz_arvore() {
        return raiz_arvore;
    }

    public void setRaiz_arvore(No raiz_arvore) {
        this.raiz_arvore = raiz_arvore;
    }
}
