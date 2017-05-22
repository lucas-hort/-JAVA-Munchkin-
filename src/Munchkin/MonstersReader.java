/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Munchkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Hort
 */
public class MonstersReader {

    public MonstersReader() {
        
        List<Monster> monsterList = new ArrayList<>();
        
        
        //MONSTERLOSELVL
        String arquivo = "monsterLvl.txt";

        try {

            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();

            while (linha != null) {

                String linhas[] = linha.split(",");
                int id = Integer.parseInt(linhas[0]);
                String name = linhas[1];
                int level = Integer.parseInt(linhas[2]);
                int damage = Integer.parseInt(linhas[3]);

                MonsterLoseLvl monster = new MonsterLoseLvl(id, name, level, damage);

                monsterList.add(monster);
                
                System.out.println(monster);

                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
        
        
        
        
        //MONSTERLOSEITEM
        String arquivo2 = "monsterItem.txt";

        try {

            FileReader arq = new FileReader(arquivo2);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();

            while (linha != null) {

                String linhas[] = linha.split(",");
                int id = Integer.parseInt(linhas[0]);
                String name = linhas[1];
                int level = Integer.parseInt(linhas[2]);
                int numItem = Integer.parseInt(linhas[3]);

                MonsterLoseLvl monster = new MonsterLoseLvl(id, name, level, numItem);

                monsterList.add(monster);
                
                System.out.println(monster);

                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
        
        Game.getINSTANCE().setMonsterList(monsterList);
        
    }
    
    
}
