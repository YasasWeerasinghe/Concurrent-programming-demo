public class University extends Thread {
    private CurrentAccount currentAccount;

    public University(CurrentAccount currentAccount,String university,ThreadGroup group){
        super(group,university);
        this.currentAccount=currentAccount;
    }

    @Override
    public void run() {
        System.out.println("_______________# |-> UNIVERSITY Transactions Begins #_______________");

        for(int i = 0; i < 3; i++){
            Transaction uniWithdrawal = new Transaction(getName(),35000);
            currentAccount.withdrawal(uniWithdrawal);
            System.out.println("# UNIVERSITY: Performed withdrawal transaction " + uniWithdrawal);

            try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){}
        }
        System.out.println("_______________# ->| UNIVERSITY Transactions Ends #_______________");
    }
}
