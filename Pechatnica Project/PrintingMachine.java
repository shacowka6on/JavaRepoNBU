import java.util.Map;
 
enum inkType{
    COLORFUL, BLACK_WHITE
}
 
enum paperType {
    REGULAR, GLOSSY, NEWSPAPER;
}
 
public class PrintingMachine {
    private int maximumPapersCount;
    private int papersCount;
    private int paintedPapers = 0;
    private inkType inkType;
    private paperType paperType;
    private Map<paperType, Integer> printedEditions;
 
    public PrintingMachine(int maximumPapersCount, inkType inkType, paperType paperType){
      this.maximumPapersCount = maximumPapersCount;
      this.inkType = inkType;
      this.paperType = paperType;
    }
 
    public int getMaximumPapersCount(){
        return this.maximumPapersCount;
    }
 
    public void loadMachine(int papersCount){
        if(papersCount <= this.maximumPapersCount){
            this.papersCount = papersCount;
            System.out.println("Machine is loaded with " + papersCount + " papers");
            return;
        }
        System.out.println("Amount is greater than the maximum amount of the machine - Trying to fill " + papersCount + " in " + this.maximumPapersCount + " space");
    }
 
    public void print(int copies, inkType inkType, paperType paperType) throws Exception {
        if (this.inkType != inkType) {
            throw new Exception("Ink type mismatch. This machine uses " + this.inkType.toString() + " ink.");
        }
 
        if (this.paperType != paperType) {
            throw new Exception("Paper type mismatch. This machine uses " + this.paperType.toString() + " paper.");
        }
 
        if (copies > this.papersCount) {
            throw new Exception("Not enough paper in the machine. Needed: " + copies + ", Available: " + this.papersCount);
        }
 
        this.papersCount -= copies;
        this.paintedPapers += copies;
 
        if(this.printedEditions.containsKey(paperType)){
            this.printedEditions.put(paperType, this.printedEditions.get(paperType) + copies);
        }
        else{
           this.printedEditions.put(paperType, copies);
        }
        System.out.println("Printed " + copies + " copies of " + paperType.toString());
    }
 
    public int getPaintedPapers(){
        return this.paintedPapers;
    }
 
    public String getPaperType(){
        return this.paperType.toString();
    }
 
    public String getInkType(){
        return this.inkType.toString();
    }
}
