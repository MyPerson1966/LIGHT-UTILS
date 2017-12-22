/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiam.utils.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author kvaziuser
 */
public class TestValidRESString implements IValidateData {

    /**
     * Validation of RES protocol's data block
     *
     * @param strBlock
     * @return
     */
    @Override
    public boolean validateBlockData(String strBlock) {
        boolean result = true;
        if (strBlock == null) {
            return false;
        }

        strBlock = strBlock.trim();
        result = strBlock.length() > 0;
        String[] parts = strBlock.split(System.lineSeparator());
        result = result && parts.length > 1;
        if (result) {
            result = result && validateHeaderString(parts[0]);
            for (int k = 1; k < parts.length; k++) {
                String line = parts[k];
                boolean isCorrectLine = testString(line);
                result = result && isCorrectLine;
//                System.out.println(k + ":  " + line + "   correct: " + isCorrectLine);
            }
        }

        return result;
    }

    private boolean testString(String str) {
        if (str == null) {
            return false;
        }
        str = str.trim();
        boolean result = str.length() > 0;
        StringTokenizer st = new StringTokenizer(str);
//        System.out.println("           st.countTokens()   " + st.countTokens());
        result = result && st.countTokens() > 0;
        if (result) {
            int p = 0;
            while (st.hasMoreTokens()) {
                String tmp = st.nextToken().trim();
                result = result && tmp.length() > 0;
//                System.out.println("        p " + p + "   tmp " + tmp + "    tmp.length() " + tmp.length() + "  res " + result);
                if (p == 3) {
                    result = result && GeneralValidation.validateSignedString(tmp);
//                    System.out.println("  result " + p + "  " + result);
                    tmp = GeneralValidation.exludeFirstCharacter(tmp);
                    result = result && GeneralValidation.validatePureNumberStr(tmp);
//                    System.out.println("  result--  " + p + "  " + result);
                } else {
                    result = result && GeneralValidation.validatePureNumberStr(tmp);
//                    System.out.println("  result--  " + p + "  " + result);
                }
                p++;
            }
        }
        return result;
    }

    private boolean validateBlockData1(String strBlock) {
        if (strBlock == null) {
            return false;
        }
        strBlock = strBlock.trim();
        //System.out.println(" strBlockstrBlockstrBlock:::::: " + strBlock);
        boolean result = true;
        String[] strings = strBlock.split(System.lineSeparator());

        result = result && validateHeaderString(strings[0]);

        //System.out.println("    strings[1] " + strings[0]);
//        for (int j = 1; j < strings.length; j++) {
//            strings[j] = strings[j].trim();
//            if (strings[j].length() > 0) {
////                System.out.println(j + "    " + strings[j]);
//                result = result && validateMesureString(strings[j]);
//
//            }
//            //System.out.println("  " + strBlock);
//            //System.out.println(" blockValidator  result: " + result);
//        }
        return result;
    }

    /**
     * Validates the header's block.
     *
     * @param str
     * @return
     */
    public boolean validateHeaderString(String str) {
        boolean res = true;
        String[] parts = str.split("\\s+");
        if (parts.length != 2) {
            return false;
        }
        for (int k = 0; k < parts.length; k++) {
            res = res & GeneralValidation.validatePureNumberStr(parts[k]);
            //System.out.println(k + ":  " + parts[k] + " res: " + res);

        }
        //System.out.println(res + " parts: " + parts.length);
        return res;
    }

    /**
     *
     * Validation of protocol's data string. Tests, that the string is a sequens
     * of strings of digits (probably with leading '+' or '-' symbol)
     *
     * @param str
     * @return
     */
    public boolean validateMesureString(String str) {
        str = str.trim();
        //strValidate = str;

        Boolean result = str.length() == 41;
        StringTokenizer st = new StringTokenizer(str);
        int k = 0;
//        System.out.println(k + ":  result: " + result);

        for (; st.hasMoreTokens();) {
            String token = st.nextToken();
            if (k == 0 || k == 4) {
                result = result && GeneralValidation.validateStr(token) && (token.length() == 6);
//                System.out.println(k + "    res: " + result);
            } else if (k == 1 || k == 2) {
                result = result && GeneralValidation.validateStr(token) && (token.length() == 8);
            } else if (k == 3) {
                result = result && GeneralValidation.validateStr(token) && (token.length() == 9);
            }
            k++;

        }
        result = result && (k == 5);
        //System.out.println(" str: " + str + " TOKENS TOTAL   " + k + " result " + result);
        return result;
    }

}
