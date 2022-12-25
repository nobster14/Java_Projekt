package DataStructures;

/**
 * Klasa ze stałymi odpowiadającymi za działanie programu
 */
public class Config {

    /**
     * Rozmiar kontenera - czyli ile osób będziemy jednorazowo eksportować do pliku xls
     */
    public static int CONTAINER_SIZE = 5000;

    // Scieżki do plików z naszymi danymi
    public static String folderName = "/Data";
    public static String maleNamesPath = "/male_names.xlsx";
    public static String femaleNamesPath = "/female_names.xlsx";
    public static String maleSurnamesPath = "/male_surnames.xlsx";
    public static String femaleSurnamesPath = "/female_surnames.xlsx";

}
