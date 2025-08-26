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
    public No getRaiz_arvore() {
        return raiz_arvore;
    }

    public void setRaiz_arvore(No raiz_arvore) {
        this.raiz_arvore = raiz_arvore;
    }
}
