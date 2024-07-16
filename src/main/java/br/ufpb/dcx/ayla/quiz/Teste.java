package br.ufpb.dcx.ayla.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Pergunta pergunta = new PerguntaDissertativa();
        System.out.println(pergunta.toString());
        Pergunta pergunta2 = new PerguntaDissertativa("Quanto é 2+2","4");
        Pergunta pergunta3 = new PerguntaDissertativa("Quanto é 1+1","2");
        List<Pergunta> perguntaList = new Vector<>();
        perguntaList.add(pergunta);
        perguntaList.add(pergunta2);
        perguntaList.add(pergunta3);
        Collections.sort(perguntaList);
        for(Pergunta p: perguntaList){
            System.out.println(p.toString());
        }
    }}
