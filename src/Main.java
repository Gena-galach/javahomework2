import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String buildURL(String baseUrl, Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder(baseUrl);

        if (params != null && !params.isEmpty()) {
            url.append("?");

            boolean first = true;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (value != null) {
                    if (!first) {
                        url.append("&");
                    }

                    url.append(URLEncoder.encode(key, "UTF-8"))
                            .append("=")
                            .append(URLEncoder.encode(value, "UTF-8"));

                    first = false;
                }
            }
        }

        return url.toString();
    }

    public static void main(String[] args) {
        try {
            // Базовый URL
            String baseUrl = "https://example.com/search";

            // Создание карты параметров
            Map<String, String> params = new HashMap<>();
            params.put("query", "java programming");
            params.put("page", "1");
            params.put("sort", null);

            // Построение полного URL
            String fullUrl = buildURL(baseUrl, params);
            System.out.println("Full URL: " + fullUrl);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
