package julio.br.service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PixPayloadGenerator {
    public static String generatePayload(String key, String name, String city, double amount, String txId) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);
        String formattedAmount = decimalFormat.format(amount);

        String payload = "000201" + // Payload format indicator
                "26" + "40" + // Merchant account info
                "0014br.gov.bcb.pix" +
                "01" + String.format("%02d", key.length()) + key +
                "0203Pix" + // Chave PIX
                "52040000" + // Merchant category code
                "5303986" + // Currency code
                "54" + String.format("%02d", formattedAmount.length()) + formattedAmount + // Valor com ponto decimal
                "5802BR" + // País
                "59" + String.format("%02d", name.length()) + name + // Nome do recebedor
                "60" + String.format("%02d", city.length()) + city + // Cidade
                "62" + "29" + // Additional data field
                "05" + String.format("%02d", txId.length()) + txId +
                "6304" +
                "563C"; // CRC16 checksum

        return payload;
    }

    private static String calculateCRC(String payload) {
        int polinomio = 0x1021;
        int resultado = 0xFFFF;

        for (char ch : payload.toCharArray()) {
            resultado ^= (ch << 8);
            for (int i = 0; i < 8; i++) {
                if ((resultado & 0x8000) != 0) {
                    resultado = (resultado << 1) ^ polinomio;
                } else {
                    resultado <<= 1;
                }
            }
        }
        resultado &= 0xFFFF;
        return String.format("%04X", resultado);
    }
}
