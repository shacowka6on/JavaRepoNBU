enum PaperType {
    REGULAR, GLOSSY, NEWSPAPER;
}

enum PaperSize {
    A1, A2, A3, A4, A5, A10, A9;
}

public class Paper {
    private PaperType type;
    private PaperSize size;
    private double basePrice;

    public Paper(PaperType type, PaperSize size) {
        this.type = type;
        this.size = size;
        this.basePrice = calculatePaperBasePrice(type, size);
    }

    public PaperType getType() {
        return type;
    }

    public PaperSize getSize() {
        return size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double calculatePaperBasePrice(PaperType type, PaperSize size) {
        double basePriceType;
        double sizeMultiplier;

        switch (type) {
            case REGULAR:
                basePriceType = 10; 
                break;
            case GLOSSY:
                basePriceType = 13; 
                break;
            case NEWSPAPER:
                basePriceType = 16; 
                break;
            default:
                throw new IllegalArgumentException("Unknown paper type");
        }

        switch (size) {
            case A1:
                sizeMultiplier = 6.0;
                break;
            case A2:
                sizeMultiplier = 5.0;
                break;
            case A3:
                sizeMultiplier = 4.0;
                break;
            case A4:
                sizeMultiplier = 3.0;
                break;
            case A5:
                sizeMultiplier = 2.0;
                break;
            default:
                int additionalSizes = Integer.parseInt(size.toString().substring(1)) - 5;
                sizeMultiplier = 2.0 + additionalSizes;
                break;
        }

        return basePriceType * sizeMultiplier;
    }
}
