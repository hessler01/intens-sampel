package com.danialhz.app.intenssampel;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int count;
    private int price = 10;

    public void increse() {
        if (count < 20)
            count++;
    }

    public void decrase() {
        if (count > 1)
            count--;
    }

    public void display() {
        TextView counttextview = findViewById(R.id.tv_4);
        counttextview.setText(String.valueOf(count));
    }

    public int caculate() {
        return price * count;
    }

    private String order() {
        String summary = "";

        EditText nameedittext = findViewById(R.id.et_1);
        summary += "Name  : " + nameedittext.getText().toString() + "\n";
        summary += "countd : " + count + "\n";
        summary += "price : " + caculate() + "\n";

        TextView summarytext = findViewById(R.id.summary_textview);
        summarytext.setText(summary);
        return summary;
    }


    public void increasebn(View view) {


        increse();
        display();

    }

    public void minesbn(View view) {
        decrase();
        display();

    }

    public void order(View view) {

        TextView pricetextview = findViewById(R.id.tv_price);
        pricetextview.setText("total price: " + caculate() + " $");
        pricetextview.setVisibility(View.VISIBLE);

    }

    public void email(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "danyalhsnzadh69@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "order coffee from app");
        intent.putExtra(Intent.EXTRA_TEXT, order());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void phone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "09024168085"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void search (View view) {

        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "www.developer.android");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }



    }
}
