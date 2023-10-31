import java.util.ArrayList;
import java.util.List;

public class Zadluzenie {
    private List<TenantLetter> tenantLetters = new ArrayList<>();

    public void addTenantLetter(TenantLetter letter) {
        tenantLetters.add(letter);
    }

    public List<TenantLetter> getZadluzenia() {
        return tenantLetters;
    }
}

