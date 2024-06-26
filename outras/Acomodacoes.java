package outras;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Acomodacoes {
    private List<Comodidades> comodidades;
    private int quantidade;
    private List<PeriodoIndisponivel> periodosIndisponiveis;

    public Acomodacoes() {
        this.comodidades = new ArrayList<>();
        this.quantidade = 0;
        this.periodosIndisponiveis = new ArrayList<>();
    }

    public List<Comodidades> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<Comodidades> comodidades) {
        this.comodidades = comodidades;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<PeriodoIndisponivel> getPeriodosIndisponiveis() {
        return periodosIndisponiveis;
    }

    public void setPeriodosIndisponiveis(List<PeriodoIndisponivel> periodosIndisponiveis) {
        this.periodosIndisponiveis = periodosIndisponiveis;
    }

    public void addComodidade(Comodidades comodidade) {
        this.comodidades.add(comodidade);
    }

    public boolean verificarDisponibilidade(String checkin, String checkout, boolean controle) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date checkinDate = dateFormat.parse(checkin);
            Date checkoutDate = dateFormat.parse(checkout);

            // Verifica se há sobreposição com os períodos indisponíveis
            for (PeriodoIndisponivel periodo : periodosIndisponiveis) {
                if (periodo.isSobreposto(checkinDate, checkoutDate)) {
                    JOptionPane.showMessageDialog(null, "Desculpe, as datas selecionadas não estão disponíveis.", "Indisponível", JOptionPane.INFORMATION_MESSAGE);
                    return false; // Reserva não é válida
                }
            }

            if (controle) {
                // Se controle for verdadeiro, solicita confirmação do usuário
                int response = JOptionPane.showConfirmDialog(null, "As datas de " + checkin + " a " + checkout + " estão disponíveis.\nDeseja confirmar a reserva?", "Confirmar Reserva", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    // Se o usuário confirmar, adiciona o período à lista de períodos indisponíveis
                    periodosIndisponiveis.add(new PeriodoIndisponivel(checkinDate, checkoutDate));
                    JOptionPane.showMessageDialog(null, "Reserva confirmada para as datas de " + checkin + " a " + checkout + ".", "Reserva Confirmada", JOptionPane.INFORMATION_MESSAGE);
                    return true; // Reserva é válida
                } else {
                    JOptionPane.showMessageDialog(null, "Reserva não confirmada.", "Reserva Cancelada", JOptionPane.INFORMATION_MESSAGE);
                    return false; // Reserva não é válida
                }
            } else {
                // Se controle for falso, adiciona o período à lista de períodos indisponíveis sem perguntar ao usuário
                periodosIndisponiveis.add(new PeriodoIndisponivel(checkinDate, checkoutDate));
                //JOptionPane.showMessageDialog(null, "Reserva automaticamente confirmada para as datas de " + checkin + " a " + checkout + ".", "Reserva Confirmada", JOptionPane.INFORMATION_MESSAGE);
                return true; // Reserva é válida
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Lida com exceção de formatação de data
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato dd/MM/yyyy.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            return false; // Reserva não é válida devido a erro de formatação
        }
    }

    @Override
    public String toString() {
        return "Acomodacoes{" +
                "comodidades=" + comodidades +
                ", quantidade=" + quantidade +
                ", periodosIndisponiveis=" + periodosIndisponiveis +
                '}';
    }

    // Classe interna para representar um período indisponível
    private static class PeriodoIndisponivel {
        private Date dataInicio;
        private Date dataFim;

        public PeriodoIndisponivel(Date dataInicio, Date dataFim) {
            this.dataInicio = dataInicio;
            this.dataFim = dataFim;
        }

        // Método para verificar se há sobreposição com um novo intervalo de datas
        public boolean isSobreposto(Date checkin, Date checkout) {
            return !(dataFim.before(checkin) || dataInicio.after(checkout));
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return "[" + dateFormat.format(dataInicio) + " - " + dateFormat.format(dataFim) + "]";
        }
    }

    public static void main(String[] args) {
        Acomodacoes acomodacao = new Acomodacoes();

        // Teste com controle = false (reserva automática)
        /*acomodacao.verificarDisponibilidade("01/07/2024", "18/07/2024", false);
        acomodacao.verificarDisponibilidade("22/07/2024", "31/07/2025", false);

        System.out.println("Períodos indisponíveis: " + acomodacao.getPeriodosIndisponiveis());

        System.out.println("\nTentativa de reserva:");
        System.out.println("Reserva válida de 05/07/2024 a 12/07/2024: " + acomodacao.verificarDisponibilidade("05/07/2024", "12/07/2024", true));
        System.out.println("Reserva inválida de 22/07/2024 a 25/07/2024: " + acomodacao.verificarDisponibilidade("22/07/2024", "25/07/2024", true));
        System.out.println("Reserva válida de 19/07/2024 a 21/07/2024: " + acomodacao.verificarDisponibilidade("19/07/2024", "21/07/2024", true));*/
    }
}
