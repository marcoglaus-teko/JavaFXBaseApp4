package ch.teko.oop;

import java.sql.ResultSet;

public interface IChinookDB {
    ResultSet getArtists();
    ResultSet getTracksFromArtists(String placeholder);
    ResultSet getAlbumsFromArtists(String placeholder);
}
