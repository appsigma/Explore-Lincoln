package com.example.android.explorelincoln;

/**
 * {@link Item} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Item {
    /** Name of item */
    private String mName;

    /** Description of item */
    private String mText;

    /** Address of item */
    private String mAddress;

    /** Phone of item */
    private String mPhone;

    /** Image Resource ID for the word.*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Item object.
     *
     * @param name is the title of the list item.
     * @param text is the description of the list item.
     * @param address is the address of the list item.
     * @param phone is the phone number of the list item.
     * @param imageResourceId resource ID for the image file associate with this item
     */
    public Item(String name, String text, String address, String phone, int imageResourceId) {
        mName = name;
        mText = text;
        mAddress = address;
        mPhone = phone;
        mImageResourceId = imageResourceId;
    }

    /** Get the name of the list item. */
    public String getName() {
        return mName;
    }

    /** Get the description of the list item. */
    public String getText() {
        return mText;
    }

    /** Get the address of the list item. */
    public String getAddress() {
        return mAddress;
    }

    /** Get the phone of the list item. */
    public String getPhone() {
        return mPhone;
    }

    /** Return the image resource ID of the word. */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /** Returns whether or not there is an image for this word */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
