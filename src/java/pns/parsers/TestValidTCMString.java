/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiam.utils.parsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class TestValidTCMString implements IValidateData {//

    /**
     * Tests the correct data in the header's first line in block
     *
     * @param str
     * @return
     */
    private Boolean validHead(String str) {
        boolean result = true;
        String[] heads = str.split("\\s");
//        System.out.println(" Heads len " + heads.length);

        result = result && GeneralValidation.validatePureNumberStr(heads[0]);
        result = result && GeneralValidation.validatePureNumberStr(heads[1]);
        result = result && GeneralValidation.validatePureNumberStr(heads[3]);

        result = result && GeneralValidation.validateDateTime(heads[2], "dd.MM.yyyy");
        if (heads.length == 9) {
            result = result && GeneralValidation.validateDateTime(heads[5], "dd.MM.yyyy");
            result = result && GeneralValidation.validateDateTime(heads[6], "HH:mm:ss");
        }
//        System.out.println("    Boolean validHead " + result);
        return result;
    }

    /**
     * Tests the correct data in the header's second line in block
     *
     * @param str
     * @return
     */
    private boolean validHead1(String str) {
        boolean result = true;

        String[] heads = str.split("\\s");
        for (int k = 0; k < heads.length; k++) {
            result = result && GeneralValidation.validatePureNumberStr(heads[k]);
        }
//        System.out.println("    Boolean validHead1 " + result);
        return result;
    }

    //@Override
    public boolean validateBlockData(String strBlock) {
        if (strBlock == null) {
            return false;
        }
        strBlock = strBlock.trim();
        boolean result = true;
        String[] parts = strBlock.split(System.lineSeparator());
        //System.out.println(" +++++++++++++++ " + parts.length);
//        System.out.println("  :    " + strBlock);
        if (parts.length < 2) {
            return false;
        }
        result = result && validHead(parts[0]);
        result = result && validHead1(parts[1]);

        for (int k = 2; k < parts.length; k++) {
            int p = 0;
            StringTokenizer st = new StringTokenizer(parts[k]);
            while (st.hasMoreTokens()) {
                String tmp = st.nextToken();
                if (p == 0) {
                    result = result && GeneralValidation.validatePureNumberStr(tmp);
                }
                if (p == 1 || p == 2 || p == 5 || p == 6) {
                    result = result && GeneralValidation.validatePureDoubleStr(tmp);
                }
                if (p == 3) {
                    result = result && (tmp.charAt(0) == '-' || tmp.charAt(0) == '+');
                    tmp = GeneralValidation.exludeFirstCharacter(tmp);
                    result = result && GeneralValidation.validatePureDoubleStr(tmp);

                }

                p++;
            }
        }
        return result;
    }

}
