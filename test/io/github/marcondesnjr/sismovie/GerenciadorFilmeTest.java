/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.sismovie;

import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorFilme;
import java.time.Year;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class GerenciadorFilmeTest {
    
    public GerenciadorFilmeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLastFilmes() throws Exception {
        Filme fl = new Filme(null, "titulo", "sinopse", Year.now());
        GerenciadorFilme.salvar(fl);
    }
    
}
