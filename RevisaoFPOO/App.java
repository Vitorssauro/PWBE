
import javax.swing.JOptionPane;

import Agenda.Agenda;
import Cadastro.Cachorro;
import Cadastro.Gato;
import Cadastro.OutrosAnimais;

public class App {
    public static void main(String[] args) {

        // cria o cadastro(armazenr no vetor)
        Agenda agenda[] = new Agenda[100];
        Gato gatos[] = new Gato[10];
        Cachorro cachorros[] = new Cachorro[10];
        OutrosAnimais outros[] = new OutrosAnimais[10];
        int contGatos = 0, contCachorros = 0, contOutros = 0, contAgenda = 0;

        // criar a minha aplicação
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consulório\ndo Dr. Maluco");
        boolean aberto = true;
        while (aberto) {
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n2-Agendar\n3-Sair"));
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
                    outros[contOutros].setNome(JOptionPane.showInputDialog("Informe o nome do Animal"));
                    outros[contOutros].setRaca(JOptionPane.showInputDialog("Informe a raca do Animal"));
                    outros[contOutros]
                            .setProprietario(
                                    JOptionPane.showInputDialog("Informe o nome do Proprietario do Animal"));
                    outros[contOutros]
                            .setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do Animal")));
                    contOutros++;
                } else {
                    JOptionPane.showMessageDialog(null, "SELECIONA UMA OPÇÃO VÁLIDA");
                    break;
                }

            } else if (acao1 == 2) {// agendar consulta
                // 1º verificação - cadastro do nome
                boolean cadastroOK = false;

                String nomeAgenda = JOptionPane.showInputDialog("Informe o Nome do PET");
                for (int i = 0; i < contGatos; i++) {// busca no vetor de gatos
                    if (gatos[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Pet Encontrado");
                        cadastroOK = true;
                        break;
                    }
                }
                for (int i = 0; i < contCachorros; i++) {// busca no vetor de gatos
                    if (cachorros[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Pet Encontrado");
                        cadastroOK = true;
                        break;
                    }
                }
                for (int i = 0; i < contOutros; i++) {// busca no vetor de gatos
                    if (outros[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Pet Encontrado");
                        cadastroOK = true;
                        break;
                    }
                }
                // 2º Terminar o Cadastro
                if (cadastroOK) {
                    boolean agendar = true;
                    while (agendar) {
                        String dataAgenda = JOptionPane.showInputDialog("Informe a Data do Agendamento");
                        String horaAgenda = JOptionPane.showInputDialog("Informe a Hora do Agendamento");
                        if (contAgenda == 0) {
                            agenda[contAgenda] = new Agenda();
                            agenda[contAgenda].setData(dataAgenda);
                            agenda[contAgenda].setHora(horaAgenda);
                            agendar = false;
                        } else {
                            for (int i = 0; i < contAgenda; i++) {
                                if (agenda[i].getDataHora().equals(dataAgenda + horaAgenda)) {
                                    // não pode agendar
                                    break;
                                } else {
                                    agenda[contAgenda] = new Agenda();
                                    agenda[contAgenda].setData(dataAgenda);
                                    agenda[contAgenda].setHora(horaAgenda);
                                    agendar = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
