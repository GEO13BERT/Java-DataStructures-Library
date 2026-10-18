package ergasia.erg.p25120.bert.contracts;

import ergasia.erg.p25120.bert.model.Member;

public interface Borrowable {
    boolean borrowTo(Member member);
    boolean returnItem();
    boolean isAvailable();
}

