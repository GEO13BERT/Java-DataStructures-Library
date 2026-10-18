package ergasia.erg.p25120.bert.model;
import java.io.Serializable;

public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;
    private LibraryItem item;
    private Member member;
    private String loanDate;
    private String returnDate;
    public static final int DEFAULT_LOAN_DAYS=14; //χρησιμοποιησα επισης το final  ωστε να μην μπορουν να τροποποιηθουν οι ελαχιστες μερες δανεισμου

    public Loan(LibraryItem item, Member member, String loanDate, String returnDate) {
        setItem(item);
        setMember(member);
        setLoanDate(loanDate);
        setReturnDate(returnDate);
    }

    public LibraryItem getItem() {
        return item;

    }

    public Member getMember() {
        return member;
    }

    public String getLoanDate() {
        return loanDate;

    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setItem(LibraryItem item) {
        if (item == null) {
            System.out.println("Το ανυικείμενο δεν επιτρέπεται να είναι κενό.");
        } else {
            this.item = item;
        }

    }

    public void setMember(Member member) {
        if (member == null) {
            System.out.println("Το μέλος δεν επιτρέπεται να είναι κενό.");
        } else {
            this.member = member;
        }
    }
    public void setLoanDate(String loanDate) {
        if(loanDate==null || loanDate.trim().equals("")){
            System.out.println("Η ημερομηνία δανεισμού δεν επιτρέπεται να είναι κενή.");
        }
        else{
            this.loanDate = loanDate;
        }
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}


