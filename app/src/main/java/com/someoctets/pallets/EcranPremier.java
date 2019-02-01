package com.someoctets.pallets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class EcranPremier extends AppCompatActivity   {

   public SharedPreferences sharedPreferences;


    boolean fast = false;
    boolean reverse = false;

    private LinearLayout linearLayoutA ;
    private TextInputEditText poidBrut;
    private TextInputEditText nombreDePalettes;
    private TextInputEditText poidPalet;
    private TextInputEditText piecesParColis;
    private TextInputEditText colisParColonne;
    private TextInputEditText colisParTranche;
    private TextInputEditText tareColis;
    private TextInputEditText nombreDeColis;
    private TextInputEditText piecesAbimees;
    private TextInputEditText nombreColisEchantillon;
    private LinearLayout colonneTrancheLayout;
    private LinearLayout tachesEchantillonLayout;

    private LinearLayout nombrePoidEchantillonLayout;
    private TextInputEditText poidEchantillon;
    private TextInputEditText nombrePoidEchantillon;

    private TextInputLayout poidNetInputLayout;
    private TextInputEditText  poidNetAnnonce;
    private ScrollView scrollView;
    private CoordinatorLayout ecran;
    private EditText resultat;

   public Outils outils = Outils.getInstanceOutils();
  boolean selectAllParDefaut ;
  boolean utiliserValeurParDefaut ;
  boolean masquerMultiplicateur;


    //private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;














































    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_premier);
       //Operations operations = (Operations) findViewById(R.id.fragment_operations);
    //    setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //


        /* mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
*/
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        outils.setSharedPreferences(sharedPreferences);


       reverse = outils.loadBoolean("reverseSwitch", false);
       fast = outils.loadBoolean("fullFastSwitch", false);

/*
        ecran = findViewById(R.id.ecran);
        ecran.setOnTouchListener(new OnSwipeTouchListener(EcranPremier.this) {
            public void onSwipeTop() {
                Toast.makeText(EcranPremier.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(EcranPremier.this, "right", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(EcranPremier.this, Options.class);
                        startActivity(intent);




            }
            public void onSwipeLeft() {
                Toast.makeText(EcranPremier.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(EcranPremier.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
*/


        final ConstraintLayout optionsButton  = (ConstraintLayout) findViewById(R.id.titreToolbar);
        optionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EcranPremier.this, Options.class);
                startActivity(intent);



            }
        });




        Button clearButton =  findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    clear();

                    }
                });

        Switch reverseSwitch =  findViewById(R.id.reverse);
        reverseSwitch.setChecked(reverse);
        reversePalets();
        reverseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                        switcherReverse();
                        reversePalets();

                    }
                });


        Switch fullFastSwitch =  findViewById(R.id.fullFastSwitch);
        fullFastSwitch.setChecked(fast);
        fastMode();
        fullFastSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                        switcherFullFast();
                        fastMode();

                    }
                });

        linearLayoutA = findViewById(R.id.linearLayoutA);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer();
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", new onClick()).show();
            }
        });



///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
        // listenner de texte

        poidBrut = findViewById(R.id.poidBrut);
        poidBrut.addTextChangedListener(new TextWatcher() {

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
                    calculer();
                }
            });

        poidNetAnnonce = findViewById(R.id.poidNetAnnonce);
        poidNetAnnonce.addTextChangedListener(new TextWatcher() {

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
                calculer();
            }
        });

        nombreDePalettes = findViewById(R.id.nombreDePalettes);
        nombreDePalettes.addTextChangedListener(new TextWatcher() {

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
                calculer();
            }
        });

        poidPalet = findViewById(R.id.poidPalet);
        poidPalet.addTextChangedListener(new TextWatcher() {

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
                calculer();
            }
        });

        piecesParColis = findViewById(R.id.piecesParColis);
        piecesParColis.addTextChangedListener(new TextWatcher() {

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
                fullFastSetup();
                calculer();
            }
        });

        poidEchantillon = findViewById(R.id.poidEchantillon);
        poidEchantillon.addTextChangedListener(new TextWatcher() {

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
                fullFastSetup();
                calculer();
            }
        });

        nombrePoidEchantillon = findViewById(R.id.nombrePoidEchantillon);
        nombrePoidEchantillon.addTextChangedListener(new TextWatcher() {

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
                fullFastSetup();
                calculer();
            }
        });


        colisParColonne = findViewById(R.id.colisParColonne);
        colisParColonne.addTextChangedListener(new TextWatcher() {

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
                fullFastSetup();
                calculer();
            }
        });

        colisParTranche = findViewById(R.id.colisParTranche);
        colisParTranche.addTextChangedListener(new TextWatcher() {

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
                fullFastSetup();
                calculer();
            }
        });

        tareColis = findViewById(R.id.tareColis);
        tareColis.addTextChangedListener(new TextWatcher() {

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
                calculer();
            }
        });

        nombreDeColis = findViewById(R.id.nombreDeColis);
        nombreDeColis.addTextChangedListener(new TextWatcher() {

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
                fullFastSetup();
                calculer();
            }
        });

        piecesAbimees = findViewById(R.id.piecesAbimees);
        piecesAbimees.addTextChangedListener(new TextWatcher() {

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
                calculer();
            }
        });

        nombreColisEchantillon = findViewById(R.id.nombreColisEchantillon);
        nombreColisEchantillon.addTextChangedListener(new TextWatcher() {

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
                calculer();
            }
        });




///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////


// on gere les preferences utilisateurs

        nombreDePalettes = findViewById(R.id.nombreDePalettes);
        poidPalet = findViewById(R.id.poidPalet) ;
        tareColis = findViewById(R.id.tareColis);
        poidEchantillon = findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = findViewById(R.id.nombrePoidEchantillon);

        setSelectAllParDefaut(outils.loadBoolean("selectionnerToutParDefaut", true));
        setUtiliserValeurParDefaut(outils.loadBoolean("utiliserValeurParDefaut", false));
        setMasquerMultiplicateur();

/*
if( utiliserValeurParDefaut == true) {

    if(outils.loadString("defautNombrePalettes", "").length() > 0){
        nombreDePalettes.setText(outils.loadString("defautNombrePalettes", ""));
    }
    if(outils.loadString("defautTarePalette", "").length() > 0){
        poidPalet.setText(outils.loadString("defautTarePalette", ""));
    }
    if(outils.loadString("defautTareColis", "").length() > 0){
        tareColis.setText(outils.loadString("defautTareColis", ""));
    }
}*/
    }





    @Override
    public void onResume() {
        super.onResume();
        setSelectAllParDefaut(outils.loadBoolean("selectionnerToutParDefaut", true));
        fastMode();
       // fullFastSetup();
      //  setUtiliserValeurParDefaut(outils.loadBoolean("utiliserValeurParDefaut", false));
    }











    public void showSoftKeyboard(View view) {

            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);

    }






/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ecran_premier, menu);
        return true;
    }



*/



/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

*/




    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
    public  SharedPreferences getSharedPreferences(){
        return sharedPreferences;


    }







public void calculer() {
    poidNetAnnonce = findViewById(R.id.poidNetAnnonce);
    poidBrut = findViewById(R.id.poidBrut);
    nombreDePalettes = findViewById(R.id.nombreDePalettes);
    poidPalet = findViewById(R.id.poidPalet);
    piecesParColis = findViewById(R.id.piecesParColis);
    colisParColonne = findViewById(R.id.colisParColonne);
    colisParTranche = findViewById(R.id.colisParTranche);
    tareColis = findViewById(R.id.tareColis);
    nombreDeColis = findViewById(R.id.nombreDeColis);
    piecesAbimees = findViewById(R.id.piecesAbimees);
    nombreColisEchantillon = findViewById(R.id.nombreColisEchantillon);
    poidEchantillon = findViewById(R.id.poidEchantillon);
    nombrePoidEchantillon = findViewById(R.id.nombrePoidEchantillon);

    resultat = findViewById(R.id.resultat);

    double poidNetAnnonceD = 0.0;
    double poidBrutD = 0.0;
    double nombreDePalettesD = 0.0;
    double poidPaletD = 0.0;
    double piecesParColisD = 0.0;
    double colisParColonneD = 0.0;
    double colisParTrancheD = 0.0;
    double tareColisD = 0.0;
    double nombreDeColisD = 0.0;
    double piecesAbimeesD = 0.0;
    double nombreColisEchantillonD = 0.0;
    double poidEchantillonD = 0.0;
    double nombrePoidEchantillonD = 0.0;

    try {
        poidNetAnnonceD = Double.parseDouble(poidNetAnnonce.getText().toString());
    } catch (Exception e) {
    }
    try {
        poidBrutD = Double.parseDouble(poidBrut.getText().toString());
    } catch (Exception e) {
    }
    try {
        nombreDePalettesD = Double.parseDouble(nombreDePalettes.getText().toString());
    } catch (Exception e) {
    }
    try {
        poidPaletD = Double.parseDouble(poidPalet.getText().toString());
    } catch (Exception e) {
    }
    try {
        piecesParColisD = Double.parseDouble(piecesParColis.getText().toString());
    } catch (Exception e) {
    }
    try {
        colisParColonneD = Double.parseDouble(colisParColonne.getText().toString());
    } catch (Exception e) {
    }
    try {
        colisParTrancheD = Double.parseDouble(colisParTranche.getText().toString());
    } catch (Exception e) {
    }
    try {
        tareColisD = Double.parseDouble(tareColis.getText().toString());
    } catch (Exception e) {
    }
    try {
        nombreDeColisD = Double.parseDouble(nombreDeColis.getText().toString());
    } catch (Exception e) {
    }
    try {
        piecesAbimeesD = Double.parseDouble(piecesAbimees.getText().toString());
    } catch (Exception e) {
    }
    try {
        nombreColisEchantillonD = Double.parseDouble(nombreColisEchantillon.getText().toString());
    } catch (Exception e) {
    }
    try {
        poidEchantillonD = Double.parseDouble(poidEchantillon.getText().toString());
    } catch (Exception e) {
    }
    try {
        nombrePoidEchantillonD = Double.parseDouble(nombrePoidEchantillon.getText().toString());
    } catch (Exception e) {
    }


    double poidNet = 0.0;
    double tarePalettes = 0.0;
    double nombreFruits = 0.0;
    double poidMoyenColis = 0.0;
    double tareColisTotale = 0.0;
    double tareTotale = 0.0;
    double pourcentageAbimes = 0.0;
    double poidMoyenParPiece = 0.0;
    double poidBrutAttendu = 0.0;
    double delta = 0.0;
    double nbrePiecesParColis = 0.0;

//TODO Penser a un systeme  plus ergonomique pour le calcul du nombre et du poid de palette intermediaires
    if (nombreDeColisD < 1) {
        nombreDeColisD = (colisParColonneD * colisParTrancheD) * nombreDePalettesD;

    }

    try {
        tareColisTotale = (tareColisD * nombreDeColisD);
    } catch (Exception e) {
    }
    try {
        tarePalettes = poidPaletD * nombreDePalettesD;
    } catch (Exception e) {
    }
    try {
        tareTotale = tareColisTotale + tarePalettes;
    } catch (Exception e) {
    }
    try {
        poidNet = poidBrutD - tareTotale;
    } catch (Exception e) {
    }
    try {
        poidMoyenColis = poidNet / nombreDeColisD;
    } catch (Exception e) {
    }
    try {
        if (piecesParColis.getText().length() < 1) {
            nombreFruits = nombreDeColisD * ((poidMoyenColis / poidEchantillonD) * nombrePoidEchantillonD);
            nbrePiecesParColis = (poidMoyenColis / poidEchantillonD) * nombrePoidEchantillonD;
        } else {
            nombreFruits = nombreDeColisD * piecesParColisD;
        }
    } catch (Exception e) {
    }


    try {
        poidMoyenParPiece = poidNet / nombreFruits;
    } catch (Exception e) {
    }
    try {
        if (piecesParColis.getText().length() < 1) {
            pourcentageAbimes = (piecesAbimeesD * 100) / (nbrePiecesParColis * nombreColisEchantillonD);
        }else {
            pourcentageAbimes = (piecesAbimeesD * 100) / (piecesParColisD * nombreColisEchantillonD);
        }
    } catch (Exception e) {
    }
    try {
        poidBrutAttendu = (poidNetAnnonceD + tareTotale) / 1;
    } catch (Exception e) {
    }
    try {
        delta = poidNet - poidNetAnnonceD;
    } catch (Exception e) {
    }

// TODO completer les manquants
    NumberFormat nf = new DecimalFormat("0.###");

    String poidNetString = nf.format(poidNet);
    if (poidBrut.getText().length() == 0) {
        poidNetString = getString(R.string.BrutManquant);
    }

    String tareTotaleString = nf.format(tareTotale);
    String tarePalettesString = nf.format(tarePalettes);
    String tareColisTotaleString = nf.format(tareColisTotale);
    String poidMoyenParPieceString = nf.format(poidMoyenParPiece);
    String nombreFruitsString = nf.format(nombreFruits);
    String nbrePiecesParColisString = nf.format(nbrePiecesParColis);
    if (poidBrut.getText().length() == 0) {
        poidMoyenParPieceString = getString(R.string.BrutManquant);
    }
    String pourcentageAbimesString = nf.format(pourcentageAbimes);
    String poidMoyenColisString = nf.format(poidMoyenColis);
    if (poidBrut.getText().length() == 0) {
        poidMoyenColisString = getString(R.string.BrutManquant);
    }
    String poidBrutAttenduString = nf.format(poidBrutAttendu);
    if (poidNetAnnonce.getText().length() == 0) {
        poidBrutAttenduString = getString(R.string.NetManquant);
    }
    String deltaString = nf.format(delta);
    if (poidBrut.getText().length() == 0 || poidNetAnnonce.getText().length() == 0) {
        deltaString = getString(R.string.BrutNetManquant);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if (fast == true) {
        if (reverse == false) {
            resultat.setText(
                    getString(R.string.PoidNetréel) + " : " + poidNetString + "\n" +
                            getString(R.string.NombredeFruits) + " : " + nombreFruitsString + "\n" +
                            getString(R.string.PoidNetMoyenColis) + "  : " + poidMoyenColisString + "\n" +
                            getString(R.string.PoidMoyenPièce) + "  : " + poidMoyenParPieceString + "\n" +
                            getString(R.string.Taretotale) + "  : " + tareTotaleString + " (" + tarePalettesString + "/" + tareColisTotaleString + ") " + "\n"

            )
            ;
        } else {
            resultat.setText(
                    getString(R.string.PoidBrutattendu) + " : " + poidBrutAttenduString + "\n" +
                            getString(R.string.PoidNetréel) + " : " + poidNetString + "\n" +
                            getString(R.string.Delta) + " : " + deltaString + "\n" +
                            getString(R.string.NombredeFruits) + " : " + nombreFruits + "\n" +
                            getString(R.string.PoidNetMoyenColis) + " : " + poidMoyenColisString + "\n" +
                            getString(R.string.PoidMoyenPièce) + " : " + poidMoyenParPieceString + "\n" +
                            getString(R.string.Taretotale) + " : " + tareTotaleString + " (" + tarePalettesString + "/" + tareColisTotaleString + ") " + "\n"

            )
            ;
        }

    }

    else {//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (reverse == false) {
            resultat.setText(
                    getString(R.string.PoidNetréel) + " : " + poidNetString + "\n" +
                            getString(R.string.NombredeFruits) + " : " + nombreFruitsString + "\n" +
                            getString(R.string.Piecescolis) + " : " + nbrePiecesParColisString + "\n" +
                            getString(R.string.PoidNetMoyenColis) + "  : " + poidMoyenColisString + "\n" +
                            getString(R.string.PoidMoyenPièce) + "  : " + poidMoyenParPieceString + "\n" +
                            getString(R.string.Taretotale) + "  : " + tareTotaleString + " (" + tarePalettesString + "/" + tareColisTotaleString + ") " + "\n" +
                            getString(R.string.Pourcentageabimés) + " : " + pourcentageAbimesString + "% " + getString(R.string.sur) + " " + nombreColisEchantillonD + " " + getString(R.string.colis) + " " + "\n" +
                            getString(R.string.Nombredecolis) + "  : " + nombreDeColisD + "\n"


            )
            ;
        } else {
            resultat.setText(
                    getString(R.string.PoidBrutattendu) + " : " + poidBrutAttenduString + "\n" +
                            getString(R.string.PoidNetréel) + " : " + poidNetString + "\n" +
                            getString(R.string.Delta) + " : " + deltaString + "\n" +
                            getString(R.string.NombredeFruits) + " : " + nombreFruits + "\n" +
                            getString(R.string.Piecescolis) + " : " + nbrePiecesParColisString + "\n" +
                            getString(R.string.PoidNetMoyenColis) + " : " + poidMoyenColisString + "\n" +
                            getString(R.string.PoidMoyenPièce) + " : " + poidMoyenParPieceString + "\n" +
                            getString(R.string.Taretotale) + " : " + tareTotaleString + " (" + tarePalettesString + "/" + tareColisTotaleString + ") " + "\n" +
                            getString(R.string.Pourcentageabimés) + " : " + pourcentageAbimesString + "% " + getString(R.string.sur) + " " + nombreColisEchantillonD + " " + getString(R.string.colis) + " " + "\n" +
                            getString(R.string.Nombredecolis) + " : " + nombreDeColisD + "\n"


            )
            ;
        }
    }
}





public void clear(){
    poidBrut = findViewById(R.id.poidBrut);
    nombreDePalettes = findViewById(R.id.nombreDePalettes);
    poidPalet = findViewById(R.id.poidPalet) ;
    piecesParColis = findViewById(R.id.piecesParColis);
    colisParColonne = findViewById(R.id.colisParColonne);
    colisParTranche = findViewById(R.id.colisParTranche);
    tareColis = findViewById(R.id.tareColis);
    nombreDeColis = findViewById(R.id.nombreDeColis);
    piecesAbimees = findViewById(R.id.piecesAbimees);
    nombreColisEchantillon = findViewById(R.id.nombreColisEchantillon);
    poidNetAnnonce = findViewById(R.id.poidNetAnnonce);
    poidEchantillon = findViewById(R.id.poidEchantillon);
    nombrePoidEchantillon = findViewById(R.id.nombrePoidEchantillon);

    poidBrut.getText().clear();
    nombreDePalettes.getText().clear();
    poidPalet.getText().clear();
    piecesParColis.getText().clear();
    colisParColonne.getText().clear();
    colisParTranche.getText().clear();
    tareColis.getText().clear();
    nombreDeColis.getText().clear();
    piecesAbimees.getText().clear();
    nombreColisEchantillon.getText().clear();
    poidNetAnnonce.getText().clear();
    poidEchantillon.getText().clear();
    nombrePoidEchantillon.getText().clear();

    setMasquerMultiplicateur();
    setUtiliserValeurParDefaut(outils.loadBoolean("utiliserValeurParDefaut", false));
}





public void switcherFullFast(){
        if(fast == true){
            fast = false;
            outils.saveBoolean("fullFastSwitch", false);
        }else {
            fast = true;
            outils.saveBoolean("fullFastSwitch", true);
        }
    }

public void fullFastSetup() {




    if (nombreDeColis.getText().length() > 0 ) { // || fast == true
        colisParTranche.setEnabled(false);
        colisParColonne.setEnabled(false);
        nombreDeColis.setNextFocusDownId(findViewById(R.id.tareColis).getId());


    } else {
        if(masquerMultiplicateur == false) {
            colisParTranche.setEnabled(true);
            colisParColonne.setEnabled(true);
            nombreDeColis.setNextFocusDownId(findViewById(R.id.colisParColonne).getId());
            //    colisParTranche.setFocusable(true);
            // colisParTranche.setBackgroundColor(android.R.attr.editTextColor);
            //  colisParColonne.setBackgroundColor(android.R.attr.editTextColor);
            //  colisParColonne.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        }
    }

    if(masquerMultiplicateur == false) {
        if (colisParColonne.getText().length() > 0 || colisParTranche.getText().length() > 0) {
            nombreDeColis.setEnabled(false);
            poidPalet.setNextFocusDownId(findViewById(R.id.colisParColonne).getId());
        } else {
            if (colisParColonne.getText().length() == 0 || colisParTranche.getText().length() == 0) {
                nombreDeColis.setEnabled(true);
                poidPalet.setNextFocusDownId(findViewById(R.id.nombreDeColis).getId());
            }

        }
    }








    if (piecesParColis.getText().length() > 0) {
        poidEchantillon.setEnabled(false);
        nombrePoidEchantillon.setEnabled(false);
        piecesParColis.setNextFocusDownId(findViewById(R.id.piecesAbimees).getId());


    } else {
        poidEchantillon.setEnabled(true);
        nombrePoidEchantillon.setEnabled(true);
        piecesParColis.setNextFocusDownId(findViewById(R.id.poidEchantillon).getId());

    }

    if (poidEchantillon.getText().length() > 0 ) {
        piecesParColis.setEnabled(false);
        tareColis.setNextFocusDownId(findViewById(R.id.poidEchantillon).getId());
    } else {
        if (poidEchantillon.getText().length() == 0 ) {
            piecesParColis.setEnabled(true);
           tareColis.setNextFocusDownId(findViewById(R.id.piecesParColis).getId());
        }

    }





    calculer();


}

public void fastMode(){
    setMasquerMultiplicateur();
    piecesParColis = findViewById(R.id.piecesParColis);
    nombreDeColis = findViewById(R.id.nombreDeColis);

    colonneTrancheLayout = findViewById(R.id.colonneTrancheLayout);
    colisParColonne = findViewById(R.id.colisParColonne);
    colisParTranche = findViewById(R.id.colisParTranche);

    tachesEchantillonLayout = findViewById(R.id.tachesEchantillonLayout);
    piecesAbimees = findViewById(R.id.piecesAbimees);
    nombreColisEchantillon = findViewById(R.id.nombreColisEchantillon);

    poidEchantillon = findViewById(R.id.poidEchantillon);
    nombrePoidEchantillon = findViewById(R.id.nombrePoidEchantillon);

        if(fast == false ) {
            colisParColonne.getText().clear();
            colisParTranche.getText().clear();
            piecesAbimees.getText().clear();
            nombreColisEchantillon.getText().clear();

            if(masquerMultiplicateur == false) {
                colonneTrancheLayout.setVisibility(View.VISIBLE);
                colisParColonne.setVisibility(View.VISIBLE);
                colisParTranche.setVisibility(View.VISIBLE);
                nombreDeColis.setNextFocusDownId(findViewById(R.id.colisParColonne).getId());

        }else {
            colonneTrancheLayout.setVisibility(View.GONE);
            colisParColonne.setVisibility(View.GONE);
            colisParTranche.setVisibility(View.GONE);
            nombreDeColis.setNextFocusDownId(findViewById(R.id.tareColis).getId());
        }

            tachesEchantillonLayout.setVisibility(View.VISIBLE);
            piecesAbimees.setVisibility(View.VISIBLE);
            nombreColisEchantillon.setVisibility(View.VISIBLE);

            poidEchantillon.setVisibility(View.VISIBLE);
            nombrePoidEchantillon.setVisibility(View.VISIBLE);

         //   nombreDeColis.setNextFocusDownId(findViewById(R.id.colisParColonne).getId());
            piecesParColis.setNextFocusDownId(findViewById(R.id.poidEchantillon).getId());

             poidEchantillon.setNextFocusDownId(findViewById(R.id.nombrePoidEchantillon).getId());
             nombrePoidEchantillon.setNextFocusDownId(findViewById(R.id.piecesAbimees).getId());





            fullFastSetup();



        }else {


            colisParColonne.getText().clear();
            colisParTranche.getText().clear();
            piecesAbimees.getText().clear();
            nombreColisEchantillon.getText().clear();
            poidEchantillon.getText().clear();
            nombrePoidEchantillon.getText().clear();

            colonneTrancheLayout.setVisibility(View.GONE);
            colisParColonne.setVisibility(View.GONE);
            colisParTranche.setVisibility(View.GONE);

            tachesEchantillonLayout.setVisibility(View.GONE);
            piecesAbimees.setVisibility(View.GONE);
            nombreColisEchantillon.setVisibility(View.GONE);

            poidEchantillon.setVisibility(View.GONE);
            nombrePoidEchantillon.setVisibility(View.GONE);

            nombreDeColis.setNextFocusDownId(findViewById(R.id.tareColis).getId());
            piecesParColis.setNextFocusDownId(findViewById(R.id.fab).getId());



          //  fullFastSetup();

        }


}




 public void switcherReverse(){
     if(reverse == true){
         reverse = false;
         outils.saveBoolean("reverseSwitch", false);
     }else {
         reverse = true;
         outils.saveBoolean("reverseSwitch", true);
     }
 }



public void reversePalets(){

    poidNetInputLayout = findViewById(R.id.poidNetInputLayout);
    poidNetAnnonce = findViewById(R.id.poidNetAnnonce);
    poidBrut = findViewById(R.id.poidBrut);

    if(reverse == false) {
        poidNetInputLayout.setVisibility(View.GONE);
        poidBrut.requestFocus();
        poidNetAnnonce.getText().clear();
        calculer();
       // clear();
    }else {
        poidNetInputLayout.setVisibility(View.VISIBLE);
        poidNetAnnonce.requestFocus();
        calculer();
    }


}

    public void setSelectAllParDefaut(boolean trueOrFalse){
        poidBrut = findViewById(R.id.poidBrut);
        poidNetAnnonce = findViewById(R.id.poidNetAnnonce);
        nombreDePalettes = findViewById(R.id.nombreDePalettes);
        poidPalet = findViewById(R.id.poidPalet);
        piecesParColis = findViewById(R.id.piecesParColis);
        colisParColonne = findViewById(R.id.colisParColonne);
        colisParTranche = findViewById(R.id.colisParTranche);
        tareColis = findViewById(R.id.tareColis);
        nombreDeColis = findViewById(R.id.nombreDeColis);
        piecesAbimees = findViewById(R.id.piecesAbimees);
        nombreColisEchantillon = findViewById(R.id.nombreColisEchantillon);
        poidEchantillon = findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = findViewById(R.id.nombrePoidEchantillon);

        poidBrut.setSelectAllOnFocus(trueOrFalse);
        nombreDePalettes.setSelectAllOnFocus(trueOrFalse);
        poidPalet.setSelectAllOnFocus(trueOrFalse);
        piecesParColis.setSelectAllOnFocus(trueOrFalse);
        colisParColonne.setSelectAllOnFocus(trueOrFalse);
        colisParTranche.setSelectAllOnFocus(trueOrFalse);
        tareColis.setSelectAllOnFocus(trueOrFalse);
        nombreDeColis.setSelectAllOnFocus(trueOrFalse);
        piecesAbimees.setSelectAllOnFocus(trueOrFalse);
        nombreColisEchantillon.setSelectAllOnFocus(trueOrFalse);
        poidNetAnnonce.setSelectAllOnFocus(trueOrFalse);
        poidEchantillon.setSelectAllOnFocus(trueOrFalse);
        nombrePoidEchantillon.setSelectAllOnFocus(trueOrFalse);


    }
    public void setUtiliserValeurParDefaut(boolean trueOrFalse){
if(trueOrFalse == true) {
    nombreDePalettes = findViewById(R.id.nombreDePalettes);
    poidPalet = findViewById(R.id.poidPalet);
    tareColis = findViewById(R.id.tareColis);
    nombrePoidEchantillon.findViewById(R.id.nombrePoidEchantillon);

    if(outils.loadString("defautNombrePalettes", "").length() > 0){
        nombreDePalettes.setText(outils.loadString("defautNombrePalettes", ""));
    }
    if(outils.loadString("defautTarePalette", "").length() > 0){
        poidPalet.setText(outils.loadString("defautTarePalette", ""));
    }
    if(outils.loadString("defautTareColis", "").length() > 0){
        tareColis.setText(outils.loadString("defautTareColis", ""));
    }
    if(outils.loadString("defautNombrePoidEchantillon", "").length() > 0){
        nombrePoidEchantillon.setText(outils.loadString("defautNombrePoidEchantillon", ""));
    }
  /*
  nombreDePalettes.setText(outils.loadString("defautNombrePalettes",""));
    poidPalet.setText(outils.loadString("defautTarePalette",""));
    tareColis.setText(outils.loadString("defautTareColis",""));
    */
 //   nombreDePalettes.setText("1");

  //  poidPalet.setText("25");
 //   tareColis.setText("0.6");
}


    }

    public void setMasquerMultiplicateur() {
       masquerMultiplicateur = (outils.loadBoolean("masquerMultiplicateur", true));
       // fullFastSetup();
    }



    /*



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //innerclass


   // A placeholder fragment containing a simple view.

    public static class PlaceholderFragment extends Fragment {
        //
         // The fragment argument representing the section number for this
         // fragment.
         //
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        //
         // Returns a new instance of this fragment for the given section
         // number.
         //
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_ecran_premier, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    //
     // A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     // one of the sections/tabs/pages.
     //
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

*/
}
