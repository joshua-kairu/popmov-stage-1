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

package com.jlt.popmov.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.jlt.popmov.R;
import com.jlt.popmov.activity.DetailActivity;
import com.jlt.popmov.adapter.PosterAdapter;
import com.jlt.popmov.data.Utility;
import com.jlt.popmov.data.model.Movie;
import com.jlt.popmov.data.remote.FetchMovieTask;
import com.jlt.popmov.databinding.FragmentPostersBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Fragment} to show the movie posters.
 * */
// begin fragment PostersFragment
public class PostersFragment extends Fragment {

    /* CONSTANTS */
    
    /* Integers */
    
    /* Strings */

    /**
     * The logger.
     */
    private static final String LOG_TAG = PostersFragment.class.getSimpleName();

    /** Fragment tag. */
    public static final String POSTER_FRAGMENT_TAG = "POSTER_FRAGMENT_TAG";

    /* VARIABLES */

    /* Fragment Posters Bindings */

    private FragmentPostersBinding binding; // ditto

    /* Poster Adapters */

    private PosterAdapter mPosterAdapter; // ditto
    
    /* CONSTRUCTOR */

    // empty constructor for fragment subclasses
    public PostersFragment() {
    }
    
    /* METHODS */
    
    /* Getters and Setters */
    
    /* Overrides */

    @Override
    // begin onCreateView
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        // 0. use the posters fragment layout
        // 1. get the grid
        // 2. initialize the movies list
        // 3. use the poster adapter
        // 4. when an movie poster is clicked
        // 4a. go to details of the movie
        // 5. set the empty view for the grid
        // last. return the inflated view NOT THE INFLATED GRID VIEW SINCE
        // THE INFLATED GRID VIEW *WILL* HAVE A PARENT

        // 0. use the posters fragment layout

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_posters, container, false );

        // 1. get the grid

        GridView postersGridView = binding.fpGvPosters;

        // 2. initialize the movies list

        List< Movie > mMovies = new ArrayList<>();

        // 3. use the poster adapter

        mPosterAdapter = new PosterAdapter( getActivity(), mMovies );

        postersGridView.setAdapter( mPosterAdapter );

        // 4. when an movie poster is clicked

        // begin postersGridView.setOnItemClickListener
        postersGridView.setOnItemClickListener(

                // 4a. go to details of the movie

                // begin new AdapterView.OnItemClickListener
                new AdapterView.OnItemClickListener() {

                    @Override
                    // begin onItemClick
                    public void onItemClick( AdapterView< ? > parent, View view, int position, long id ) {

                        Movie selectedMovie = ( Movie ) parent.getItemAtPosition( position );

                        Intent detailIntent = new Intent( getActivity(), DetailActivity.class );

                        detailIntent.putExtra( DetailFragment.ARGUMENT_MOVIE, selectedMovie );

                        startActivity( detailIntent );

                    } // end onItemClick

                } // end new AdapterView.OnItemClickListener

        ); // end postersGridView.setOnItemClickListener

        // 5. set the empty view for the grid

        postersGridView.setEmptyView( binding.fpTvEmpty );

        // last. return the inflated view NOT THE INFLATED GRID VIEW SINCE
        // THE INFLATED GRID VIEW *WILL* HAVE A PARENT

        return binding.getRoot();

    } // end onCreateView

    @Override
    // begin onStart
    public void onStart() {

        // 0. super stuff
        // 1. update the movies

        // 0. super stuff

        super.onStart();

        // 1. update the movies

        updateMovies();

    } // end onStart

    /* Other Methods */

    /**
     * Helper method to update the movies displayed onscreen.
     * */
    // begin method updateMovies
    private void updateMovies() {

        // 0. if there is net
        // 0a. get the preferred sort order
        // 0b. fetch movie info using the preferred sort order
        // 1. update the empty view

        // begin if there is net
        if ( Utility.isInternetUp() ) {

            // 0a. get the preferred sort order

            String preferredSortOrder = Utility.getPreferredSortOrder( getActivity() );

            // 0b. fetch movie info using the preferred sort order

            FetchMovieTask fetchMovieTask = new FetchMovieTask( mPosterAdapter );

            fetchMovieTask.execute( preferredSortOrder );

        } // end if there is net

        // 1. update the empty view

        updateEmptyView();

    } // end method updateMovies

    /** Helper method to respond to change in the sort order. */
    // begin method onSortOrderChanged
    public void onSortOrderChanged() {

        // 0. update the movies

        updateMovies();

    } // end method onSortOrderChanged

    /** Helper method to update the view showing that the movie list is empty. */
    // begin method updateEmptyView
    private void updateEmptyView() {

        // 0. if the movie adapter has nothing
        // 0a. get the empty view
        // 0a0. if there is the empty view
        // 0a0a. tell the user why the list is empty - possibly because
        // 0a0a0. there is no internet

        // 0. if the movie adapter has nothing

        // begin if adapter count is zero
        if ( mPosterAdapter.getCount() == 0 ) {

            // 0a. get the empty view

            TextView emptyTextView = binding.fpTvEmpty;

            // 0a0. if there is the empty view

            // begin if there is an empty view
            if ( emptyTextView != null ) {

                // 0a0a. tell the user why the list is empty - possibly because

                int message = R.string.message_error_no_movie_info;

                // 0a0a0. there is no internet

                if ( ! Utility.isInternetUp() ) { message = R.string.message_error_no_movie_info_no_connectivity; }

                emptyTextView.setText( message );

            } // end if there is an empty view

        } // end if adapter count is zero

    } // end method updateEmptyView

    /* INNER CLASSES */

} // end fragment PostersFragment