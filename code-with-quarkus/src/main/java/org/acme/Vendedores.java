package org.acme;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Vendedores {
    List<String>  listarVendedores(int n);
    double promedio(String vendedor); 
    
    CompletableFuture<List<String>> listarVendedoresAsync(int n);
}
