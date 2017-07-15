package com.example.android.explorelincoln;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dom on 6/30/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item>{

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    public ItemAdapter(Activity context, ArrayList<Item> items, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Item currentItem = getItem(position);

        // Find the TextView in the items_list.xml layout with the ID name_text_view
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the version name from the current Item object and set this text on the name TextView
        nameTextView.setText(currentItem.getName());

        // Find the TextView in the items_list.xml layout with the ID text_text_view
        TextView textTextView = (TextView) listItemView.findViewById(R.id.text_text_view);
        // Get the version number from the current Item object and set this text on the number TextView
        textTextView.setText(currentItem.getText());

        // Find the TextView in the items_list.xml layout with the ID address_text_view
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the version number from the current Item object and set this text on the number TextView
        addressTextView.setText(currentItem.getAddress());

        // Find the TextView in the items_list.xml layout with the ID phone_text_view
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone_text_view);
        // Get the version number from the current Item object and set this text on the number TextView
        phoneTextView.setText(currentItem.getPhone());

        // Find the ImageView in the items_list.xml layout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentItem.hasImage()) {
            // Set the ImageView to the image resource specified in the current Item
            iconView.setImageResource(currentItem.getImageResourceId());

            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        }
        else {
            // Otherwise, hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }

        // Set theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
