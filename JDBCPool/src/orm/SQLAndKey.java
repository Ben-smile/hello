package orm;

import java.util.ArrayList;

public class SQLAndKey {

    private String SQL;
    private ArrayList<String> keys;

    public SQLAndKey(String SQL, ArrayList<String> keys) {
        this.SQL = SQL;
        this.keys = keys;
    }

    public String getSQL() {
        return SQL;
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }

    public ArrayList<String> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<String> keys) {
        this.keys = keys;
    }
}
