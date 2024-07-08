package br.com.fiap.clientes.dados;

import br.com.fiap.clientes.api.model.UsuarioDto;
import br.com.fiap.clientes.domain.model.Usuario;

import java.time.LocalDate;

public class ClienteDados {

    public Usuario criarCliente1(){
        return Usuario.builder()
                .id(1L)
                .nome("Bruno Silveira")
                .email("bruno.silveira@gmail.com")
                .telefone("(11) 89345-5687")
                .dataNascimento(LocalDate.of(1990, 12, 1))
                .cpf("156.683.240-36")
                .build();
    }

    public Usuario criarCliente2(){
        return Usuario.builder()
                .id(1L)
                .nome("Bruno Otávio")
                .build();
    }

    public UsuarioDto criarClienteDto1(){
        return UsuarioDto.builder()
                .id(1L)
                .nome("Bruno Silveira")
                .email("bruno.silveira@gmail.com")
                .telefone("(11) 89345-5687")
                .dataNascimento(LocalDate.of(1990, 12, 1))
                .cpf("156.683.240-36")
                .build();
    }

    public UsuarioDto criarClienteDto2(){
        return UsuarioDto.builder()
                .id(1L)
                .nome("Bruno Otávio")
                .build();
    }
}
