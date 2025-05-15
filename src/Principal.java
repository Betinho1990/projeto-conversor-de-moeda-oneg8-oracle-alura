import com.google.gson.Gson;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {

    private static final String API_KEY = System.getenv("EXCHANGE_API_KEY");
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static final String HISTORICO_ARQUIVO = "historico.txt";

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = httpResponse.body();

            Gson gson = new Gson();
            MoedaApiResposta response = gson.fromJson(jsonString, MoedaApiResposta.class);

            if (response.conversion_rates == null) {
                System.out.println("Erro ao obter taxas. Verifique sua chave de API.");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            List<String> moedasFixas = Arrays.asList(
                    "USD", "EUR", "BRL", "GBP", "JPY", "CAD", "AUD", "INR", "CNY", "ARS",
                    "CHF", "MXN", "ZAR", "NZD", "SEK", "NOK", "DKK", "RUB", "KRW", "SGD",
                    "HKD", "TRY", "PLN", "THB", "IDR", "HUF", "CZK", "ILS", "CLP", "PHP",
                    "AED", "COP", "SAR", "MYR", "RON", "BGN", "PKR", "EGP", "NGN", "BDT",
                    "VND", "KZT", "QAR", "UAH", "PEN", "DZD", "MAD", "LKR", "OMR", "KWD",
                    "JOD", "BHD", "ISK", "TWD", "HRK", "UYU", "GHS", "TZS", "KES", "UGX",
                    "BWP", "MUR", "XOF", "XAF", "XCD", "XPF", "XDR"
            );

            while (continuar) {
                System.out.println("\n=== Conversor de Moedas ===");
                System.out.println("Moedas disponíveis:");
                System.out.println(" 0 - Ver histórico de conversões");

                for (int i = 0; i < moedasFixas.size(); i++) {
                    String moeda = moedasFixas.get(i);
                    String pais = buscarNomePaisPorMoeda(moeda);
                    System.out.printf("%3d - %s (%s)\n", i + 1, moeda, pais);
                }

                System.out.print("\nDigite o número da moeda de ORIGEM (ou 0 para ver o histórico): ");
                int escolha = scanner.nextInt();

                if (escolha == 0) {
                    mostrarHistorico();
                    continue;
                }

                int indexOrigem = escolha - 1;
                String moedaOrigem = moedasFixas.get(indexOrigem);
                String paisOrigem = buscarNomePaisPorMoeda(moedaOrigem);
                System.out.println("País da moeda de origem: " + paisOrigem);

                System.out.print("Digite o número da moeda de DESTINO: ");
                int indexDestino = scanner.nextInt() - 1;
                String moedaDestino = moedasFixas.get(indexDestino);

                System.out.print("Digite o valor a ser convertido: ");
                double valorOriginal = scanner.nextDouble();

                double valorConvertido = converterMoeda(valorOriginal, moedaOrigem, moedaDestino, response.conversion_rates);

                System.out.printf("\n%.2f %s = %.2f %s\n", valorOriginal, moedaOrigem, valorConvertido, moedaDestino);

                String registro = String.format("%.2f %s = %.2f %s", valorOriginal, moedaOrigem, valorConvertido, moedaDestino);
                salvarHistorico(registro);

                System.out.print("\nDeseja fazer outra conversão? (s/n): ");
                String resposta = scanner.next().toLowerCase();
                continuar = resposta.equals("s");
            }

            System.out.println("Programa encerrado. Obrigado!");

        } catch (IOException | InterruptedException | InputMismatchException | IndexOutOfBoundsException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static String buscarNomePaisPorMoeda(String moeda) {
        return MoedaNomePaises.getPais(moeda);
    }

    public static double converterMoeda(double valorOriginal, String moedaOrigem, String moedaDestino, Map<String, Double> conversionRates) {
        if (conversionRates.containsKey(moedaOrigem) && conversionRates.containsKey(moedaDestino)) {
            double taxaOrigem = conversionRates.get(moedaOrigem);
            double taxaDestino = conversionRates.get(moedaDestino);
            return (valorOriginal / taxaOrigem) * taxaDestino;
        } else {
            System.out.println("Moeda inválida.");
            return 0;
        }
    }

    // Salvar histórico no arquivo
    public static void salvarHistorico(String registro) {
        try (FileWriter writer = new FileWriter(HISTORICO_ARQUIVO, true)) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = agora.format(formatter);

            writer.write("[" + timestamp + "] " + registro + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao salvar histórico: " + e.getMessage());
        }
    }

    // Mostrar histórico do arquivo
    public static void mostrarHistorico() {
        System.out.println("\n=== Histórico de Conversões ===");
        File arquivo = new File(HISTORICO_ARQUIVO);

        if (!arquivo.exists()) {
            System.out.println("Nenhuma conversão registrada ainda.");
            return;
        }

        try (Scanner leitor = new Scanner(arquivo)) {
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler histórico: " + e.getMessage());
        }
    }
}