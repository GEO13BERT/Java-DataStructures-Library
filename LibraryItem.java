package ergasia.erg.p25120.bert.model;

import ergasia.erg.p25120.bert.contracts.Borrowable;
import java.io.Serializable;

public abstract class LibraryItem implements Borrowable, Serializable { // Δηλώνεται ως abstract καθως θελω να δημιουργω γενικα αντικειμενα και οχι συγκεκριμενα
    private static final long serialVersionUID = 1L;
    private String code;
    private String title;
    private int PublicationYear;
    private boolean isAvailable;
    private static int totalItems=0; // χρησιμοποιησα το static το οποιο ανηκει μονο σε αυτην την κλαση και οχι σε καθε αντικειμενο και με βαση αυτην μετραω το ποσα αντικειμενα δημιουργηθηκαν συνολικα
    public LibraryItem(String code,String title,int PublicationYear,boolean isAvailable){
        setCode(code);
        setTitle(title);
        setIsAvailable(isAvailable);
        setPublicationYear(PublicationYear);
        totalItems++;
    }
    public String getCode(){
        return code;

    }
    public String getTitle(){
        return title;
    }
    public int getPublicationYear(){
        return PublicationYear;

    }
    public static int getTotalItems(){
        return totalItems;
    }
    public boolean isAvailable(){

        return isAvailable;
    }
    public void setCode(String code){
        if(code==null || code.trim().equals("") ){// ελεγχος ο κωδικος του υλικου να μην ειναι κενος οπως ζητηθηκε στην εκφωνηση
            System.out.println("Ο κωδικός δεν επιτρέπεται να είναι κενός");
        } else{
            this.code=code;
        }
    }
    public void setTitle(String title){
        if(title==null || title.trim().equals("")){
            System.out.println("Ο τίτλος δεν επιτρέπεται να είναι κενός");
        } else {
            this.title = title;
        }
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable=isAvailable;
    }
    public void setPublicationYear(int PublicationYear){
        if(PublicationYear<=0 || PublicationYear>2026){//ελεγχος το ετος εκδοσης να ειναι θετικος αριθμος και να μην ξεπερναει το τρεχον ετος
            System.out.println("Το έτος έκδοσης πρέπει να μην ξεπερνάει το τρέχον έτος και να είναι θετικό ");

        }
        else{
            this.PublicationYear=PublicationYear;
        }
    }

    public boolean borrowTo(Member member){
        if(isAvailable==true){//ελεγος εαν το βιβλιο δεν ειναι δανεισμενο αλλιως δεν πραγματοποιειται δανεισμος
            System.out.println("Επιτυχής δανεισμός.");
            isAvailable=false;
            return true;
        }
        else{
            System.out.println("Το αντικείμενο είναι ήδη δανεισμένο.");
            return false;
        }

    }
    public boolean returnItem(){
        if(isAvailable==false){
            System.out.println("Επιτυχής επιστροφή του αντικειμένου.");
            isAvailable=true;
            return true;
        }
        else{
            System.out.println("Το αντικείμενο δεν είχε δανειστεί.");
            return false;
        }
    }

    public abstract String getInformation();

    boolean isValidCode(String code){  // χρησιμοποιησα εδω την package-private μεθοδο ετσι ωστε αυτη να ειναι προσβασιμη μονο απο κλασεις του ιδιου package δηλαδη του model
        boolean flag=true;
        if (code == null || code.trim().equals("")) {
            flag=false;

        }
        return flag;
    }



}
