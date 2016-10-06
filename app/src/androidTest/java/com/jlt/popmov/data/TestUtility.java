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
import android.test.AndroidTestCase;

/**
 * A test for the correctness of {@link Utility} methods.
 * */
// begin class TestUtility
public class TestUtility extends AndroidTestCase {

    /* CONSTANTS */

    /* Integers */

    /* Strings */

    /* VARIABLES */

    /* CONSTRUCTOR */

    /* METHODS */

    /* Getters and Setters */

    /* Overrides */

    /* Other Methods */

    /**
     * Tests for the correctness of the poster path Uri gotten from
     * {@link Utility#getPosterUri(String)} */
    // begin method testPosterUrl
    public void testPosterUrl() {

        // 0. for a poster path of /a.jpg, the url returned should look like
        // http://image.tmdb.org/t/p/w185//a.jpg

        // 0. for a poster path of /a.jpg, the url returned should look like
        // http://image.tmdb.org/t/p/w185//a.jpg

        String posterPath = "/a.jpg";
        String correctPosterUrl = "http://image.tmdb.org/t/p/w185/" + posterPath;

        Uri posterUri = Utility.getPosterUri( posterPath );

        assertTrue( "Error: The Utility poster Url is " + posterUri.toString() +
                        " while the correct poster Url is " + correctPosterUrl,
                posterUri.toString().equals( correctPosterUrl ) );

    } // end method testPosterUrl

    /* INNER CLASSES */

} // end class TestUtility