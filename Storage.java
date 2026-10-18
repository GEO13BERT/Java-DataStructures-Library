package ergasia.erg.p25120.bert.Serialize;
import ergasia.erg.p25120.bert.service.Library;
import java.io.*;

public final class Storage {
    private static final String FILE_NAME="library.ser";

    public static void saveLibrary(Library library){
        try(ObjectOutput oos= new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(library);
            System.out.println("Τα δεδομένα της βιβλιοθήκης αποθηκεύτηκαν επιτυχώς.");
        }catch (IOException e){
            System.out.println("Υπήρξε σφάλμα κατά την αποθήκευση."+e.getMessage());
        }
    }
    public static Library loadLibrary(){
        File file=new File(FILE_NAME);
        if(!file.exists()){
            System.out.println("Δημιουργία νέας βιβλιοθήκης.");
            return null;
        }
        try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(FILE_NAME))){
            Library library=(Library) ois.readObject();
            System.out.println("Τα δεδομένα της βιβλιοθήκης φορτώθηκαν επιτυχώς απο το αρχείο.");
            return library;

        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Σφάλμα κατά την φόρτωση των δεδομένων"+e.getMessage());
            return null;
        }
    }
}
