/*
 *
 * PopMov
 *
 * An Android app to show the latest movies from https://www.themoviedb.org.
 *
 * Copyright (C) 2016 Kairu Joshua Wambugu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 */

package com.jlt.popmov.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

import com.jlt.popmov.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A utility class to handle preferences and formatting
 * */
// begin class Utility
public class Utility {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */

    /**
     * The logger.
     */
    private static final String LOG_TAG = Utility.class.getSimpleName();

    /* VARIABLES */
    
    /* CONSTRUCTOR */
    
    /* METHODS */
    
    /* Getters and Setters */
    
    /* Overrides */
    
    /* Other Methods */

    /* statics */

    /**
     * Helper method to get a movie's poster {@link android.net.Uri} using the movie's poster path
     *
     * @param posterPath The movie's poster path
     *
     * @return a {@link android.net.Uri} pointing to the movie's poster path
     * */
    // begin method getPosterUri
    public static Uri getPosterUri( String posterPath ) {

        // 0. initialize build items
        // 0a. the base url
        // 0b. the size path
        // 1. return a built Uri

        // 0. initialize build items

        // 0a. the base url

        final String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";

        // 0b. the size path

        final String SIZE_PATH = "w185";

        // 1. return a built Uri

        return Uri.parse( POSTER_BASE_URL ).buildUpon()
                .appendPath( SIZE_PATH )
                .appendEncodedPath( posterPath )
                .build();

    } // end method getPosterUri

    /**
     * Helper method to get the preferred sort order from preferences.
     *
     * @param context Android {@link android.content.Context}
     *
     * @return A string having the preferred sort order
     * */
    // begin method getPreferredSortOrder
    public static String getPreferredSortOrder( Context context ) {

        // 0. get the preferences
        // 1. return the preferred sort order, default popular

        // 0. get the preferences

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );

        // 1. return the preferred sort order, default popular

        return sharedPreferences.getString( context.getString( R.string.pref_sort_order_key ),
                context.getString( R.string.pref_sort_order_most_popular_entry_value ) );

    } // end method getPreferredSortOrder

    /**
     * Helper method to format the movie release date so that it appears as required by the screenshots.
     *
     * TMDB JSON gives the movie release date in the form YYYY-MM-DD, for example 2016-06-16.
     * The screenshots need the date to be in the form YYYY, for example 2016.
     *
     * */
    // begin method getFormattedReleaseDate
    public static String getFormattedReleaseDate ( String releaseDate ) {

        // 0. convert the release date to a date object
        // 1. set up a date format with the needed format
        // 2. return a formatted date string

        // begin trying to get the formatted date string
        try {

            // 0. convert the release date to a date object

            Date actualReleaseDate = SimpleDateFormat.getDateInstance().parse( releaseDate );

            // 1. set up a date format with the needed format
            // 2. return a formatted date string

            return new SimpleDateFormat( "yyyy", Locale.getDefault() ).format( actualReleaseDate );

        } // end trying to get the formatted date string

        // begin catching parse issues
        catch ( ParseException e ) {

            Log.e( LOG_TAG, "getFormattedReleaseDate: Error parsing date.", e );

            return null;

        } // end catching parse issues

    } // end method getFormattedReleaseDate

    /* INNER CLASSES */

} // end class Utility