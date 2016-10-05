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

package com.jlt.popmov.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jlt.popmov.R;
import com.jlt.popmov.databinding.ActivityMainBinding;

/**
 * The landing activity
 * */
// begin activity MainActivity
public class MainActivity extends AppCompatActivity {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */

    /**
     * The logger.
     */
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    
    /* VARIABLES */

    /* Activity Main Bindings */

    private ActivityMainBinding binding; // ditto

    /* Strings */

    private String mCurrentSortOrder; // ditto

    /* METHODS */

    /* Getters and Setters */

    /* Overrides */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the main activity layout

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the main activity layout

        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

    } // end onCreate
    
    /* Other Methods */
    
    /* INNER CLASSES */

} // end activity MainActivity