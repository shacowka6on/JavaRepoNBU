public class Edition {
    private String title;
    private int numberOfPages;
    private Paper paper;

    public Edition(String title, int numberOfPages, Paper paper) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.paper = paper;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Paper getPaper() {
        return paper;
    }

    public double calculatePrintingCost(int copies) {
        return paper.getBasePrice() * numberOfPages * copies;
    }
}
