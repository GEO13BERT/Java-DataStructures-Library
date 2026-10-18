package ergasia.erg.p25120.bert.contracts;

import ergasia.erg.p25120.bert.model.LibraryItem;
import ergasia.erg.p25120.bert.model.Member;

public interface Searchable {
    LibraryItem findItemByCode(String code);
    Member findMemberById(String id);
}
