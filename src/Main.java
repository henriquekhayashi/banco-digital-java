public class Main {
    public static void main(String[] args) {
        Cliente johnDoe = new Cliente();
        johnDoe.setNome("JohnDoe");

        Cliente alice = new Cliente();
        alice.setNome("Alice");

        Banco banco = new Banco();
        banco.addCliente(johnDoe);
        banco.addCliente(alice);

        Conta cc = new ContaCorrente(johnDoe);
        Conta cc1 = new ContaCorrente(alice);
        banco.addConta(cc);
        banco.addConta(cc1);


        Conta poupanca = new ContaPoupanca(johnDoe);
        banco.addConta(poupanca);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        banco.imprimirListaContas();
        banco.imprimirListaClientes();

        banco.removeConta(cc.getNumero());
        banco.removeCliente(johnDoe);


        System.out.println();
        banco.imprimirListaContas();
        banco.imprimirListaClientes();

        banco.removeConta(alice);
        banco.removeConta("JohnDoe");
        banco.removeCliente("Alice");

        System.out.println();
        banco.imprimirListaContas();
        banco.imprimirListaClientes();
    }
}