public class EstruturaEstatica<T> {
    public T[][] elementos;
    public int tamanho;

    public EstruturaEstatica(int capacidade) {
        this.elementos = (T[][]) new Object[capacidade][2];
        this.tamanho = 0;
    }

    public EstruturaEstatica() {
        this(10);
    }

     public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            for (int i = 0; i < 2; i++) {
                this.elementos[this.tamanho][i] = elemento;
            }
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, int colunas, T elemento) {
        if (!(posicao >= 0 && posicao <= tamanho)) {
            throw new IllegalArgumentException("Posição Inválida");
        }

        this.aumentaCapacidade();

            for (int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i + 1][colunas] = this.elementos[i][colunas];
            }

        this.elementos[posicao][colunas] = elemento;

        this.tamanho++;
        return true;
    }

    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            T[][] elementosNovos = (T[][]) new Object[this.elementos.length * 2][2];

            for (int i = 0; i < this.tamanho; i++) {
                for (int j = 0; j < 2; j++) {
                    elementosNovos[i][j] = this.elementos[i][j];
                }
            }
            this.elementos = elementosNovos;
        }
    }
    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < this.tamanho-1; j++) {
                s.append(this.elementos[j][i]);
                s.append(", ");
            }
        }

        if(this.tamanho > 0) {
            for(int i = 0; i < 2; i++) {
                s.append(this.elementos[this.tamanho-1][i]);
            }
        }

        s.append("]");

        return s.toString();
    }
    public boolean estaVazia() {
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < 2; j++) {
                if (this.elementos[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public T remove(int posicao, int colunas) {
        if(!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição Inválida");
        }

        T elementoRemovido = this.elementos[posicao][0];

        for (int i = posicao; i < tamanho; i++) {
            elementos[i][colunas] = elementos[i + 1][colunas];
        }

        this.tamanho--;

        return elementoRemovido;
    }
}