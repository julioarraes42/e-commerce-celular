package julio.br.service;

// import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
// import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import julio.br.model.Celular;
import julio.br.repository.CelularRepository;
import julio.br.validation.ValidationException;
import org.apache.tika.Tika;

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
    public void salvar(Long id, String nomeImagem, byte[] imagem) throws IOException {
        try {
            String novoNomeImagem = salvarImagem(nomeImagem, imagem);
            celularRepository.findById(id).setNomeImagem(novoNomeImagem);
        } catch (IOException e) {
            throw new ValidationException("imagem", e.getMessage());
        }
    }

    private String salvarImagem(String nomeImagem, byte[] imagem) throws IOException {
        Tika tika = new Tika();
        String mimeType = tika.detect(imagem);
        List<String> listMimeType = Arrays.asList("image/jpg", "image/gif", "image/png", "image/jpeg", "image/jfif");
        if (mimeType == null || !listMimeType.contains(mimeType)) {
            throw new IOException("imagem não suportado.");
        }

        if (imagem.length > 1024 * 1024 * 10) {
            throw new IOException("tamanho máximo 10mb.");
        }

        // criar pasta quando nao existir
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists())
            diretorio.mkdirs();

        String path = PATH_USER + nomeImagem;

        File file = new File(path);
        if (file.exists()) {
            throw new IOException("Este arquivo ja existe");
        }

        file.createNewFile();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(imagem);
            fos.flush();
            fos.close();
        }

        System.out.println(nomeImagem);
        System.out.println(path);
        System.out.println(PATH_USER);

        return nomeImagem;
    }

    @Override
    public File download(String nomeImagem) {
        return new File(PATH_USER + nomeImagem);
    }
}