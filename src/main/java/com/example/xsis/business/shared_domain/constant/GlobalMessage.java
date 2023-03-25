package com.example.xsis.business.shared_domain.constant;

public final class GlobalMessage {

    private GlobalMessage(){

    }

    public static final String[] paramVariable = new String[]{
            "#Variable1",
            "#Variable2",
            "#Variable3",
            "#Variable4",
            "#Variable5"};

    /** CONSTANT **/
    private static final String NOT_FOUND = " not found";

    /** ERROR MESSAGE **/
    public static final String MOVIE_NOT_FOUND = "Movie with id " + paramVariable[0] + NOT_FOUND;
}
