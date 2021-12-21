package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ualr.layoutassignment.R;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Button calculate_total;
    MaterialButtonToggleGroup discount_group;
    EditText p1, p2, p3, p4;
    CheckBox c1, c2, c3, c4;
    TextView total;
    Boolean isDiscount = false;

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate_total = findViewById(R.id.calculate_total_btn);
        p1 = findViewById(R.id.edit_1);
        p2 = findViewById(R.id.edit_2);
        p3 = findViewById(R.id.edit_3);
        p4 = findViewById(R.id.edit_4);
        c1 = findViewById(R.id.product_1);
        c2 = findViewById(R.id.product_2);
        c3 = findViewById(R.id.product_3);
        c4 = findViewById(R.id.product_4);
        total = findViewById(R.id.amount);
        discount_group = findViewById(R.id.toggle_button_group);

        discount_group.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    if (checkedId == R.id.discount) {
                        isDiscount = true;
                    } else if (checkedId == R.id.no_discount) {
                        isDiscount = false;
                    }
                }
            }
        });

        calculate_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTotal();
            }
        });
    }

    public void calculateTotal()
    {
        double sum = 0.00;
        if(c1.isChecked()) {
            try {
                sum += Double.parseDouble(p1.getText().toString());
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }
        if(c2.isChecked()) {
            try {
                sum += Double.parseDouble(p2.getText().toString());
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }
        if(c3.isChecked()) {
            try {
                sum += Double.parseDouble(p3.getText().toString());
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }
        if(c4.isChecked()) {
            try {
                sum += Double.parseDouble(p4.getText().toString());
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }
        if (isDiscount) {
            sum = sum*.75;
        }
        total.setText(String.format(Locale.getDefault(), "%.2f", sum));
    }
}