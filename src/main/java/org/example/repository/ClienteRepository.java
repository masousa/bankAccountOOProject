package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dominios.Cliente;
import org.example.dominios.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ClienteRepository implements IRepository<Cliente> {

    private final String filePath = "clientes.txt";
    private Collection<Cliente> clientesList;
    private ObjectMapper mapper;

    public ClienteRepository() {
        clientesList = new HashSet<>();
        mapper = new ObjectMapper();

    }

    private void loadList() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(getPath())) {
            StringBuilder stringBuilder = new StringBuilder();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                stringBuilder.append(linha);
            }

            String texto = stringBuilder.toString();
            List<Cliente> clientes = Arrays.asList(mapper.readValue(texto, Cliente[].class));
            clientesList.addAll(clientes);
        }

    }

    public Cliente findClientePorLoginESenha(String login, String senha) {
        for (Cliente cliente : clientesList) {
            Usuario usuario = cliente.getUsuario();
            if (usuario.autenticar(login, senha)) {
                return cliente;
            }
        }
        return null;
    }


    private void escreverAoSalvar(String texto) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(), StandardOpenOption.WRITE)) {
            writer.flush();
            writer.write(texto);
        }
        loadList();
    }

    public Path getPath() {

        try {

            Path path = Paths.get(getClass()
                    .getResource(File.separator).toURI());
            File baseFolder = path.toFile();
            File subFolder = new File(baseFolder, "savedFiles");
            if (!subFolder.exists()) {
                Files.createDirectory(subFolder.toPath());
            }
            File file = new File(subFolder, filePath);
            if (!file.exists()) {
                Files.createFile(file.toPath());
            }
            return file.toPath();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Cliente cliente) {
        clientesList.add(cliente);
        try {
            String resultado = mapper.writeValueAsString(clientesList);
            escreverAoSalvar(resultado);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente read(Cliente cliente) {

        if (this.clientesList.contains(cliente)) {
            return cliente;
        }
        return null;
    }

}
