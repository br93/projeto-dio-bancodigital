public interface IConta {

    boolean sacar(double valor);

    void depositar(double valor);

    boolean transferir(double valor, IConta contaDestino);

    void imprimirExtrato();
}
