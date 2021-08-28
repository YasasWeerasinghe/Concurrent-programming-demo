public class BankingSystem {
    Student student;
    GrandMother grandMother;
    LoanCompany loanCompany;
    University university;
    CurrentAccount currentAccount;
    ThreadGroup human;
    ThreadGroup nonHuman;

    public BankingSystem(){
        this.currentAccount = new CurrentAccount("Rex",1010,0);
        this.student = new Student(currentAccount,currentAccount.getAccountHolder(),human);
        this.grandMother = new GrandMother(currentAccount,"Grand Mother", human);
        this.loanCompany = new LoanCompany(currentAccount,"AA Loan",nonHuman);
        this.university = new University(currentAccount,"Y University",nonHuman);

        this.human = new ThreadGroup("Human");
        this.nonHuman = new ThreadGroup("Non Human");
    }

    public static void main(String[] args){

        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.student.start();
        bankingSystem.grandMother.start();
        bankingSystem.loanCompany.start();
        bankingSystem.university.start();

        try{
            bankingSystem.student.join();
            bankingSystem.grandMother.join();
            bankingSystem.loanCompany.join();
            bankingSystem.university.join();
        }catch (InterruptedException e){}

    }


}

