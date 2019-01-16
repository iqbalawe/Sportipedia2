package iqbal.app.projectku;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class ArenaActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_futsal);
    }

    public void increment(View view) {
        if (quantity == 5) {
            Toast.makeText(this, "Booking maksimal 5 jam", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            Toast.makeText(this, "Booking minimal 1 jam", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
        display(quantity);
    }

    public void submitOrder(View view) {
        EditText edtName = (EditText) findViewById(R.id.edt_name);
        String name = edtName.getText().toString();
        Log.v("ArenaActivity", "Nama : " + name);

        EditText edtPhone = (EditText) findViewById(R.id.edt_phone);
        String phone = edtPhone.getText().toString();
        Log.v("ArenaActivity", "Nomor Telepon : " + phone);

        EditText edtDate = (EditText) findViewById(R.id.edt_date);
        String date = edtDate.getText().toString();
        Log.v("ArenaActivity", "Tanggal Booking : " + date);

        EditText edtTime = (EditText) findViewById(R.id.edt_time);
        String time = edtTime.getText().toString();
        Log.v("ArenaActivity", "Jam Booking : " + time);

        CheckBox rompiCheckBox = (CheckBox) findViewById(R.id.rompi_checkbox);
        boolean rentRompi = rompiCheckBox.isChecked();
        Log.v("ArenaActivity", "Sewa Rompi : " + rentRompi);

        CheckBox sepatuCheckBox = (CheckBox) findViewById(R.id.sepatu_checkbox);
        boolean rentSepatu = sepatuCheckBox.isChecked();
        Log.v("ArenaActivity", "Sewa sepatu : " + rentSepatu);

        int price = calculatePrice(rentRompi, rentSepatu);
        String priceMessage = createOrderSummary(price, name, phone, date, time, rentRompi, rentSepatu);
        displayMessage(priceMessage);
    }

    private int calculatePrice(boolean addRompi, boolean addSepatu) {
        int harga = 100000;

        if (addRompi) {
            harga = harga + 15000;
        }

        if (addSepatu) {
            harga = harga + 50000;
        }

        return quantity * harga;
    }

    private String createOrderSummary(int price, String name, String phone, String date, String time, boolean addRompi, boolean addSepatu) {
        String priceMessage = "Nama : " + name;
        priceMessage+="\nNomor Telepon : " + phone;
        priceMessage+="\nTanggal Booking : " + date;
        priceMessage+="\nWaktu Booking : " + time;
        priceMessage+="\nSewa Rompi : " + addRompi;
        priceMessage+="\nSewa Sepatu : " + addSepatu;
        priceMessage+="\nDurasi Booking : " + quantity;
        priceMessage+="\nTotal Pembayaran : Rp." + price;
        priceMessage+="\nTerima Kasih";
        return  priceMessage;
    }

    private void displayMessage(String message) {
        TextView txtPrice = (TextView) findViewById(R.id.price_textview);
        txtPrice.setText(message);
    }

    private void display(int number) {
        TextView txtQuantity = (TextView) findViewById(R.id.quantity_textview);
        txtQuantity.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView txtPrice = (TextView) findViewById(R.id.price_textview);
        txtPrice.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
