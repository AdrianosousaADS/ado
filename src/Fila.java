public class Fila<T> extends EstruturaEstatica<T>{

    public Fila() {
        super();
    }

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileira(int posicao, T elemento, boolean prioridade) {

        if (prioridade == true) {
            this.adiciona(posicao, 0,elemento); // Adiciona no início da fila de prioridade
        } else {
            this.adiciona(posicao, 1,elemento); // Adiciona no final da fila normal
        }
    }
    public T espiar() {
        if (!this.estaVazia()) {
            if (this.elementos[0][0] != null) {
                return this.elementos[0][0]; // Retorna o próximo paciente prioritário
            } else if(this.elementos[0][1] != null) {
                return this.elementos[0][1]; // Retorna o próximo paciente normal
            }
        }
        return null; // Retorna null se a fila estiver vazia
    }

    public T desenfileira(boolean prioridade) {
        if (this.estaVazia()) {
            return null;
        }

        // Verifica se há elemento prioritário no início da fila
        if (this.elementos[0][0] != null) {
            return this.remove(0, 0); // Remove o elemento prioritário
        } else {
            return this.remove(0, 1); // Remove o elemento normal
        }
    }
}
