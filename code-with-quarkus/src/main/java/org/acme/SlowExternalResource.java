package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@ApplicationScoped
public class SlowExternalResource implements Vendedores {

    @Override
    public List<String> listarVendedores(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return IntStream.range(0, n)
                .mapToObj(i -> "Vendedor " + i)
                .toList();
    } 
    
    @Override
    public double promedio(String vendedor) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextDouble(10.0);
    }

    @Override
    public CompletableFuture<List<String>> listarVendedoresAsync(int n) {
        return CompletableFuture.supplyAsync(() -> listarVendedores(n), 
                CompletableFuture.delayedExecutor(1000, java.util.concurrent.TimeUnit.MILLISECONDS));
    }
}
