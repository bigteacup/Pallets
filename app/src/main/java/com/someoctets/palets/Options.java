package com.someoctets.palets;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Options  extends Activity {


    public SharedPreferences sharedPreferences;
    public Outils outils = Outils.getInstanceOutils();

    boolean utiliserValeurParDefaut = false;
    boolean selectionnerToutParDefaut = false;
    boolean masquerMultiplicateur = false;
    boolean masquerAdditionneur = false;
    // setMasquerMultiplicateur()
    TextInputEditText defautNombrePalettes;
    TextInputEditText defautTarePalette;
    TextInputEditText defautTareColis;
    TextInputEditText defautNombrePoidEchantillon;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.options);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
       outils.setSharedPreferences(sharedPreferences);
        utiliserValeurParDefaut = outils.loadBoolean("utiliserValeurParDefaut", false);
        selectionnerToutParDefaut = outils.loadBoolean("selectionnerToutParDefaut", true);
        masquerMultiplicateur = outils.loadBoolean("masquerMultiplicateur", true);
        masquerAdditionneur = outils.loadBoolean("masquerAdditionneur", true);



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

        Switch masquerMultiplicateurSwitch = findViewById(R.id.masquermultiplicateur);
        masquerMultiplicateurSwitch.setChecked(masquerMultiplicateur);
        masquerMultiplicateurSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                switcherMasquerMultiplicateur();

            }
        });



        Switch masquerAdditionneurSwitch = findViewById(R.id.masquerAdditionneur);
        masquerAdditionneurSwitch.setChecked(masquerAdditionneur);
        masquerAdditionneurSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                switcherMasquerAdditionneur();

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

        String defautNombrePoidEchantillonString = outils.loadString("defautNombrePoidEchantillon","");
        defautNombrePoidEchantillon = findViewById(R.id.defautNombrePoidEchantillon);
        defautNombrePoidEchantillon.setText(defautNombrePoidEchantillonString);
        defautNombrePoidEchantillon.addTextChangedListener(new TextWatcher() {

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
                outils.saveString("defautNombrePoidEchantillon", defautNombrePoidEchantillon.getText().toString().trim());
            }
        });


        }







    public void Back(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", "your message");
        setResult(RESULT_OK, returnIntent);
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



    public void switcherMasquerMultiplicateur(){
        if( masquerMultiplicateur == true){
            masquerMultiplicateur = false;
            outils.saveBoolean("masquerMultiplicateur", false);
        }else {
            masquerMultiplicateur = true;
            outils.saveBoolean("masquerMultiplicateur", true);

        }
    }


    public void switcherMasquerAdditionneur(){
        if( masquerAdditionneur == true){
            masquerAdditionneur = false;
            outils.saveBoolean("masquerAdditionneur", false);
        }else {
            masquerAdditionneur = true;
            outils.saveBoolean("masquerAdditionneur", true);
        }


    }





}

