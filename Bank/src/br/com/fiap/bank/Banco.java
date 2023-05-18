package br.com.fiap.bank;

class Banco {
    private double saldo;
    private String titular;

    public Banco(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void deposito(double valor) throws DepositoException {
        if (valor < 0) {
            throw new DepositoException("Nao e permitido realizar depositos com valores negativos.");
        }

        this.saldo += valor;
        System.out.println("Deposito de " + valor + " realizado com sucesso. Saldo atual: " + this.saldo);
    }

    public void saque(double valor) throws SaqueException {
        if (valor < 0) {
            throw new SaqueException("Nao e permitido realizar saques com valores negativos.");
        }

        if (this instanceof ContaPoupanca) {
            throw new SaqueException("Nao e possivel realizar saques em conta poupanca.");
        }

        if (valor > this.saldo) {
            throw new SaqueException("Saldo insuficiente. Não e possível realizar o saque.");
        }

        this.saldo -= valor;
        System.out.println("Saque de " + valor + " realizado com sucesso. Saldo atual: " + this.saldo);
    }

    public void transferencia(Banco contaDestino, double valor) throws TransferenciaException {
        if (!this.titular.equals(contaDestino.titular)) {
            throw new TransferenciaException("Nao e permitido realizar transferencias para contas com titularidades diferentes.");
        }

        if (valor < 0) {
            throw new TransferenciaException("Nao e permitido realizar transferências com valores negativos.");
        }

        if (valor > this.saldo) {
            throw new TransferenciaException("Saldo insuficiente. Não é possível realizar a transferência.");
        }

        this.saldo -= valor;
        contaDestino.saldo += valor;
        System.out.println("Transferencia de " + valor + " realizada com sucesso. Saldo atual: " + this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}