package ergasia.erg.p25120.bert;


import ergasia.erg.p25120.bert.model.*;
import ergasia.erg.p25120.bert.contracts.Reviewable;
import ergasia.erg.p25120.bert.service.Library;
import ergasia.erg.p25120.bert.Serialize.Storage;

import java.util.Scanner;

public  class Main{
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int choice;
        Library library = Storage.loadLibrary();
        if(library == null){
            library = new Library();
        }

        do {
            System.out.println("=== University Library ===");
            System.out.println("1. Προσθήκη υλικού βιβλιοθήκης.");
            System.out.println("2. Προσθήκη μέλους.");
            System.out.println("3. Αναζήτηση υλικού βιβλιοθήκης.");
            System.out.println("4. Δανεισμός υλικού βιβλιοθήκης.");
            System.out.println("5. Επιστροφή υλικού βιβλιοθήκης.");
            System.out.println("6. Εμφάνιση ενεγών δανεισμών.");
            System.out.println("7. Στατιστικά βιβλιοθήκης.");
            System.out.println("8. Αξιολόγηση υλικού βιβλιοθήκης.");
            System.out.println("0. Έξοδος.");
            System.out.print("Παρακαλώ επιλέξτε λειτουργία:");
            choice = scanner.nextInt();
            System.out.println("Επιλέξατε την λειτουργία:" + choice);
            if(choice==1){
                scanner.nextLine();
                System.out.println("Επιλέξτε υλικό που επιθυμείτε να προσθεθέι.");
                System.out.println("1. Βιβλίο.");
                System.out.println("2. Ψηφιακό Βιβλίο.");
                System.out.println("3. Ηχητικό βιβλίο");
                System.out.println("4. Περιοδικό");
                System.out.println("5. Εφημερίδα.");
                System.out.println("Παρακαλώ επιλέξτε.");
                int type=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Παρακαλώ να δωθέι ο κωδικός.");
                String code=scanner.nextLine();
                System.out.println("Παρσκσλώ να δοθεί ο τίτλος.");
                String title=scanner.nextLine();
                System.out.println("Παρακαλώ να δωθεί το έτος έκδοσης.");
                int year=scanner.nextInt();
                scanner.nextLine();
                if (type == 1) {
                    System.out.println("Παρακαλώ να δοθεί συγγραφέας.");
                    String author=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί ISBN");
                    String ISBN=scanner.nextLine();
                    Book newBook=new  Book(code,title,year,true,author,ISBN);
                    library.addItem(newBook);
                    System.out.println("Το νέο βιβλίο εισάχθηκε με επιτυχία.");
                }
                else if (type==2){
                    System.out.println("Παρακαλώ να δοθεί συγγραφέας.");
                    String author=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί ISBN");
                    String ISBN=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί το μέγεθος.(σε δεκαδική μορφή)");
                    float size=scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί ο τύπος.");
                    String Type=scanner.nextLine();
                    DigitalBook newDigitalBook=new DigitalBook(code,title,year,true,author,ISBN,size,Type);
                    library.addItem(newDigitalBook);
                    System.out.println("Το ψηφιακό βιβλίο εισάχθηκε με επιτυχία.");

                }
                else if(type==3){
                    System.out.println("Παρακαλώ να δοθεί συγγραφέας.");
                    String author=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί ISBN");
                    String ISBN=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί αφηγητής.");
                    String narrator=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί διάρκεια.(σε λεπτά)");
                    int duration=scanner.nextInt();
                    AudioBook newAudioBook=new AudioBook(code,title,year,true,author,ISBN,narrator,duration);
                    library.addItem(newAudioBook);
                    System.out.println("Το ηχητικό βιβλίο εισάχθηκε με επιτυχία");
                }
                else if(type==4){
                    System.out.println("Παρακαλώ να δωθέι αριθμός τεύχους.");
                    int number=scanner.nextInt();
                    Magazine newMagazine=new Magazine(code,title,year,true,number);
                    library.addItem(newMagazine);
                    System.out.println("Το περιοδικό προστέθηκε με επιτυχία.");
                }
                else if(type==5){
                    System.out.println("Παρακαλώ να δωθεί εκδότης.");
                    String publisher=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθεί συχνότητα έκδοσης");
                    String regularity=scanner.nextLine();
                    Newspaper newNewspaper=new Newspaper(code,title,year,true,publisher,regularity);
                    library.addItem(newNewspaper);
                    System.out.println("Η εφημερίδα εισάχθηκε με επιτυχία.");


                }





            }
            else if(choice==2){
                scanner.nextLine();
                System.out.println("Παρακαλώ να δωθέι τύπος μέλους.");
                System.out.println("1. Καθηγητής.");
                System.out.println("2. Φοιτητής.");
                System.out.println("Παρακαλώ επιλέξτε.");
                int type=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Παρακαλώ να δωθέι ID");
                String id=scanner.nextLine();
                System.out.println("Παρακαλώ να δωθέι Όνοματεπώνυμο");
                String name=scanner.nextLine();
                System.out.println("Παρακαλώ να δωθεί E-mail.");
                String email=scanner.nextLine();
                System.out.println("Παρακαλώ να δωθεί μέγιστος αριθμός δανεισμών.");
                int number=scanner.nextInt();
                scanner.nextLine();
                if(type==1){
                    System.out.println("Παρακαλώ να δωθεί γνωστικό αντικείμενο.");
                    String subject=scanner.nextLine();
                    ProfessorMember newProfessor=new ProfessorMember(id,name,email,number,subject);
                    library.addMember(newProfessor);
                    System.out.println("Ο καθηγήτης προστέθηκε με επιτυχία.");
                }
                else if(type==2){
                    System.out.println("Παρακαλώ να δοθέι Αριθμός Μητρώου.");
                    String AM=scanner.nextLine();
                    System.out.println("Παρακαλώ να δωθέι Τμήμα σπουδών.");
                    String department=scanner.nextLine();
                    StudentMember newStudent=new StudentMember(id,name,email,number,AM,department);
                    library.addMember(newStudent);
                    System.out.println("Ο φοιτητής προστέθηκε με επιτυχία");
                }
            }
            else if(choice==3){
                scanner.nextLine();
                System.out.println("Επιλέξτε τι θέλετε να αναζητήσετε.");
                System.out.println("1. Αντικείμενο βιβλιοθήκης.");
                System.out.println("2. Μέλος βιβλιοθήκης.");
                System.out.println("Παρακαλώ επιλέξτε.");
                int type=scanner.nextInt();
                scanner.nextLine();
                if (type==1){
                    System.out.println("Παρακαλώ να δωθεί κωδικός αντικειμένου.");
                    String code=scanner.nextLine();
                    LibraryItem find=library.findItemByCode(code);
                    if(find==null){
                        System.out.println("Το αντικείμενο με κωδικό "+code+ " δεν βρέθηκε.");

                    }
                    else{
                        System.out.println("Το αντικείμενο με κωδικό "+ code+ "βρέθηκε επιτυχώς.");
                        System.out.println("Στοιχεία αντικειμένου:"+  find.getInformation());

                    }
                }
                else if(type==2){
                    System.out.println("Παρακαλώ να δωθεί ID μέλους.");
                    String id=scanner.nextLine();
                    Member find=library.findMemberById(id);
                    if(find==null){
                        System.out.println("Το μέλος με ID "+ id+ "δεν βρέθηκε.");

                    }
                    else{
                        System.out.println("Το μέλος με ID "+ id+ "βρέθηκε επιτυχώς.");
                                     }
                }
            }
            else if (choice==4){
                scanner.nextLine();
                System.out.println("Παρακαλώ να δωθεί ID μέλους.");
                String id=scanner.nextLine();
                Member find=library.findMemberById(id);
                if(find==null){
                    System.out.println("Το ID: "+id+"δεν βρέθηκε.");
                }
                else{
                    System.out.println("Παρακαλώ να δωθεί κωδικός αντικειμένου.");
                    String code=scanner.nextLine();
                    LibraryItem item=library.findItemByCode(code);
                    if(item==null){
                        System.out.println("Το αντικείμενο με κωδικό "+ code+ "δεν βρέθηκε.");
                    }
                    else{
                        if(item.borrowTo(find)){// ελεγχος αν το υλικο δεν ειναι δανεσιμενο σε καποιον αλλον
                            System.out.println("Παρακαλώ να δωθεί ημερομηνία δανεισμού.");
                            String date=scanner.nextLine();
                            Loan newLoan=new Loan(item,find,date,"Εκρεμμεί");
                            item.setIsAvailable(false);
                            library.addLoan(newLoan);

                        }

                    }
                }

            }
            else if (choice==5){
                scanner.nextLine();
                System.out.println("Παρακαλώ να δωθεί ο κωδικός του ατικειμένου που επιθυμείτε να επιστραφεί.");
                String code=scanner.nextLine();
                LibraryItem item=library.findItemByCode(code);
                if(item==null){
                    System.out.println("Το αντικείμενο δεν βρέθηκε.");
                }
                else{
                    item.returnItem();
                }

            }
            else if (choice==6){
                System.out.println("Λίστα δανεισμών");
                library.showLoans();
            }
            else if(choice==7){
                library.showStatistics();

            }
            else if(choice==8){
                scanner.nextLine();
                System.out.println("Παρακαλώ να δωθεί ο κωδικός του αντικειμένου. ");
                String code= scanner.nextLine();
                LibraryItem item=library.findItemByCode(code);
                if(item==null){
                    System.out.println("Το αντικείμενο δεν βρέθηκε.");
                }
                else {
                    System.out.println("Δώστε βαθμολογία.(Από 1 εώς 10");
                    int rate = scanner.nextInt();
                    Reviewable rev = (Reviewable) item;
                    rev.addRating(rate);
                    System.out.println("Επιτυχής προσθήκη βαθμολογίας: " + rate);
                    System.out.println("Νέος μέσος όρος: " + rev.getAverage());
                }
            }
            else if (choice==9){
                Storage.saveLibrary(library);
            }
            else if (choice==0){
                Storage.saveLibrary(library);
                System.out.println("Τερματισμός συστήματος.");

            }
            else{
                System.out.println("Ο αριθμός που επιλέξατε δεν βρίσκεται στο μενού. Παρακαλώ επιλέξτε ξανά.");
            }


        }while(choice!=0);
    }

}



