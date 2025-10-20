public class ArvoreBusca {
    private No raiz;

    public ArvoreBusca() {
        this.setRaiz(null);
    }

    public boolean arvoreVazia(){
        if (this.getRaiz() == null) {
            return true;
        } else{
            return false;
        }
    }
    public No buscar_elemento(No e){
        if (this.arvoreVazia()){
            return null;
        }
        else{
            No auxiliar = this.getRaiz();
            while(auxiliar != null){
                if (e.getElemento_armazenado() == auxiliar.getElemento_armazenado()){
                    return auxiliar;
                } else if (e.getElemento_armazenado() < auxiliar.getElemento_armazenado()) {
                    auxiliar = auxiliar.getFilho_esquerda();
                }else{
                    auxiliar = auxiliar.getFilho_direita();
                }
            }
        }
        return null;
    }
    public void adicionarElemento(int e){
        No novo = new No(e);
        if (!this.arvoreVazia()){
            No ax = this.getRaiz();
            while (ax != null){
                if (novo.getElemento_armazenado() < ax.getElemento_armazenado()){
                    if (ax.getFilho_esquerda() == null){
                        ax.setFilho_esquerda(novo);
                        ax = null;
                    }else{
                        ax = ax.getFilho_esquerda();
                    }
                }else{
                    if (ax.getFilho_direita() == null){
                        ax.setFilho_direita(novo);
                        ax = null;
                    }else{
                        ax = ax.getFilho_direita();
                    }
                }
            }
        }else{
            this.setRaiz(novo);
        }
    }
    public No buscaPai(No e){
        if (this.arvoreVazia()){
            return null;
        }else{
            No ax = this.getRaiz();
            while (ax != null){
                if (ax.getFilho_esquerda() != null && e.getElemento_armazenado() == ax.getFilho_esquerda().getElemento_armazenado()){
                    return ax;
                }if (ax.getFilho_direita() != null && e.getElemento_armazenado() == ax.getFilho_direita().getElemento_armazenado()) {
                    return ax;
                }if (e.getElemento_armazenado() < ax.getElemento_armazenado()){
                    ax = ax.getFilho_esquerda();
                }else{
                    ax = ax.getFilho_direita();
                }
            }
        }
        return null;
    }
    public No removerElemento(No e){
        No removido = null;
        if (!this.arvoreVazia()){
            removido = buscar_elemento(e);
            if (removido != null){
                No esquerda = removido.getFilho_esquerda();
                No direita = removido.getFilho_direita();
                No pai = this.buscaPai(e);
                if (esquerda == null && direita == null){
                    if (pai.getFilho_esquerda() == removido){
                        pai.setFilho_esquerda(null);
                    }else{
                        pai.setFilho_direita(null);
                    }
                } else if (pai != null && esquerda != null && direita != null) {
                    No folha = removido.getFilho_esquerda();
                    if (pai != null  && pai.getFilho_esquerda() == removido){
                        pai.setFilho_esquerda(esquerda);
                    }else{
                        pai.setFilho_direita(esquerda);
                    }while (folha.getFilho_direita() != null){
                        folha = folha.getFilho_direita();
                    }folha.setFilho_direita(removido.getFilho_direita());
                }else{
                    if (pai.getFilho_esquerda() == removido){
                        if (esquerda == null){
                            pai.setFilho_esquerda(direita);
                        }else{
                            pai.setFilho_esquerda(esquerda);
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
    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
}
