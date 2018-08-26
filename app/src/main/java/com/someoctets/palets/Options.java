package com.someoctets.palets;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

public class Options  extends Activity {


    public SharedPreferences sharedPreferences;
    public Outils outils = Outils.getInstanceOutils();

    boolean utiliserValeurParDefaut = false;
    boolean selectionnerToutParDefaut = false;

    TextInputEditText defautNombrePalettes;
    TextInputEditText defautTarePalette;
    TextInputEditText defautTareColis;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.options);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
       outils.setSharedPreferences(sharedPreferences);
        utiliserValeurParDefaut = outils.loadBoolean("utiliserValeurParDefaut", false);
        selectionnerToutParDefaut = outils.loadBoolean("selectionnerToutParDefaut", true);


        Switch utiliserValeurParDefautSwitch = findViewById(R.id.utiliserValeurParDefaut);
        utiliserValeurParDefautSwitch.setChecked(utiliserValeurParDefaut);
        utiliserValeurParDefautSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                switcherUtiliserValeurParDefaut();

            }
        });

        Switch selectionnerToutParDefautSwitch = findViewById(R.id.selectionnerToutParDefaut);
        selectionnerToutParDefautSwitch.setChecked(selectionnerToutParDefaut);
        selectionnerToutParDefautSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                switcherSelectionnerToutParDefaut();

            }
        });













        String  defautNombrePalettesString = outils.loadString("defautNombrePalettes","");
        defautNombrePalettes = findViewById(R.id.defautNombrePalettes);
        defautNombrePalettes.setText(defautNombrePalettesString);
        defautNombrePalettes.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c)
            {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                outils.saveString("defautNombrePalettes", defautNombrePalettes.getText().toString().trim());
            }
        });
        String defautTarePaletteString = outils.loadString("defautTarePalette","");
        defautTarePalette = findViewById(R.id.defautTarePalette);
        defautTarePalette.setText(defautTarePaletteString);
        defautTarePalette.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c)
            {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                outils.saveString("defautTarePalette", defautTarePalette.getText().toString().trim());
            }
        });

        String defautTareColisString = outils.loadString("defautTareColis","");
        defautTareColis = findViewById(R.id.defautTareColis);
        defautTareColis.setText(defautTareColisString);
        defautTareColis.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c)
            {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                outils.saveString("defautTareColis", defautTareColis.getText().toString().trim());
            }
        });
        }







    public void Back(View v) {
        finish() ;

    }




    public void switcherUtiliserValeurParDefaut(){
        if(utiliserValeurParDefaut == true){
            utiliserValeurParDefaut = false;
            outils.saveBoolean("utiliserValeurParDefaut", false);
        }else {
            utiliserValeurParDefaut = true;
            outils.saveBoolean("utiliserValeurParDefaut", true);
        }
    }



    public void switcherSelectionnerToutParDefaut(){
        if(selectionnerToutParDefaut == true){
            selectionnerToutParDefaut = false;
            outils.saveBoolean("selectionnerToutParDefaut", false);

            }else {
            selectionnerToutParDefaut = true;
            outils.saveBoolean("selectionnerToutParDefaut", true);

            }
    }






}

