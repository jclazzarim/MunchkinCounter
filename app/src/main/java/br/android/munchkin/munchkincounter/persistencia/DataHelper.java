package br.android.munchkin.munchkincounter.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import br.android.munchkin.munchkincounter.br.android.munchkin.model.EImagemSexo;
import br.android.munchkin.munchkincounter.br.android.munchkin.model.Player;

public class DataHelper {

    private static final String DATABASE_NAME = "munchkin_counter.db";
    private static final int DATABASE_VERSION = 9;
    private static final String TABLE_NAME = "player";
    private static final String[] colunas = new String[]{" id ", " nome ", " sexo ", " vitorias ", " jogos "};

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (nome, sexo, vitorias, jogos) values (?,?,?,?)";
    private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE id = ";

    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insert_statement;

    public DataHelper(Context context) {
        this.context = context;
        OpenHelper op = new OpenHelper(context);
        db = op.getWritableDatabase();
        insert_statement = db.compileStatement(INSERT);
    }

    public void insert(Player player) {
        insert_statement.bindString(1, player.getNome());
        insert_statement.bindString(2, player.getSexo().toString());
        insert_statement.bindLong(3, player.getVitorias());
        insert_statement.bindLong(4, player.getJogos());

        insert_statement.executeInsert();
    }

    public void delete(Player player){
        String d = DELETE + player.getId();
        db.compileStatement(d).executeUpdateDelete();
    }

    private List<Player> getListFromCursor(Cursor cursor) {
        List<Player> list = new ArrayList<Player>();
        if (cursor.moveToFirst()) {
            do {
                Player p = new Player();
                p.setId(cursor.getInt(0));
                p.setNome(cursor.getString(1));
                p.setSexo(EImagemSexo.valueOf(cursor.getString(2)));
                p.setVitorias(cursor.getInt(3));
                p.setJogos(cursor.getInt(4));
                list.add(p);
            } while (cursor.moveToNext());
        }

        if (cursor != null && cursor.isClosed()) {
            cursor.close();
        }

        return list;
    }

    private Player getOneFromCursor(Cursor cursor) {
        Player p = new Player();
        if (cursor.moveToFirst()) {
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setSexo(EImagemSexo.valueOf(cursor.getString(2)));
            p.setVitorias(cursor.getInt(3));
            p.setJogos(cursor.getInt(4));
        }

        if (cursor != null && cursor.isClosed()) {
            cursor.close();
        }

        return p;
    }

    public Player consultaPorNome(String nome) {
        Cursor cursor = db.query(TABLE_NAME, colunas, " NOME = '" + nome + "' ", null, null, null, " nome ");
        return getOneFromCursor(cursor);
    }

    public List<Player> selectAll() {
        Cursor cursor = db.query(TABLE_NAME, colunas, null, null, null, null, " nome ");
        return getListFromCursor(cursor);
    }


    private static class OpenHelper extends SQLiteOpenHelper {
        private Context myContext;

        OpenHelper(Context c) {
            super(c, DATABASE_NAME, null, DATABASE_VERSION);
            this.myContext = c;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, sexo TEXT, vitorias INTEGER, jogos INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
