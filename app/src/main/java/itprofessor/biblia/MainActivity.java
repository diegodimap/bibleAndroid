package itprofessor.biblia;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private ArrayList<String> inserirDados2 = new ArrayList<String>();
    private int capitulo = 1;
    private String banco = "bibliaNova2";
    private SQLiteDatabase meuBanco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set content view AFTER ABOVE sequence (to avoid crash)
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        //setContentView(R.layout.main);
        //this.criarBanco();
        AbrirBanco ab = new AbrirBanco(this);
        try {
            //this.StoreDatabase();
            //ab.copyDataBase();
            ab.createDataBase();
            ab.openDataBase();
            //set up notitle
            //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            //set up full screen
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            meuBanco = ab.getBanco();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void clicouVersiculo(View v) {
        Toast.makeText(this, "Envio de Versículos em desenvolvimento!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ClicouLivros(View v) {
        setContentView(R.layout.livro);
    }

    public void ClicouPesquisar(View v) {
        setContentView(R.layout.pesquisar);
    }

    public void ClicouVoltar(View v) {
        setContentView(R.layout.main);
    }

    public void escolherCapitulo(int livro) {
        final int livroFinal = livro;
        int quantidadeCapitulos = verQuantidadeCapitulos(livro);
        String capitulos[] = new String[quantidadeCapitulos];
        for (int i = 0; i < quantidadeCapitulos; i++) {
            capitulos[i] = (i + 1) + "";
        }

        Builder janela = new Builder(this);
        janela.setTitle("Escolha o capítulo");
        janela.setItems(capitulos, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                capitulo = which + 1;
                //chamar select passando livro + capítulo
                selecionouLivro(livroFinal, capitulo);
            }
        });
        janela.show();
    }

    //LIVROS
    public void ClicouGenesis(View v) {
        setContentView(R.layout.listarlivro);
        escolherCapitulo(1);
    }

    public void ClicouExodo(View v) {
        setContentView(R.layout.listarlivro);
        escolherCapitulo(2);
    }

    public void ClicouLevitico(View v) {
        setContentView(R.layout.listarlivro);
        escolherCapitulo(3);
    }

    public void ClicouNumeros(View v) {
        setContentView(R.layout.listarlivro);
        escolherCapitulo(4);
    }

    public void ClicouDeuteronomio(View v) {
        setContentView(R.layout.listarlivro);

        escolherCapitulo(5);
    }

    public void ClicouJosue(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(6);
    }

    public void ClicouJuizes(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(7);
    }

    public void ClicouRute(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(8);
    }

    public void ClicouISamuel(View v) {
        setContentView(R.layout.listarlivro);


        this.escolherCapitulo(9);
    }

    public void ClicouIISamuel(View v) {
        setContentView(R.layout.listarlivro);


        this.escolherCapitulo(10);
    }

    public void ClicouIReis(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(11);
    }

    public void ClicouIIReis(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(12);
    }

    public void ClicouICronicas(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(13);
    }

    public void ClicouIICronicas(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(14);
    }

    public void ClicouEsdras(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(15);
    }

    public void ClicouNeemias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(16);
    }

    public void ClicouEster(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(17);
    }

    public void ClicouJo(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(18);
    }

    public void ClicouSalmos(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(19);
    }

    public void ClicouProverbios(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(20);
    }

    public void ClicouEclesiastes(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(21);
    }

    public void ClicouCanticos(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(22);
    }

    public void ClicouIsaias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(23);
    }

    public void ClicouJeremias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(24);
    }

    public void ClicouLamentacoes(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(25);
    }

    public void ClicouEzequiel(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(26);
    }

    public void ClicouDaniel(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(27);
    }

    public void ClicouOseias(View v) {
        setContentView(R.layout.listarlivro);


        this.escolherCapitulo(28);
    }

    public void ClicouJoel(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(29);
    }

    public void ClicouAmos(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(30);
    }

    public void ClicouObadias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(31);
    }

    public void ClicouJonas(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(32);
    }

    public void ClicouMiqueias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(33);
    }

    public void ClicouNaum(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(34);
    }

    public void ClicouHabacuque(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(35);
    }

    public void ClicouSofonias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(36);
    }

    public void ClicouAgeu(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(37);
    }

    public void ClicouZacarias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(38);
    }

    public void ClicouMalaquias(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(39);
    }

    public void ClicouMateus(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(40);
    }

    public void ClicouMarcos(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(41);
    }

    public void ClicouLucas(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(42);
    }

    public void ClicouJoao(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(43);
    }

    public void ClicouAtos(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(44);
    }

    public void ClicouRomanos(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(45);
    }

    public void ClicouICorintios(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(46);
    }

    public void ClicouIICorintios(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(47);
    }

    public void ClicouGalatas(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(48);
    }

    public void ClicouEfesios(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(49);
    }

    public void ClicouFilipenses(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(50);
    }

    public void ClicouColossenses(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(51);
    }

    public void ClicouITessalonicenses(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(52);
    }

    public void ClicouIITessalonicenses(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(53);
    }

    public void ClicouITimoteo(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(54);
    }

    public void ClicouIITimoteo(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(55);
    }

    public void ClicouTito(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(56);
    }

    public void ClicouFilemom(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(57);
    }

    public void ClicouHebreus(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(58);
    }

    public void ClicouTiago(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(59);
    }

    public void ClicouIPedro(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(60);
    }

    public void ClicouIIPedro(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(61);
    }

    public void ClicouIJoao(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(62);
    }

    public void ClicouIIJoao(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(63);
    }

    public void ClicouIIIJoao(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(64);
    }

    public void ClicouJudas(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(65);
    }

    public void ClicouApocalipse(View v) {
        setContentView(R.layout.listarlivro);

        this.escolherCapitulo(66);
    }

    public int verQuantidadeCapitulos(int livro) {
        try {
            SQLiteDatabase db = meuBanco; //openOrCreateDatabase(banco, Context.MODE_PRIVATE, null);
            int maxCapitulos = 1;
            String sql = "select max(capitulo) from versiculos where livro = " + livro;
            Cursor c = db.rawQuery(sql, null);
            if (c.moveToFirst()) {
                maxCapitulos = c.getInt(0);
            }
            c.close();
            return maxCapitulos;
        } catch (Exception e) {
            //Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return 1;
    }

    public void selecionouLivro(int livro, int capitulo) {
        try {
            SQLiteDatabase db = meuBanco; //openOrCreateDatabase(banco, Context.MODE_PRIVATE, null);
            String tabela = "versiculos";
            Cursor cursor = db.rawQuery("SELECT _id, livro, capitulo, versiculo, texto FROM " + tabela + " WHERE capitulo = " + capitulo + " AND livro = " + livro, null);
            String from[] = {"versiculo", "texto"};
            int to[] = {R.id.numeroVersiculo, R.id.textoVersiculo};
            SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(), R.layout.listarlivro_model, cursor, from, to, 0);
            ListView lv = (ListView) findViewById(R.id.listarLivroView);
            lv.setAdapter(ad);
            //db.close();
        } catch (Exception e) {
            //Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void criarBanco() {
        try {
            SQLiteDatabase db = openOrCreateDatabase(banco, Context.MODE_PRIVATE, null);
            StringBuilder criarBanco = new StringBuilder();
            criarBanco.append("CREATE TABLE IF NOT EXISTS  `versiculos` (" +
                    "`id` INT(11) NOT NULL," +
                    "`livro` INT(11) NOT NULL DEFAULT '0'," +
                    "`capitulo` INT(11) NOT NULL DEFAULT '0'," +
                    "`versiculo` INT(11) NOT NULL DEFAULT '0'," +
                    "`texto` TEXT NOT NULL, " +
                    "PRIMARY KEY(`id`) " +
                    ");");
            db.execSQL(criarBanco.toString());

            //db.close();

        } catch (Exception e) {
            //Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void inserirVersiculosNoLivro(int livro) {
        try {
            SQLiteDatabase db = openOrCreateDatabase(banco, Context.MODE_PRIVATE, null);

            for (int i = 0; i < inserirDados2.size(); i++) {
                //db.beginTransaction();
                db.execSQL(inserirDados2.get(i));
                //db.endTransaction();
                //db.setTransactionSuccessful();
            }

            db.close();
        } catch (Exception e) {
            //Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void ClicouSair(View v) {
        Builder msg = new Builder(MainActivity.this);
        msg.setMessage("TEM CERTEZA QUE JÁ? LEU O SUFICIENTE DA PALAVRA DE DEUS POR HOJE?");
        msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                meuBanco.close();
                Toast.makeText(getBaseContext(), "QUE DEUS ABENÇOE SEU DIA :)", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        msg.setNegativeButton("Não", null);
        msg.show();
    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.main);
    }

    public void pesquisou(View v) {
        EditText digitado;
        RadioGroup radioGroup;
        RadioButton radioButton1;
        Button btnDisplay;

        //edit text
        digitado = (EditText) findViewById(R.id.digitado);

        //radio
        radioGroup = (RadioGroup) findViewById(R.id.radioTipoPesquisa);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton1 = (RadioButton) findViewById(selectedId);

        String tipoPesquisa = "";

        String ondeNaBiblia = " > 0";

        if (radioButton1.getText().equals("Pesquisar na Bíblia Inteira")) {
            tipoPesquisa = "toda";
            ondeNaBiblia = " > 0";
        }
        if (radioButton1.getText().equals("Pesquisar no Novo Testamento")) {
            tipoPesquisa = "novo";
            ondeNaBiblia = " >= 40";
        }
        if (radioButton1.getText().equals("Pesquisar no Velho Testamento")) {
            tipoPesquisa = "velho";
            ondeNaBiblia = " < 40";
        }

        String SQL = "SELECT _id , livro, capitulo, versiculo, texto FROM versiculos WHERE texto like '%" + digitado.getText() + "%'";

        SQL += " AND livro " + ondeNaBiblia;

        //Toast.makeText(MainActivity.this, SQL , Toast.LENGTH_SHORT).show();

        //CONSULTA

        setContentView(R.layout.pesquisarlivro);
        try {
            SQLiteDatabase db = meuBanco; //openOrCreateDatabase(banco, Context.MODE_PRIVATE, null);
            String tabela = "versiculos";
            Cursor cursor = db.rawQuery(SQL, null);
            String from[] = {"livro", "capitulo", "versiculo", "texto"};
            int to[] = {R.id.livroPesquisa, R.id.capituloPesquisa, R.id.numeroVersiculo, R.id.textoVersiculo};
            SimpleCursorAdapter ad = new SimpleCursorAdapter(getBaseContext(), R.layout.listarpesquisa_model, cursor, from, to, 0);
            ListView lv = (ListView) findViewById(R.id.listarPesquisaView);
            lv.setAdapter(ad);
            //db.close();
        } catch (Exception e) {
            //Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void StoreDatabase() {
        File DbFile = new File("data/data/ceu.deus.verdade.biblia/databases/" + banco + ".sqlite");
        if (DbFile.exists()) {
            Toast.makeText(MainActivity.this, "EXISTE", Toast.LENGTH_SHORT).show();
        } else {
            try {
                DbFile.createNewFile();
                Toast.makeText(MainActivity.this, "CRIADO", Toast.LENGTH_SHORT).show();
                InputStream is = this.getAssets().open(banco + ".sqlite");
                FileOutputStream fos = new FileOutputStream(DbFile);
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                Toast.makeText(MainActivity.this, "SD CARD", Toast.LENGTH_SHORT).show();
                //Close the streams
                fos.flush();
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
