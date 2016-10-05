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

package com.jlt.popmov.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A movie, as defined by the TMDB JSON.
 * */
// begin class Movie
public class Movie implements Parcelable {

    /* CONSTANTS */

    /* Creators */

    // begin new Parcelable.Creator< Movie >
    public static final Parcelable.Creator< Movie > CREATOR
            = new Parcelable.Creator< Movie >() {

        @Override
        /**
         * Create a new instance of the Parcelable class, instantiating it from
         * the given Parcel whose data had previously been written by
         * Parcelable.writeToParcel()
         * */
        // createFromParcel
        public Movie createFromParcel( Parcel source ) { return new Movie( source ); }

        @Override
        /** Create a new array of the Parcelable class. */
        // newArray
        public Movie[] newArray( int size ) { return new Movie[ size ]; }


    }; // end new Parcelable.Creator< Movie >

    /* Integers */
    
    /* Strings */
        
    /* VARIABLES */

    /* Primitives */

    /** The movie's user rating, out of 10. */
    private float vote_average;

    /* Strings */

    private String title; // ditto

    /** The movie's release date, in the form 2016-12-31. */
    private String release_date;

    /**
     * The path to the movie's poster.
     * To use this path, build a Url that looks like this:
     * http://image.tmdb.org/t/p/w185/poster_path
     * */
    private String poster_path;

    /** The movie's synopsis. */
    private String overview;

    /* CONSTRUCTOR */

    // begin default constructor
    public Movie( String title, String release_date, String overview, float vote_average,
                  String poster_path ) {

        // 0. initialize members

        // 0. initialize members

        setTitle( title );
        setRelease_date( release_date );
        setOverview( overview );
        setVote_average( vote_average );
        setPoster_path( poster_path );

    } // end default constructor

    // begin parcel constructor
    public Movie( Parcel inParcel ) {

        // 0. initialize members from parcel

        // 0. initialize members from parcel

        // Parcel reads need to be in the same order as Parcel writes
        setTitle( inParcel.readString() );
        setRelease_date( inParcel.readString() );
        setOverview( inParcel.readString() );
        setVote_average( inParcel.readFloat() );
        setPoster_path( inParcel.readString() );

    } // end parcel constructor

    /* METHODS */
    
    /* Getters and Setters */

    // getter for the overview
    private String getOverview() {
        return overview;
    }

    // setter for the overview
    private void setOverview( String overview ) {
        this.overview = overview;
    }

    // getter for the poster path
    private String getPoster_path() {
        return poster_path;
    }

    // setter for the poster path
    private void setPoster_path( String poster_path ) {
        this.poster_path = poster_path;
    }

    // getter for the release date
    private String getRelease_date() {
        return release_date;
    }

    // setter for the release date
    private void setRelease_date( String release_date ) {
        this.release_date = release_date;
    }

    // getter for the title
    public String getTitle() {
        return title;
    }

    // setter for the title
    public void setTitle( String title ) {
        this.title = title;
    }

    // getter for the vote average
    private float getVote_average() {
        return vote_average;
    }

    // setter for the vote average
    private void setVote_average( float vote_average ) {
        this.vote_average = vote_average;
    }

    /* Overrides */

    @Override
    /** Flatten this object in to a Parcel. */
    // begin writeToParcel
    public void writeToParcel( Parcel destParcel, int flags ) {

        // 0. write members to the parcel

        // 0. write members to the parcel

        // Parcel writes need to be in the same order as Parcel reads
        destParcel.writeString( getTitle() );
        destParcel.writeString( getRelease_date() );
        destParcel.writeString( getOverview() );
        destParcel.writeFloat( getVote_average() );
        destParcel.writeString( getPoster_path() );

    } // end writeToParcel

    @Override
    /**
     * Describe the kinds of special objects
     * contained in this Parcelable instance's marshaled representation.
     * */
    // describeContents
    public int describeContents() {
        return 0;
    }

    /* Other Methods */

    /**
     * Gets the movie's poster path.
     *
     * To use this path, build a Url that looks like this:
     * http://image.tmdb.org/t/p/w185/poster_path
     * */
    // method getPosterPath
    public String getPosterPath() { return getPoster_path(); }

    /** Gets the movie's synopsis. */
    // method getSynopsis
    public String getSynopsis() { return getOverview(); }

    /** Gets the movie's user rating. This value is out of 10. */
    // method getUserRating
    public float getUserRating() { return getVote_average(); }

    /* INNER CLASSES */

} // end class Movie