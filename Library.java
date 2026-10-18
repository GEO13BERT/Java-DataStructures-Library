package ergasia.erg.p25120.bert.service;

import ergasia.erg.p25120.bert.contracts.Searchable;
import ergasia.erg.p25120.bert.model.LibraryItem;
import ergasia.erg.p25120.bert.model.Loan;
import ergasia.erg.p25120.bert.model.Member;
import ergasia.erg.p25120.bert.util.ReportGenerator;

import java.util.ArrayList;
import java.io.Serializable;


public class  Library implements Searchable,Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<LibraryItem> items;  //εδω χρησιμοποιω τον πολυμορφισμο καθως η λιστα items αποθηκευει καθε αντικειμενο που κληρονομει απο την LibraryItem
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;
    public Library(){
        items=new ArrayList<>();
        members= new ArrayList<>();
        loans=new ArrayList<>();
    }
    public void addItem(LibraryItem item){
        if(item==null){
            System.out.println("Το αντικείμενο είναι κενό.");
            return;
        }
        else{
            items.add(item);
        }
    }
    public void addMember(Member member){
        if(member==null){
            System.out.println("Το μέλος είναι κενό.");
            return;
        }
        else{
            members.add(member);
        }
    }
    public void addLoan(Loan loan){
        if(loan==null){
            System.out.println("Ο δανεισμός είναι κενός.");
        }
        else{
            loans.add(loan);
        }
    }

    public LibraryItem findItemByCode(String code){
        for(int i=0; i<items.size(); i++){
            LibraryItem item=items.get(i);
            if(item.getCode().equals(code)){
                return item;
            }
        }
        return null;
    }
    public Member findMemberById(String id){
        for(int i=0; i<members.size(); i++){
            Member member=members.get(i);
            if(member.getId().equals(id)){
                return member;
            }
        }
        return null;
    }

    public void showLoans(){
        for(int i=0; i<loans.size(); i++){
            Loan loan=loans.get(i);
            if(loan.getReturnDate().equals("Εκρεμμεί")){
                ReportGenerator.printLoan(loan);
            }
        }
    }
    public void showStatistics(){
        System.out.println("Συνολικά αντικείμενα που δημιουργήθηκαν: "+LibraryItem.getTotalItems());
        System.out.println("Συνολικός αριθμός αντικειμένων τώρα: "+ items.size());
        System.out.println("Συνολικός αριθμός μελών: "+ members.size());
        int count=0;
        for (int i=0; i<loans.size(); i++){
            Loan loan=loans.get(i);
            if(loan.getReturnDate()=="Εκρεμμεί"){
                count++;
            }
        }

        System.out.println("Ενεργοί δανεισμοί: "+ count);
    }

}
