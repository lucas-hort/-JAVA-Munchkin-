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
public class ItemsReader {

    public ItemsReader() {
        
        
        //ITEMS
        List<Item> itemList = new ArrayList<>();        
        String arquivo = "item.txt";
        try {
            
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            
            while (linha != null) {
                
                String linhas[] = linha.split(",");
                int id = Integer.parseInt(linhas[0]);
                String name = linhas[1];
                int level = Integer.parseInt(linhas[2]);
                String geartype = linhas[3];
                
                Item item = new Item(id,name,level,geartype);
                
                itemList.add(item);
                
                linha = lerArq.readLine();
            }
            
            arq.close();
            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        
        Game.getINSTANCE().setItemList(itemList);
        
    }
        
}
