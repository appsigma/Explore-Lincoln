package com.example.android.explorelincoln;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class BarsFragment extends Fragment {

    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);

        // Create an array of items
        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(getString(R.string.barry_name), getString(R.string.barry_text),
                getString(R.string.barry_address), getString(R.string.barry_phone), R.drawable.barry));
        items.add(new Item(getString(R.string.longwell_name), getString(R.string.longwell_text),
                getString(R.string.longwell_address), getString(R.string.longwell_phone), R.drawable.longwell));
        items.add(new Item(getString(R.string.buzzard_name), getString(R.string.buzzard_text),
                getString(R.string.buzzard_address), getString(R.string.buzzard_phone), R.drawable.buzzard));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.category_bars);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // items_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

}