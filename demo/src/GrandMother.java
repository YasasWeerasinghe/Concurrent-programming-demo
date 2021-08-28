public class GrandMother extends Thread {
    private CurrentAccount currentAccount;

    public GrandMother(CurrentAccount currentAccount, String grandMother, ThreadGroup group){
        super(group,grandMother);
        this.currentAccount = currentAccount;
    }

    @Override
    public void run(){
        System.out.println("_______________# |-> GRAND_MOTHER Transactions Begins #_______________");

        Transaction birthdayDeposit = new Transaction(getName(),1500);
        currentAccount.deposit(birthdayDeposit);
        System.out.println("# GRAND_MOTHER: Performed deposit transaction " + birthdayDeposit);

        try{
            sleep((int)(Math.random()* 100));
        }catch (InterruptedException e){}

        Transaction chritmasDeposit = new Transaction(getName(),800);
        currentAccount.deposit(chritmasDeposit);
        System.out.println("# GRAND_MOTHER: Performed deposit transaction" + chritmasDeposit);
        System.out.println("_______________# ->| GRAND_MOTHER Transactions Ends #_______________");
    }

}
