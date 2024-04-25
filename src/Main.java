import com.aluracursos.coinconverter.models.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class Main {
    static String apiKey;
    static HashMap<Integer, String[]> conversionsType;
    static ApiConsultation consultation;
    static String[] values;
    static String coinToChange;
    static String coinUser;
    static int options;
    static double valueUser;
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        apiKey = "4697f49c99a433acd5d5826d";
        conversionsType = new ConversionsType().getConversions();
        consultation = new ApiConsultation();
        coinToChange = "";
        coinUser = "";
        options = 0;
        valueUser = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("Welcome to coin converter");

        //Options Menu
        String menu = """
                **Choose a option **
                1 - Dolar =>> Real Brasileño
                2 - Real Brasileño =>> Dólar
                3 - Dolar =>> Peso Colombiano
                4 - Peso Colombiano =>> Dolar
                5 - Peso Argentino =>> Dolar
                6 - Dólar =>> Peso Argentino
                7 - Dolar =>> Peso Mexicano
                8 - Peso Mexicano =>> Dolar
                9 - Peso Chileno =>> Dolar
                10 - Go out
                """;

        while (options != 10) {
            try {
                System.out.println(menu);
                options = scanner.nextInt();
                if (options == 10) {
                    System.out.println("Thank you for using our service");
                    break;
                }

                values = conversionsType.get(options);
                coinToChange = values[0];
                coinUser = values[1];

                //Checking value change
                var json = consultation.consultationCoin(apiKey, coinToChange);
                Coin coin = new Coin(json);
                System.out.println("Enter the value you want to convert: ");
                valueUser = scanner.nextDouble();
                coin.conversionHandle(coinUser, valueUser);
                System.out.println(coin);

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Add a valid option", e);
            }
        }

    }


}