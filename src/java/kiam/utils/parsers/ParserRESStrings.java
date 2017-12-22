/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiam.utils.parsers;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kvaziuser
 */
public class ParserRESStrings extends AbstractParserString {

    public ParserRESStrings() {
    }

    public ParserRESStrings(String dataToParse) {
        super(dataToParse);
    }

    /**
     * returns the k-th block Content
     *
     * @param k
     * @return
     */
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

        //System.out.println("    str " + str);
        String[] sArray = str.split(kiam.AppConstants.BLOCKS_BREAKER_END_RUS_BRIEF);
        for (String s : sArray) {
            if (s.trim().length() > 0) {
                //System.out.println(" s: " + s);
                String[] sArray1 = s.split(kiam.AppConstants.BLOCKS_BREAKER_START_RUS_BRIEF);
                for (String s0 : sArray1) {
                    if (s0.trim().length() > 0) {
                        dataBlocks.add(System.lineSeparator() + s0.trim() + System.lineSeparator());
                    }
                }
            }
        }
    }

    /**
     * Outputs to the Screen the blocks content
     */
    public void outputAllBlocs() {
        for (int k = 0; k < dataBlocks.size(); k++) {
            System.out.println(getDataBlocks(k));
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isValidDataBlocks() {
        if (dataBlocks == null) {
            return false;
        }
        boolean result = (dataBlocks.size() > 0);
        TestValidRESString testValidStr = new TestValidRESString();
        for (int k = 0; k < dataBlocks.size(); k++) {
            String block = dataBlocks.get(k);
//            System.out.println(" block: " + block);
            boolean tmp = testValidStr.validateBlockData(block);
            result = result && tmp;
//            System.out.println("      " + tmp + "/" + result);

        }
        if (result) {
            attr = "RES";
        }
//        System.out.println("               " + result);
        return result;
    }

}
