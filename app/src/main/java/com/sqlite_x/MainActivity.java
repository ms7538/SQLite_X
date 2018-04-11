package com.sqlite_x;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textEdit;
    TextView textView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEdit = findViewById(R.id.editText);
        textView = findViewById(R.id.dbText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();

    }

    public void addButtonClicked(View view) {
        Products product = new Products(textEdit.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }
    public void deleteButtonClicked(View view){
        String inputText = textEdit.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase() {

        String dbString = dbHandler.databaseToString();
        textView.setText(dbString);
        textEdit.setText("");
    }


}
