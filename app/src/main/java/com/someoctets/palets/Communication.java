package com.someoctets.palets;



import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.textfield.TextInputEditText;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Reconstructionpalette.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Reconstructionpalette#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Communication extends Fragment {
    ViewGroup root ;
    TextView txtData;
    TextInputEditText nombreColisET;
    //entrées reçus :
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

    //resultats reçus :
    double poidNet = 0;
    double tarePalettes = 0;
    double nombreFruits = 0;
    double poidsMoyenColis = 0;
    double tareColisTotale = 0;
    double tareTotale = 0;
    double pourcentageAbimes = 0;
    double poidMoyenParPiece = 0;
    double poidBrutAttendu = 0;
    double delta = 0;
    double nbrePiecesParColis = 0;








    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Communication() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reconstructionpalette.
     */
    // TODO: Rename and change types and number of parameters
    public static Communication newInstance(String param1, String param2) {
        Communication fragment = new Communication();

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.activity_communication, null);


        //TODO en cour
        nombreColisET = root.findViewById(R.id.nombreColis);
        nombreColisET.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                calculer();
            }
        });




        // Inflate the layout for this fragment
        return root;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtData = (TextView)view.findViewById(R.id.resultatCommunication);

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

    protected void displayReceivedData(ArrayList<Double> listeResultats, ArrayList<Double> listeEntrees)
    {
        try {
   /*        txtData.setText("Données reçues : "+ "\n" +
                           listeResultats.get(0) + "\n" +
                           listeResultats.get(1) + "\n" +
                           listeResultats.get(2) + "\n" +
                           listeResultats.get(3) + "\n" +
                           listeResultats.get(4) + "\n" +
                           listeResultats.get(5) + "\n" +
                           listeResultats.get(6) + "\n" +
                           listeResultats.get(7) + "\n" +
                           listeResultats.get(8) + "\n" +
                           listeResultats.get(9) + "\n" +
                           listeResultats.get(10) + "\n"

                   );

    */
            //   listeResultats.add(0,poidNet);
            //   listeResultat.add(1,tarePalettes);
            //   listeResultat.add(2,nombreFruits);
            //   listeResultat.add(3,poidMoyenColis);
            //   listeResultat.add(4,tareColisTotale);
            //   listeResultat.add(5,tareTotale);
            //   listeResultat.add(6,pourcentageAbimes);
            //   listeResultat.add(7,poidMoyenParPiece);
            //   listeResultat.add(8,poidBrutAttendu);
            //   listeResultat.add(9,delta);
            //   listeResultat.add(10,nbrePiecesParColis);

            //resultats reçus :
            poidNet =  listeResultats.get(0);
            tarePalettes =  listeResultats.get(1);
            nombreFruits =  listeResultats.get(2);
            poidsMoyenColis =  listeResultats.get(3);
            tareColisTotale =  listeResultats.get(4);
            tareTotale =  listeResultats.get(5);
            pourcentageAbimes =  listeResultats.get(6);
            poidMoyenParPiece =  listeResultats.get(7);
            poidBrutAttendu =  listeResultats.get(8);
            delta =  listeResultats.get(9);
            nbrePiecesParColis =  listeResultats.get(10);







            //listeEntrees.add(0,poidNetAnnonceD);
            //listeEntrees.add(1,poidBrutD);
            //listeEntrees.add(2,nombreDePalettesD);
            //listeEntrees.add(3,poidPaletD);
            //listeEntrees.add(4,piecesParColisD);
            //listeEntrees.add(5,colisParColonneD);
            //listeEntrees.add(6,colisParTrancheD);
            //listeEntrees.add(7,tareColisD);
            //listeEntrees.add(8,nombreDeColisD);
            //listeEntrees.add(9,piecesAbimeesD);
            //listeEntrees.add(10,nombreColisEchantillonD);
            //listeEntrees.add(11,poidEchantillonD);
            //listeEntrees.add(12,nombrePoidEchantillonD);
            //entrées reçues :
            poidNetAnnonceD = listeEntrees.get(0);
            poidBrutD = listeEntrees.get(1);
            nombreDePalettesD = listeEntrees.get(2);
            poidPaletD = listeEntrees.get(3);
            piecesParColisD = listeEntrees.get(4);
            colisParColonneD = listeEntrees.get(5);
            colisParTrancheD = listeEntrees.get(6);
            tareColisD = listeEntrees.get(7);
            nombreDeColisD = listeEntrees.get(8);
            piecesAbimeesD = listeEntrees.get(9);
            nombreColisEchantillonD = listeEntrees.get(10);
            poidEchantillonD = listeEntrees.get(11);
            nombrePoidEchantillonD = listeEntrees.get(12);



        }catch(Exception e){}
        calculer();
    }





    public void calculer(){
        double nombreColisVoulus  = 0.0;
        //nombreColisET = root.findViewById(R.id.nombreColis);
        NumberFormat nf = new DecimalFormat("0.###");
/*
        //on tranfomre en string :
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
        String poidMoyenColisString = nf.format(poidsMoyenColis);
        if (poidBrut.getText().length() == 0) {
            poidMoyenColisString = getString(R.string.BrutManquant);
        }
        String poidBrutAttenduString = nf.format(poidBrutAttendu);
        if (poidNetAnnonce.getText().length() == 0) {
            poidBrutAttenduString = getString(R.string.NetManquant);
        }
        String deltaString = nf.format(delta);
        if (poidBrut.getText().length() == 0 || poidNetAnnonceD.length() == 0) {
            deltaString = getString(R.string.BrutNetManquant);
        }


*/

        try {
            nombreColisVoulus = Double.parseDouble(nombreColisET.getText().toString());
        } catch (Exception e) {
            nombreColisVoulus = 0;
        }


        //double resultat =  (nombreColisVoulus * poidsMoyenColis );
        try {
            txtData.setText(getString(R.string.PoidMoyenParColisSource) + " : " + (poidsMoyenColis) + "\n" +
                    getString(R.string.PoidNetReconstruit) + " : " + nf.format(nombreColisVoulus * poidsMoyenColis) + "\n" +
                    getString(R.string.Delta) + " : " + nf.format((nombreColisVoulus * poidsMoyenColis) - poidNetAnnonceD) + "\n" +
                    getString(R.string.Piecescolis) + " :  " + nf.format(nbrePiecesParColis) + "\n" +
                    getString(R.string.NombredeFruits) + " : " + nf.format(nbrePiecesParColis * nombreColisVoulus) + "\n" +
                    getString(R.string.PoidMoyenPièce) + " : " + nf.format(poidMoyenParPiece)


            );
        }catch (Exception e){}
    }
}








