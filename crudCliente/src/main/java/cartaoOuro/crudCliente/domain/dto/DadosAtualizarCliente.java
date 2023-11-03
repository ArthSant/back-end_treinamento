package cartaoOuro.crudCliente.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DadosAtualizarCliente {

        private String cpf;

        private String nome;

        private String sobrenome;
        private String email;
        private String data;
        private String cep;

        private String rua;
        private String numero;
        private String bairro;
        private String cidade;
        private String uf;



}
