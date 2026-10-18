package ergasia.erg.p25120.bert.util;

import ergasia.erg.p25120.bert.model.LibraryItem;
import ergasia.erg.p25120.bert.model.Loan;
import ergasia.erg.p25120.bert.model.Member;

public final class ReportGenerator {  // δηλωνω την κλαση αυτη ως final για να μην μπορει να κληρονομηθει απο αλλες κλασεις
    public static void  printItem(LibraryItem item){
        System.out.println("Κωδικός: "+ item.getCode());
        System.out.println("Τίτλος: "+ item.getTitle());
        System.out.println("Έτος: "+ item.getPublicationYear());
    }
    public static void printMember(Member member){
        System.out.println("Όνομα μέλους: "+ member.getName());
        System.out.println("ID μέλους: "+ member.getId());
        System.out.println("E-mail μέλους: "+ member.getEmail());

    }
    public static void printLoan(Loan loan){
        printItem(loan.getItem());
        printMember(loan.getMember());
        System.out.println("Ημερομηνία δανεισμού: "+ loan.getLoanDate());
        System.out.println("Ημερομηνία επιστροφής: "+ loan.getReturnDate());

    }


}
