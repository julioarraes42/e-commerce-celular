package julio.br.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import julio.br.model.Celular;
import julio.br.repository.CelularRepository;
import julio.br.validation.ValidationException;

@ApplicationScoped
public class CelularFileServiceImpl implements FileService {
    private final String PATH_USER = System.getProperty("user.home")
            + File.separator + ".quarkus"
            + File.separator + "imagens"
            + File.separator + "celulares" + File.separator;

    @Inject
    CelularRepository celularRepository;

    @Override
    @Transactional
    public void salvar(Long id, String nomeImagem, byte[] imagem) {
        Celular celular = celularRepository.findById(id);
        try {
            celular.setNomeImagem(salvarImagem(nomeImagem, imagem));
        } catch (IOException e) {
            throw new ValidationException("imagem", e.getMessage());
        }
    }

    private String salvarImagem(String nomeImagem, byte[] imagem) throws IOException {
        String mimeType = Files.probeContentType(new File(nomeImagem).toPath());
        List<String> listMimeType = Arrays.asList("image/jpg", "image/gif", "image/png", "image/jpeg");
        if (!listMimeType.contains(mimeType))
            throw new IOException("imagem não suportado.");

        if (imagem.length > 1024 * 1024 * 10) {
            throw new IOException("tamanho máximo 10mb.");
        }

        File diretorio = new File(PATH_USER);
        if (!diretorio.exists())
            diretorio.mkdirs();

        String nomeArquivo = UUID.randomUUID()
                + "."
                + mimeType.substring(mimeType.lastIndexOf("/") + 1);
        String path = PATH_USER + nomeArquivo;

        File file = new File(path);
        if (file.exists())
            throw new IOException("Este arquivo ja existe");

        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagem);
        fos.flush();
        fos.close();

        return nomeArquivo;
    }

    @Override
    public File download(String nomeImagem) {
        return new File(PATH_USER + nomeImagem);
    }
}