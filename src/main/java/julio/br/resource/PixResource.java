package julio.br.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import julio.br.service.PixPayloadGenerator;
import julio.br.service.QrCodeGenerator;

import java.nio.file.Files;

@Path("/pix")
public class PixResource {

    @GET
    @Path("/qrcode")
    @Produces("image/png")
    public Response generatePixQrCode(@QueryParam("key") String key,
            @QueryParam("name") String name,
            @QueryParam("city") String city,
            @QueryParam("amount") double amount,
            @QueryParam("txId") String txId) {
        try {
            String payload = PixPayloadGenerator.generatePayload(key, name, city, amount, txId);
            java.nio.file.Path tempFile = Files.createTempFile("qrcode", ".png");
            QrCodeGenerator.generateQrCode(payload, tempFile);

            byte[] qrCodeBytes = Files.readAllBytes(tempFile);
            System.out.println(payload);
            return Response.ok(qrCodeBytes).type("image/png").build();
        } catch (Exception e) {
            return Response.status(500).entity("Erro ao gerar o QR Code").build();
        }
    }
}
