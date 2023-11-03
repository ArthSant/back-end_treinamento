package cartaoOuro.crudCliente.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DadosCadastroCliente {

    @NotBlank
   private String nome;

    @NotBlank
    private String sobrenome;

    @Email
   private String email;

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @NotBlank
    private String data;


  @NotBlank
  @Pattern(regexp = "\\d{8}")
  private String cep;

  @NotBlank
  private String rua;

  @NotBlank
  private String numero;

  @NotBlank
  private String bairro;

  @NotBlank
  private String  cidade;


  @NotBlank
  private String uf;



}
