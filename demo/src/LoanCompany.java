public class LoanCompany extends Thread {
    private CurrentAccount currentAccount;

    public LoanCompany(CurrentAccount currentAccount,String loanCompany,ThreadGroup group){
        super(group,loanCompany);
        this.currentAccount = currentAccount;
    }

    @Override
    public void run() {
        System.out.println("_______________# |-> LOAN_COMPANY Transactions Begins #_______________");

        for(int i = 0; i < 3; i++){
            Transaction loadDeposit = new Transaction(getName(),45000);
            currentAccount.deposit(loadDeposit);
            System.out.println("# LOAN_COMPANY: Performed deposit transaction " + loadDeposit);

            try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){}
        }
        System.out.println("_______________# ->| LOAN_COMPANY Transactions Ends #_______________");
    }
}
