package view;

import controller.PacienteController;
import enumeration.TipoConvenio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Paciente;

/**
 *
 * @author V.Camargo
 */
public class PacienteView implements View {

    //static Scanner scan = new Scanner(System.in);
    static final String PACIENTE_NAO_ENCONTRADO = "Paciente não encontrado.";

    @Override
    public void exibeInterface() {
        //USAR ESTE METODO COMO SIMULADOR DE MENSAGEM
        System.out.println("PacienteView.exibeInterface()");
    }

    @Override
    public void fecharInterface() {
        TrabalhoPOO1.iniciaSistema();
    }

    private Paciente getPaciente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira o nome do paciente desejado: ");
        return PacienteController.getPacienteByNome(scan.nextLine());
    }

    public void inserirPaciente() {
        Paciente paciente = new Paciente();
        pegaDadosPaciente(paciente);
        if (PacienteController.adicionarPaciente(paciente) == 0) {
            System.out.println("Paciente não inserido com sucesso.");
        } else {
            System.out.println("Paciente inserido com sucesso.");
        }
        //exibeInterface();
    }

    public void gerarRelatorioPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
        } else {
            System.out.println("Nome: " + paciente.getNome());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            System.out.println("Data nascimento: " + formatter.format(paciente.getDataNascimento()));
            System.out.println("Endereço: " + paciente.getEndereco());
            System.out.println("Telefone: " + paciente.getTelefone());
            System.out.println("Celular: " + paciente.getCelular());
            System.out.println("Email: " + paciente.getEmail());
            System.out.println("Tipo convênio: " + paciente.getTipoConvenio().toString());
        }
        exibeInterface();
    }

    public void removerPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            exibeMensagemPacienteNaoEncontrado();
        } else {
            PacienteController.removePaciente(paciente);
            System.out.println("Paciente removido com sucesso.");
        }
        exibeInterface();

    }

    private void pegaDadosPaciente(Paciente paciente) {
        Scanner scan = new Scanner(System.in);
        boolean dadosCorretos = true;
        do {
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

    public void alterarPaciente() {
        Paciente paciente = getPaciente();
        if (paciente == null) {
            System.err.println(PACIENTE_NAO_ENCONTRADO);
        } else {
            pegaDadosPaciente(paciente);
            System.out.println("Paciente alterado com sucesso.");
        }
        exibeInterface();
    }

    public PacienteView() {
    }

    void gerarRelatorioMedicoPaciente() {
        //IMPLEMENTAR RELATÒRIO MÉDICO -> PACIENTE AQUI
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void removerDadosAdicionaisPaciente() {
        
    }

    void alterarDadosAdicionaisPaciente() {
    }

    void inserirDadosAdicionaisPaciente() {
        Scanner scan = new Scanner(System.in);
        Paciente paciente = getPaciente();
        if (paciente == null){
            exibeMensagemPacienteNaoEncontrado();
            return;
        }
        boolean dadosCorretos = true;
        do {
            try {
                System.out.println("Responda [S]Sim [N]Não");
                System.out.print("Paciente fuma?: ");
                paciente.setFuma( geraBooleano( scan.nextLine() ) );
                System.out.print("Paciente bebe?: ");
                paciente.setBebe( geraBooleano( scan.nextLine() ) );
                System.out.print("Paciente tem colesterol?: ");
                paciente.setColesterol( geraBooleano( scan.nextLine() ) );
                System.out.print("Paciente tem diabete?: ");
                paciente.setDiabete( geraBooleano( scan.nextLine() ) );
                                
                System.out.print("Insira convênio: (1) PARTICULAR,"
                        + " (2) PLANO DE SAÚDE  ");
                paciente.setTipoConvenio(TipoConvenio.values()[scan.nextInt() - 1]);
            } catch (Exception ex) {
                System.out.println("Houve um erro nos dados inseridos. "
                        + "Favor reiniciar o preenchimento dos dados do paciente.");
                ex.printStackTrace();
                dadosCorretos = false;
            }
        } while (!dadosCorretos);
    }
    
    private boolean geraBooleano( String resposta ){
        return resposta.equalsIgnoreCase( "Sim" ) || resposta.equalsIgnoreCase( "S" );
    }
    
    private void exibeMensagemPacienteNaoEncontrado(){
        System.err.println(PACIENTE_NAO_ENCONTRADO);
    }

}
