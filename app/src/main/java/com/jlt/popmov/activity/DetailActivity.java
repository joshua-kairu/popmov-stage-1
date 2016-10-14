/*
 * 
 * com.jlt.popmov.activity
 * 
 * <one line to give the program's name and a brief idea of what it does.>
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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jlt.popmov.R;
import com.jlt.popmov.data.model.Movie;
import com.jlt.popmov.fragment.DetailFragment;

/**
 * Activity to show the details of a movie.
 * */
// begin activity DetailActivity
public class DetailActivity extends AppCompatActivity {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */
    
    /* VARIABLES */

    /* METHODS */

    /* Getters and Setters */

    /* Overrides */

    @Override
    // begin onCreate
    protected void onCreate( Bundle savedInstanceState ) {

        // 0. super things
        // 1. use the detail layout
        // 2. if this is the first time
        // 2a. start the detail fragment

        // 0. super things

        super.onCreate( savedInstanceState );

        // 1. use the detail layout

        DataBindingUtil.setContentView( this, R.layout.activity_detail );

        // 2. if this is the first time

        // begin if the saved state is null
        if ( savedInstanceState == null ) {

            // 2a. start the detail fragment

            // begin if the intent has a bundle
            if ( getIntent() != null ) {

                Movie selectedMovie = getIntent().getParcelableExtra( DetailFragment.ARGUMENT_MOVIE );

                getSupportFragmentManager().beginTransaction()
                        .add( R.id.ad_fl_container, DetailFragment.newInstance( selectedMovie ) )
                        .commit();

            } // end if the intent has a bundle

        } // end if the saved state is null

    } // end onCreate
    
    /* Other Methods */
    
    /* INNER CLASSES */

} // end activity DetailActivity