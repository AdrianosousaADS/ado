import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Fila<String> pessoa = new Fila<>();

        int resp = 0;

        int posPP = 0, posPN = 0;
        Pessoa pessoa1 = new Pessoa();

        JOptionPane.showMessageDialog(null, "Seja Bem vindo(a) ao nosso centro de atendimento! ");


        do {
            String[] valores = {"Retirar Senha", "Chamar paciente", "Total de pessoas na fila", "Olhar o inicio da fila", "Sair"};
            Object opcao = JOptionPane.showInputDialog(null, "Escolhe uma opção", "Laboratório", JOptionPane.WARNING_MESSAGE, null, valores, valores[0]);

            if (opcao.equals("Retirar Senha")) {
                String nome = JOptionPane.showInputDialog(null, "Digite o nome do paciente: ");
                String[] situacao = {"Paciente Normal", "Paciente Prioritário"};
                opcao = JOptionPane.showOptionDialog(null, "Situação do paciente", "Senha", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, situacao, situacao[1]);

                if(pessoa.estaVazia()) {
                    posPP = 0;
                    posPN = 0;
                } if(opcao.equals(1)) {
                    pessoa.enfileira(posPP, nome, true);
                    posPP++;
                } else if(opcao.equals(0)) {
                    pessoa.enfileira(posPN, nome, false);
                    posPN++;
                }


                JOptionPane.showMessageDialog(null, "Paciente adicionado!");

            } else if (opcao.equals("Chamar paciente")) {
                if(!(pessoa.estaVazia())) {
                    String proxPaciente = pessoa.espiar();
                    JOptionPane.showMessageDialog(null, "Próximo paciente: " + proxPaciente);

                    if(pessoa1.isPrioridade() == true) {
                        pessoa.desenfileira(true);
                    } else if (pessoa1.isPrioridade() == false) {
                        pessoa.desenfileira(false);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Não há ninguém na fila");
                }

            } else if (opcao.equals("Total de pessoas na fila")) {
                if (!pessoa.estaVazia()) {
                    String mensagem = "Tamanho da fila: " + pessoa.tamanho() + " pessoas";
                    
                    JOptionPane.showMessageDialog(null, mensagem);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há ninguém na fila");
                }
            } else if (opcao.equals("Olhar o inicio da fila")) {
                if(!(pessoa.estaVazia())) {
                    String paciente1 = pessoa.espiar();
                    JOptionPane.showMessageDialog(null, "Primeiro paciente: " + paciente1);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há ninguém na fila");
                }
            } else if (opcao.equals("Sair")) {
                resp = 1;
            }
        } while(resp == 0);

    }
}
