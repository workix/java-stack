package br.com.codecode.workix.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPFValidator {

    static List<String> array;
    static List<Integer> calc ;

    private static List<Integer> fillCalc(int seed) {
        List<Integer> calc = new ArrayList<>();
        for(int x = seed; x >= 2; x--){
            calc.add(x);
        }
        return calc;
    }

    private static int accumulate(int length) {
        int acc = 0;
        for(int x = 0; x < length; x++){
            acc += Integer.parseInt(array.get(x)) * calc.get(x);
        }
        return acc;
    }

    private static int returnMod(int acc) throws IllegalArgumentException{
        int mod = acc % 11;
        if (mod < 2) {
            return 0;
        } else if (mod >= 2) {
            return 11 - (mod);
        } else {
            throw new IllegalArgumentException("Error on Validation");
        }
    }

    public static boolean validate(String cpf){
        if(cpf.length() != 11){
            return false;
        }

        if(cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") ||
           cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") ||
           cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") ||
           cpf.equals("00000000000")){
            return false;
        }



        String validatedCPF;
        String dig1,dig2;
        int mod, acc;

        array = new ArrayList<>(Arrays.asList(cpf.split("")));
        array = array.subList(0,9);

        calc = fillCalc(array.size() + 1);

        acc = accumulate(array.size());

        dig1 = String.valueOf(returnMod(acc));

        calc = new ArrayList<>();
        acc = 0;
        mod = 0;

        array.add(dig1);

        calc = fillCalc(array.size() + 1);

        acc = accumulate(array.size());

        dig2 = String.valueOf(returnMod(acc));

        array.add(dig2);

        validatedCPF = String.join("", array);

        return validatedCPF.equals(cpf);
    }


}
