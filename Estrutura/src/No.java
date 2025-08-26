public class No {
    private int elemento_armazenado;
    private No filho_esquerda;
    private No filho_direita;

    private No proximo;

    public No(int e){
        this.setElemento_armazenado(e);
        this.setFilho_esquerda(null);
        this.setFilho_direita(null);
    }

    public int getElemento_armazenado() {
        return elemento_armazenado;
    }

    public No getFilho_direita() {
        return filho_direita;
    }

    public No getFilho_esquerda() {
        return filho_esquerda;
    }

    public void setElemento_armazenado(int elemento_armazenado) {
        this.elemento_armazenado = elemento_armazenado;
    }

    public void setFilho_direita(No filho_direita) {
        this.filho_direita = filho_direita;
    }

    public void setFilho_esquerda(No filho_esquerda) {
        this.filho_esquerda = filho_esquerda;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
