package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    EditText et_nome, et_telefone;
    Button btn_gravar, btn_consultar, btn_fechar;

    SQLiteDatabase db= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_telefone = (EditText) findViewById(R.id.et_telefone);
        btn_gravar = (Button) findViewById(R.id.btn_gravar);
        btn_consultar = (Button) findViewById(R.id.btn_consultar);
        btn_fechar = (Button) findViewById(R.id.btn_fechar);

        abrirBanco();

    }
           public void abrirBanco(Object v){
        try {
            db=openOrCreateDatabase("bancoAgenda", MODE_PRIVATE, null );
            }
        catch (Exception ex){
                msg("Erro ao abrir ou criar banco de dados");
             }finally {
            msg("Banco de dados aberto");
        }

        public void abrirOuCriarTabela(){
                   try {
                       db.execSQL("CREATE TABLE IF NOT EXISTS contato ( id INTEGER PRIMARY KEY, nome TXT, fone TEXT);");
                   }      catch (Exception ex){
                       msg("Erro ao criar tabela");
                   }

               }

        public void FecharDB(){
            db.close();
               }

        public void inserirRegistro(View v){
                   String st_nome, st_fone;
                   st_nome= et_nome.getText().toString();
                   st_fone= et_telefone.getText().toString();
                   if (st_nome=="|| st_fone ==") {
                   msg("Campos não pode está vazio");
                   return;
                   }
                   abrirBanco(v);
                   try {
                   db.execSQL("INSERT INTO contatos(nome, fone) VALUES(' "+ st_nome"' ,'"st_fone+"')");
                   }catch (Exception ex){
                       msg("Erro ao inserir registro");
                   }
                   }

                FecharDB()
                et_nome.setText(null);
                et_telefone.setText(null);

    }
            public void abrir_tela_consulta (View v) {

               Intent it_tela_consulta= new Intent(this.TelaConsulta.class);
               startActivity(it_tela_consulta);
           }

           public void fechar_tela (View v){
           this.finish();}

            public void msg(String txt){

                AlertDialog.Builder abd= new AlertDialog.Builder(this);
                abd.setMessage(txt);
                abd.setNeutralButton("ok", null);
                abd.show();

            }

           }



