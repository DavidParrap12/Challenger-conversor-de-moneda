import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    @SerializedName("base_code")
    private String Moneda;
    @SerializedName("target_code")
    private String monedaDeDestino;
    private double montoAConvertir;
    private double montoConvertido;

    public ConsultaMoneda(String Moneda, String monedaDeDestino, double montoAConvertir) {
        this.Moneda = Moneda.toUpperCase();
        this.monedaDeDestino = monedaDeDestino.toUpperCase();
        this.montoAConvertir = montoAConvertir;
    }

    public double convert() throws IOException, InterruptedException {
        String apikey = "Ingrese su APIKEY";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apikey + "/latest/" + Moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double conversionRate = conversionRates.get(monedaDeDestino).getAsDouble();
            montoConvertido = montoAConvertir * conversionRate;
            return montoConvertido;
        } else {
            throw new IOException("Error al realizar la solicitud" + response.statusCode());
        }
    }
}
/* <a href="https://www.exchangerate-api.com">Rates By Exchange Rate API</a> */
