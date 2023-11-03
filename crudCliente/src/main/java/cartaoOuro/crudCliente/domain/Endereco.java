package cartaoOuro.crudCliente.domain;


import cartaoOuro.crudCliente.domain.dto.DadosAtualizarCliente;
import cartaoOuro.crudCliente.domain.dto.DadosCadastroCliente;
import cartaoOuro.crudCliente.domain.dto.DadosEndereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(DadosCadastroCliente dadosEndereco) {
        this.rua = dadosEndereco.getRua();
        this.numero = dadosEndereco.getNumero();
        this.bairro = dadosEndereco.getBairro();
        this.cidade = dadosEndereco.getCidade();
        this.uf = dadosEndereco.getUf();
        this.cep = dadosEndereco.getCep();
    }

    public void atualizarEndereco(DadosAtualizarCliente dados) {
        if(!dados.getRua().isEmpty())
            this.rua = dados.getRua();
        if(!dados.getNumero().isEmpty())
            this.numero = dados.getNumero();
        if(!dados.getBairro().isEmpty())
            this.bairro = dados.getBairro();
        if(!dados.getCidade().isEmpty())
            this.cidade = dados.getCidade();
        if(!dados.getUf().isEmpty())
            this.uf = dados.getUf();
        if(!dados.getUf().isEmpty())
            this.cep = dados.getCep();


    }


}
