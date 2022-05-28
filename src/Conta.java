public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private static final double LIMITE_SAQUE_PADRAO = 1000;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected double limiteSaque;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.limiteSaque = LIMITE_SAQUE_PADRAO;
    }

    @Override
    public void sacar(double valor) {
        if(checarMaiorQueLimite(valor))
            System.out.println("Valor maior que limite de saque.");
        else if(checarMaiorQueSaldo(valor))
            System.out.println("Saldo insuficiente.");
        else
            saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(checarMaiorQueSaldo(valor))
            System.out.println("Saldo insuficiente.");
        else
            saldo -= valor;
            contaDestino.depositar(valor);
    }

    @Override
    public boolean checarMaiorQueLimite(double valor) {
        if(valor > limiteSaque)
            return true;
        return false;
    }

    @Override
    public boolean checarMaiorQueSaldo(double valor) {
        if(valor > saldo)
            return true;
        return false;
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

    public Cliente getCliente(){
        return cliente;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    protected void imprimirInfos() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", limiteSaque=" + limiteSaque +
                ", cliente=" + cliente +
                "}";
    }
}
