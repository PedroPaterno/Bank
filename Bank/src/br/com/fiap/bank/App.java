package br.com.fiap.bank;

public class App {
    public static void main(String[] args) {
        try {
            Banco conta1 = new Banco("Titular 1");
            conta1.deposito(1000.0);
            conta1.saque(500.0);

            Banco conta2 = new Banco("Titular 2");
            conta2.deposito(2000.0);
            conta2.transferencia(conta1, 1500.0);

            ContaPoupanca contaPoupanca = new ContaPoupanca("Titular 3");
            contaPoupanca.deposito(3000.0);
            contaPoupanca.saque(1000.0);
        } catch (DepositoException e) {
            System.out.println("Erro ao realizar deposito: " + e.getMessage());
        } catch (SaqueException e) {
            System.out.println("Erro ao realizar saque: " + e.getMessage());
        } catch (TransferenciaException e) {
            System.out.println("Erro ao realizar transferencia: " + e.getMessage());
        }
    }
}
