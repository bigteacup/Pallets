package com.someoctets.palets;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class EcranPremier  extends AppCompatActivity  implements peseepalettenormale.OnFragmentInteractionListener, peseepalettenormale.SendMessage { // implements peseepalettenormale.PeseeListener



    //private SectionsPagerAdapter mSectionsPagerAdapter;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


  //  private FragmentB fragmentB;

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    @Override
    public void sendData(ArrayList<Double> message1, ArrayList<Double> message2 ) {
        String tag = "android:switcher:" + R.id.viewpager1 + ":" + 1;
        reconstructionpalette f = (reconstructionpalette) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message1, message2);
    }


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        //essai viewpager
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager1);
        mViewPager.setAdapter(mSectionsPagerAdapter);




    }




    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


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
            View rootView = inflater.inflate(R.layout.activity_peseepalettenormale, container, false);




            return rootView;
        }

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String fragments []= {"calcul","recon"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new peseepalettenormale();
                case 1:
                    return new reconstructionpalette();
                default:
                    return null;


            }

        }

        @Override
        public int getCount() {

            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return fragments[position];
        }
    }




}
///////////
/*
          FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.viewpager1, peseepalettenormaleA);
                            transaction.addToBackStack(null);
                            transaction.commit();
                    return  peseepalettenormaleA;
 */