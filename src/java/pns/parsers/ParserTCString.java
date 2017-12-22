/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiam.utils.parsers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ParserTCString extends AbstractParserString {

    public ParserTCString() {
    }

    public ParserTCString(String dataToParse) {
        super(dataToParse);
    }

    @Override
    public void blockGenerator(String str) {
        if (str == null) {
            dataBlocks = null;
            return;
        }
        if (str.length() == 0) {
            dataBlocks = null;
            return;
        }

        String[] parts = str.split("TCMSM\\.");
        for (int k = 0; k < parts.length; k++) {
            String s = parts[k];
            if (s.trim().length() != 0) {
                dataBlocks.add(s.trim());
            }
        }
    }

    @Override
    public boolean isValidDataBlocks() {
        if (dataBlocks == null) {
            return false;
        }
        boolean result = (dataBlocks.size() > 0);
//        System.out.println("        dataBlocks.size()  " + dataBlocks.size());
        TestValidTCMString testValidStr = new TestValidTCMString();
        for (int k = 0; k < dataBlocks.size(); k++) {
            String block = dataBlocks.get(k);
            //System.out.println(" block: " + block);
            boolean tmp = testValidStr.validateBlockData(block);
            result = result && tmp;
//            System.out.println("      " + tmp + "/" + result);

        }
        if (result) {
            attr = "TC";
        }
        return result;
    }

}
