import java.math.BigDecimal;
import java.math.RoundingMode;
class Result {
    // ------------------ Task1 ------------------
    // public static int countNumbers(int bottom, int top, int difference) {
    //     int count = 0;
    //     if (bottom < 0 || top < 0) {
    //         return 0;
    //     }
    //     for (int i = bottom; i <= top; i++) {
    //         String numStr = String.valueOf(i);
    //         String shifted = numStr.substring(1) + numStr.charAt(0);
    //         int shiftedResult = Integer.parseInt(shifted);

    //         int currentDiff = shiftedResult - i;
    //         if (currentDiff > difference) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // //------------------ Task2 ------------------
    // public static int sumOfNumbers(int size) {
    //     if (size < 1 || size > 9) {
    //         return 0;
    //     }
    //     int ans = 0;
    //     for (int i = 1; i < size; i++) {
    //         for (int j = i; j <= size; j++) {
    //             ans += j;
    //         }
    //     }
    //     ans *= 4;
    //     ans += size * 2;
    //     return ans;
    // }
    // /*
    //  * 12344321 - 10
    //  *  234432 - 9
    //  *   3443 - 7
    //  *    44 - size * 2
    //  *   3443
    //  *  234432
    //  * 12344321
    //  */
    // ------------------ Task3 ------------------
    // static class Manager {
    //     String name;
    //     LocalDate hiringDate;

    //     public Manager(String name) {
    //         this.name = name;
    //     }

    //     public String getName() {
    //         return name;
    //     }

    //     public LocalDate getHiringDate() {
    //         return hiringDate;
    //     }

    //     public void setHiringDate(LocalDate hiringDate) {
    //         this.hiringDate = hiringDate;
    //     }

    //     public long numberOfYearsInCompanyTill(LocalDate date) {
    //         return ChronoUnit.YEARS.between(hiringDate, date);
    //     }
    // }

    // public static void main(String[] args) throws IOException {
    //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //     String name = "Gosho";
    //     int hiringYear = 2021;
    //     int hiringMonth = 3;
    //     int hiringDay = 4;
    //     int currentYear = 2024;
    //     int currentMonth = 3;
    //     int currentDay = 5;
    //     Manager manager = new Manager(name);
    //     manager.setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay));

    //     System.out.println(manager.getHiringDate());
    //     System.out.println(manager.numberOfYearsInCompanyTill(LocalDate.of(currentYear,
    //             currentMonth, currentDay)));
    // }
    //------------------ Task4 ------------------
    public static class Studio {
        private long id;
        private BigDecimal pricePerHour;
        private int maxWorkingHours;
        private int rentedHours;
        private BigDecimal minPricePerHour;
        private BigDecimal currencyEuro;

        public Studio(long id, int maxWorkingHours) {
            this.id = id;
            this.maxWorkingHours = (maxWorkingHours >= 0 && maxWorkingHours <= 24) ? maxWorkingHours : 24;
            this.rentedHours = 0;
        }

        public void setMinPricePerHour(double minPricePerHour) {
            this.minPricePerHour = (minPricePerHour >= 0) ? BigDecimal.valueOf(minPricePerHour) : BigDecimal.ZERO;
        }

        public void setPricePerHour(double pricePerHour) {
            BigDecimal price = BigDecimal.valueOf(pricePerHour);
            if (minPricePerHour == null) {
                minPricePerHour = BigDecimal.ZERO;
            }
            this.pricePerHour = (price.compareTo(minPricePerHour) >= 0) ? price : minPricePerHour;
        }

        public void setRentedHours(int rentedHours) {
            this.rentedHours = (rentedHours <= maxWorkingHours) ? rentedHours : maxWorkingHours;
        }

        public void setCurrencyEuro(double currencyEuro) {
            this.currencyEuro = BigDecimal.valueOf(currencyEuro);
        }

        public long getId() {
            return id;
        }

        public BigDecimal getPricePerHour() {
            return pricePerHour;
        }

        public int getMaxWorkingHours() {
            return maxWorkingHours;
        }

        public int getRentedHours() {
            return rentedHours;
        }

        public BigDecimal getMinPricePerHour() {
            return minPricePerHour;
        }

        public BigDecimal getCurrencyEuro() {
            return currencyEuro;
        }

        public BigDecimal calculateTurnoverInLev() {
            return pricePerHour.multiply(BigDecimal.valueOf(rentedHours));
        }

        public BigDecimal calculateTurnoverInEuro() {
            return pricePerHour.multiply(BigDecimal.valueOf(rentedHours))
            .divide(currencyEuro, 2, RoundingMode.HALF_UP);
        }

        public static Studio compareByPricePerHour(Studio studio1, Studio studio2) {
            return (studio1.getPricePerHour().compareTo(studio2.getPricePerHour()) >= 0) ? studio2 : studio1;
        }

        public static boolean isFirstStudioWithGreaterTurnover(Studio studio1, Studio studio2) {
            return studio1.calculateTurnoverInLev().compareTo(studio2.calculateTurnoverInLev()) > 0;
        }
    }

    public static void main(String[] args) {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //Both studios
        double minPricePerHour = 100;
        double currencyEuro = 0.51;
        
        long id = 1L;
        int maxWorkingHours = 24;
        double pricePerHour = 120;
        int workedHours = 15;
        
        Studio studioTest = new Studio(id,maxWorkingHours);
        studioTest.setMinPricePerHour(minPricePerHour); 

        //User variable minPricePerHour to pass it as a method argument.
        studioTest.setMinPricePerHour(minPricePerHour);
        // Use set method to set the Euro currency. Pass currencyEuro to the set method.
        studioTest.setCurrencyEuro(currencyEuro);
        // Use set method to set the price for renting the studio for one hour. Pass pricePerHour to the set method.
        studioTest.setPricePerHour(pricePerHour);
        // Use set method to set the number of hours for the day that the studio was rented.
        studioTest.setRentedHours(workedHours);
        // Print on the console the turnover in lv., calculated by using workedHours and pricePerHour.
        int studioWorkedHours = studioTest.getRentedHours();
        BigDecimal studioPricePerHour = studioTest.getPricePerHour();
        BigDecimal turnover = studioPricePerHour.multiply(BigDecimal.valueOf(studioWorkedHours));
        System.out.println(turnover);
        // Print on the console the turnover in Euro., calculated by using workedHours and pricePerHour.
        BigDecimal euro = studioTest.getCurrencyEuro();
        BigDecimal turnoverConverted = turnover.multiply(euro);
        System.out.println(turnoverConverted);

        long id2 = 2L;
        int maxWorkingHours2 = 20;
        double pricePerHour2 = 120;
        int workedHours2 = 15;

        // Create the second object of type Studio, using the constructor with 2 parameters. 
        // Use id2 and maxWorkingHours2 to pass them as arguments
        Studio studioTest2 = new Studio(id2, maxWorkingHours2);
        // Use set method to set the price for renting the second studio for one hour. 
        // Pass pricePerHour2 to the set method.
        studioTest2.setPricePerHour(pricePerHour2);
        // Use set method to set the number of hours for the day that the second studio was rented (workedHours2)
        studioTest2.setRentedHours(workedHours2);
        // Print on the console the result of getting the id of the studio that is returned as a result of the 
        // studioWithLargerPrice() method. The first studio object is used to call the method.
        Studio largerPriceStudio = Studio.compareByPricePerHour(studioTest, studioTest2);
        System.out.println(largerPriceStudio.getId());
        // Check which studio has a greater turnover
        boolean isFirstStudioGreaterTurnover = Studio.isFirstStudioWithGreaterTurnover(studioTest, studioTest2);
        System.out.println(isFirstStudioGreaterTurnover);
        
    }
}