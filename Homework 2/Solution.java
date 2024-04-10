class Solution{
    static class Manufacturer{
        String ManufacturerName;
        boolean IsLongTermWarranty;

        public Manufacturer(String name, boolean isLongTermWarranty) {
            this.ManufacturerName = name;
            this.IsLongTermWarranty = isLongTermWarranty;
        }
    }
    
    static class ElectricDevice {
        Manufacturer Manufacturer;
        int MinWarranty;
        
        public ElectricDevice(Manufacturer manufacturer, int minWarranty){
            this.Manufacturer = manufacturer;
            this.MinWarranty = minWarranty < 6 ? 6 : minWarranty;
        }
        public int warranty(){
            return Manufacturer.IsLongTermWarranty ? MinWarranty + 12 : MinWarranty;
        }
    }
    static class Cooker extends ElectricDevice{
        boolean IsGas;
        
        public Cooker(Manufacturer manufacturer, int minWarranty, boolean isGas) {
            super(manufacturer, minWarranty);
            this.IsGas = isGas;
        }

        public int warranty(){
            return IsGas ? super.warranty() + 12 : super.warranty();
        }
    }
    static class WashingMachine extends ElectricDevice{
        boolean IsDryer;
        
        public WashingMachine(Manufacturer manufacturer, int minWarranty, boolean isDryer) {
            super(manufacturer, minWarranty);
            this.IsDryer = isDryer;
        }

        public int warranty(){
            return IsDryer ? super.warranty() + (int)(0.5 * super.MinWarranty) : super.warranty();
        }
    }
        /*------------------------------Method used for testing------------------------------*/
    public static void main(String[] args) {
        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = false;
        int minWarranty = 3;
        boolean isGas = true;
        boolean isDryer = true; 

        // Create object of type Manufacturer using the constructor with two parameters. 
        // Pass manufacturerName and isLongTermWarranty as arguments
        Manufacturer manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);

        // Create object of type ElectricDevice using the constructor with 2 parameters. 
        // Pass manufacturer and minWarranty as arguments 
        ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);
       
        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // Assign the electricDevice a new object of type Cooker using the constructor with 3 parameters. 
        //Pass manufacturer, price and minWarranty as arguments 
        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        // Print on the console the warranty of the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // Assign the electricDevice a new object of type WashingMachine using the constructor with 3 parameters. 
        // Pass manufacturer, price and minWarranty as arguments 
        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());
    }
}
/*------------------------------Method used in Hackerrank------------------------------
     * public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String manufacturerName = bufferedReader.readLine();

        boolean isLongTermWarranty = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        int minWarranty = Integer.parseInt(bufferedReader.readLine().trim());

        boolean isGas = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        boolean isDryer = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        // Create object of type Manufacturer using the constructor with two parameters. 
        // Pass manufacturerName and isLongTermWarranty as arguments
        Manufacturer manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);

        // Create object of type ElectricDevice using the constructor with 2 parameters. 
        // Pass manufacturer and minWarranty as arguments 
        ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);
       
        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // Assign the electricDevice a new object of type Cooker using the constructor with 3 parameters. 
        //Pass manufacturer, price and minWarranty as arguments 
        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        // Print on the console the warranty of the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // Assign the electricDevice a new object of type WashingMachine using the constructor with 3 parameters. 
        // Pass manufacturer, price and minWarranty as arguments 
        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());
        bufferedReader.close();
    }
     */
