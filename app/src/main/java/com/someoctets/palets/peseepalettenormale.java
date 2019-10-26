package com.someoctets.palets;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link peseepalettenormale.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link peseepalettenormale#newInstance} factory method to
 * create an instance of this fragment.
 */
public class peseepalettenormale extends Fragment  {

    public SharedPreferences sharedPreferences;


    boolean fast = false;
    boolean reverse = false;

    private LinearLayout linearLayoutA;

    private MemoryTextInputEditText poidBrut;
    private MemoryTextInputEditText nombreDePalettes;
    private MemoryTextInputEditText poidPalet;
    private MemoryTextInputEditText piecesParColis;
    private MemoryTextInputEditText colisParColonne;
    private MemoryTextInputEditText colisParTranche;
    private MemoryTextInputEditText tareColis;
    private MemoryTextInputEditText nombreDeColis;
    private MemoryTextInputEditText piecesAbimees;
    private MemoryTextInputEditText nombreColisEchantillon;
    private MemoryTextInputEditText poidNetAnnonce;
    private MemoryTextInputEditText poidEchantillon;
    private MemoryTextInputEditText nombrePoidEchantillon;

    //Les champs texte memoires des memoryInputEditText
    private TextView memoire1;
    private TextView memoire2;
    private TextView memoire3;
    private TextView memoire4;
    private TextView memoire5;
    private TextView memoire6;
    private TextView memoire7;
    private TextView memoire8;
    private TextView memoire9;
    private TextView memoire10;
    private TextView memoire11;
    private TextView memoire12;

    private TextView rappelSourceTextView;

    private MemoryTextInputEditText selectedInputEditText; //Etat
    private MemoryTextInputEditText focusSource = null; //Etat

    private ArrayList<MemoryTextInputEditText> listeInputText = new ArrayList<MemoryTextInputEditText>();


    private LinearLayout colonneTrancheLayout;
    private LinearLayout tachesEchantillonLayout;
    private LinearLayout nombrePoidEchantillonLayout;


    private FrameLayout frameAddition;
    private TextInputEditText additionInputText;

    private TextInputLayout poidNetInputLayout;
    private ScrollView scrollView;
    private CoordinatorLayout ecran;
    private EditText resultat;

    public Outils outils = Outils.getInstanceOutils();
    boolean selectAllParDefaut;
    boolean utiliserValeurParDefaut;
    boolean masquerMultiplicateur;
    boolean masquerAdditionneur;
    ViewGroup root;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public peseepalettenormale() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment peseepalettenormale.
     */
    // TODO: Rename and change types and number of parameters
    public static peseepalettenormale newInstance(String param1, String param2) {
        peseepalettenormale fragment = new peseepalettenormale();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root = (ViewGroup) inflater.inflate(R.layout.activity_peseepalettenormale, null);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        outils.setSharedPreferences(sharedPreferences);


        reverse = outils.loadBoolean("reverseSwitch", false);
        fast = outils.loadBoolean("fullFastSwitch", false);

        poidBrut = root.findViewById(R.id.poidBrut);
        nombreDePalettes = root.findViewById(R.id.nombreDePalettes);
        poidPalet = root.findViewById(R.id.poidPalet);
        piecesParColis = root.findViewById(R.id.piecesParColis);
        poidEchantillon = root.findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = root.findViewById(R.id.nombrePoidEchantillon);
        colisParColonne = root.findViewById(R.id.colisParColonne);
        colisParTranche = root.findViewById(R.id.colisParTranche);
        tareColis = root.findViewById(R.id.tareColis);
        nombreDeColis = root.findViewById(R.id.nombreDeColis);
        piecesAbimees = root.findViewById(R.id.piecesAbimees);
        nombreColisEchantillon = root.findViewById(R.id.nombreColisEchantillon);
        poidNetAnnonce = root.findViewById(R.id.poidNetAnnonce);

        rappelSourceTextView = root.findViewById(R.id.rappelSourceTextView);

        listeInputText.add(poidBrut);
        listeInputText.add(nombreDePalettes);
        listeInputText.add(poidPalet);
        listeInputText.add(piecesParColis);
        listeInputText.add(colisParColonne);
        listeInputText.add(colisParTranche);
        listeInputText.add(tareColis);
        listeInputText.add(nombreDeColis);
        listeInputText.add(piecesAbimees);
        listeInputText.add(nombreColisEchantillon);
        listeInputText.add(poidNetAnnonce);
        listeInputText.add(poidEchantillon);
        listeInputText.add(nombrePoidEchantillon);

        memoire1 = root.findViewById(R.id.memoire1);
        memoire2 = root.findViewById(R.id.memoire2);
        memoire3 = root.findViewById(R.id.memoire3);
        memoire4 = root.findViewById(R.id.memoire4);
        memoire5 = root.findViewById(R.id.memoire5);
        memoire6 = root.findViewById(R.id.memoire6);
        memoire7 = root.findViewById(R.id.memoire7);
        memoire8 = root.findViewById(R.id.memoire8);
        memoire9 = root.findViewById(R.id.memoire9);
        memoire10 = root.findViewById(R.id.memoire10);
        memoire11 = root.findViewById(R.id.memoire11);
        memoire12 = root.findViewById(R.id.memoire12);


        FloatingActionButton fab = root.findViewById(R.id.fab);
        masquerAdditionneur =   outils.loadBoolean("masquerAdditionneur", false);
        if( masquerAdditionneur == true){
            fab.hide();
        }else {
            fab.show();
        }





        final ConstraintLayout optionsButton = (ConstraintLayout) root.findViewById(R.id.titreToolbar);
        optionsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Options.class);
                //startActivity(intent);
                startActivityForResult(intent, 1);



            }

        });


        Button clearButton = root.findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        clear();

                    }
                });

        Switch reverseSwitch = root.findViewById(R.id.reverse);
        reverseSwitch.setChecked(reverse);
        reversePalets();
        reverseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                switcherReverse();
                reversePalets();

            }
        });


        Switch fullFastSwitch = root.findViewById(R.id.fullFastSwitch);
        fullFastSwitch.setChecked(fast);
        fastMode();
        fullFastSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                switcherFullFast();
                fastMode();

            }
        });

        /*     linearLayoutA = root.findViewById(R.id.linearLayoutA);*/
        frameAddition = root.findViewById(R.id.frameAddition);
        additionInputText = root.findViewById(R.id.additionInputText);
        //TODO gerer etat fab et faire les calculs avec une calculette interne


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double focusDouble = 0;
                //ouverture de la fenetre FAB
                if (frameAddition.getVisibility() == View.GONE) {
                    frameAddition.setVisibility(View.VISIBLE);


                    if (selectedInputEditText != null) {
                        focusSource = selectedInputEditText;
                    } else {
                        selectedInputEditText = (MemoryTextInputEditText) getActivity().getCurrentFocus();
                        focusSource = selectedInputEditText;
                    }

                    try {
                        focusDouble = Double.parseDouble(selectedInputEditText.getText().toString());
                    } catch (Exception e) { }


                    // String valeurSource = selectedInputEditText.getText().toString();
                    rappelSourceTextView.setText(focusDouble + " + ");


                    //  for(String mem : selectedInputEditText.getListeMemoire()){ //selectedInputEditText.getListeMemoire().size()
                    if(!selectedInputEditText.getMemoire(0).contentEquals(focusSource.getText().toString())) {
                        selectedInputEditText.setMemoire(String.valueOf(focusDouble));
                    }
                    memoire1.setText(selectedInputEditText.getMemoire(0));
                    memoire2.setText(selectedInputEditText.getMemoire(1));
                    memoire3.setText(selectedInputEditText.getMemoire(2));
                    memoire4.setText(selectedInputEditText.getMemoire(3));
                    memoire5.setText(selectedInputEditText.getMemoire(4));
                    memoire6.setText(selectedInputEditText.getMemoire(5));
                    memoire7.setText(selectedInputEditText.getMemoire(6));
                    memoire8.setText(selectedInputEditText.getMemoire(7));
                    memoire9.setText(selectedInputEditText.getMemoire(8));
                    memoire10.setText(selectedInputEditText.getMemoire(9));
                    memoire11.setText(selectedInputEditText.getMemoire(10));
                    memoire12.setText(selectedInputEditText.getMemoire(11));


                    additionInputText.setSelection(additionInputText.getText().length());
                    additionInputText.requestFocus();

                } else { //Fermeture de la fenetre FAB
                    //   int sizeListeMemoire = selectedInputEditText.getListeMemoire().size() - 1;

                    try {
                        focusDouble = Double.parseDouble(selectedInputEditText.getText().toString());
                    } catch (Exception e) { }

                    double additionInputTextDouble = 0;
                    try {
                        additionInputTextDouble = Double.parseDouble(additionInputText.getText().toString());
                    } catch (Exception e) { }
/*
                    ArrayList<Double> listeDouble = new ArrayList<Double>();
                    ArrayList<String> listeString = new ArrayList<String>();


                    for(String s : additionInputText.getText().toString().split("\\+".trim())) {
                        try {
                            double doubleS = Double.parseDouble(s);

                            listeDouble.add( doubleS);
                            listeString.add( String.valueOf(doubleS));
                        }catch (Exception e){}
                    }

                    String recomposition = "";
                    int t = 0;
                    for (String s : listeString) {
                        if (t > 0) {
                            recomposition = recomposition + " + " + s;
                        } else {
                            recomposition = s;
                        }
                        t++;
                    }

                    if (additionInputText.getText().toString().length() > 0 && !recomposition.contentEquals(String.valueOf(focusDouble)) && recomposition.length() > 0) {
                        selectedInputEditText.setMemoire(recomposition); // on enregistre
                    }else {}
*/
                    if (additionInputText.getText().toString().length() > 0) {
                        selectedInputEditText.setMemoire(String.valueOf(additionInputTextDouble)); // on enregistre
                    }


                    focusSource.setText(String.valueOf(calculateur(focusDouble)));
                    focusSource.setSelection(focusSource.getText().length());
                    focusSource.requestFocus();
                    additionInputText.setText("");
                    frameAddition.setVisibility(View.GONE);
                }

                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", new onClick()).show();
            }
        });


        // on gere les preferences utilisateurs


        setSelectAllParDefaut(outils.loadBoolean("selectionnerToutParDefaut", true));
        setUtiliserValeurParDefaut(outils.loadBoolean("utiliserValeurParDefaut", false));
        setMasquerMultiplicateur();



        // listenner de texte
        //TODO en cour
        for (MemoryTextInputEditText textInput : listeInputText) {
            final MemoryTextInputEditText textInput2 = textInput;
            textInput2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    setSelectedInputEditText(textInput2);
                }
            });


            textInput2.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int st, int b, int c) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int st, int c, int a) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    fullFastSetup();
                    calculer();
                }
            });


            // Set an OnTouchListener to always return true for onTouch events so that a touch
            // sequence cannot pass through the item to the item below.
            frameAddition = root.findViewById(R.id.frameAddition);
            frameAddition.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.onTouchEvent(event);
                    return true;
                }
            });


            additionInputText = root.findViewById(R.id.additionInputText);
            additionInputText.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int st, int b, int c) {

                }

                @Override
                public void beforeTextChanged(CharSequence s, int st, int c, int a) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    //   calculateur();
                }
            });
        }
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

        poidBrut.requestFocus();
        return root;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////



    public double calculateur(double source) {
        additionInputText = root.findViewById(R.id.additionInputText);
        String ligne = additionInputText.getText().toString();
        double resultat = 0;
      /*
        try {

            List<String> items = Arrays.asList(ligne.split("\\+"));
            for (String item : items) {

                resultat = resultat + Double.parseDouble(item);
            }
            // String l1 = ligne.split("\\+")[0];

        } catch (Exception e) {
        }
        */
        resultat = source;
        try { // on catch l'erreur si un string est vi
            // e
            resultat = source + Double.parseDouble(ligne);
        }catch(Exception e){}

        return resultat;
    }







    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            FloatingActionButton fab = root.findViewById(R.id.fab);
            masquerAdditionneur =   outils.loadBoolean("masquerAdditionneur", false);
            if( masquerAdditionneur == true){
                fab.hide();
            }else {
                fab.show();
            }
        }
/*

            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
        */
    }//onActivityResult












    public void setSelectedInputEditText(MemoryTextInputEditText selected) {
        if (selected.getClass() == MemoryTextInputEditText.class) {
            selectedInputEditText = selected;
        }

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
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);

    }












    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;


    }









    public void calculer() {
        poidNetAnnonce = root.findViewById(R.id.poidNetAnnonce);
        poidBrut = root.findViewById(R.id.poidBrut);
        nombreDePalettes = root.findViewById(R.id.nombreDePalettes);
        poidPalet = root.findViewById(R.id.poidPalet);
        piecesParColis = root.findViewById(R.id.piecesParColis);
        colisParColonne = root.findViewById(R.id.colisParColonne);
        colisParTranche = root.findViewById(R.id.colisParTranche);
        tareColis = root.findViewById(R.id.tareColis);
        nombreDeColis = root.findViewById(R.id.nombreDeColis);
        piecesAbimees = root.findViewById(R.id.piecesAbimees);
        nombreColisEchantillon = root.findViewById(R.id.nombreColisEchantillon);
        poidEchantillon = root.findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = root.findViewById(R.id.nombrePoidEchantillon);

        resultat = root.findViewById(R.id.resultat);

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
            } else {
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

        } else {//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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









    public void clear() {
        FloatingActionButton fab = root.findViewById(R.id.fab);
        poidBrut = root.findViewById(R.id.poidBrut);
        nombreDePalettes = root.findViewById(R.id.nombreDePalettes);
        poidPalet = root.findViewById(R.id.poidPalet);
        piecesParColis = root.findViewById(R.id.piecesParColis);
        colisParColonne = root.findViewById(R.id.colisParColonne);
        colisParTranche = root.findViewById(R.id.colisParTranche);
        tareColis = root.findViewById(R.id.tareColis);
        nombreDeColis = root.findViewById(R.id.nombreDeColis);
        piecesAbimees = root.findViewById(R.id.piecesAbimees);
        nombreColisEchantillon = root.findViewById(R.id.nombreColisEchantillon);
        poidNetAnnonce = root.findViewById(R.id.poidNetAnnonce);
        poidEchantillon = root.findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = root.findViewById(R.id.nombrePoidEchantillon);

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

        masquerAdditionneur =   outils.loadBoolean("masquerAdditionneur", false);
        if( masquerAdditionneur == true){
            fab.hide();
        }else {
            fab.show();
        }
    }











    public void switcherFullFast() {
        if (fast == true) {
            fast = false;
            outils.saveBoolean("fullFastSwitch", false);
        } else {
            fast = true;
            outils.saveBoolean("fullFastSwitch", true);
        }
    }

    public void fullFastSetup() {


        if (nombreDeColis.getText().length() > 0) { // || fast == true
            colisParTranche.setEnabled(false);
            colisParColonne.setEnabled(false);
            nombreDeColis.setNextFocusDownId(root.findViewById(R.id.tareColis).getId());


        } else {
            if (masquerMultiplicateur == false) {
                colisParTranche.setEnabled(true);
                colisParColonne.setEnabled(true);
                nombreDeColis.setNextFocusDownId(root.findViewById(R.id.colisParColonne).getId());
                //    colisParTranche.setFocusable(true);
                // colisParTranche.setBackgroundColor(android.R.attr.editTextColor);
                //  colisParColonne.setBackgroundColor(android.R.attr.editTextColor);
                //  colisParColonne.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            }
        }

        if (masquerMultiplicateur == false) {
            if (colisParColonne.getText().length() > 0 || colisParTranche.getText().length() > 0) {
                nombreDeColis.setEnabled(false);
                poidPalet.setNextFocusDownId(root.findViewById(R.id.colisParColonne).getId());
            } else {
                if (colisParColonne.getText().length() == 0 || colisParTranche.getText().length() == 0) {
                    nombreDeColis.setEnabled(true);
                    poidPalet.setNextFocusDownId(root.findViewById(R.id.nombreDeColis).getId());
                }

            }
        }


        if (piecesParColis.getText().length() > 0) {
            poidEchantillon.setEnabled(false);
            nombrePoidEchantillon.setEnabled(false);
            if (fast == false) { //fast switch true -> fastMode //fast switch false -> fullMode
                piecesParColis.setNextFocusDownId(root.findViewById(R.id.piecesAbimees).getId());
            } else {
                //  piecesParColis.setNextFocusDownId(root.findViewById(R.id.fab).getId()); // todo surveiller en cas de requestfocus impossible
                piecesParColis.setImeOptions(EditorInfo.IME_ACTION_DONE); // correction requestfocus
            }

        } else {
            if (fast == false) { //fast switch true -> fastMode //fast switch false -> fullMode
                poidEchantillon.setEnabled(true);
                nombrePoidEchantillon.setEnabled(true);
                piecesParColis.setNextFocusDownId(root.findViewById(R.id.poidEchantillon).getId());
            } else {
                //  piecesParColis.setNextFocusDownId(root.findViewById(R.id.fab).getId());
                piecesParColis.setImeOptions(EditorInfo.IME_ACTION_DONE); // correction requestfocus
            }
        }

        if (poidEchantillon.getText().length() > 0) {
            piecesParColis.setEnabled(false);
            tareColis.setNextFocusDownId(root.findViewById(R.id.poidEchantillon).getId());
        } else {
            if (poidEchantillon.getText().length() == 0) {
                piecesParColis.setEnabled(true);
                tareColis.setNextFocusDownId(root.findViewById(R.id.piecesParColis).getId());
            }

        }


        calculer();


    }







    public void fastMode() {
        setMasquerMultiplicateur();
        piecesParColis = root.findViewById(R.id.piecesParColis);
        nombreDeColis = root.findViewById(R.id.nombreDeColis);

        colonneTrancheLayout = root.findViewById(R.id.colonneTrancheLayout);
        colisParColonne = root.findViewById(R.id.colisParColonne);
        colisParTranche = root.findViewById(R.id.colisParTranche);

        tachesEchantillonLayout = root.findViewById(R.id.tachesEchantillonLayout);
        piecesAbimees = root.findViewById(R.id.piecesAbimees);
        nombreColisEchantillon = root.findViewById(R.id.nombreColisEchantillon);

        poidEchantillon = root.findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = root.findViewById(R.id.nombrePoidEchantillon);

        if (fast == false) {
            colisParColonne.getText().clear();
            colisParTranche.getText().clear();
            piecesAbimees.getText().clear();
            nombreColisEchantillon.getText().clear();

            if (masquerMultiplicateur == false) {
                colonneTrancheLayout.setVisibility(View.VISIBLE);
                colisParColonne.setVisibility(View.VISIBLE);
                colisParTranche.setVisibility(View.VISIBLE);
                nombreDeColis.setNextFocusDownId(root.findViewById(R.id.colisParColonne).getId());

            } else {
                colonneTrancheLayout.setVisibility(View.GONE);
                colisParColonne.setVisibility(View.GONE);
                colisParTranche.setVisibility(View.GONE);
                nombreDeColis.setNextFocusDownId(root.findViewById(R.id.tareColis).getId());
            }

            tachesEchantillonLayout.setVisibility(View.VISIBLE);
            piecesAbimees.setVisibility(View.VISIBLE);
            nombreColisEchantillon.setVisibility(View.VISIBLE);

            poidEchantillon.setVisibility(View.VISIBLE);
            nombrePoidEchantillon.setVisibility(View.VISIBLE);
                /*
                if(outils.loadString("defautNombrePoidEchantillon", "").length() > 0){
                    nombrePoidEchantillon.setText(outils.loadString("defautNombrePoidEchantillon", ""));
                }
*/

            //   nombreDeColis.setNextFocusDownId(root.findViewById(R.id.colisParColonne).getId());
            piecesParColis.setNextFocusDownId(root.findViewById(R.id.poidEchantillon).getId());

            poidEchantillon.setNextFocusDownId(root.findViewById(R.id.nombrePoidEchantillon).getId());
            nombrePoidEchantillon.setNextFocusDownId(root.findViewById(R.id.piecesAbimees).getId());


            fullFastSetup();
            calculer();


        } else {


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

            nombreDeColis.setNextFocusDownId(root.findViewById(R.id.tareColis).getId());
            // piecesParColis.setNextFocusDownId(root.findViewById(R.id.fab).getId());// correction requestfocus
            piecesParColis.setImeOptions(EditorInfo.IME_ACTION_DONE); // correction requestfocus

            calculer();
            //  fullFastSetup();

        }


    }










    public void switcherReverse() {
        if (reverse == true) {
            reverse = false;
            outils.saveBoolean("reverseSwitch", false);
        } else {
            reverse = true;
            outils.saveBoolean("reverseSwitch", true);
        }
    }








    public void reversePalets() {

        poidNetInputLayout = root.findViewById(R.id.poidNetInputLayout);
        poidNetAnnonce = root.findViewById(R.id.poidNetAnnonce);
        poidBrut = root.findViewById(R.id.poidBrut);

        if (reverse == false) {
            poidNetInputLayout.setVisibility(View.GONE);
            poidBrut.requestFocus();
            poidNetAnnonce.getText().clear();
            calculer();
            // clear();
        } else {
            poidNetInputLayout.setVisibility(View.VISIBLE);
            poidNetAnnonce.requestFocus();
            calculer();
        }


    }

    public void setSelectAllParDefaut(boolean trueOrFalse) {
        poidBrut = root.findViewById(R.id.poidBrut);
        poidNetAnnonce = root.findViewById(R.id.poidNetAnnonce);
        nombreDePalettes = root.findViewById(R.id.nombreDePalettes);
        poidPalet = root.findViewById(R.id.poidPalet);
        piecesParColis = root.findViewById(R.id.piecesParColis);
        colisParColonne = root.findViewById(R.id.colisParColonne);
        colisParTranche = root.findViewById(R.id.colisParTranche);
        tareColis = root.findViewById(R.id.tareColis);
        nombreDeColis = root.findViewById(R.id.nombreDeColis);
        piecesAbimees = root.findViewById(R.id.piecesAbimees);
        nombreColisEchantillon = root.findViewById(R.id.nombreColisEchantillon);
        poidEchantillon = root.findViewById(R.id.poidEchantillon);
        nombrePoidEchantillon = root.findViewById(R.id.nombrePoidEchantillon);

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

    public void setUtiliserValeurParDefaut(boolean trueOrFalse) {
        if (trueOrFalse == true) {
            nombreDePalettes = root.findViewById(R.id.nombreDePalettes);
            poidPalet = root.findViewById(R.id.poidPalet);
            tareColis = root.findViewById(R.id.tareColis);
            nombrePoidEchantillon = root.findViewById(R.id.nombrePoidEchantillon);

            if (outils.loadString("defautNombrePalettes", "").length() > 0) {
                nombreDePalettes.setText(outils.loadString("defautNombrePalettes", ""));
            }
            if (outils.loadString("defautTarePalette", "").length() > 0) {
                poidPalet.setText(outils.loadString("defautTarePalette", ""));
            }
            if (outils.loadString("defautTareColis", "").length() > 0) {
                tareColis.setText(outils.loadString("defautTareColis", ""));
            }
            if (outils.loadString("defautNombrePoidEchantillon", "").length() > 0) {
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


}
