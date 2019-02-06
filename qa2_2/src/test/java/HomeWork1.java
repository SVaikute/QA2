import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWork1 {

    @Test
    public void checkTotalLoanSumToPay() {
        double principalAmount = 1000.00;
        double amountToPayExpected = 3400.00;

        double amountToPayCalculated = calculatePrincipalAmountToPay(principalAmount) + principalAmount;

        System.out.println("Calculated Amount is " + amountToPayCalculated);

        Assertions.assertEquals(amountToPayExpected, amountToPayCalculated, "Total Loan Sum is not correct!");

    }

    private double calculatePrincipalAmountToPay(double amountClientNeeds) {

        double payFirstDecade = calculateInterestRate(10, 10) * amountClientNeeds;
        double paySecondDecade = calculateInterestRate(8, 10) * amountClientNeeds;
        double payThirdDecade = calculateInterestRate(6, 10) * amountClientNeeds;

        double principalAmountToPay = payFirstDecade + paySecondDecade + payThirdDecade;

        return principalAmountToPay;
    }

    private double calculateInterestRate(double interestRate, int years) {

        double calculateInterestRate = (interestRate/100) * years;

        return calculateInterestRate;
    }

}
