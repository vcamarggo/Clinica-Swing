package view;

import controller.PacienteController;
import enumeration.TipoConvenio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import model.Paciente;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public class PacienteView extends JFrame {

    static final String PACIENTE_NAO_ENCONTRADO = "Paciente não encontrado.";

    public void exibeInterface() {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        System.out.println("Operação realizada às: " + formatter.format(Calendar.getInstance().getTime()));
    }

    /**
     * metodo responsavel por fachar a interface
     */
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    /**
     * Retorna o paciente segundo o nome digitado.
     */
    private Paciente getPaciente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira o nome do paciente desejado: ");
        return Paciente.getPacienteByNome(scan.nextLine());
    }

    /**
     * Insere um paciente segundo os dados inseridos.
     */
    public void inserirPaciente() {
        Paciente paciente = new Paciente();
        pegaDadosPaciente(paciente);
        if (Paciente.adicionarPaciente(paciente) == 0) {
            System.out.println("Paciente não inserido com sucesso.");
        } else {
            System.out.println("Paciente inserido com sucesso.");
        }
        exibeInterface();
    }

    /**
     * Gera relatorio do paciente segundo o nome digitado.
     */
    public void gerarRelatorioPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
        } else {
            System.out.println(" --------------------------------");
            System.out.println("Nome: " + paciente.getNome());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data nascimento: " + formatter.format(paciente.getDataNascimento()));
            System.out.println("Endereço: " + paciente.getEndereco());
            System.out.println("Telefone: " + paciente.getTelefone());
            System.out.println("Celular: " + paciente.getCelular());
            System.out.println("Email: " + paciente.getEmail());
            System.out.println("Tipo convênio: " + paciente.getTipoConvenio().toString());
            System.out.println(" --------------------------------");
        }
        exibeInterface();
    }

    /**
     * Remove um paciente por nome.
     */
    public void removerPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
        } else {
            Paciente.removePaciente(paciente);
            System.out.println("Paciente removido com sucesso.");
        }
        exibeInterface();

    }

    /**
     * Recebe os dados digitados via teclado.
     */
    private void pegaDadosPaciente(Paciente paciente) {
        Scanner scan = new Scanner(System.in);
        boolean dadosCorretos;
        do {
            dadosCorretos = true;
            try {
                System.out.print("Insira nome: ");
                paciente.setNome(scan.nextLine());
                System.out.print("Insira data de nascimento: ");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                paciente.setDataNascimento((Date) formatter.parse(scan.nextLine()));
                System.out.print("Insira endereço: ");
                paciente.setEndereco(scan.nextLine());
                System.out.print("Insira telefone residencial: ");
                paciente.setTelefone(scan.nextLine());
                System.out.print("Insira celular (Enter caso não tenha): ");
                paciente.setCelular(scan.nextLine());
                System.out.print("Insira email (Enter caso não tenha): ");
                paciente.setEmail(scan.nextLine());
                System.out.print("Insira convênio: (1) PARTICULAR,"
                        + " (2) PLANO DE SAÚDE  ");
                paciente.setTipoConvenio(TipoConvenio.values()[scan.nextInt() - 1]);
            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do paciente.");
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }

    /**
     * Altera o paciente selecionado pelo nome.
     */
    public void alterarPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
        } else {
            pegaDadosPaciente(paciente);
            System.out.println("Paciente alterado com sucesso.");
        }
        exibeInterface();
    }

    /**
     * Construtor padrao.
     */
    public PacienteView() {
    }

    /**
     * Interface referente a remoção de dados adicionais do paciente
     */
    void removerDadosAdicionaisPaciente() {
        Scanner scan = new Scanner(System.in);
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
            return;
        }
        System.out.println("Confirma a remoção dos dados adicionais do paciente?");
        if (geraBooleano(scan.nextLine())) {
            Paciente.removeDadosAdicionaisPaciente(paciente);
        }
        exibeInterface();
    }

    /**
     * Dados referentes a Inclusão e alteração do paciente
     *
     * @param alteracao -> se verdadeiro é uma alteração se falso é inclusao
     */
    void dadosAdicionaisPaciente(boolean alteracao) {
        Scanner scan = new Scanner(System.in);
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
            return;
        }
        if (alteracao) {
            Paciente.removeDadosAdicionaisPaciente(paciente);
        }
        boolean dadosCorretos;
        do {
            dadosCorretos = true;
            try {
                System.out.println("Responda [S]Sim [N]Não");
                System.out.print("Paciente fuma? ");
                paciente.setFuma(geraBooleano(scan.nextLine()));
                System.out.print("Paciente bebe? ");
                paciente.setBebe(geraBooleano(scan.nextLine()));
                System.out.print("Paciente tem colesterol? ");
                paciente.setColesterol(geraBooleano(scan.nextLine()));
                System.out.print("Paciente tem diabete? ");
                paciente.setDiabete(geraBooleano(scan.nextLine()));

                digitarCirurgiasPaciente(paciente);
                digitarAlergiasPaciente(paciente);

            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do paciente.");
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }

    /**
     * Conversor basico de string para booleano.
     */
    private boolean geraBooleano(String resposta) {
        return resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S");
    }

    /**
     * Exibe mensagem de erro de paciente nao encontrado.
     */
    private void exibeMensagemPacienteNaoEncontrado() {
        System.err.println(PACIENTE_NAO_ENCONTRADO);
    }

    /**
     * Metodo responsavel pela digitação da lista de cirurgias do paciente
     */
    private void digitarCirurgiasPaciente(Paciente paciente) {
        Scanner scan = new Scanner(System.in);
        String cirurgia;
        System.out.println("Entre com as Cirurgias do paciente. Digite 0 para sair");
        while (!(cirurgia = scan.nextLine()).equals("0")) {
            paciente.getCirurgias().add(cirurgia);
        }
    }

    /**
     * metodo responsavel pela digitação das alergias do paciente
     */
    private void digitarAlergiasPaciente(Paciente paciente) {
        Scanner scan = new Scanner(System.in);
        String alergia;
        System.out.println("Entre com as Alergias do paciente. Digite 0 para sair");
        while (!(alergia = scan.nextLine()).equals("0")) {
            paciente.getAlergias().add(alergia);
        }
    }

    /**
     * metodo responsavel pela digitação dos sintomas do paciente
     *
     * @param paciente
     */
    private void digitarSintomasPaciente(Paciente paciente) {
        Scanner scan = new Scanner(System.in);
        String sintoma;
        System.out.println("Entre com os sintomas do paciente. Digite 0 para sair");
        while (!(sintoma = scan.nextLine()).equals("0")) {
            paciente.getAlergias().add(sintoma);
        }
    }

    /**
     * metodo responsavel pela inclusao e alteração do prontuario do paciente
     *
     * @param alteracao -> se verdadeiro = alteração | se falso = inclusao
     */
    public void prontuarioPaciente(boolean alteracao) {
        Scanner scan = new Scanner(System.in);
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
            return;
        }
        if (alteracao) {
            Paciente.removeDadosAdicionaisPaciente(paciente);
        }
        boolean dadosCorretos;
        do {
            dadosCorretos = true;
            try {
                digitarSintomasPaciente(paciente);
                System.out.print("Insira o diagnostico:");
                paciente.setDiagnostico(scan.nextLine());
                System.out.print("Insira o tratamento: ");
                paciente.setTratamento(scan.nextLine());

            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do paciente.");
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }

    /**
     * metodo responsavel pela remoção dos dados de prontuario do paciente
     */
    public void removerDadosProntuarioPaciente() {
        Scanner scan = new Scanner(System.in);
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
            return;
        }
        System.out.println("Confirma a remoção do prontuário do paciente?");
        if (geraBooleano(scan.nextLine())) {
            Paciente.removeDadosProntuarioPaciente(paciente);
        }
        exibeInterface();
    }

}
