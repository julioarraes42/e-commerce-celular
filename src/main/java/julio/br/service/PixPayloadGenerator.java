package julio.br.service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PixPayloadGenerator {
    public static String generatePayload(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);
        String formattedAmount = decimalFormat.format(amount);

        String payload = "00020126330014BR.GOV.BCB.PIX01110750292911852040000530398654"
                + String.format("%02d", formattedAmount.length()) + formattedAmount +
                "5802BR5901N6001C62070503***6304";

        return payload + calculateCRC(payload);

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