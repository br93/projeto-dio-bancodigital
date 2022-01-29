public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected String tipo;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > saldo)
        {
            System.err.println("\nValor: "+ valor + "\nSaldo em " + this.getTipo() + " " + saldo + "\nSaldo insuficiente\n");
            return false;
        }
        saldo -= valor;
        System.out.println("Valor retirado com sucesso da conta " + this.getTipo() + " numero: " + this.getNumero());
        return true;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Valor depositado com sucesso na conta " + this.getTipo() + " numero: " + this.getNumero());
    }

    @Override
    public boolean transferir(double valor, IConta contaDestino) {
        if(!this.sacar(valor))
            return false;
        contaDestino.depositar(valor);
        System.out.println("Valor transferido com sucesso");
        return true;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}