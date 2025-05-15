import java.util.HashMap;
import java.util.Map;

public class MoedaNomePaises {
    private static final Map<String, String> mapaMoedas = new HashMap<>() {{
        put("USD", "Estados Unidos");
        put("EUR", "União Europeia");
        put("BRL", "Brasil");
        put("GBP", "Reino Unido");
        put("JPY", "Japão");
        put("CAD", "Canadá");
        put("AUD", "Austrália");
        put("INR", "Índia");
        put("CNY", "China");
        put("ARS", "Argentina");
        put("CHF", "Suíça");
        put("MXN", "México");
        put("ZAR", "África do Sul");
        put("NZD", "Nova Zelândia");
        put("SEK", "Suécia");
        put("NOK", "Noruega");
        put("DKK", "Dinamarca");
        put("RUB", "Rússia");
        put("KRW", "Coreia do Sul");
        put("SGD", "Singapura");
        put("HKD", "Hong Kong");
        put("TRY", "Turquia");
        put("PLN", "Polônia");
        put("THB", "Tailândia");
        put("IDR", "Indonésia");
        put("HUF", "Hungria");
        put("CZK", "República Tcheca");
        put("ILS", "Israel");
        put("CLP", "Chile");
        put("PHP", "Filipinas");
        put("AED", "Emirados Árabes Unidos");
        put("COP", "Colômbia");
        put("SAR", "Arábia Saudita");
        put("MYR", "Malásia");
        put("RON", "Romênia");
        put("BGN", "Bulgária");
        put("PKR", "Paquistão");
        put("EGP", "Egito");
        put("NGN", "Nigéria");
        put("BDT", "Bangladesh");
        put("VND", "Vietnã");
        put("KZT", "Cazaquistão");
        put("QAR", "Catar");
        put("UAH", "Ucrânia");
        put("PEN", "Peru");
        put("DZD", "Argélia");
        put("MAD", "Marrocos");
        put("LKR", "Sri Lanka");
        put("OMR", "Omã");
        put("KWD", "Kuwait");
        put("JOD", "Jordânia");
        put("BHD", "Bahrein");
        put("ISK", "Islândia");
        put("TWD", "Taiwan");
        put("HRK", "Croácia");
        put("UYU", "Uruguai");
        put("GHS", "Gana");
        put("TZS", "Tanzânia");
        put("KES", "Quênia");
        put("UGX", "Uganda");
        put("BWP", "Botsuana");
        put("MUR", "Maurício");
        put("XOF", "África Ocidental");
        put("XAF", "África Central");
        put("XCD", "Caribe Oriental");
        put("XPF", "Polinésia Francesa");
        put("XDR", "Fundo Monetário Internacional");
    }};

    public static String getPais(String codigoMoeda) {
        return mapaMoedas.getOrDefault(codigoMoeda, "Desconhecido");
    }
}
