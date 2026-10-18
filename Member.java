package ergasia.erg.p25120.bert.model;
import java.io.Serializable;

public abstract class  Member implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;
    protected int maxNumber; // χρησιμοποιησα το protected ωστε η μεταβλητη να μπορει να χρησιμοποιηθει μονο απο τις υποκλασεις της κλασης Member
    public Member(String id, String name, String email,int maxNumber){
        setId(id);
        setName(name);
        setEmail(email);
        setMaxNumber(maxNumber);


    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getMaxNumber(){
        return maxNumber;
    }
    public void setId(String id){
        if(id==null || id.trim().equals("")){// ελεγχος το id να μην ειναι κενο
            System.out.println("Το ID δεν επιτρέπεται να είναι κενό.");

        }
        else{
            this.id=id;
        }
    }
    public void setName(String name){
        if(name==null || name.trim().equals("")){
            System.out.println("Το όνομα δεν επιτρέπεται να είναι κενό.");

        }
        else{
            this.name=name;
        }
    }
    public void setEmail(String email){
        if(email==null || email.trim().equals("")|| !email.contains("@")){// ελεγχος εγκυροτητας που ζητηθηκε στην εκφωνηση δηλαδη να περιεχει υποχρεωτικα τον χαρακτηρα @
            System.out.println("Το E-Mail πρέπει να περιέχει το σύμβολο @ και να μην είναι κενό.");
        }
        else{
            this.email=email;
        }

    }
    public void setMaxNumber(int maxNumber){
        if(maxNumber<0){
            System.out.println("Ο μέγιστος αριθμός δανεισμών δεν επιτρέπεται να είναι αρνητικός αριθμός.");
        }
        else{
            this.maxNumber=maxNumber;
        }
    }
}
