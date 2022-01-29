public class Main {

    public static void main(String[] args) {
        Banco banco1 = new Banco("Banco 1");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Cliente1");

        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente1);

        banco1.getContas().add(cc);
        banco1.getContas().add(poupanca);

        //System.out.println(banco1.toString());

        cc.depositar(100);
        cc.sacar(110);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

}
