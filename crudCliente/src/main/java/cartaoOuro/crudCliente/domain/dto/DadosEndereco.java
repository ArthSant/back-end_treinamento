package cartaoOuro.crudCliente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DadosEndereco {


        public String rua;

        public String numero;

        public String bairro;

        public String cidade;

        public String uf;
        public String complemento;

}
