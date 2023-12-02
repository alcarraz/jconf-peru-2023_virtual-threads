package org.acme;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;


@Path("/api")
public class Ventas {

    @Inject
    Vendedores externalResource;

    //===== Versión bloqueante
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vendedores")
    public Collection<String> vendedores(@QueryParam("n") @DefaultValue("10") int n) {
        return externalResource.listarVendedores(n);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("promedios")
    public String promedios(@QueryParam("n") @DefaultValue("10") int n) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>(n);
        IntStream.range(0, n).forEach(i -> {
            Thread t = new Thread(() -> externalResource.promedio("vendedor " + i));
            t.start();
            threads.add(t);

        });
        for (Thread thread : threads) thread.join();
        return "Obtenidos " + n + " resultados de vendedores";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vendedoresV")
    @RunOnVirtualThread
    public Collection<String> vendedoresV(@QueryParam("n") @DefaultValue("10") int n) {
        return externalResource.listarVendedores(n);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("promediosV")
    public String promediosV(@QueryParam("n") @DefaultValue("10") int n) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>(n);
        IntStream.range(0, n).forEach(i -> {
            Thread t = Thread.ofVirtual().unstarted(() -> externalResource.promedio("vendedor " + i));
            t.start();
            threads.add(t);

        });
        for (Thread thread : threads) thread.join();
        return "Obtenidos " + n + " resultados de vendedores";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vendedoresA")
    CompletableFuture<List<String>> getVendedoresAsync(@QueryParam("n") @DefaultValue("10") int n) {
        return externalResource.listarVendedoresAsync(n);
    }


}
