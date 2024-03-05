import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.*;

class Result {
    // public static int countNumbers(int bottom, int top, int difference) {
    // int count = 0;
    // if(bottom < 0 || top < 0){
    // return 0;
    // }
    // for (int i = bottom; i <= top; i++) {
    // String numStr = String.valueOf(i);
    // String shifted = numStr.substring(1) + numStr.charAt(0);
    // int shiftedResult = Integer.parseInt(shifted);

    // int currentDiff = shiftedResult - i;
    // if(currentDiff > difference)
    // {
    // count++;
    // }
    // }
    // return count;
    // }
    // public static int sumOfNumbers(int size) {
    // if(size < 1 || size > 9)
    // {
    // return 0;
    // }
    // int ans = 0;
    // for(int i = 1; i < size; i++)
    // {
    // for(int j = i; j <= size; j++)
    // {
    // ans += j;
    // }
    // }
    // ans *= 4;
    // ans += size * 2;
    // return ans;
    // }
    /*
     * 12344321 - 10
     * 234432 - 9
     * 3443 - 7
     * 44 - size * 2
     * 3443
     * 234432
     * 12344321
     */
    static class Manager {
        String name;
        LocalDate hiringDate;

        public Manager(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public LocalDate getHiringDate() {
            return hiringDate;
        }

        public void setHiringDate(LocalDate hiringDate) {
            this.hiringDate = hiringDate;
        }

        public long numberOfYearsInCompanyTill(LocalDate date) {
            return ChronoUnit.YEARS.between(hiringDate, date);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // String name = bufferedReader.readLine();

        int hiringYear = 2021;

        int hiringMonth = 3;
        
        int hiringDay = 4;

        int currentYear = 2024;
        
        int currentMonth = 3;
        
        int currentDay = 5;

        Manager manager = new Manager("Gosho");
        manager.setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay));

        System.out.println(manager.getHiringDate());
        System.out.println(manager.numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay)));

    }

}