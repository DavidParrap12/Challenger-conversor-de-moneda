import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Lista {
    String apikey = "Ingrese su APIkey";
    String direccion = "https://v6.exchangerate-api.com/v6/" +apikey + "/latest/USD";


    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create (direccion))
            .build();
    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

    String json = response.body();

    public Lista() throws IOException, InterruptedException {
    }

    public void imprimirLista(){
        System.out.println(json);
        String leyendaLista = """
                    Se imprimieron las tasas de conversion 
                    respecto al dólar estadounidense.
                """;
        System.out.println(leyendaLista);
    }
}
