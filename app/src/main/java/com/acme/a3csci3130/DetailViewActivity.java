package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, businessField,
            addressField, provinceField;
    Contact receivedBusinessInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedBusinessInfo != null) {
            nameField.setText(receivedBusinessInfo.name);
            numberField.setText(receivedBusinessInfo.number);
            businessField.setText(receivedBusinessInfo.business);
            addressField.setText(receivedBusinessInfo.address);
            provinceField.setText(receivedBusinessInfo.province);
        }
    }

    public void updateContact(View v) {
        //TODO: Update contact funcionality
        Contact business = receivedBusinessInfo;
        business.name = nameField.getText().toString();
        business.number = numberField.getText().toString();
        business.business = businessField.getText().toString();
        business.address = addressField.getText().toString();
        business.province = provinceField.getText().toString();

        appState.firebaseReference.child(business.uid).setValue(business);
    }

    public void eraseContact(View v) {
        //TODO: Erase contact functionality
    }
}
