
public class Application {

//    public static void main(String[] args) {
//        View view = new View();
//        if (areArgsValid(args)) {
//            FileContent fileContent = new FileContent(args[0]);
//            System.out.println(fileContent.getDoc());
//        } else {
//            view.print("Please provide single file name to analyze.");
//        }
//    }

    // main function for running app from IDE

    public static void main(String[] args) {
        View view = new View();
        if (true) {
            FileContent fileContent = new FileContent("test.txt");
            CharIterator charIterator = new CharIterator(fileContent);
            WordIterator wordIterator = new WordIterator(fileContent);

            StatisticalAnalysis lettersAnalysis = new StatisticalAnalysis(fileContent.charIterator());
            StatisticalAnalysis wordsAnalysis = new StatisticalAnalysis(fileContent.wordIterator());

            view.printInt(wordsAnalysis.dictionarySize(), "Different letters used: ");
            view.printSet(lettersAnalysis.occurMoreThan(5), "Elements that make up more than 5% of the text.");
            view.printInt(lettersAnalysis.getDataSize(), "All letters: ");
            view.printMap(lettersAnalysis.getOccurrences(), "Letter occurrences: ");
        } else {
            view.printString("Please provide single file name to analyze.");
        }
    }

    private static boolean areArgsValid(String[] args) {
        return args.length == 1;
    }
}