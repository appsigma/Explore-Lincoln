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
public class ToDoFragment extends Fragment {


    public ToDoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);

        // Create an array of items
        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(getString(R.string.memorial_name), getString(R.string.memorial_text),
                getString(R.string.memorial_address), getString(R.string.memorial_phone), R.drawable.memorial));
        items.add(new Item(getString(R.string.sheldon_name), getString(R.string.sheldon_text),
                getString(R.string.sheldon_address), getString(R.string.sheldon_phone), R.drawable.sheldon));
        items.add(new Item(getString(R.string.sunken_name), getString(R.string.sunken_text),
                getString(R.string.sunken_address), getString(R.string.sunken_phone), R.drawable.sunken));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.category_todo);

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