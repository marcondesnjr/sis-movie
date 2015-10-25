/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.sismovie;

import io.github.marcondesnjr.sismovie.*;
import io.github.marcondesnjr.sismovie.dao.daobd.ConnectionManager;
import io.github.marcondesnjr.sismovie.dao.daobd.DAOBDFilme;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class SisMovieTest {
    
    public SisMovieTest() {
    }
    
    @Test
    public void test() throws Exception{
        System.out.println(SisMovie.lastFilmes());
    }

    
}
