package com.znewell.sports_connection.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

import com.znewell.sports_connection.R;
import com.znewell.sports_connection.model.LocationModel;
import com.znewell.sports_connection.model.Sport;
import com.znewell.sports_connection.rest.SportConnectionApiServiceImpl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

public class AddSportDialogFragment extends DialogFragment {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private String sportName;
    @Getter @Setter
    private Time time;
    @Getter @Setter
    private float lat;
    @Getter @Setter
    private float lon;

    private SportConnectionApiServiceImpl apiService =
            new SportConnectionApiServiceImpl();
    private Sport sport;
    private LocationModel locationModel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.add_a_sport);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_sport_dialog,
                (ViewGroup) getView(), false);

        // Make the input fields needed for a sport
        final EditText nameInput = (EditText) view.findViewById(R.id.name);
        final EditText sportNameInput = (EditText) view.findViewById(R.id.sportName);
        final TimePicker timeInput = (TimePicker) view.findViewById(R.id.time);
        final EditText LatInput = (EditText) view.findViewById(R.id.locationLat);
        final EditText LonInput = (EditText) view.findViewById(R.id.locationLon);

        // Build the input view for the Dialog
        builder.setView(view);

        // Setup the buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = nameInput.getText().toString();
                sportName = sportNameInput.getText().toString();
                String s = timeInput.toString();
                @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                try {
                    time = (Time) formatter.parse(s);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                lat = Float.parseFloat(LatInput.getText().toString());
                lon = Float.parseFloat(LonInput.getText().toString());

                // build the data to call the api
                locationModel.builder()
                        .lat(lat)
                        .lon(lon)
                        .build();
                sport.builder()
                        .id(new Random().nextInt())
                        .name(name)
                        .sportName(sportName)
                        .time(time)
                        .locationModel(locationModel)
                        .build();
                apiService.insertSport(sport);
                dialog.dismiss();
            }
        }); builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}
