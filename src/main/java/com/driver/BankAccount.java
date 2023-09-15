package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
         this.name = name;
         this.balance = balance;
         this.minBalance = minBalance;
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        int remi = sum;
        String acctno = "";
        if(remi*9 < sum){
            throw  new Exception("can not generate account number");
        }
        else {
            while (digits > 0 && remi > 0){
                if(remi >= 9){
                    remi = remi - 9;
                    acctno += "9";
                }else {
                    acctno = acctno + Integer.toString(remi);
                    remi = 0;
                }
                digits --;
            }
            while (digits > 0){
                acctno += "0";
                digits--;
            }

            return acctno;
        }

//        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance = balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

           if (this.balance - amount >= getMinBalance()){
               balance = balance - amount;
           }else {
               throw new Exception("insufficient balance");
           }
    }

}