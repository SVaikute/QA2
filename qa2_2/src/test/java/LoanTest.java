import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanTest {

    @Test
    public void checkTotalLoanSumToPay() {

        double principalAmount = 1000.00;
        double amountToPayExpected = 2336.67;
        int numberOfPayments = 360;

        double principalPayment = calculatePrincipalPayment(principalAmount, numberOfPayments);

        double AmountToBePaid = calculatePaymentForAllPeriod(principalAmount, 0.1, 0.08, 0.06, principalPayment);
        System.out.println("Calculated Amount to be Paid is " + AmountToBePaid);

        double roundedAmountToBePaid = Math. round(AmountToBePaid * 100.0) / 100.0;
        System.out.println("Calculated Rounded Amount to be Paid is " + roundedAmountToBePaid);

        Assertions.assertEquals(amountToPayExpected, roundedAmountToBePaid, "Total Loan Sum to be paid is not correct!");
    }

    public double calculatePrincipalPayment(double principalAmount, int numberOfPayments) {

        return principalAmount / numberOfPayments;
    }

    public double calculateMonthlyInterest(double unpaidBalance, double annualInterestRate) {
        return unpaidBalance * (annualInterestRate / 12);

    }

    public double calculatePaymentForAllPeriod(double unpaidBalance, double annualInterestRate, double annualInterestRate2, double annualInterestRate3, double principalPayment) {
        double payment = 0;
        for (int i = 0; i < 120; i++) {
            payment = payment + principalPayment + calculateMonthlyInterest(unpaidBalance, annualInterestRate);
            unpaidBalance = unpaidBalance - principalPayment;

        }

        for (int i = 0; i < 120; i++) {
            payment = payment + principalPayment + calculateMonthlyInterest(unpaidBalance, annualInterestRate2);
            unpaidBalance = unpaidBalance - principalPayment;

        }

        for (int i = 0; i < 120; i++) {
            payment = payment + principalPayment + calculateMonthlyInterest(unpaidBalance, annualInterestRate3);
            unpaidBalance = unpaidBalance - principalPayment;

        }
        return payment;

    }

}
