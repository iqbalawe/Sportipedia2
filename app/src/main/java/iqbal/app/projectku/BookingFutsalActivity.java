package iqbal.app.projectku;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class BookingFutsalActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_futsal);
        submitOrder();
    }

    public void increment(View view) { //perintah tombol tambah
        if (quantity == 5) {
            Toast.makeText(this, "Maksimal Booking 5 Jam", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            Toast.makeText(this, "Booking minimal 1 Jam", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void submitOrder() {
        EditText edtName = (EditText) findViewById(R.id.edt_name);
        String name = edtName.getText().toString();
        Log.v("BookingFutsalActivity", "Nama : " + name);

        EditText edtPhone = (EditText) findViewById(R.id.edt_phone);
        String phone = edtPhone.getText().toString();
        Log.v("BookingFutsalActivity", "Nomor Telepon : " + phone);

        EditText edtDate = (EditText) findViewById(R.id.edt_date);
        String date = edtDate.getText().toString();
        Log.v("BookingFutsalActivity", "Tanggal : " + date);

        EditText edtTime = (EditText) findViewById(R.id.edt_time);
        String time = edtTime.getText().toString();
        Log.v("BookingFutsalActivity", "Nomor Telepon: " + time);

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, name, phone, date, time);

        displayMessage(priceMessage);
        displayPrice(price);
    }

    private int calculatePrice() {
        int harga = 100000;

        if (harga >= 0) {
            harga = harga * 100000;
        }
        return quantity * harga;
    }

    private String createOrderSummary(int price, String name, String phone, String date, String time) {
        String pricemessage=" Nama = "+name;
        pricemessage+="\n Nomor Telepon =" +phone;
        pricemessage+="\n Tanggal Booking =" +date;
        pricemessage+="\n Waktu Booking =" +time;
        pricemessage+="\n Jumlah Pemesanan =" +quantity;
        pricemessage+="\n Total = Rp " +price;
        pricemessage+="\n Terimakasih";
        return  pricemessage;
    }

    //cetak hasil
    private void displayMessage(String message) {
        TextView txtPrice = (TextView) findViewById(R.id.txt_price);
        txtPrice.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.txt_quantity);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView txtPrice = (TextView) findViewById(R.id.txt_price);
        txtPrice.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
