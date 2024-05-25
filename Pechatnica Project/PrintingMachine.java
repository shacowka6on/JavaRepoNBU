enum inkType{
    COLORFUL, BLACK_WHITE
}
 
public class PrintingMachine {
    private int maximumPapersCount;
    private int papersCount;
    private int paintedPapers;
 
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
 
    private int getPaintedPapers(){
        return this.paintedPapers;
    }
}