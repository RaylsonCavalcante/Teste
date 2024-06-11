import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 – Inserir todos os funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(1990, 5, 15), BigDecimal.valueOf(3000), "Analista"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1985, 8, 20), BigDecimal.valueOf(3500), "Gerente"));
        funcionarios.add(new Funcionario("Pedro", LocalDate.of(1988, 11, 10), BigDecimal.valueOf(2800), "Técnico"));
        funcionarios.add(new Funcionario("Ana", LocalDate.of(1995, 3, 25), BigDecimal.valueOf(3200), "Analista"));

        // 3.2 – Remover o funcionário “João” da lista
        Funcionario joao = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals("João")) {
                joao = funcionario;
                break;
            }
        }
        if (joao != null) {
            funcionarios.remove(joao);
        }

        // 3.3 – Imprimir todos os funcionários
        System.out.println("Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        // 3.4 – Aumentar salário dos funcionários em 10%
        for (Funcionario funcionario : funcionarios) {
            funcionario.aumentarSalario(BigDecimal.TEN);
        }

        // 3.5 – Agrupar os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }
            funcionariosPorFuncao.get(funcao).add(funcionario);
        }

        // 3.6 – Imprimir os funcionários, agrupados por função
        System.out.println("\nFuncionários por função:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\nFuncionários que fazem aniversário no mês 10 e 12:");
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                System.out.println(funcionario);
            }
        }

        // 3.9 – Imprimir o funcionário com a maior idade
        System.out.println("\nFuncionário com maior idade:");
        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionario;
            }
        }
        System.out.println("Nome: " + maisVelho.getNome() +
                ", Idade: " + (LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear()));

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome());
        }

        // 3.11 – Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        System.out.println("\nTotal dos salários: " + totalSalarios);

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário
        System.out.println("\nSalários mínimos ganhos por cada funcionário:");
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioMinimoGanho = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(funcionario.getNome() + ": " + salarioMinimoGanho + " salários mínimos");
        }
    }
}
