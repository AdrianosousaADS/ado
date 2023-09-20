public class Lista<T> extends EstruturaEstatica<T>{
    public Lista(int linhas) {
        super(linhas);
    }

    public Lista() {
        super();
    }

    public boolean adiciona(T elementos) {
        return super.adiciona(elementos);
    }

    public boolean adiciona(int posicao, int colunas, T elementos) {
        return super.adiciona(posicao, colunas, elementos);
    }
}