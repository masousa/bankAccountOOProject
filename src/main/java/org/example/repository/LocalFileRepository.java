package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class LocalFileRepository<T> implements IRepository<T> {

    private final String filePath;
    protected Collection<T> persistenceList;
    private ObjectMapper mapper;

    public LocalFileRepository(String filePath) {
        this.filePath = filePath;
        persistenceList = new HashSet<>();
        mapper = new ObjectMapper();

    }

    @Override
    public void save(T object) {
        persistenceList.add(object);
        try {
            String resultado = mapper.writeValueAsString(persistenceList);
            escreverAoSalvar(resultado);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public T read(T object) {
        if (this.persistenceList.contains(object)) {
            return object;
        }
        return null;
    }

    private void loadList() throws IOException {
        
        try (BufferedReader bufferedReader = Files.newBufferedReader(getPath())) {
            StringBuilder stringBuilder = new StringBuilder();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                stringBuilder.append(linha);
            }

            String texto = stringBuilder.toString();
            //TypeReference é um objeto do Jackson (mapper) que permite o retorno de um tipo especifico de retorno.
            List<T> persistence = mapper.readValue(texto, new TypeReference<List<T>>() {});
            persistenceList.addAll(persistence);
        }

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
}
