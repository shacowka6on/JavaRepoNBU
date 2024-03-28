
interface Deliverable {
    double deliveryPrice();
}

abstract class DeliverableItem implements Deliverable {
    boolean deliveryToClient;
    static double AdditionalPrice;

    public DeliverableItem(boolean deliveryToClient) {
        this.deliveryToClient = deliveryToClient;
    }

    void setAdditionalPrice(double additionalPrice) {
        additionalPrice = additionalPrice < 1 ? 1 : additionalPrice;
        DeliverableItem.AdditionalPrice = additionalPrice;
    }

    public double deliveryPrice() {
        return DeliverableItem.AdditionalPrice;
    }
}

class Material {
    String Name;
    boolean IsFragile;

    public Material(String name, boolean isFragile) {
        this.Name = name;
        this.IsFragile = isFragile;
    }

    public boolean IsTheItemFragile() {
        return IsFragile;
    }
}

class WeightedItem extends DeliverableItem {
    Material Material;
    double Weight;
    double PricePerKg;

    public WeightedItem(Material material, double weight, double pricePerKg, double additionalPrice,
            boolean deliveryToClient) {
        super(deliveryToClient);
        this.Material = material;
        this.Weight = weight < 1 ? 1 : weight;
        this.PricePerKg = pricePerKg < 1 ? 1 : pricePerKg;
    }

    @Override
    public double deliveryPrice() {
        double DeliveryPrice = Weight * PricePerKg;
        if (deliveryToClient) {
            DeliveryPrice += super.deliveryPrice();
        }
        if (Material.IsFragile) {
            DeliveryPrice *= 1.01;
        }
        return DeliveryPrice;
    }
}

class Document extends DeliverableItem {
    double minPrice;

    public Document(double minPrice, boolean deliveryToClient) {
        super(deliveryToClient);
        this.minPrice = minPrice < 1 ? 1 : minPrice;
    }

    @Override
    public double deliveryPrice() {
        return deliveryToClient ? minPrice + AdditionalPrice : minPrice;
    }
}

/*------------------------------Method used for testing------------------------------*/
class Solution {
    public static void main(String[] args) {
        String materialName = "Timber";
        boolean isFragile = true;
        boolean toClientsAddress = false;
        double minPrice = 5;
        double weight = 10;
        double pricePerKg = 1.5;
        double additionalPrice = 2;

        // Create an object of type Material using the constructor with two parameters.
        // Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        // Use the reference of type Deliverable to create an object of type Document.
        // Use toClientsAddress and minPrice to the constructor of the Document.
        DeliverableItem deliverable = new Document(minPrice, toClientsAddress);
        deliverable.setAdditionalPrice(additionalPrice);
        // Print on the console the result of calling the deliveryPrice() method:
        // the method that has to return the total shipping price for the delivery.
        System.out.println(deliverable.deliveryPrice());

        // Use the reference of type Deliverable to create an object of type
        // WeightedItem.
        // Use weight and pricePerKg to pass them to the constructor of the
        // WeightedItem.
        Deliverable weightedDeliverable = new WeightedItem(material, weight, pricePerKg, additionalPrice,
                toClientsAddress);

        // Print on the console the result of calling the deliveryPrice() method:
        // the method that has to return the total shipping price for the delivery.
        System.out.println(weightedDeliverable.deliveryPrice());
    }

    /*------------------------------Method used in Hackerrank------------------------------
     public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
        String materialName = bufferedReader.readLine();
    
        boolean isFragile = Integer.parseInt(bufferedReader.readLine().trim()) != 0;
    
        boolean toClientsAddress = Integer.parseInt(bufferedReader.readLine().trim()) != 0;
    
        double minPrice = Double.parseDouble(bufferedReader.readLine().trim());
    
        double weight = Double.parseDouble(bufferedReader.readLine().trim());
    
        double pricePerKg = Double.parseDouble(bufferedReader.readLine().trim());
    
        double additionalPrice = Double.parseDouble(bufferedReader.readLine().trim());
    
        // Use the set method to give the value additionalPrice to the additional price when the shipment 
        // has to be delivered to the client's address.
    
        // Create an object of type Material using the constructor with two parameters.
        // Pass materialName and isFragile as arguments.
    
        // Create a reference of type Deliverable.
    
        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
    
        // Print on the console the result of calling the deliveryPrice() method: the method that has to return the total shipping price for the delivery.
    
        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
    
        // Print on the console the result of calling the deliveryPrice() method: the method that has to return the total shipping price for the delivery.
    
        bufferedReader.close();
    }
    }
    
     */
}