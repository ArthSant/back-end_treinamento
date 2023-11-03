package cartaoOuro.crudCliente.domain.dto;


import cartaoOuro.crudCliente.domain.Cliente;
import cartaoOuro.crudCliente.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DadosCliente {
    private String nome;
    private String sobrenome;
    private String email;
    private String dataNascimento;
    private String cpf;

    private Endereco endereco;
    public DadosCliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.dataNascimento = cliente.getData();
        this.endereco = cliente.getEndereco();


    }



}
