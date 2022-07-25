package baemin.june;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] arg = {"01/01 4 50000", "01/11 6 3555", "02/01 0 -23555", "02/25 5 5000", "03/25 0 -15000", "06/09 8 43951", "12/30 9 99999"};
        String[] arg = {"04/01 1 40000", "05/01 5 20000", "08/31 4 10000", "11/11 0 -45000"};
        System.out.println(solution.solution(arg));
    }
    static class Solution {
        public int solution(String[] ledgers) {
            Stack<Ledger> ledgerStack = new Stack<>();
            int rateSum = 0;
            for (String ledgerString : ledgers) {
                String[] splits = ledgerString.split(" ");
                String[] monthDayStringArray = splits[0].split("/");
                MonthDay monthDay = MonthDay.of(Integer.parseInt(monthDayStringArray[0]), Integer.parseInt(monthDayStringArray[1]));
                int rate = Integer.parseInt(splits[1]);
                BankType bankType = BankType.fromRate(rate);
                int money = Integer.parseInt(splits[2]);
                if (bankType.isWithdraw()) {
                    money *= -1;
                }
                Ledger ledger = new Ledger(monthDay, bankType, money, rate);
                if (bankType.isWithdraw()) {
                    rateSum += calculateRateMoney(ledgerStack, ledger);
                } else {
                    ledgerStack.add(ledger);
                }
            }

            rateSum += ledgerStack.stream()
                    .mapToInt(ledger -> ledger.calculateRateMoney(MonthDay.of(12, 31)))
                    .sum();
            return rateSum;
        }



        private int calculateRateMoney(Stack<Ledger> ledgerStack, Ledger withdraw) {
            int rateMoney = 0;
            while (ledgerStack.size() > 0) {
                Ledger deposit = ledgerStack.pop();
                if (deposit.isEnoughWithdraw(withdraw.getMoney())) {
                    rateMoney += deposit.calculateRateMoney(withdraw.getMonthDay(), withdraw.getMoney());
                    int moneyLeft = deposit.getMoney() - withdraw.getMoney();
                    if (moneyLeft != 0) {
                        ledgerStack.add(new Ledger(deposit, moneyLeft));
                    }
                    return rateMoney;
                }
                rateMoney += deposit.calculateRateMoney(withdraw.getMonthDay(), deposit.getMoney());
                withdraw.withdrawMoney(deposit.getMoney());
            }
            return rateMoney;
        }

        class Ledger{
            private MonthDay monthDay;
            private BankType bankType;
            private int money;
            private int rate;

            public boolean isEnoughWithdraw(int withdrawMoney) {
                if (this.money >= withdrawMoney) {
                    return true;
                }
                return false;
            }

            public int getMoney() {
                return money;
            }

            public MonthDay getMonthDay() {
                return monthDay;
            }

            public BankType getBankType() {
                return bankType;
            }

            public int getRate() {
                return rate;
            }

            public Ledger(Ledger ledger, int money) {
                this(ledger.getMonthDay(), ledger.getBankType(), money, ledger.getRate());
            }

            public Ledger(MonthDay monthDay, BankType bankType, int money, int rate) {
                this.monthDay = monthDay;
                this.bankType = bankType;
                this.money = money;
                this.rate = rate;
            }

            public int calculateRateMoney(MonthDay withdrawMonthDay, int withdrawMoney) {
                LocalDate withdrawLocalDate = withdrawMonthDay.atYear(2022);
                LocalDate localDate = this.getMonthDay().atYear(2022);

                long withdrawLength = withdrawLocalDate.toEpochDay() - localDate.toEpochDay();
                return (int) (withdrawMoney * this.getRate() * 0.01 * (withdrawLength)) / 365;
            }

            public int calculateRateMoney(MonthDay withdrawMonthDay) {
                return calculateRateMoney(withdrawMonthDay, this.getMoney());
            }
            public void withdrawMoney(int withdraw) {
                this.money = this.money - withdraw;
            }
        }

        enum BankType{
            DEPOSIT, WITHDRAW;

            public static BankType fromRate(int rate){
                if (rate == 0) {
                    return WITHDRAW;
                }
                return DEPOSIT;
            }

            public boolean isWithdraw(){
                if (this.equals(WITHDRAW)) {
                    return true;
                }
                return false;
            }
        }
    }
}
