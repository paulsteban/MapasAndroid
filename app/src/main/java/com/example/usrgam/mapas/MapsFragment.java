package com.example.usrgam.mapas;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback,GoogleMap.OnPolygonClickListener,GoogleMap.OnPolylineClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private GoogleMap mMap;


    public MapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapsFragment newInstance(String param1, String param2) {
        MapsFragment fragment = new MapsFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getMapAsync(this);
        return  super.onCreateView(inflater,container,savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // throw new RuntimeException(context.toString()
            //       + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.M){
                requestPermissions(new String[]{ Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},177);
            }
            return;
        }else{
            mMap.setMyLocationEnabled(true);
            dibujar2();
        }

    }
     /*   public void dibujar(){
        Polyline polyline = mMap.addPolyline(new PolylineOptions().clickable(true).add(new LatLng(-0.208389,-78.4917644),new LatLng(
                -0.2078966,-78.4917764),new LatLng(
                -0.2075193,-78.4904052),new LatLng(
                -0.2080561,-78.4881768),new LatLng(
                -0.208389,-78.4917644)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-0.2078966,-78.4917764),16));
        }*/
    public void dibujar2(){
        Polygon polygon = mMap.addPolygon(new PolygonOptions().clickable(true).add(new LatLng(-0.208389,-78.4917644),new LatLng(
                -0.2078966,-78.4917764),new LatLng(
                -0.2075193,-78.4904052),new LatLng(
                -0.2080561,-78.4881768),new LatLng(
                -0.208389,-78.4917644)).fillColor(Color.RED).strokeColor(Color.BLUE));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-0.2078966,-78.4917764),16));
    }
    @Override
    public void onPolygonClick(Polygon polygon) {

    }

    @Override
    public void onPolylineClick(Polyline polyline) {


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
}
