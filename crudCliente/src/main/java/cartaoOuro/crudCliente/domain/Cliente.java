package cartaoOuro.crudCliente.domain;


import cartaoOuro.crudCliente.domain.dto.DadosAtualizarCliente;
import cartaoOuro.crudCliente.domain.dto.DadosCadastroCliente;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity(name = "Cliente")
@Table(name = "clientes")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private String sobrenome;
        private String cpf;
        private String email;
        private String data;


        @Embedded
        private Endereco endereco;


        public Cliente(DadosCadastroCliente dados) {
                this.nome = dados.getNome();
                this.sobrenome = dados.getSobrenome();
                this.cpf = dados.getCpf();
                this.email = dados.getEmail();
                this.data = dados.getData();
                this.endereco = new Endereco(dados);
        }


        public void atualizar(DadosAtualizarCliente dados) {

               if(! dados.getNome().isEmpty())
                       this.nome = dados.getNome().toUpperCase();

                if(! dados.getSobrenome().isEmpty())
                        this.sobrenome = dados.getSobrenome().toUpperCase();


                if(! dados.getEmail().isEmpty()) {
                        this.email = dados.getEmail();

                }
                if(! dados.getData().isEmpty())
                        this.data = dados.getData();




                this.endereco.atualizarEndereco(dados);


        }
}
