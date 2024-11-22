package julio.br.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

// import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import julio.br.dto.CelularDTO;
import julio.br.service.CelularFileServiceImpl;
import julio.br.service.CelularService;
import julio.br.form.ImagemForm;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/celulares")
public class CelularResource {

    @Inject
    public CelularService celularService;

    @Inject
    public CelularFileServiceImpl fileService;

    @GET
    public Response findAll(
            @PathParam("page") @DefaultValue("0") int page,
            @PathParam("pageSize") @DefaultValue("100") int pageSize) {
                if (pageSize <= 0) {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity("Page size must be greater than 0")
                            .build();
                }
        return Response.ok(celularService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(celularService.findById(id)).build();
    }

    @GET
    public Response findByMarca(
            @PathParam("marca") String marca,
            @PathParam("page") @DefaultValue("0") int page,
            @PathParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(celularService.findByMarca(marca, page, pageSize)).build();
    }

    @GET
    public Response findByNome(
            @PathParam("nome") String nome,
            @PathParam("page") @DefaultValue("0") int page,
            @PathParam("pageSize") @DefaultValue("100") int pageSize) {
        return Response.ok(celularService.findByNome(nome, page, pageSize)).build();
    }

    @GET
    @Path("/busca/marca/{marca}")
    public Response findByMarca(@PathParam("marca") String marca) {
        return Response.ok(celularService.findByMarca(marca)).build();
    }

    @GET
    @Path("/busca/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(celularService.findByNome(nome)).build();
    }

    @GET
    @Path("/busca/lancamento/{data}")
    public Response findByAnoLancamento(@PathParam("data") String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        return Response.ok(celularService.findByAnoLancamento(dataFormatada)).build();
    }

    @GET
    @Path("/busca/armazenamento/{armazenamento}")
    public Response findByArmazenamento(@PathParam("armazenamento") Float armazenamento) {
        return Response.ok(celularService.findByArmazenamento(armazenamento)).build();
    }

    @GET
    @Path("/busca/ram/{ram}")
    public Response findByRam(@PathParam("ram") Float ram) {
        return Response.ok(celularService.findByRam(ram)).build();
    }

    @GET
    @Path("/busca/preco/{preco}")
    public Response findByPreco(@PathParam("preco") Float preco) {
        return Response.ok(celularService.findByPreco(preco)).build();
    }

    @POST
    @Transactional
    public Response create(CelularDTO dto) {
        return Response.status(Status.CREATED).entity(celularService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(CelularDTO dto, @PathParam("id") Long id) {
        celularService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delet(@PathParam("id") Long id) {
        celularService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id}/imagen/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImagemForm form) {
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }

    @PATCH
    @Path("/estoque/{id}/{valor}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response definirEstoque(@PathParam("id") Long id, @PathParam("valor") int valor) {
        celularService.definirEstoque(id, valor);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/estoque/adicionar/{id}/{valor}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response adicionarEstoque(@PathParam("id") Long id, @PathParam("valor") int valor) {
        celularService.adicionarEstoque(id, valor);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/estoque/diminuir/{id}/{valor}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response diminuirEstoque(@PathParam("id") Long id, @PathParam("valor") int valor) {
        celularService.diminuirEstoque(id, valor);
        return Response.status(Status.NO_CONTENT).build();
    }
}
