package com.znewell.sports_connection.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.znewell.sports_connection.R;
import com.znewell.sports_connection.model.Sport;

import java.util.List;


public class SportAdapter extends ArrayAdapter<Sport> {

    private Activity activity;
    private List<Sport> sports;
    private static LayoutInflater layoutInflater;

    public SportAdapter(Activity activity, int textViewResourceId, List<Sport> sports) {
        super(activity, textViewResourceId, sports);
        try {
            this.activity = activity;
            this.sports = sports;

            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {
            Log.e("Adapter", e.getMessage());
        }
    }

    public int getCount() {
        return sports.size();
    }

    public static class ViewHolder{
        public TextView display_sport;
        public TextView display_time;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder viewHolder;
        try {
            if (convertView == null) {
                vi = layoutInflater.inflate(R.layout.activity_maps, null);
                viewHolder = new ViewHolder();

                viewHolder.display_sport = (TextView) vi.findViewById(R.id.display_sport);
                viewHolder.display_time = (TextView) vi.findViewById(R.id.display_time);

                vi.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) vi.getTag();
            }

            viewHolder.display_sport.setText(sports.get(position).getName());
            viewHolder.display_time.setText(sports.get(position).getTime().toString());
        } catch (Exception e) {
            Log.e("Adapter", e.getMessage());
        }

        return vi;
    }
}
