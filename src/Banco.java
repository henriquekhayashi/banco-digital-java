import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Banco {
    private String nome;
    private List<Conta> contas;
    private Set<Cliente> clientes;

    public Banco() {
        contas = new ArrayList<>();
        clientes = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Set<Cliente> getClientes(){
        return clientes;
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente){
        if(clientes.contains(cliente))
            clientes.remove(cliente);

    }

    public void removeCliente(String nome){
        List<Cliente> listaFilter = clientes.stream()
                .filter(c -> c.getNome().equals(nome))
                .collect(Collectors.toList());
        if(listaFilter.size() > 1)
            System.out.println("Conta não encontrada.");
        else {
            Cliente cliente = listaFilter.get(0);
            clientes.remove(cliente);
        }
    }

    public void addConta(Conta conta){
        Cliente cliente = conta.getCliente();
        if(!clientes.contains(cliente))
            addCliente(cliente);
        contas.add(conta);

    }


    public void removeConta(int numero){
        List<Conta> listaFilter = contas.stream()
                        .filter(c -> c.numero == numero)
                        .collect(Collectors.toList());
        if(listaFilter.size() > 1)
            System.out.println("Conta não encontrada.");
        else {
            Conta conta = listaFilter.get(0);
            contas.remove(conta);
        }
    }

    public void removeConta(Cliente cliente){
        List<Conta> listaFilter = contas.stream()
                .filter(c -> c.getCliente() == cliente)
                .collect(Collectors.toList());
        if(listaFilter.size() > 1)
            System.out.println("Conta não encontrada.");
        else {
            Conta conta = listaFilter.get(0);
            contas.remove(conta);
        }
    }

    public void removeConta(String nome){
        List<Conta> listaFilter = contas.stream()
                .filter(c -> c.getCliente().getNome().equals(nome))
                .collect(Collectors.toList());
        if(listaFilter.size() > 1)
            System.out.println("Conta não encontrada.");
        else {
            Conta conta = listaFilter.get(0);
            contas.remove(conta);
        }
    }

    public void imprimirListaContas(){
        System.out.println("Contas:");
        contas.forEach(System.out::println);
    }

    public void imprimirListaClientes(){
        System.out.println("Clientes:");
        clientes.forEach(System.out::println);
    }
}
