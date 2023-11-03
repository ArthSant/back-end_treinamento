package cartaoOuro.crudCliente.controller;


import cartaoOuro.crudCliente.domain.Cliente;
import cartaoOuro.crudCliente.domain.dto.DadosAtualizarCliente;
import cartaoOuro.crudCliente.domain.dto.DadosCadastroCliente;
import cartaoOuro.crudCliente.domain.dto.DadosCliente;
import cartaoOuro.crudCliente.infra.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

        @Autowired
        ClienteRepository repository;



        @PostMapping
        @CrossOrigin(origins = "http://localhost:4200")
        public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
                Cliente newCliente = new Cliente(dados);
                repository.save(newCliente);
                URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(newCliente.getId()).toUri();

                return ResponseEntity.created(uri).body(new DadosCliente(newCliente));

        }


        @GetMapping // Lista todos os clientes.
        public ResponseEntity<Page<DadosCliente>> listar(@PageableDefault(sort = {"nome"} , size = 10) Pageable pagina) {
                var page = repository.findAll(pagina).map(DadosCliente::new);
                return ResponseEntity.ok(page);

        }

        @GetMapping("/{cpf}") // Lista um cliente especifico
        public ResponseEntity<DadosCliente> encontrarPorCPF(@PathVariable String cpf) {

                return ResponseEntity.ok(new DadosCliente(repository.getReferenceByCpf(cpf)));


        }


        @PutMapping
        @Transactional


        public ResponseEntity atualizar(@RequestBody DadosAtualizarCliente dados) {
                Cliente att = repository.findByCpf(dados.getCpf());
                att.atualizar(dados);
                return ResponseEntity.ok(new DadosCliente(att));

        }


        //Exclui fisicamente a entidade.
        @DeleteMapping("/{cpf}")
        public ResponseEntity delete(@PathVariable String cpf) {
                repository.deleteByCpf(cpf);
                return ResponseEntity.noContent().build();
        }


}