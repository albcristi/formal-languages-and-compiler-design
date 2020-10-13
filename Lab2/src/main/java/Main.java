import com.sun.tools.javac.util.Pair;
import model.SymbolTable;

public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable(17);
        Pair<Integer, Integer> a = symbolTable.search("a");
        assert  a.fst == -1;
        a = symbolTable.add("a");
        assert a.fst != -1;
        assert a.snd == 0;
    }
}
