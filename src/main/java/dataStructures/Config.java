package dataStructures;

/**
 * Klasa ze stałymi odpowiadającymi za działanie programu
 */
public class Config {

    // Ścieżki do plików z naszymi danymi
    public static String inputDataFolderName = "/Data";
    public static String maleNamesPath = "/male_names.xlsx";
    public static String femaleNamesPath = "/female_names.xlsx";
    public static String maleSurnamesPath = "/male_surnames.xlsx";
    public static String femaleSurnamesPath = "/female_surnames.xlsx";
    public static String citiesPath = "/cities.xlsx";
    public static String streetsPath = "/streets.xlsx";

    // Parametry, od których zależą wygenerowane dane
    public static int maxAdultAge = 80;

    public static int minAdultAge = 18;

    public static int ageDiff = 5;

    // Ścieżki do plików zwracanych przez nasz program
    public static String outputDataFolderName = "/OutputData";
    public static String outputFileName = "/newSheet.xlsx";

    public static String outputSheetName = "Random Generated data";
}
