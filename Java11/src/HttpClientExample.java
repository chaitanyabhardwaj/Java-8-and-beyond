import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {
    public static void main(String[] args)throws IOException, InterruptedException {
        //http request using HttpURLConnection API (< JDK11)
        System.out.println(requestBefore11());
        //http request using HttpClient API (>= JDK11)
        System.out.println(requestAfter11());
        //async http request using HttpClient API (>= JDK11)
        requestAfter11Async();
    }

    //Making an Http request before JDK 11
    public static String requestBefore11()throws IOException {
        final var uri = "https://www.boredapi.com/api/activity";
        var url = new URL(uri);
        var con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        var res = "";
        var line = "";
        if(con.getResponseCode() == 200) {
            var br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while((line = br.readLine()) != null) res += line;
        }
        else res = "Something went wrong...";
        return res;
    }

    //Making an Http request with and after JDK 11
    public static String requestAfter11() throws IOException, InterruptedException {
        final var uri = "https://www.boredapi.com/api/activity";
        var client = HttpClient.newHttpClient();
        var req = HttpRequest.newBuilder()
                             .uri(URI.create(uri))
                             .GET()
                             .build();
        var res = client.send(req, HttpResponse.BodyHandlers.ofString());
        if(res.statusCode() == 200)
            return res.body();
        else
            return "Something went wrong...";
    }

    public static void requestAfter11Async() {
        final var uri = "https://www.boredapi.com/api/activity";
        var client = HttpClient.newBuilder()
                               .connectTimeout(Duration.ofSeconds(3))
                               .build();
        var req = HttpRequest.newBuilder()
                             .uri(URI.create(uri))
                             .GET()
                             .build();
        CompletableFuture<HttpResponse<String>> resultFuture = client.sendAsync(req, BodyHandlers.ofString());
        resultFuture.thenApply(HttpResponse::body)
                    .exceptionally(ex -> "Something went wrong...")
                    .thenAccept(System.out::println);
        resultFuture.join();
    }

}
