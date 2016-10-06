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

import android.net.Uri;

/**
 * A utility class to handle preferences and formatting
 * */
// begin class Utility
public class Utility {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */
        
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
    
    /* INNER CLASSES */

} // end class Utility