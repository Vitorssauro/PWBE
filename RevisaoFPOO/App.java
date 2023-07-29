package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.OutrosAnimais;

public class App {
    public static void main(String[] args) {

        // cria o cadastro(armazenr no vetor)
        Gato gatos[] = new Gato[10];
        Cachorro cachorros[] = new Cachorro[10];
        OutrosAnimais outros[] = new OutrosAnimais[10];
        int contGatos = 0, contCachorros = 0, contOutros = 0;

        // criar a minha aplicação
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consulório\ndo Dr. Maluco");
        boolean aberto = true;
        while (aberto) {
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n2-Consulta\n3-Sair"));
            if (acao1 == 1) {// cadastro
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n2-Cachorro\n3-Outro"));
                if (acao2 == 1) {// cadastro do gato
                    // criar um objeto
                    gatos[contGatos] = new Gato();// utilizei o construtor
                    // setar os valores do cadastro
                    gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o nome do gato"));
                    gatos[contGatos].setRaca(JOptionPane.showInputDialog("Informe a raca do gato"));
                    gatos[contGatos]
                            .setProprietario(JOptionPane.showInputDialog("Informe o nome do Proprietario do gato"));
                    gatos[contGatos].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do gato")));
                    contGatos++;
                } else if (acao2 == 2) {// cadastro do Cachorro
                    // criar um objeto
                    cachorros[contCachorros] = new Cachorro();// utilizei o construtor
                    // setar os valores do cadastro
                    cachorros[contCachorros].setNome(JOptionPane.showInputDialog("Informe o nome do Cachorro"));
                    cachorros[contCachorros].setRaca(JOptionPane.showInputDialog("Informe a raca do Cachorro"));
                    cachorros[contCachorros]
                            .setProprietario(JOptionPane.showInputDialog("Informe o nome do Proprietario do Cachorro"));
                    cachorros[contCachorros]
                            .setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do Cachorro")));
                    contCachorros++;

                } else if (acao2 == 3) {// cadastro do OutrosAnimai
                    // criar um objeto
                    outros[contOutros] = new OutrosAnimais();// utilizei o construtor
                    // setar os valores do cadastro
                    outros[contOutros].setNome(JOptionPane.showInputDialog("Informe o nome do OutrosAnimai"));
                    outros[contOutros].setRaca(JOptionPane.showInputDialog("Informe a raca do OutrosAnimai"));
                    outros[contOutros]
                            .setProprietario(
                                    JOptionPane.showInputDialog("Informe o nome do Proprietario do OutrosAnimai"));
                    outros[contOutros]
                            .setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do OutrosAnimai")));
                    contOutros++;
                } else {
                    JOptionPane.showMessageDialog(null,"SELECIONA UMA OPÇÃO VÁLIDA");
                    break;
                }
                
            }

            else if (acao1 == 2) {// agendar consulta

            }
        }
    }
}