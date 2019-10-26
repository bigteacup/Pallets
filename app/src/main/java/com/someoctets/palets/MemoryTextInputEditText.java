package com.someoctets.palets;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

import java.util.ArrayList;

public class MemoryTextInputEditText extends TextInputEditText {
    public MemoryTextInputEditText(Context context) {
        super(context);

    }
    public MemoryTextInputEditText(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    ArrayList<String> listeMemoire = new ArrayList<String>();





    public String getMemoire(int i) {
        String memoireSelectionnee = "";
        try {
             memoireSelectionnee =listeMemoire.get(i);
            }catch(Exception e){
            memoireSelectionnee = "";
        }
        return memoireSelectionnee;
    }
    public ArrayList<String> getListeMemoire() {
        return listeMemoire;
    }

    public void setMemoire(String memoire) {
            listeMemoire.add(0, memoire);

    }

    public void clear(int i){
       String memoire = listeMemoire.get(i);
       memoire = "";
    }
}
