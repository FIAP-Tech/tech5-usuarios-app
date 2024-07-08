package br.com.fiap.clientes.domain.service;

import br.com.fiap.clientes.api.model.UsuarioDto;
import br.com.fiap.clientes.config.MessageConfig;
import br.com.fiap.clientes.domain.exception.UsuarioNaoEncontradoException;
import br.com.fiap.clientes.domain.model.Usuario;
import br.com.fiap.clientes.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository clienteRepository;

    private final ModelMapper modelMapper;

    private final MessageConfig messageConfig;

    public List<UsuarioDto> buscarClientePorNome(String nome) {
        var clienteList = clienteRepository.findByNomeIgnoreCaseContaining(nome);

        return clienteList.stream()
                .map(cliente -> modelMapper.map(cliente, UsuarioDto.class))
                .toList();
    }

    public void add(UsuarioDto clienteDto) {
        var cliente = modelMapper.map(clienteDto, Usuario.class);
        clienteRepository.save(cliente);
    }

    public UsuarioDto update(UsuarioDto clienteDto, Long id) {
        var optionalCliente = clienteRepository.findById(id);

        if(optionalCliente.isPresent()){
            var cliente = optionalCliente.get();
            modelMapper.map(clienteDto, cliente);

            cliente = clienteRepository.save(cliente);

            return modelMapper.map(cliente, UsuarioDto.class);
        } else {
            throw new UsuarioNaoEncontradoException(messageConfig.getClienteNaoEncontrado());
        }
    }

    public void delete(Long id) {
        var optionalCliente = clienteRepository.findById(id);

        if(optionalCliente.isPresent()){
            clienteRepository.deleteById(id);
        } else {
            throw new UsuarioNaoEncontradoException(messageConfig.getClienteNaoEncontrado());
        }
    }

    public UsuarioDto getClienteById(Long id) {
        var optionalCliente = clienteRepository.findById(id);

        if(optionalCliente.isPresent()){
            return modelMapper.map(optionalCliente.get(), UsuarioDto.class);
        } else {
            throw new UsuarioNaoEncontradoException(messageConfig.getClienteNaoEncontrado());
        }
    }

    public List<UsuarioDto> findAll() {
        return clienteRepository.findAll().stream()
                .map(cliente -> modelMapper.map(cliente, UsuarioDto.class))
                .toList();
    }
}
