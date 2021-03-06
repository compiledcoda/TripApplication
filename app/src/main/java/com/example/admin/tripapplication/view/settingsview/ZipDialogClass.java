package com.example.admin.tripapplication.view.settingsview;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.tripapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;
import static com.example.admin.tripapplication.util.CONSTANTS.*;


public class ZipDialogClass extends Dialog {

    public interface OnZipEventListener {
        void ZipUpdated(String value);
    }

    public Activity c;
    @BindView(R.id.etValue)
    EditText etValue;

    public ZipDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_zip);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnClose, R.id.btnSave})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClose:
                dismiss();
                break;
            case R.id.btnSave:
                String zip = etValue.getText().toString();

                SharedPreferences prefs = c.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
                String zip_old = prefs.getString(MY_PREFS_ZIP, "");

                if(!zip_old.equals(zip)) {
                    SharedPreferences.Editor editor = c.getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                    editor.putString(MY_PREFS_ZIP, zip);
                    editor.commit();
                    Toast.makeText(c, "Zip code saved successfully", Toast.LENGTH_SHORT).show();
                    ((OnZipEventListener) c).ZipUpdated(zip);
                    dismiss();
                } else{
                    Toast.makeText(c, "No changes were made", Toast.LENGTH_SHORT).show();
                    ((OnZipEventListener) c).ZipUpdated("");
                }
                break;
        }
    }
}
