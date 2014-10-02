package com.example.bernard.chieng;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            String[] forecastArray={
                                     "Today-sunny-88/63",
                                     "Tommorrow-cloudy-74/89",
                                     "wed-foggy-98/43",
                                     "Thursday-warm-56/34",
                                     "Friday-snowy-101/42"
                                   };
            List<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray));

        //The forecast adapter will use the dummy text to populate the list view

            ArrayAdapter<String> mForecastAdapter;
            mForecastAdapter = new ArrayAdapter<String>(
                    //The current context ie this fragment parent activity
                    getActivity(),
                    // ID of the list item layout
                    R.layout.list_item_forecast,
                    //ID of list item to populate
                    R.id.list_item_forecast_textView,
                    //forecast data
                    weekForecast);

            //Get a reference to the ListView and attach the adapter
            ListView listView =(ListView) rootView.findViewById(
                    R.id.listView_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
